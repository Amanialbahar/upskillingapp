/* University*/
CREATE TABLE UNIVERSITY(UNIVERSITY_ID NUMBER(5),
 UNIVERSITY_ANAME VARCHAR2(500),
 UNIVERSITY_ENAME VARCHAR2(500),
 WEBSITE VARCHAR2(100),
 CONSTRAINT UNIVERSITY_PK PRIMARY KEY(UNIVERSITY_ID));
/*School*/
CREATE TABLE SCHOOL(SCHOOL_ID NUMBER(5),
 SCHOOL_NAME VARCHAR2(500),
 SCHOOL_ENAME VARCHAR2(500),
 CONSTRAINT SCHOOL_PK PRIMARY KEY(SCHOOL_ID));
 
SELECT * FROM SCHOOL FOR UPDATE;
SELECT NVL (MAX(SCHOOL_ID),0)+1 FROM SCHOOL;
/*PROGRAM*/
CREATE TABLE PROGRAM(SCHOOL_ID NUMBER(5),
 PROGRAM_ID NUMBER(5),
 PROGRAM_ANAME VARCHAR2(500),
 PROGRAM_ENAME VARCHAR2(500),
CONSTRAINT PROGRAM_PK PRIMARY KEY(SCHOOL_ID, PROGRAM_ID),
CONSTRAINT SCHOOL_FK FOREIGN KEY (SCHOOL_ID) REFERENCES SCHOOL(SCHOOL_ID));
/* TRAINING COURSE */
CREATE TABLE TRAINING_COURSE(COURSE_ID NUMBER(5),
 COURSE_ANAME VARCHAR2(500),
 COURSE_ENAME VARCHAR2(500),
 MAX_STUDENTS NUMBER(5) DEFAULT 15,
 SHORT_DESC VARCHAR2(2000),
 DETAILED_DESC VARCHAR2(4000),
 CONSTRAINT TRAINING_COURSE_PK PRIMARY KEY(COURSE_ID));
 
/*STUDENT*/
CREATE TABLE STUDENT(STUDENT_ID NUMBER(10),
 STUDENT_ANAME VARCHAR2(500),
 STUDENT_ENAME VARCHAR2(500),
 BIRTHDATE DATE,
 SEX NUMBER(1),
 MOBILE VARCHAR2(20),
 EMAIL VARCHAR2(50),
 UNIVERSITY_ID NUMBER(5),
 SCHOOL_ID NUMBER(5),

 PROGRAM_ID NUMBER(5),
 FINAL_AVAERAGE NUMBER(7,2),
 MAX_AVAREAGE NUMBER(7,2),
 RATE VARCHAR2(50),
 GRADUATE_YEAR NUMBER(4),
 GRADUATE_SEM NUMBER(1),
 CONSTRAINT STUDENT_PK PRIMARY KEY(STUDENT_ID),
 CONSTRAINT STUDENT_UNIVERSITY_FK FOREIGN KEY 
(UNIVERSITY_ID)REFERENCES UNIVERSITY(UNIVERSITY_ID),
 CONSTRAINT STUDENT_PROGRAM_FK FOREIGN KEY (SCHOOL_ID, PROGRAM_ID) 
REFERENCES PROGRAM (SCHOOL_ID, PROGRAM_ID));
/* STUDENT_TRAINING_COURSE*/
CREATE TABLE STUDENT_TRAINING_COURSE(STUDENT_ID NUMBER(10),
 COURSE_ID NUMBER(5),
 PRIOORITY NUMBER(5),
 CONSTRAINT STUDENT_TRAINING_COURSE_PK PRIMARY KEY 
(STUDENT_ID, COURSE_ID),
 CONSTRAINT STUDENT_TRAINING_COURSE_FK1 FOREIGN KEY 
(STUDENT_ID) REFERENCES STUDENT(STUDENT_ID),
 CONSTRAINT STUDENT_TRAINING_COURSE_FK2 FOREIGN 
KEY(COURSE_ID)REFERENCES TRAINING_COURSE(COURSE_ID)); 
 
/* STUDENT_RESULT */
CREATE TABLE student_result (student_id number(10) ,
 course_id number(5), 
 english_mark number(7,2), 
 interview_mark number(7,2), 
 accepted_flag number(1),
 notes varchar2(2000),
 PRIMARY KEY (student_id),
 FOREIGN KEY (student_id) REFERENCES student(student_id),
 FOREIGN KEY (course_id) REFERENCES TRAINING_COURSE(course_id)); 
/* INTERVIEW */
CREATE TABLE INTERVIEW(STUDENT_ID NUMBER(10),
 INTERVIEW_DATE DATE,
 START_TIME DATE,
 END_TIME DATE,
 loc VARCHAR2(200),
 CONSTRAINT INTERVIEW_PK PRIMARY KEY(STUDENT_ID),
 CONSTRAINT INTERVIEW_FK FOREIGN KEY(STUDENT_ID)
 REFERENCES STUDENT(STUDENT_ID));
 
 
