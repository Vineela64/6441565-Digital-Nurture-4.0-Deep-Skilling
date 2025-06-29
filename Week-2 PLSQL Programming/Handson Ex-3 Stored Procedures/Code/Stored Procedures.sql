SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_interest_rate CONSTANT NUMBER := 0.01; -- 1%
    v_count NUMBER := 0;
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'SAVINGS'
        FOR UPDATE
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * v_interest_rate),
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;

        v_count := v_count + 1;
        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || acc.AccountID);
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(v_count || ' savings account(s) updated with monthly interest.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error while processing interest: ' || SQLERRM);
END;
/
EXEC ProcessMonthlyInterest;


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
) AS
    v_count NUMBER := 0;
BEGIN
    FOR emp IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_department
        FOR UPDATE
    ) LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * p_bonus_pct / 100)
        WHERE EmployeeID = emp.EmployeeID;

        v_count := v_count + 1;
        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp.EmployeeID);
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(v_count || ' employee(s) in ' || p_department || ' department received a bonus.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error while updating employee bonus: ' || SQLERRM);
END;
/
EXEC UpdateEmployeeBonus('SALES', 10);


CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) AS
    v_balance_from Accounts.Balance%TYPE;
BEGIN
    -- Check and lock source account
    SELECT Balance INTO v_balance_from
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    -- Validate sufficient funds
    IF v_balance_from < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- Debit source
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    -- Credit destination
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from Account ' || p_from_account_id || 
                         ' to Account ' || p_to_account_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One of the accounts does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
END;
/
EXEC TransferFunds(1, 2, 500);