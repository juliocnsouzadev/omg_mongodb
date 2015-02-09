/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juliocnsouza.dawii.exercicio4.controller;

import br.com.juliocnsouza.dawii.exercicio4.model.Worker;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Nunes de Souza
 */
public class PrincipalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * <p>
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request , HttpServletResponse response )
            throws ServletException ,
                   IOException {
        //criarHtmlViaServelet( response , request );
        RequestDispatcher dispacher = request.getRequestDispatcher( "/worker.jsp" );
        setWorker( request );
        dispacher.forward( request , response );
    }

    private void setWorker( HttpServletRequest request ) {
        if ( request == null ) {
            return;
        }
        String nome = request.getParameter( "nome" );
        String data = request.getParameter( "data" );
        if ( nome == null || data == null ) {
            request.setAttribute( "worker" , "no worker!" );
            return;
        }
        DateFormat df = DateFormat.getDateInstance();
        try {
            Date date = df.parse( data );
            Worker worker = new Worker( nome , date );
            request.setAttribute( "worker" , worker );
        }
        catch ( ParseException e ) {
            System.err.println( "erro: " + e.getMessage() );
        }

    }

    private void criarHtmlViaServelet( HttpServletResponse response , HttpServletRequest request )
            throws IOException {
        response.setContentType( "text/html;charset=UTF-8" );
        PrintWriter out = response.getWriter();
        try {
            String paramNome = request.getParameter( "nome" );
            String nome = paramNome != null
                          ? paramNome
                          : "sem nome";
            nome = nome.toUpperCase();
            out.println( "<!DOCTYPE html>" );
            out.println( "<html>" );
            out.println( "<head>" );
            out.println( "<title>Servlet Principal de " + nome + " </title>" );
            out.println( "</head>" );
            out.println( "<body>" );
            out.println(
                    "<h1>Servlet Principal criado em " + getDataFormatada() + " por " + nome + "</h1>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * <p>
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request , HttpServletResponse response )
            throws ServletException ,
                   IOException {
        processRequest( request , response );
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * <p>
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
            throws ServletException ,
                   IOException {
        processRequest( request , response );
    }

    /**
     * Returns a short description of the servlet.
     * <p>
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getDataFormatada() {
        DateFormat df = DateFormat.getDateTimeInstance( DateFormat.FULL , DateFormat.MEDIUM ,
                                                        Locale.ITALIAN );
        return df.format( new Date() );
    }

}
