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
        <title>TodosDados do Trabalhador</title>
    </head>
    <body>
        <h2>Todos dados do trabalhador</h2>
        <% Worker worker = ( Worker ) request.getAttribute( "worker" );%>
        <h2>Worker é: <% out.print( worker.getNome() );%></h2>
        <h2>Nascido em: <% out.print( worker.getDataNascimentoText() );%></h2>
        <h2>Com idade: <% out.print( worker.getIdade() );%> anos</h2>
        <h2>Setor: <% out.print( worker.getSetor() );%></h2>
        <h2>Função: <% out.print( worker.getFuncao() );%></h2>
        <h2>Salario: <% out.print( worker.getSalarioText() );%></h2>

    </body>
</html>
