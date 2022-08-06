/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Suzzanne Acevedo
 */
@WebServlet(urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {
    ClienteModell cliente;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter igual = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            cliente=new ClienteModell();   
            cliente.setCodigo(request.getParameter("cod"));
            cliente.setNombre(request.getParameter("name"));
            cliente.setDireccion(request.getParameter("loc"));
            cliente.setCorreo(request.getParameter("mail"));
            cliente.setTelefono(request.getParameter("tel"));
            

            igual.println("<!DOCTYPE html>");
            igual.println("<html>");
            igual.println("<head>");    
            igual.println("</head>");
            igual.println("<body>");
            
            igual.println("<h5>Servlet: " + request.getContextPath() + "</h5><br>");
            igual.println("<h4>__________________________________________</h4>");
            igual.println("<h1>Registro del Cliente</h1>"); 
            igual.println("<h4>__________________________________________</h4><br>");
            igual.println("<h3>Codigo:    " + cliente.getCodigo() + "</h3>");
            igual.println("<h3>Nombre:    " + cliente.getNombre() + "</h3>");
            igual.println("<h3>Direccion: " + cliente.getDireccion() + "</h3>");
            igual.println("<h3>Email :    " + cliente.getCorreo() + "</h3>");
            igual.println("<h3>Telefono : " + cliente.getTelefono() + "</h3><br>");
            igual.println("<h4>__________________________________________</h4>");
            igual.println("<h1></h1><br>");      
            igual.println("<a href=\"index.html\" > volver al Inivio --> </a>");
            igual.println("</body>");
            igual.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
