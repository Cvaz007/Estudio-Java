package org.udemy.poointerfaces.catalogo;

import org.udemy.poointerfaces.catalogo.electronico.IElectronico;
import org.udemy.poointerfaces.catalogo.electronico.IPhone;
import org.udemy.poointerfaces.catalogo.electronico.TvLcd;
import org.udemy.poointerfaces.catalogo.literario.Comic;
import org.udemy.poointerfaces.catalogo.literario.ILibro;
import org.udemy.poointerfaces.catalogo.literario.Libro;

public class Main {
    public static void main(String[] args) {
        IProducto[] productos = new Producto[6];

        productos[0] = new IPhone(299000, "Apple", "3G", "Negro");
        productos[1] = new IPhone(399000, "Apple", "4G", "Blanco");
        productos[2] = new TvLcd(340000, "Sony", 40);
        productos[3] = new Libro(18000,"Eric Gamma", "Elementos reusables POO", "Alguna...");
        productos[4] = new Libro(14000,"Martin Fowler", "UML Gota a Gota", "Alguna...");
        productos[5] = new Comic(5000,"Pepo", "Condorito", "Alguna...", "Condorito");

        for (IProducto producto : productos) {

            System.out.print("Tipo de: " + producto.getClass().getName());
            System.out.print(" - ");
            System.out.print("Precio: " + producto.getPrecio());
            System.out.print(" - ");
            System.out.print("Precio final: " + producto.getPrecioVenta());

            // Para los Electronicos  ============
            if (producto instanceof IElectronico) {
                System.out.print(" - ");
                System.out.print("Fabricante: " + ((IElectronico) producto).getFabricante());

                // Para los IPhone ============
                if (producto instanceof IPhone) {
                    System.out.print(" - ");
                    System.out.print("Modelo: " + ((IPhone) producto).getModelo());
                    System.out.print(" - ");
                    System.out.print("Color: " + ((IPhone) producto).getColor());
                }

                // Para los LCD  ============
                if (producto instanceof TvLcd) {
                    System.out.print(" - ");
                    System.out.print("Pulgadas: " + ((TvLcd) producto).getPulgada());
                }
            }

            // Para los Libros  ============
            if (producto instanceof ILibro) {
                System.out.print(" - ");
                System.out.print("Titulo: " + ((ILibro) producto).getTitulo());
                System.out.print(" - ");
                System.out.print("Autor: " + ((ILibro) producto).getAutor());

                // Para los Comics  ============
                if (producto instanceof Comic) {
                    System.out.print(" - ");
                    System.out.print("Personaje: " + ((Comic) producto).getPersonaje());
                }

            }

            System.out.println();
        }
    }
}
