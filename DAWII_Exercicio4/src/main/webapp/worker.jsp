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
        <title>Dados do Trabalhador</title>
    </head>
    <body>
        <% Worker worker = ( Worker ) request.getAttribute( "worker" );%>
        <h1>Workers é: <% out.print( worker.getNome() );%></h1>
        <h1>Nascido em: <% out.print( worker.getDataNascimentoText() );%></h1>
        <h1>Com idade: <% out.print( worker.getIdade() );%> anos</h1>
        <h2>Informe o setor, função e o salário</h2>
        <form action="/daw2ex4/outrosDados" method="post">
            Setor: <input type="text" name="setor" value="" />
            <br>
            Função<input type="text" name="funcao" value="" />
            <br>
            Salario<input type="text" name="salario" value="" />


            <input hidden="true" type="text" name="nome" value="<% out.print( worker.getNome() );%>" />

            <input hidden="true" type="text" name="data" value="<% out.print( worker.getDataNascimentoText() );%>" />
            <input type="submit" value="enviar" name="send" />
        </form>

    </body>
</html>
