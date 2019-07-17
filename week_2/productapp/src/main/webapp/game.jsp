<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="GameServlet">
<h2>Guess the answer</h2>
Question: Who won the UCL last season?<br/>
Life left : ${lives} <br/>
Answer : ${answer}<br />
<input type="text" name="guess" maxlength="1" /><br />
<button type="submit"> Submit button</button>

</form>

</body>
</html>