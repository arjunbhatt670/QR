<!doctype html>

<html lang="en">

<header>
    <!-- change the name to yours! -->
    <title>SignUp portal</title>
    <!-- link to the master cascading stylesheet -->
    <link rel="stylesheet" href="css\masterReg.css">
    <script type="text/javascript" src="js\scriptReg.js"></script>

</header>

<body bgcolor="#FAEAEA">
<form id ='regForm' method="post" action="servreg">
    <fieldset class="box">
        <legend>Input Types</legend>
        <label class='sty box'>Name: <input type='text' id = 'name' name = 'name'></label><br/>

        <label class='sty box'>Email: <input type='email' name = 'email'> </label><br/>

        <label>Password: <input type='password' name = 'pass' id='pass'></label>
        <label>Confirm Password: <input type='password' name = 'rpass' id='rpass'></label>
        <label class='styled sub1'> <input type="checkbox" name="contact1" value="Bike">Contact me via email</label>

        <input class="favorite styled sub" type='submit' value="DONE" onclick="return Validate()">
    </fieldset>
</form>

<%--<img src="..\images\poster.jpg" height="500" width="1500">--%>

</body>

<footer>
    <hr>
    <!-- change the name to yours! -->
    <code>Copyright (C) 2020 Arjun Bhatt</code>
</footer>

</html>
