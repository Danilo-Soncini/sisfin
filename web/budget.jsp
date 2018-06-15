<%-- 
    Document   : budget
    Created on : Jun 14, 2018, 10:08:17 PM
    Author     : dell-soncini
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>

    <!-- Bootstrap -->
    <link href="/financeiro/plugin/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/financeiro/plugin/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/financeiro/plugin/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/financeiro/plugin/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="/financeiro/plugin/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/financeiro/plugin/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/financeiro/plugin/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/financeiro/plugin/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/financeiro/plugin/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/financeiro/css/custom.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="" role="tabpanel" data-example-id="togglable-tabs">
                <ul  class="nav nav-tabs bar_tabs" role="tablist">
    
                    <li role="presentation" class="${Mes.equals("01") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=01"  aria-expanded="true"> 01/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("02") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=02"  aria-expanded="true"> 02/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("03") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=03"  aria-expanded="true"> 03/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("04") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=04"  aria-expanded="true"> 04/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("05") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=05"  aria-expanded="true"> 05/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("06") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=06"  aria-expanded="true"> 06/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("07") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=07"  aria-expanded="true"> 07/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("08") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=08"  aria-expanded="true"> 08/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("09") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=09"  aria-expanded="true"> 09/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("10") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=10"  aria-expanded="true"> 10/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("11") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=11"  aria-expanded="true"> 11/${Ano} </a>
                    </li>
                    <li role="presentation" class="${Mes.equals("12") ? 'active' : ''}">
                        <a href="/financeiro/user/budget?year=${Ano}&month=12"  aria-expanded="true"> 12/${Ano} </a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">

                    <div class="">
                        <form action="" method="post">
                            <input type="hidden" name="month" value="${Mes}">
                            <input type="hidden" name="year" value="${Ano}">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Orçamento ${Mes}/${Ano} </h2>
                                            <a class="btn btn-dark pull-right"   href="/spend?year=${Mes}&month=${Ano}" >Gastos</a>
                                        </div>
                                        <div class="x_content">
                                            <table  class="table table-striped table-bordered">

                                                <thead>
                                                <tr>
                                                    <td>Nome</td>
                                                    <td>Valor</td>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                 <c:forEach items="${Categories}" var="category"> 
                                                    <tr>
                                                         <td>${category.name}</td>
                                                         <td>
                                                              <input name="cat${category.id}" type="text" value="<c:forEach items="${Orcamentos}" var="budget">${budget.idCategory == category.id  ? budget.budget :"" }</c:forEach >">
                                                         </td>
                                                     </tr>
                                                 </c:forEach>       
                                            </table>

                                            <button class="btn btn-primary pull-right" >Salvar </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
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
<!-- iCheck -->
<script src="/financeiro/plugin/iCheck/icheck.min.js"></script>
<!-- Datatables -->
<script src="/financeiro/plugin/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/financeiro/plugin/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/financeiro/plugin/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="/financeiro/plugin/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="/financeiro/plugin/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="/financeiro/plugin/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="/financeiro/plugin/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="/financeiro/plugin/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="/financeiro/plugin/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="/financeiro/plugin/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="/financeiro/plugin/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="/financeiro/plugin/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="/financeiro/plugin/jszip/dist/jszip.min.js"></script>
<script src="/financeiro/plugin/pdfmake/build/pdfmake.min.js"></script>
<script src="/financeiro/plugin/pdfmake/build/vfs_fonts.js"></script>

<!-- Custom Theme Scripts -->
<script src="/financeiro/js/custom.js"></script>

</body>
</html>