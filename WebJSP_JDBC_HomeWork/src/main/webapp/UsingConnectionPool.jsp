<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool Test</title>
</head>
<body>
	<%
	
	Connection conn = null;

		//JNDI (현재 프로젝트에서  특정한 이름으로 파일을 검색)
		Context context = new InitialContext();  //검색기능
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  //  (정해진 약속) java:comp/env + jdbc/oracle 이름
	    //DataSource 판매하는 상점 (튜브를 판매)
	    
	    //POOL 안에서 Connection 빌려주세요
	    conn = ds.getConnection();
		
		out.print("db연결여부 : " + conn.isClosed() + "<br>");
		
		//반드시 사용 후에는 반환 (메서드 안에서 빌리고 반환)
		conn.close(); //반환(POOL)
		
		
		out.print("db연결여부 : " + conn.isClosed() + "<br>");
	%>
=======
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tomcat Connection Pool 사용하기</title>
</head>
<body>
<%
    Connection conn= null;

    //JNDI
    Context context = new InitialContext(); //현재 프로젝에서 특정 이름을 가진 녀석을 검색(이름 기반 검색)
    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  //java:comp/env/  +  jdbc/oracle   이름  => 정해진 약속

    //POOL 안에서  connection 가지고 오기
    conn = ds.getConnection();

    out.print("db 연결여부 : " + conn.isClosed() + "<br>");

    //POINT 반드시 집에 가실때 반환
    conn.close(); //반환 (POOL)

    out.print("db 연결여부 : " + conn.isClosed() + "<br>");
%>
>>>>>>> e34eddec066e9d06dd2d8f261377bfbbb743f09c
</body>
</html>