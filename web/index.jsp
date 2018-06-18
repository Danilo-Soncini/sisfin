<%-- 
    Document   : index
    Created on : Jun 14, 2018, 8:55:45 PM
    Author     : dell-soncini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Controler Financeiro | Login </title>

    <!-- Bootstrap -->
    <link href="/financeiro/plugin/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/financeiro/plugin/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/financeiro/plugin/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/financeiro/plugin/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/financeiro/css/custom.css" rel="stylesheet">

    <script src="/financeiro/js/app.js"></script>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="" method="post">
                    <h1>Controle Financeiro</h1>
                    <div>
                        <input type="text" name="email" class="form-control" placeholder="Email" required="" />
                    </div>
                    <div>
                        <input type="password" name="password" class="form-control" placeholder="Senha" required="" />
                    </div>
                    
                    
                    <div>
                        <button class="btn btn-default submit" >Log in</button>
                        
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator" style="display:none">
                        <p class="change_link">New to site?
                            <a href="#signup" class="to_register"> Create Account </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />
                    </div>
                </form>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form>
                    <h1>Create Account</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" required="" />
                    </div>
                    <div>
                        <input type="email" class="form-control" placeholder="Email" required="" />
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" required="" />
                    </div>
                    <div>
                        <a class="btn btn-default submit" href="index.html">Submit</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="#signin" class="to_register"> Log in </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-paw"></i> Sistema Financeiro</h1>
                            <p>©2018 All Rights Reserved. Sistema Financeiro</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>

</html>