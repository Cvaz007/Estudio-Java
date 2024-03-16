package org.udemy.primasClases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ejerciciofechas {
    public Date ingresoFecha() throws ParseException {
        Scanner x = new Scanner(System.in);

        System.out.println("Ingrese el formato de la fecha: ");
        String formato = x.next();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = format.parse(formato);

        return fecha;
    }
    public void calcularFecha(Date d){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date actual = new Date();
        df = new SimpleDateFormat("yyyyMMdd");

        int desde = Integer.parseInt(df.format(d));
        int hasta = Integer.parseInt(df.format(actual));

        int edad = (hasta - desde) / 10000;
        System.out.println("La edad es: " + edad);
    }
}
