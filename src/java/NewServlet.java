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
 * @author S
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    Cliente alumno;

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
        try ( PrintWriter respuesta = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            alumno=new Cliente();    
            String pass =  request.getParameter("pass");
            String opcion =  request.getParameter("opcion");
            alumno.setNombre(request.getParameter("nombre"));
            alumno.setCorreo(request.getParameter("correo"));
            respuesta.println("<!DOCTYPE html>");
            respuesta.println("<html>");
            respuesta.println("<head>");
            respuesta.println("<title>Servlet NewServlet</title>");            
            respuesta.println("</head>");
            respuesta.println("<body>");
            respuesta.println("<h1>Mi primer servlet " + request.getContextPath() + "</h1>");
            respuesta.println("<h1>Datos del alumno registrado, gracias por registrarse </h1><br>");         
            respuesta.println("<h2>" + alumno.getNombre() + "</h2>");
            respuesta.println("<h2>" + alumno.getCorreo() + "</h2>");
            respuesta.println("</body>");
            respuesta.println("</html>");
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