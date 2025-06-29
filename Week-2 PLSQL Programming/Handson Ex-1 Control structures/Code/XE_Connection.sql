SET SERVEROUTPUT ON;
DECLARE
    v_customer_id   Customers.CustomerID%TYPE;
    v_dob           Customers.DOB%TYPE;
    v_age           NUMBER;
    v_count         NUMBER := 0;
BEGIN
    FOR cust_rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_customer_id := cust_rec.CustomerID;
        v_dob := cust_rec.DOB;

        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;

            v_count := v_count + 1;
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to customer ID: ' || v_customer_id || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(v_count || ' customer(s) received a 1% interest rate discount.');
    COMMIT;
END;
/

SET SERVEROUTPUT ON;
DECLARE
    v_vip_count   NUMBER := 0;
    v_nonvip_count NUMBER := 0;
BEGIN
    FOR cust_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;

            v_vip_count := v_vip_count + 1;
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || cust_rec.CustomerID || ' marked as VIP (Balance: ' || cust_rec.Balance || ')');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = cust_rec.CustomerID;

            v_nonvip_count := v_nonvip_count + 1;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(v_vip_count || ' customer(s) promoted to VIP.');
    DBMS_OUTPUT.PUT_LINE(v_nonvip_count || ' customer(s) not eligible for VIP status.');
    COMMIT;
END;
/

SET SERVEROUTPUT ON;
DECLARE
    v_name       Customers.Name%TYPE;
    v_loan_id    Loans.LoanID%TYPE;
    v_end_date   Loans.EndDate%TYPE;
    v_count      NUMBER := 0;
BEGIN
    FOR loan_rec IN (
        SELECT L.LoanID, L.EndDate, C.Name
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        v_loan_id := loan_rec.LoanID;
        v_end_date := loan_rec.EndDate;
        v_name := loan_rec.Name;

        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_name ||
                             ', your loan (ID: ' || v_loan_id ||
                             ') is due on ' || TO_CHAR(v_end_date, 'DD-MON-YYYY') || '.');
        v_count := v_count + 1;
    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans are due in the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_count || ' reminder(s) sent.');
    END IF;
END;
/




