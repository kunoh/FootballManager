<%-- 
    Document   : newjsp
    Created on : 25-04-2017, 13:39:46
    Author     : Kunoh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            body{

                padding:200px;
                padding-left:550px;
                padding-right:550px;
                background-image:url('http://www.pixelstalk.net/wp-content/uploads/2016/11/Download-Camp-Nou-Image.jpg');
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                color: #e7e7e7;

            }

            h1{
                color:white;
            }
            div.bottom {
                height: 400px;
                width: 100%;
                margin-left: auto;
                margin-right: auto;
                margin-top: none;
                margin-bottom: none;
                border-top: 4px solid #00ccff;
                border-bottom-left-radius: 15px;
                border-bottom-right-radius: 15px;
                background-color: transparent;
            }

            div.col {
                float: left;
                width: 18%;
            }
            div.col2 {
                float: left;
                width: 25%;
            }
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            tr:hover{background-color:#f5f5f5}


        </style><center>
        <div class="w3-container">
            <h1>Football Manager</h1>

            <div class="w3-bar w3-black">
                <button class="w3-bar-item w3-button tablink w3-red" onclick="openCity(event, 'Kamp')">Spil kamp</button>
                <button class="w3-bar-item w3-button tablink" onclick="openCity(event, 'SpilledeKampe')">Spillede kampe</button>
                <button class="w3-bar-item w3-button tablink" onclick="openCity(event, 'Liga')">Liga</button>
                <button class="w3-bar-item w3-button tablink" onclick="openCity(event, 'Hold')">Hold</button>
                <button class="w3-bar-item w3-button tablink" onclick="openCity(event, 'Information')">Information</button>
            </div>

            <div id="Kamp" class="w3-container w3-border city">
                <h2>Kamp</h2>
                <p>London is the capital city of England.</p>
            </div>

            <div id="SpilledeKampe" class="w3-container w3-border city" style="display:none">
                <h2>blabla</h2>
                <p>bla bla bla...</p> 
            </div>

            <div id="Liga" class="w3-container w3-border city" style="display:none">
                <div class="bottom">
                    <table>
                        <tr>
                            <th>Team Name</th>
                            <th>Goal For</th>
                            <th>Goal Against</th>
                            <th>Goal Difference</th>
                            <th>Liga Point</th>
                        </tr>
                        <tr>
                            <td>Peter</td>
                            <td>Griffin</td>
                            <td>$100</td>
                        </tr>
                        <tr>
                            <td>Lois</td>
                            <td>Griffin</td>
                            <td>$150</td>
                        </tr>
                        <tr>
                            <td>Joe</td>
                            <td>Swanson</td>
                            <td>$300</td>
                        </tr>
                        <tr>
                            <td>Cleveland</td>
                            <td>Brown</td>
                            <td>$250</td>
                        </tr>
                    </table>

                </div>
            </div>

            <div id="Hold" class="w3-container w3-border city" style="display:none">
                <h2>Hold</h2>
                <p>Tokyo is the capital of Japan.</p>
            </div>

            <div id="Information" class="w3-container w3-border city" style="display:none">
                <h2>Information</h2>
                <p>Tokyo is the capital of Japan.</p>
            </div>
        </div>

        <script>
            function openCity(evt, cityName) {
                var i, x, tablinks;
                x = document.getElementsByClassName("city");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablink");
                for (i = 0; i < x.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " w3-red";
            }
        </script>

    </body>
</html>
