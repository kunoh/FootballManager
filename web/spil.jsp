<%-- 
    Document   : spil
    Created on : 19-04-2017, 09:59:06
    Author     : Kunoh
--%>

<%@page import="com.google.firebase.FirebaseApp"%>
<%@page import="com.google.firebase.auth.FirebaseCredentials"%>
<%@page import="com.google.firebase.FirebaseOptions"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.google.firebase.database.ValueEventListener"%>
<%@page import="com.google.firebase.database.DatabaseError"%>
<%@page import="com.google.firebase.database.DataSnapshot"%>
<%@page import="com.google.firebase.database.ChildEventListener"%>
<%@page import="com.google.firebase.database.DatabaseReference"%>
<%@page import="com.google.firebase.database.FirebaseDatabase"%>
<%@page import="footballmanager.FootballManagerI"%>
<%@page import="java.rmi.registry.Registry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-social.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Hind+Guntur:300,400,600" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Playfair+Display:900|Raleway:300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

        <script src="https://www.gstatic.com/firebasejs/3.7.5/firebase.js"></script>
        <script>
            // Initialize Firebase
            var config = {
                apiKey: "AIzaSyD0m_RFpnrkDKGn5xXIyGsWY7qKZ3_Uf4M",
                authDomain: "foot-cb5a9.firebaseapp.com",
                databaseURL: "https://foot-cb5a9.firebaseio.com",
                projectId: "foot-cb5a9",
                storageBucket: "foot-cb5a9.appspot.com",
                messagingSenderId: "1021895041298"
            };
            firebase.initializeApp(config);
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>


        <%
            FootballManagerI spil = null;
            boolean aktiv = false;

            try {
                Registry registry = LocateRegistry.getRegistry("ubuntu4.javabog.dk", 53518);
                spil = (FootballManagerI) registry.lookup("FootballManagerI15351");
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.print(request.getParameter("username"));

          /*  String brugernavn = request.getParameter("username2");
            String adgangskode = request.getParameter("password2");
            if (!aktiv) {
                aktiv = spil.loggedIn(brugernavn, adgangskode);
            }
            if (aktiv
                    == true) {
                out.println("Welcome " + brugernavn + " <meta http-equiv=refresh content=2;URL=\"google.com\">");

            } else {
                out.println("Welcome " + brugernavn + " <meta http-equiv=refresh content=2;URL=\"facebook.com\">");
            }
      */  %>
<form name="myForm" action="/FM/spil.jsp" method="post" >
        <input type="hidden" name="username" id="username" value="jacno">
        <input type="hidden" name="password" id="password" value="jacno">
        <input type="submit" >
</form>
        <script>
            window.onload = function () {
                setTimeout(getUsername, 1);
                setTimeout(getPassword, 1);
            };

            function load_user() {
                document.getElementById("username").value = testFunc;
                console.log(testFunc());
            }
            function getUsername() {
                var refUsername = firebase.database().ref('User').orderByKey();
                refUsername.on('value', function (snapshot) {

                    var value = snapshot.child("Username").val();
                    document.getElementById("username").value = value;
                });
            }
            function getPassword() {
                var refUsername = firebase.database().ref('User').orderByKey();
                refUsername.on('value', function (snapshot) {

                    var value = snapshot.child("Password").val();
                    document.getElementById("password").value = value;
                });
            }
        </script>

    </body>
</html>
