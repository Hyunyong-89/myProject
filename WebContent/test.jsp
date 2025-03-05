<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "test.DBConn" %> 

<html>
<head>
<meta charset="UTF-8">
<title>testJSP</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8"); //한글 깨짐 조치

String yymmdd = request.getParameter("yymmdd");
String name = request.getParameter("name");
String phoneNo = request.getParameter("phoneNo");

DBConn dbcn = new DBConn();

String result = null;
result = dbcn.insert(yymmdd, name, phoneNo);

//int result = dbcn.sum(phoneNo, phoneNo);

//String result = null;
//result = dbcn.dbData();

%>
정상등록여부 : <%= result %>

조회 
</body>
</html>