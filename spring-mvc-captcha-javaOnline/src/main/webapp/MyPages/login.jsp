<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Captcha Demo</title>
<style>
.error {
	color: red;
}
</style>

</head>

<body bgcolor="#EAEBEE">



	<form:form action="login" method="post" commandName="login">
		<div class="login">
			<table border="0" align="center">
				<tr>
					<td align="center"><h1>Login</h1></td>
				</tr>
				<tr>
					<td colspan="2"><font color="red"><c:out
								value="${message}"></c:out></font></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="userId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter User Id</td>
					<td><form:input path="userId" /></td>
				</tr>
				<tr>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter Password</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>Image#</td>
					<td>
						<div>
							<img id="captcha_id" name="imgCaptcha" src="captcha.jpg">
						</div>
					</td>


					<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
							<img src="images/refresh.png" />
					</a></td>




				</tr>
				<tr>
					<td colspan="2"><form:errors path="captcha" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter above Image text#</td>
					<td><form:input path="captcha" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>

			</table>
		</div>

	</form:form>


</body>
</html>