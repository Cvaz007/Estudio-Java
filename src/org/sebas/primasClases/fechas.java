package org.sebas.primasClases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class fechas {
    public void formatoFechas() {
        Date fecha = new Date();
        System.out.println("fecha = " + fecha);
        // ahora para darle formato usamos el metodo de la clase date
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(fecha);
        System.out.println("date = " + date);

    }
    public void metodoGettime(int f) {
        //para tomar el tiempo que se demora una accion en realizarse
        Date time1 = new Date();
        int sum = 0;
        for (long i = 0; i < 10088888800l; i++) {
            sum += 1;
        }
        Date time2 = new Date();
        long finalT = time2.getTime() - time1.getTime();
        System.out.println("finalT = " + finalT);
    }
    public void claseCalendar() {
        //es una clase absatrata, lo que no nos permite hacer un new de calendar
        Calendar calendario = Calendar.getInstance();
        calendario.set(2020, 0, 07);
        System.out.println("calendario = " + calendario);
    }
    public void stringToDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Scanner x = new Scanner(System.in);
        System.out.println("Ingrese el formato de la fecha: ");
        String formato = x.next();
        Date fecha = new Date();

        try {
            fecha = format.parse(formato);
            System.out.println("fecha = " + fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //esto es por pereza de crear un metodo para pedir las PrimasClases.fechas
        Date fecha2 = new Date();
        comparateDates(fecha2,fecha);
    }
    public void comparateDates(Date d1,Date d2){
        String resultado = d1.after(d2)? "La fecha 1 tiene es after":"La fecha 2 es after";
        System.out.println("resultado = " + resultado);
        String resultado2 = d1.before(d2)? "La fecha 1 es before":"La fecha 2 es before";
        System.out.println("resultado2 = " + resultado2);
    }
}
