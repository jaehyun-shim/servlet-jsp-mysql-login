# servlet-jsp-mysql-login
## 자바 서블릿 심플 웹페이지
 - 주요기능 : 반응형웹, 로그인, 회원가입, 회원정보목록(수정,삭제)
 - 사이트 이미지
  > 로그인화면
  ![ex_screenshot](/resources/login.png)
  
  > 회원가입화면
  ![ex_screenshot](/resources/register.png)
  
  > 메인화면
  ![ex_screenshot](/resources/main.png)
  
  > 회원정보목록
  ![ex_screenshot](/resources/userList.png)
  
  > 모바일
  ![ex_screenshot](/resources/mobile.png)
 
 - 폴더구조  
 
 ```
 servlet-jsp-mysql-login
  ├── resources
   ├── css
   ├── images
   ├── js
   ├── vendor
  ├── src
  | ├── com 
  | ├── controllers
  | ├── dao
  | ├── model
  └── web
   └── WEB-INF
    ├── lib
    └── view
     ├── error
     └── inc
 ```

- Java-version: 1.8.0_161

- Tomcat-version : 9.0.12

### Mysql Schema
```
create table user
(
	userid bigint auto_increment primary key,
	username varchar(30) not null,
	password varchar(30) not null,
	email varchar(100) not null
);
```

### Libraries
 > New Peoject Library
 
 ```
 - /servlet-jsp-mysql-login/web/WEB-INF/lib/mysql-connector-java-8.0.12.jar
 - /servlet-jsp-mysql-login/web/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar
 - /servlet-jsp-mysql-login/web/WEB-INF/lib/taglibs-standard-jstlel-1.2.5.jar
 - /servlet-jsp-mysql-login/web/WEB-INF/lib/taglibs-standard-spec-1.2.5.jar
 ```

### InteliJ Project Settings
 > Facets > Web Resource Directories

 ```
 - Web Resource Directory : /project-path/servlet-jsp-mysql-login/web/WEB-INF
   Path Relative to Deployment Root : /
 - Web Resource Directory : /project-path/servlet-jsp-mysql-login/resources
   Path Relative to Deployment Root : /
 ```
