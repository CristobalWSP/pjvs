/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.pgy2121.mipymes.business;

import java.util.Date;

/**
 *
 * @author Nancy
 */
public class Valida {

    public Valida() {
    }
    /**
     * Valor debe ser mayor a 0
     * @param valor recibe un entero
     * @return true si es positivo y false si es cero o negativo
     */
    public boolean validaNroPositivo(int valor){
        return valor>0;
        //<editor-fold defaultstate="collapsed" desc="codigo SIN optimizar">
        /*
        if (valor>0) {
            return true;
        }else
        {
            return false;
        }*/
        //</editor-fold>        
    }
    /**
     * valor debe tener largo 4
     * @param valor recibe un entero
     * @return true si tiene largo 4 y false si no
     */
    public boolean validaLargo4(int valor)
    {
        return (valor>=1000 && valor<=9999);
        //<editor-fold defaultstate="collapsed" desc="codigo SIN optimizar">
        /*
        if (valor>=1000 && valor<=9999) {
            return true;
        }else
        {
            return false;
        }*/
        //</editor-fold>
    }
    /**
     * La subcategoría debe ser Fruta o Verdura
     * @param subcategoria
     * @return 
     */
    public boolean validaSubcategoria(String subcategoria)
    {
        return (subcategoria.equalsIgnoreCase("FRUTA") ||
                subcategoria.equalsIgnoreCase("VERDURA"));
    }
    /**
     * valor debe tener largo 8
     * @param valor recibe un entero
     * @return true si tiene largo 8 y false si no
     */
    public boolean validaLargo8(int valor)
    {
        String largo=valor+"";//truco para convertir número en String
        return (largo.length()==8);
        //return (valor>=10000000 && valor<=99999999);
    }
    /**
     * El mail debe tener largo mínimo de 6
     * @param mail
     * @return 
     */
    public boolean validaMail(String mail){
        return (mail.length()>=6);
    }
    /**
     * El run debe ser válido
     * @param rut
     * @param dv
     * @return true si el DV coincide con el s resultante
     */
    public boolean validaRut(int rut,char dv){
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return Character.toUpperCase(dv) == (char) (s != 0 ? s + 47 : 75);
    }
    /**
     * La fecha de la solicitud debe ser menor o igual a la actual
     * @param fechaSolicitud
     * @return 
     */
    public boolean validarFecha(Date fechaSolicitud)
    {
        Date fechaHoy= new Date();
        return (fechaSolicitud.compareTo(fechaHoy)<=0);
    }

}
