-- USER SQL
CREATE USER "BOOK_EX" IDENTIFIED BY "BOOK_EX"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS
ALTER USER "BOOK_EX" QUOTA UNLIMITED ON "USERS";

-- ROLES
GRANT "DBA" TO "BOOK_EX" WITH ADMIN OPTION;
ALTER USER "BOOK_EX" DEFAULT ROLE "DBA";

-- SYSTEM PRIVILEGES
GRANT CREATE SESSION TO "BOOK_EX" WITH ADMIN OPTION;
