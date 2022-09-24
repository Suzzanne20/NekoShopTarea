/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Clases.Cliente;
import Clases.ClienteVec;
import Clases.LinkStart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Suzzanne Acevedo
 */
@WebServlet(urlPatterns = {"/ServletClient"})
public class ServletClient extends HttpServlet {
    Cliente cliente;
    ClienteVec regCliente;
    Cliente[] registro;
    StringBuffer objOut = new StringBuffer();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            regCliente=new ClienteVec();
            
            String control = request.getParameter("control");
            
            if(control.toUpperCase().equals("GUARDAR")){
            cliente=new Cliente(
            Integer.parseInt(request.getParameter("cod")),
            request.getParameter("name"),
            request.getParameter("loc"),
            request.getParameter("mail"),
            request.getParameter("tel"));
            
            regCliente.saveCli(cliente);
            }else if (control.toUpperCase().equals("ELIMINAR")){
             int codDelete = Integer.parseInt(request.getParameter("codigoBD"));
             regCliente.eliminarclienteBd(codDelete);
            }
                   
            
        //if(regCliente==null){regCliente=new ClienteVec();}
        
        if(regCliente.saveCliBD(cliente)){out.println(1);}else{out.println(0);}
        regCliente.bdView(objOut);
        out.write(objOut.toString());
        
        /*
        registro=regCliente.gimmeCli(); //<<<<<<<<<<<<< 
        
        for (int i=0; i<registro.length;i++){
                if(!registro[i].getNombre().isEmpty()){
                out.println("<tr><th scope=\"row\">"+ registro[i].getCodigo()+"</th>\n" +
            "      <td>"+registro[i].getNombre() +"</td>\n" +
            "      <td>"+registro[i].getDireccion() +"</td>\n" +
            "      <td>"+registro[i].getCorreo() +"</td>\n" +
            "      <td>"+registro[i].getTelefono() +"</td>" +
            "      <td><button type=\"button\" class=\"btn btn-danger\">Eliminar</button></td></tr>");                 
                }
            }  
        out.println(1);
        */
        
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
