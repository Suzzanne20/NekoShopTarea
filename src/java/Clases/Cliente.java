/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * @author Suzzanne Acevedo
 */
public class Cliente {
    private String codigo;
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;

    public Cliente(String codigo, String nombre, String direccion, String correo, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }    
    
    public Cliente(){ this.nombre="Nekito"; }

    public String getCodigo() {return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre;  }

    public String getCorreo() { return correo;   }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() {return direccion;  }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }  
    
    
}