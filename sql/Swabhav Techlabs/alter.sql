/*ALTER TABLE EMP ADD CONSTRAINT EMP_SELF_KEY FOREIGN KEY(MGR) REFERENCES EMP (EMPNO);*/

/*ALTER TABLE EMP MODIFY HIREDATE DATE;*/

/*ALTER TABLE COUNTRIES
ADD  CONSTRAINT COUNTR_REG_FK
                 FOREIGN KEY (REGION_ID)
                  REFERENCES REGIONS(REGION_ID)*/


/*, CONSTRAINT LOC_C_ID_FK FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRIES(COUNTRY_ID);*/

/*ALTER TABLE LOCATIONS
ADD CONSTRAINT LOC_ID_PK PRIMARY KEY (LOCATION_ID);*/

ALTER TABLE LOCATIONS
ADD CONSTRAINT LOC_C_ID_FK FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRIES(COUNTRY_ID)
