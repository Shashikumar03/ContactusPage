<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="contactus.css">
    <title>Document</title>
</head>
<body>
    <div class="main-container">
        <div class="container"> 
            <div class="top-div">
                <header class="header">
                    <h1> Contact Us</h1>
                    <h3> please fill this form in a decent manner</h3>
                </header>
               
            </div>
            
            <div class="form" >
                <form action="contactus" method="post" class="login" id="form1" >
                    <label for="name" id="name"><strong>Full Name <small id="star">*</small></strong></label><br>
                    <input type="text" id="name" name="name" required><br>
                    <label for="email" id="email"><strong>E-mail <small id="star">*</small></strong></label> <br>
                    <input type="email" name="email" id="email" required ><br>
                    <label for="message"><strong>Message</strong><small id="star">*</small> </label><br>
                     <textarea name="message" id="message" cols="" rows="5"></textarea><br>
                    <div id="submit"><input type="submit" id="submit" name ="submit"></div>
                </form>
            </div>

        </div>
        

    </div>
</body>
</html>