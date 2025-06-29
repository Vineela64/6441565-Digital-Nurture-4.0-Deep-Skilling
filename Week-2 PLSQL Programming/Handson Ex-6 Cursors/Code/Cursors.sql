SET SERVEROUTPUT ON;

DECLARE
    CURSOR txn_cursor IS
        SELECT C.CustomerID, C.Name, T.TransactionID, T.TransactionDate, T.Amount, T.TransactionType
        FROM Customers C
        JOIN Accounts A ON C.CustomerID = A.CustomerID
        JOIN Transactions T ON A.AccountID = T.AccountID
        WHERE TRUNC(T.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY C.CustomerID, T.TransactionDate;

    v_customer_id    Customers.CustomerID%TYPE;
    v_name           Customers.Name%TYPE;
    v_txn_id         Transactions.TransactionID%TYPE;
    v_txn_date       Transactions.TransactionDate%TYPE;
    v_amount         Transactions.Amount%TYPE;
    v_type           Transactions.TransactionType%TYPE;

BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_customer_id, v_name, v_txn_id, v_txn_date, v_amount, v_type;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' (ID: ' || v_customer_id || ')');
        DBMS_OUTPUT.PUT_LINE('   Transaction ID: ' || v_txn_id || 
                             ', Date: ' || TO_CHAR(v_txn_date, 'DD-Mon-YYYY') ||
                             ', Amount: ' || v_amount ||
                             ', Type: ' || v_type);
    END LOOP;
    CLOSE txn_cursor;
END;
/


SET SERVEROUTPUT ON;

DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;

    v_account_id Accounts.AccountID%TYPE;
    v_balance    Accounts.Balance%TYPE;
    v_fee CONSTANT NUMBER := 100;  -- annual maintenance fee

BEGIN
    OPEN acc_cursor;
    LOOP
        FETCH acc_cursor INTO v_account_id, v_balance;
        EXIT WHEN acc_cursor%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_account_id;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee || ' deducted from Account ID: ' || v_account_id);
    END LOOP;
    CLOSE acc_cursor;
    COMMIT;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans FOR UPDATE;

    v_loan_id     Loans.LoanID%TYPE;
    v_amount      Loans.LoanAmount%TYPE;
    v_interest    Loans.InterestRate%TYPE;
    v_new_rate    NUMBER;

BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_amount, v_interest;
        EXIT WHEN loan_cursor%NOTFOUND;

        IF v_amount > 100000 THEN
            v_new_rate := v_interest + 0.5;
        ELSE
            v_new_rate := v_interest + 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan_id || ' interest updated from ' || v_interest || ' to ' || v_new_rate);
    END LOOP;
    CLOSE loan_cursor;
    COMMIT;
END;
/
