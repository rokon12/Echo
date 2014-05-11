<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#container pre {
	font-family: Georgia, Times New Roman, Times, serif;
}
#container pre {
	font-family: Comic Sans MS, cursive;
}
#changeField pre {
	font-family: Comic Sans MS, cursive;
}
</style>
<body>
<div id = "container" style="background-color:#F30; width:1366px;height:700px">
<div id = "header" style="background-color:#F30; width:1366px;height:140px">
<h1 align="center" style="margine-bottom: 0; font-weight: bold;"><img src="../images.jpg" width="176" height="58">.com</h1>
<p align="center" style="margine-bottom: 0; font-weight: bold;">This web site allows you to post message called Echo</p>
</div>
<div id = "changeField" style="background-color:#FF9; width:1366px;height:350px"  align="center">
<p>
<pre>


<label>Present Password           </label><input name="presentPassword" type="password" size="25"><br></br>
<label>New Password                </label><input name="newPassword" type="password"size="25"><br></br>
<label>Re-enter new Password   </label><input name="confirmPassword" type="password"size="25">

<input name="confirm" type="button" value="Submit">
</pre>
</p>
</div>
</div>
</body>
</html>