/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author susan
 */
public class ClienteVec {
      Cliente[] tabClient;
    int ind;
    private LinkStart linkBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null; 
    
    public ClienteVec(){
        this.tabClient = new Cliente[100];
        this.ind=0;
    }
    
     public void saveCli(Cliente cliente){
        this.tabClient[this.ind]=cliente;  
        this.ind=this.ind+1;
    }
    
    public Cliente[] gimmeCli(){
        return this.tabClient;
    }
   
    public void starConex(){
        linkBD= new LinkStart();
        conexion=linkBD.conectar();
    }
    
    public boolean saveCliBD(Cliente cliente){        
        String sql = "INSERT INTO nekoshop.clientes(codigoBD, nombre, direccion, correo, telefono)";
             sql += " VALUES( ?,?,?,?,?)"; 
        try{
            starConex();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, cliente.getCodigo());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getCorreo());
            statement.setString(5, cliente.getTelefono());
             int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return true;
                }else{
                    return false;
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            return false;
        }    
    }
    
    public void bdView(StringBuffer out){   
        String sql="select * from nekoshop.clientes";
        try{
        starConex();
        out.setLength(0);
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if (result!=null){
                while (result.next()){
                out.append("<tr>");
                out.append("<td >").append(result.getString("codigoBD")).append("</td>");
                out.append("<td >").append(result.getString("nombre")).append("</td>");
                out.append("<td >").append(result.getString("direccion")).append("</td>");
                out.append("<td >").append(result.getString("correo")).append("</td>");
                out.append("<td >").append(result.getString("telefono")).append("</td>");
                out.append("<td id=\"").append(result.getString("codigoBD"))
                        .append("\"  onclick=\"eliminarcliente(this.id);\">") 
                        .append(" <a class=\"btn btn-danger\"'> <i class=\"bi bi-trash\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                out.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     public String eliminarclienteBd(int codi){        
        String sql = "DELETE FROM clientes WHERE codigoBD="+codi;              
       try{     
            starConex();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    
}
