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
  <form name="form1" method="post" action="">
    <label for="username"></label>
       <div align="center">
         <p>UserName
           <input type="text" name="username" id="username">
         </p>
         <p>
           <label for="password">Password</label>
           <input type="Password" name="password" id="password">
         </p>
         <p>
           <input name="buttonlog" type="submit" id="buttonlog" value="log in"><br>
          <a href="forgotpassword.jsp">Forgot Password?</a></br></p>
         
       </div>
      <div id="register" style="background-color: #FC9; height: 290px; width: 1366px; float: center; font-style: italic; /* [disabled]font-size: 36px; */ font-weight: bold; text-align: justify;">
        <div align="center">
         
            <p>
              <label><b> <br>
              New to Echo???Register Now</b></label>
            ,,,,,,it's Free</p>
            <p>
          <a href="register.jsp">Sign up</a></p>
          
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