/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cl.duoc.pgy2121.mipymes;

import cl.duoc.pgy2121.mipymes.business.Solicitud;
import cl.duoc.pgy2121.mipymes.business.Valida;
import cl.duoc.pgy2121.mipymes.domain.Cliente;
import cl.duoc.pgy2121.mipymes.domain.Producto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Nancy
 */
public class MiPymes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //menú
        int opc;
        boolean flag;//para validaciones
        //variables para el cliente
        int rut, telefono;
        char dv;
        String nombre, mail, direccion;
        //variables para el producto
        int codigo, precio, cantidad, totalProductos;
        String subcategoria, descripcion;
        char medida;
        //variables para la solicitud
        int numero;
        String fecha;

        int porcentaje, descuento;

        Scanner input = new Scanner(System.in);
        Valida valida = new Valida();
        Cliente cliente = new Cliente();
        Solicitud solicitud = new Solicitud();
        //escribo el menú
        do {
            System.out.println(".....MENU.....");
            System.out.println("1.- Ingresar Cliente");
            System.out.println("2.- Ingresar Solicitud (y sus productos)");
            System.out.println("3.- Aplicar Descuento");
            System.out.println("4.- Ver Solicitud [SALIR]");
            opc = input.nextInt();

            switch (opc) {
                case 1: //1.- Ingresar Cliente
                    do {
                        System.out.println("Ingrese RUT: ");
                        rut = input.nextInt();
                        System.out.println("Ingrese DV: ");
                        dv = input.next().charAt(0);
                        flag = valida.validaRut(rut, dv);
                        if (flag == false) {
                            System.out.println("RUT NO Valido");
                        }
                    } while (flag == false);
                    System.out.println("Ingrese Nombre: ");
                    nombre = input.next();
                    do {
                        System.out.println("Ingrese Fono: ");
                        telefono = input.nextInt();
                        flag = valida.validaLargo8(telefono);
                        if (flag == false) {
                            System.out.println("Telefono NO Valido (debe ser largo 8)");
                        }
                    } while (flag == false);
                    do {
                        System.out.println("Ingrese Correo: ");
                        mail = input.next();
                        flag = valida.validaMail(mail);
                        if (flag == false) {
                            System.out.println("Correo NO Valido (minimo largo 6)");
                        }
                    } while (flag == false);
                    System.out.println("Ingrese direccion: ");                    
                    direccion = input.next();
                    //guardo los datos validados en el cliente
                    cliente.setRut(rut);
                    cliente.setDv(dv);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setMail(mail);
                    cliente.setDireccion(direccion);
                    break;
                case 2://2.- Ingresar Solicitud (y sus productos)
                    numero = solicitud.obtenerNro();
                    solicitud.setNumero(numero);
                    solicitud.setCliente(cliente);
                    Date fechaDate = null;
                    do {
                        System.out.println("Ingrese Fecha [dd/mm/aaaa]: ");
                        fecha = input.next();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            fechaDate = formato.parse(fecha);
                            flag = valida.validarFecha(fechaDate);
                        } catch (ParseException ex) {
                            flag = false;
                            System.out.println("Fecha NO Valida");
                        }
                    } while (flag == false);
                    solicitud.setFecha(fechaDate);
                    //Productos para la solicitud
                    System.out.println("¿Cuántos productos ingresara?: ");
                    totalProductos = input.nextInt();
                    for (int i = 1; i <= totalProductos; i++) {
                        Producto prod = new Producto();
                        codigo = 0;
                        precio = 0;
                        cantidad = 0;
                        subcategoria = "";
                        descripcion = "";
                        medida = ' ';
                        do {
                            System.out.println("Ingrese codigo: ");
                            codigo = input.nextInt();
                            flag = valida.validaLargo4(codigo);
                            if (flag == false) {
                                System.out.println("Codigo NO Valido (debe ser largo 4)");
                            }
                        } while (flag == false);
                        do {
                            System.out.println("Ingrese precio: $");
                            precio = input.nextInt();
                            flag = valida.validaNroPositivo(precio);
                            if (flag == false) {
                                System.out.println("Precio NO Valido");
                            }
                        } while (flag == false);
                        do {
                            System.out.println("Ingrese subcategoria [Fruta o Verdura]: ");
                            subcategoria = input.next();
                            flag = valida.validaSubcategoria(subcategoria);
                            if (flag == false) {
                                System.out.println("Subcategoria NO Valido");
                            }
                        } while (flag == false);
                        System.out.println("Ingrese descripcion: ");
                        descripcion=input.next();
                        
                        System.out.println("Ingrese medida [U: unidad/G: gramos]");
                        medida=input.next().charAt(0);
                        if (medida=='U') {
                            System.out.println("Ingrese unidades: ");
                        }else
                        {
                            System.out.println("Ingrese gramos: ");
                        }
                        cantidad=input.nextInt();
                        //guardo en producto
                        prod.setCodigo(codigo);
                        prod.setPrecio(precio);
                        prod.setSubcategoria(subcategoria);
                        prod.setDescripcion(descripcion);
                        prod.setMedida(medida);
                        prod.setCantidad(cantidad);
                        //agrego producto a la solicitud
                        solicitud.agregarProductos(prod);
                        System.out.println("----------------------------");                        
                    }
                    break;
                case 3://3.- Aplicar Descuento
                    System.out.println("Ingrese porcentaje de descuento [1-100]%: ");
                    porcentaje=input.nextInt();
                    descuento=solicitud.descontar(porcentaje);
                    System.out.println("Total: $"+solicitud.getTotal());
                    System.out.println("Descuento: $"+descuento);
                    System.out.println("Total a Pagar: $"+(solicitud.getTotal()-descuento));
                    break;
                case 4://4.- Ver Solicitud
                    System.out.println("Fin de Solicitud");
                    solicitud.verPedido();
                    break;
                default:
                    System.out.println("Opcion NO VALIDA!!");
            }

        } while (opc != 4);
    }

}
