<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#container #menu form #register div p label {
	font-family: Verdana, Geneva, sans-serif;
}
</style>
<body>
<div id="container" style="background-color:#F93;width:1366px;height:620px">

<div id="header" style="background-color:#FFA500;">
<h1 align="center" style="margine-bottom: 0; font-weight: bold;"><img src="../images.jpg" width="345" height="146">Echo.com</h1>
<p align="center" style="margine-bottom: 0; font-weight: bold;">This web site allows you to post message called Echo</p>
</div>
<div id="menu" style="background-color:#FFC; height: 155px; width: 1366px; float:center; font-style: italic;">
  <div align="center"></div>
  <form name="register" method="post" action="">
      <div id="register" style="background-color: #FC9; height: 290px; width: 1366px; float: center; font-style: italic; /* [disabled]font-size: 36px; */ font-weight: bold; text-align: justify;">
        <div align="center">
         
            <p>
              <label><b> <br>
              Create your Echo Account</b></label>
            </p>
            <pre>
            <input name="firstName" type="text" id="firstName" value="FirstName">
            <input name="lastName" type="text" id="lastName" value="LastName">
            <input name="email" type="text" id="email" value="E-Mail">
            <input name ="password" type="text" id="password" value="Password">
            <input name="Re-TypePassword" type="text" id="Re-TypePassword" value="Re-Type Password">
            <input name="userName" type="text" id="userName" value="UserName">
            <input name="gender" type="radio"  id="gender" value="Gender"><label for="Gender">Male</label> <input type="radio" name="radio" id="Gender" value="Gender"><label for="Gender">Fe-male</label> 
          <input type="submit" name="Confirm" id="Confirm" value="Sign up">
         </pre>
         
        </div>
        <p>&nbsp;</p>
      </div>

  </form>
  <p>&nbsp;</p>
</div>
<div align="justify"></div>
</div>
</body>
</html>