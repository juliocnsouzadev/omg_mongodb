/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juliocnsouza.dawii.exercicio4.controller;

import br.com.juliocnsouza.dawii.exercicio4.model.Worker;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Nunes de Souza
 */
public class OutrosDadosServlet extends HttpServlet {

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
        response.setContentType( "text/html;charset=UTF-8" );
        Worker worker = new Worker();

        String setor = request.getParameter( "setor" );
        String funcao = request.getParameter( "funcao" );
        double salario = getSalario( request.getParameter( "salario" ) );
        String nome = request.getParameter( "nome" );
        String data = request.getParameter( "data" );
        worker.setNome( nome );

        try {
            if ( data != null && !data.isEmpty() ) {
                worker.setDataNascimento( DateFormat.getDateInstance().parse( data ) );
            }
        }
        catch ( ParseException ex ) {
            Logger.getLogger( OutrosDadosServlet.class.getName() ).log( Level.SEVERE , null , ex );
        }
        worker.setSalario( salario );
        worker.setSetor( setor );
        worker.setFuncao( funcao );
        request.setAttribute( "worker" , worker );

        RequestDispatcher dispacher = request.getRequestDispatcher( "/workerfull.jsp" );
        if ( dispacher != null ) {
            dispacher.forward( request , response );
        }
        else {
            System.err.println( "dispacher nulo em " + request.getContextPath() );
        }

    }

    private double getSalario( String parameter ) {
        if ( parameter == null ) {
            return 0.00;
        }
        try {
            return Double.parseDouble( parameter );
        }
        catch ( NumberFormatException e ) {
            System.err.println( "erro: " + e.getMessage() );
        }
        return 0.00;
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

}
