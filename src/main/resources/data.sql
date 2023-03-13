-- We can use basic SQL scripts to initialize the database. In order to 
-- demonstrate this, let's add a data.sql file under src/main/resources directory:

-- Spring Boot will automatically pick up this file and run it against an embedded in-memory database, 
-- such as our configured H2 instance. This is a good way to seed the database for testing or initialization purposes.

INSERT INTO PERSON (id, name,surname) VALUES ((select next value for person_seq), 'TESTNAME-1','TESTSURNAME-1');
INSERT INTO PERSON (id, name,surname) VALUES ((select next value for person_seq), 'TESTNAME-2','TESTSURNAME-2');
INSERT INTO PERSON (id, name,surname) VALUES ((select next value for person_seq), 'TESTNAME-3','TESTSURNAME-3');
INSERT INTO PERSON (id, name,surname) VALUES ((select next value for person_seq), 'TESTNAME-4','TESTSURNAME-4');
INSERT INTO PERSON (id, name,surname) VALUES ((select next value for person_seq), 'TESTNAME-5','TESTSURNAME-5');