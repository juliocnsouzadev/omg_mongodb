<%--
    Document   : worker
    Created on : 09/02/2015, 19:43:49
    Author     : Julio Cesar Nunes de Souza
--%>

<%@page import="br.com.juliocnsouza.dawii.exercicio4.model.Worker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Worker worker = ( Worker ) request.getAttribute( "worker" );%>
        <h1>Workers é: <% out.print( worker.getNome() );%></h1>
        <h1>Nascido em: <% out.print( worker.getDataNascimentoText() );%></h1>
        <h1>Com idade: <% out.print( worker.getIdade() );%> anos</h1>

    </body>
</html>
