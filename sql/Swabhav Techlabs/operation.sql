/*Query 1: Display employees by asscending order of their salary
select * from EMP order by SAL;*/

/*Query 2: Displat employee name 'scott'
select * from EMP where ENAME = 'SCOTT';*/

/*Query 3: DisplaY employee IN DEPT 10
select * from EMP where DEPTNO = 10;*/

/*Query 4: DisplaY employee IN DEPT 10 AND DEPT 20
select * from EMP where DEPTNO = 10 || DEPTNO = 20;*/


/*Query 5: DisplaY employee WHOSE NAME ENDS WITH N
select ENAME from EMP where ENAME LIKE '%N';*/

/*Query 6: DisplaY employee IN DEPT 10 AND MANAGERS
select * from EMP where DEPTNO=10 && JOB='MANAGER';*/

/*Query 7: DisplaY employee COMMISSION IS NULL
select * from EMP where COMM IS NULL;*/

/*Query 8: DisplaY employee ANNUAL CTC 
select ENAME, SUM((SAL*12)+IFNULL(COMM, 0)) CTC from EMP GROUP BY ENAME;*/

/*Query 9: DISPLAY ALL EMPLOYESS WHO HAS SAME SALARY OF 'SCOTT' 
select ENAME, SAL from EMP WHERE SAL = ALL(SELECT SAL FROM EMP WHERE ENAME='SCOTT');*/

/*Query 10: DISPLAY ALL EMPLOYESS WHO HAS SAME DEPT NO SAS 'SCOTT' 
select * from EMP WHERE DEPTNO = ALL(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');*/

/*Query 11: TOP 5 SALARIED EMPLOYEES 
select * from EMP ORDER BY SAL DESC LIMIT 5;*/

/*Query 12: SECOND HIGHEST SALARIED EMPLOYEES 
select MAX(SAL) from EMP WHERE SAL < (SELECT MAX(SAL) FROM EMP);*/

/*Query 13: SUM OF ALL SALARIES OF ALL EMPLOYEES 
select SUM(SAL) FROM EMP;*/

/*Query 14: COUNT OF ALL EMPLOYEES 
select COUNT(ENAME) FROM EMP;*/

/*Query 15: DEPT WISE EMPLOYEES 
select D.DEPTNO, COUNT(E.ENAME) EMPLOYEES
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO 
GROUP BY D.DEPTNO;*/

/*Query 16: JOB WISE EMPLOYEES 
select E.JOB, COUNT(E.ENAME) JOB
FROM EMP E 
GROUP BY E.JOB
ORDER BY JOB;*/

/*Query 17: JOB WISE, DEPT WISE EMPLOYEES 
select JOB, DEPTNO, COUNT(ENAME) EMPLOYEE
FROM EMP
GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO;*/

/*Query 18: JOB WISE, DEPT WISE EMPLOYEES WITH COUNT > 2 
select E.JOB, D.DEPTNO, COUNT(E.ENAME) EMPLOYEE
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO 
GROUP BY D.DEPTNO,E.JOB 
HAVING COUNT(EMPLOYEE) >= 2
ORDER BY DEPTNO;*/

/*Joins*/

/*SELECT ALL DEPTS AND EMP
select * 
from EMP E
LEFT JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
UNION
SELECT * 
FROM EMP E 
RIGHT JOIN DEPT D
ON E.DEPTNO=D.DEPTNO;*/


/*DEPT WHERE THERE IS NO EMPLOYEE

select DNAME 
from DEPT 
where DEPTNO 
not in (select DEPTNO from EMP);*/

/*DEPT WHERE THERE IS NO EMPLOYEE(with join)

SELECT * 
FROM DEPT D
LEFT JOIN EMP E
ON E.DEPTNO = D.DEPTNO
where E.ENAME IS NULL;*/

/*SELF JOIN */

/*QUERY 1
SELECT X.ENAME EMP, Y.ENAME BOSS, K.DNAME DNAME
FROM EMP X INNER JOIN EMP Y ON IFNULL(X.MGR, X.EMPNO)=Y.EMPNO*/

/*QUERY 2
SELECT X.ENAME EMP, Y.ENAME BOSS, K.DNAME DNAME
FROM EMP X INNER JOIN EMP Y ON IFNULL(X.MGR, X.EMPNO)=Y.EMPNO
INNER JOIN DEPT K ON X.DEPTNO = K.DEPTNO; */


/*FIND THE REGINS WHERE THERE ARE NO COUNTRIES

SELECT R.region_name 
from REGIONS R
LEFT JOIN COUNTRIES C
ON R.region_id = C.REGION_ID
WHERE C.COUNTRY_NAME is NULL;*/

/*find the country where there are no location

SELECT C.COUNTRY_NAME
FROM COUNTRIES C
LEFT JOIN LOCATIONS L
ON L.COUNTRY_ID = C.COUNTRY_ID
WHERE L.LOCATION_ID IS NULL;*/

/* REGION WISE NO OF COUNTROES

SELECT R.region_name, count(C.REGION_ID)
from COUNTRIES C INNER JOIN REGIONS R
ON R.region_id = C.REGION_ID
group by C.REGION_ID;*/

/*REGION WISE COUNTRY WISE NO OF LOC*/

SELECT R.region_name, C.COUNTRY_NAME, count(L.LOCATION_ID)
FROM REGIONS R 
INNER JOIN COUNTRIES C
ON R.region_id = C.REGION_ID
INNER JOIN LOCATIONS  L
ON C.COUNTRY_ID = L.COUNTRY_ID
GROUP BY L.LOCATION_ID;

/*REGION NAME COUNTRY NAME LOC NAME

SELECT R.region_name, C.COUNTRY_NAME, L.CITY
FROM REGIONS R
LEFT JOIN COUNTRIES C
ON R.region_id = C.REGION_ID
LEFT JOIN LOCATIONS L
ON C.COUNTRY_ID = L.COUNTRY_ID;*/


