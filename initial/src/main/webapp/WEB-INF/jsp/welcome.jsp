<html>  
    <head>
        <style>
            .navbar {
                overflow: hidden;
                background-color: #333;
                font-family: Arial, Helvetica, sans-serif;
            }
        
            .navbar a {
                float: left;
                font-size: 16px;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

        </style>
        

	
		<title>Home</title>
	</head>
	<body>
			
        <div class='navbar'>
            <h2>
                <a href='welcome'>Home</a>
                <a href='logout'>Log Out</a>
        </div>

    </h2>

        <h2>Welcome</h2>
        ${message}
        </br>
        </br>
        Name : ${name}	
        </br>
        Username : ${username}	
        </br>
        Role : ${role}	
        </br>
        
        <%
            if (request.getAttribute("role").equals("Manager")){
        %>
            <a href='restricted'>Restricted</a>
        <%
            }
        %>        

	</body>
</html>  