/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author susan
 */
public class ClienteVec {
      Cliente[] tabClient;
    int ind;
    
    public ClienteVec(){
        this.tabClient = new Cliente[50];
        this.ind=0;
    }
    
     public void saveCli(Cliente cliente){
        this.tabClient[this.ind]=cliente;  
        this.ind=this.ind+1;
    }
    
    public Cliente[] gimmeCli(){
        return this.tabClient;
    }
   
    
}
