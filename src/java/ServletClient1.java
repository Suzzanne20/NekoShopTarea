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
@WebServlet(urlPatterns = {"/ServletClient1"})
public class ServletClient1 extends HttpServlet {
    Cliente cliente;
    ClienteVec regCliente;
    Cliente[] registro;

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
            /* TODO output your page here. You may use following sample code. */
            cliente=new Cliente(
            Integer.parseInt(request.getParameter("cod")),
            request.getParameter("name"),
            request.getParameter("loc"),
            request.getParameter("mail"),
            request.getParameter("tel"));
        if(regCliente==null){regCliente=new ClienteVec();}
        regCliente.saveCli(cliente); 
        
        if(regCliente.saveCliBD(cliente)){out.println(1);}else{out.println(0);}
        
        
        
        registro=regCliente.gimmeCli();
          
        /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css' >");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js' ></script>"+
            "          <link rel=\"shortcut icon\" href=\"https://raw.githubusercontent.com/Suzzanne20/ResourceNekoStation/main/Neko-icon.ico\" type=\"image/x-icon\"/>"+
            "          </script><link href=\"csserv.css\" rel=\"stylesheet\" type=\"text/css\"/> ");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-dark bg-dark\"><div class=\"container-fluid row text-center \"> <div class=\"row align-items-center\">\n" +
            "          <a class=\"navbar-brand col\" href=\"index.html\"><img src=\"https://raw.githubusercontent.com/Suzzanne20/ResourceNekoStation/main/Neko%20icon.png\" alt=\"\" width=\"30\" height=\"30\" class=\"d-inline-block align-text-top\">Neko Shop</a>\n" +
            "          <a class=\"navbar-brand col \" href=\"ServletClient\">Clientes</a>\n" +
            "          <a class=\"navbar-brand col \" href=\"index1.html\">Registro</a>\n" +
            "          <a class=\"navbar-brand col \" href=\"Promos.html\">Promociones</a>\n" +
            "          <a class=\"navbar-brand col \" href=\"https://nekoshopgt.ecu.red/?fbclid=IwAR35lHTEkOxyFAEKAd2LblNHNTgu0f61fcEBXT3T-mi0HyGBe-6dp7RxpCw#/place-detail-page\" target=\"_blank\">Tienda</a>\n" +
            "          </div></div></nav>");
            
            out.println("<main class=\"main \"><div class=\"container text-center \"> "  +
            "<br><h1>Clientes Registrados</h1><br><table class=\"table table-dark table-hover\"><thead><tr>\n" +
            "      <th scope=\"col\">COD</th>\n" +
            "      <th scope=\"col\">NOMBRE</th>\n" +
            "      <th scope=\"col\">DIRECCION</th>\n" +
            "      <th scope=\"col\">EMAIL</th>\n" +
            "      <th scope=\"col\">TELEFONO</th>\n" +         
            "      <th scope=\"col\">ACCION</th>\n" +
            "      </tr></thead><tbody>");
            for (int i=0; i<registro.length;i++){
                if(!registro[i].getCodigo().isEmpty()){
                out.println("    <tr>\n" +
            "      <th scope=\"row\">"+ registro[i].getCodigo()+"</th>\n" +
            "      <td>"+registro[i].getNombre() +"</td>\n" +
            "      <td>"+registro[i].getDireccion() +"</td>\n" +
            "      <td>"+registro[i].getCorreo() +"</td>\n" +
            "      <td>"+registro[i].getTelefono() +"</td>" +
            "      <td><button type=\"button\" class=\"btn btn-danger\">Eliminar</button></td></tr>");                 
                }
            }                     
            out.println("</tbody></table></div>");
            out.println("</main></body></html>");*/
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
