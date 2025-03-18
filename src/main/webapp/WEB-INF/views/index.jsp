<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST TITLE</title>
</head>
<body>
	
    <h1>Servlet Test</h1>
    <div>
        <form action="/java-servlet/test" method="get">
            GET 이름 : <input type="text" name="NAME"/>
            <input type="submit" value="확인"/>
        </form>
    </div>
    <div>
        <form action="/java-servlet/test" method="post">
            POST 이름 : <input type="text" name="NAME"/>
            <input type="submit" value="확인"/>
        </form>
    </div>
    
</body>
</html>	