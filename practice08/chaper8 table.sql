CREATE TABLE EMPLOYEE(
NAME VARCHAR(20),
ADDRESS VARCHAR(100),
SSN VARCHAR(15));

INSERT INTO EMPLOYEE
VALUES('DUKE','SEOUL','970224-1039234');
INSERT INTO EMPLOYEE
VALUES('PORORO','PUSAN','001222-1038782');
INSERT INTO EMPLOYEE
VALUES('CANDY','DAEJEON','981221-1829192');


SELECT * FROM EMPLOYEE;

CREATE TABLE item(
NAME VARCHAR(20),
price NUMBER(8),
description VARCHAR2(100));
