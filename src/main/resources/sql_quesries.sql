CREATE TABLE EMPLOYEE
  (
    ID           NUMBER(10),
    FIRSTNAME    VARCHAR2(20),
    LASTNAME     VARCHAR2(20),
    EMAILID      VARCHAR2(50) NOT NULL,
    MOBILENUMBER VARCHAR2(15),
    CREATIONTIME DATE DEFAULT SYSDATE,
    CONSTRAINT PK_EMPLOYEE PRIMARY KEY (id)
  );

-- Create sequence to manage employee sequence number for each insertion of employee record
CREATE SEQUENCE EMPLOYEE_SEQ 
MINVALUE 1 
MAXVALUE 9999999999 
INCREMENT BY 1 
START WITH 1 
NOORDER NOCYCLE;


CREATE TABLE EMPLOYEE_SALARY
  (
    TRANSACTION_ID VARCHAR2(40),
    EMPLOYEE_ID    NUMBER(10) ,
    SALARY         NUMBER(10, 5),
    ISSUED_DATE    DATE,
    CONSTRAINT PK_EMPLOYEE_SALARY PRIMARY KEY (TRANSACTION_ID),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID)
  );

-- Create EMPLOYEE_SALARY_HISTORY table similar to EMPLOYEE_SALARY table
create table EMPLOYEE_SALARY_HISTORY AS (select * from EMPLOYEE_SALARY);


CREATE OR REPLACE FUNCTION EmplyeeCountInSalaryRange
  (
    min_salary IN INTEGER,
    max_salary IN INTEGER
  )
  RETURN NUMBER
IS
  TOTAL_EMPLOYESS NUMBER;
BEGIN
  SELECT COUNT(ID)
  INTO TOTAL_EMPLOYESS
  FROM EMPLOYEE
  WHERE SALARY >= min_salary
  AND SALARY   <= max_salary;
  RETURN (TOTAL_EMPLOYESS);
END;
/

-- Stored procedure which takes source table and history table and perform the back up for 90 days old records
CREATE OR REPLACE PROCEDURE performBackup(
      source_table  VARCHAR2,
      history_table VARCHAR2)
  IS
  BEGIN
    EXECUTE immediate 'INSERT INTO '||history_table||' (select * from '||source_table||' where CREATE_DATE < sysdate - 90)';
    EXECUTE immediate 'DELETE FROM '||source_table||' where CREATE_DATE < sysdate - 90';
    COMMIT;
  END;
/

-- Added a new table