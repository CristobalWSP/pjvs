/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.pgy2121.mipymes.business;

import cl.duoc.pgy2121.mipymes.domain.Cliente;
import cl.duoc.pgy2121.mipymes.domain.Producto;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author Nancy
 */
public class Solicitud {
//<editor-fold defaultstate="collapsed" desc="atributos">
    private int numero, total;
    private Date fecha;
    private Cliente cliente;
    private String productos="";    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="constructores">
    public Solicitud() {
    }

    public Solicitud(int numero, int total, Date fecha, Cliente cliente, String productos) {
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
    }    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Get&Set">
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="customers">
    /**
     * Un método que permite agregar productos a la solicitud
     * @param producto recibo el producto para agregar a la
     * solicitud
     */
    public void agregarProductos(Producto producto)
    {
        String uMedidas;
        if (producto.getMedida()=='U') {
            uMedidas="unidades";
        }else{
            uMedidas="gramos";
        }
        this.total=this.total+producto.getPrecio();
        this.productos=this.productos + 
                producto.getDescripcion()+ " " +
                producto.getCantidad()+ " " +
                uMedidas + " $" +
                producto.getPrecio() + ";\n";
    }
    /**
     * Un método que obtenga el número de la solicitud, 
     * el cual será un correlativo
     * @return el número correlativo
     */
    public int obtenerNro(){
        this.numero=this.numero+1;
        return this.numero;
    }
    /**
     * Un método que permite realizar un descuento 
     * en un % variable
     * @param porcentaje recibe el porcentaje de descuento
     * @return el valor a descontar
     */
    public int descontar(int porcentaje){
        int descuento= this.total*porcentaje/100;//*
        return descuento;
    }
    
    /**
     * Un método que permite ver el detalle del pedido
     * del cliente
     */
    public void verPedido(){
        SimpleDateFormat formated=new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Solicitud: "+this.numero);
        System.out.println("****************************");
        System.out.println("Cliente: "+ this.cliente.getNombre());
        System.out.println("Fecha: "+ formated.format(this.fecha));
        System.out.println(this.productos);
        System.out.println("****************************");
        System.out.println("Total: $"+this.total+"\n");
    }
//</editor-fold>
    
}
