/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.pgy2121.mipymes.domain;

/**
 *
 * @author Nancy
 */
public class Producto {
//<editor-fold defaultstate="collapsed" desc="atributos">
    private int codigo, precio, cantidad;
    private String subcategoria, descripcion;
    private char medida; //U: unidad - G: gramos    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="constructores">
    public Producto() {
    }

    public Producto(int codigo, int precio, int cantidad, String subcategoria, String descripcion, char medida) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.medida = medida;
    }
    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Get&Set">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getMedida() {
        return medida;
    }

    public void setMedida(char medida) {
        this.medida = medida;
    }
    
//</editor-fold>
}
