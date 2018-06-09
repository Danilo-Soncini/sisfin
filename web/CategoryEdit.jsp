<%-- 
    Document   : UserEdit
    Created on : Jun 15, 2018, 12:27:52 AM
    Author     : dell-soncini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Editar Usuário</title>

    <!-- Bootstrap -->
    <link href="/financeiro/plugin/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/financeiro/plugin/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/financeiro/plugin/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/financeiro/plugin/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="/financeiro/plugin/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="/financeiro/plugin/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="/financeiro/plugin/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="/financeiro/plugin/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="/financeiro/plugin/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/financeiro/css/custom.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Editar Categoria</h2>
                            </div>
                            <div class="x_content">
                                <br />
                                <form id="demo-form2" action="" method="POST" data-parsley-validate class="form-horizontal form-label-left">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Nome <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text"  name="name" required="required" value="${CategoryToEdit.name}" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Descrição <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" name="description" required="required" value ="${CategoryToEdit.description}"class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Entrada  
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="middle-name" class="form-control col-md-7 col-xs-12"  ${CategoryToEdit.entrece ? "checked" :""} value ="true" type="checkbox" name="entrece">
                                        </div>
                                    </div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <a class="btn btn-primary" href="/financeiro/category/list">Cancelar</a>
                                            <button type="submit" class="btn btn-success">Enviar</button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">

            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="/financeiro/plugin/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/financeiro/plugin/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/financeiro/plugin/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/financeiro/plugin/nprogress/nprogress.js"></script>
<!-- bootstrap-progressbar -->
<script src="/financeiro/plugin/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="/financeiro/plugin/iCheck/icheck.min.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/financeiro/plugin/moment/min/moment.min.js"></script>
<script src="/financeiro/plugin/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap-wysiwyg -->
<script src="/financeiro/plugin/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
<script src="/financeiro/plugin/jquery.hotkeys/jquery.hotkeys.js"></script>
<script src="/financeiro/plugin/google-code-prettify/src/prettify.js"></script>
<!-- jQuery Tags Input -->
<script src="/financeiro/plugin/jquery.tagsinput/src/jquery.tagsinput.js"></script>
<!-- Switchery -->
<script src="/financeiro/plugin/switchery/dist/switchery.min.js"></script>
<!-- Select2 -->
<script src="/financeiro/plugin/select2/dist/js/select2.full.min.js"></script>
<!-- Parsley -->
<script src="/financeiro/plugin/parsleyjs/dist/parsley.min.js"></script>
<!-- Autosize -->
<script src="/financeiro/plugin/autosize/dist/autosize.min.js"></script>
<!-- jQuery autocomplete -->
<script src="/financeiro/plugin/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
<!-- starrr -->
<script src="/financeiro/plugin/starrr/dist/starrr.js"></script>
<!-- Custom Theme Scripts -->
<script src="/financeiro/js/custom.js"></script>

</body>
</html>
