<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
}

* {
    box-sizing: border-box;
}

/* Add padding to containers */
.container {
    padding: 16px;
    background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Overwrite default styles of hr */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

.registerbtn:hover {
    opacity: 1;
}

/* Add a blue text color to links */
a {
    color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
    background-color: #f1f1f1;
    text-align: center;
}

.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    
}
</style>
</head>
<body>

<form action="register" method="post">
  <div class="container">
    <h1 style="text-align:center">Register</h1>
    <hr>
    ${message}  
    </br>
    </br>
    <label for="user"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="user" required>

    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>

    <label for="pass"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pass" required>

    <label for="cpass"><b>Confirm Password</b></label>
    <input type="password" placeholder="Confirm Password" name="cpass" required>

    <label for="role"><b>Role</b></label>
    <select name="role">
        <option value="User">User</option>
        <option value="Manager">Manager</option>
    </select>

    <button type="submit" class="registerbtn">Register</button>
 
  </div>
  
 
</form>

</body>
</html>
