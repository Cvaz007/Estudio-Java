package org.riwi.simulacro2;

import org.riwi.simulacro2.controller.AppointmentController;
import org.riwi.simulacro2.controller.DoctorController;
import org.riwi.simulacro2.controller.PatientController;
import org.riwi.simulacro2.controller.SpecialtyController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DoctorController doctorController = new DoctorController();
        SpecialtyController specialtyController =  new SpecialtyController();
        PatientController patientController = new PatientController();
        AppointmentController appointmentController = new AppointmentController();
        
        int opcion = 0, opcionEspecialidad = 0, opcionMedico = 0, opcionPaciente = 0 , opcionCita = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Ingrese una opción
                    1 - CRUD ESPECIALIDAD
                    2 - CRUD MEDICO
                    3 - CRUD PACIENTE
                    4 - CRUD CITA
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcionEspecialidad = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear especialidad
                                2 - Eliminar especialidad 
                                3 - Actualizar especialidad
                                4 - Listar especialidades
                                5 - Salir 
                                """));

                        switch (opcionEspecialidad){
                            case 1:
                                specialtyController.saveSpecialty();
                                break;
                            case 2:
                                specialtyController.deleteSpecialty();
                                break;
                            case 3:
                                specialtyController.updateSpecialty();
                                break;
                            case 4:
                                specialtyController.finAllSpecialty();
                                break;
                        }
                    }while (opcionEspecialidad != 5);

                    break;

                case 2:
                    do {
                        opcionMedico = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear medico
                                2 - Eliminar medico 
                                3 - Actualizar medico
                                4 - Listar medicos 
                                5 - Buscar medicos por especialidad 
                                6 - Salir
                                """));

                        switch (opcionMedico){
                            case 1:
                                doctorController.saveDoctor();
                                break;
                            case 2:
                                doctorController.deleteDoctor();
                                break;
                            case 3:
                                doctorController.updateDoctor();
                                break;
                            case 4:
                                doctorController.findAll();
                                break;
                            case 5:
                                //Falta
                                doctorController.findDoctorBySpecialty();
                                break;
                        }


                    }while (opcionMedico != 6);
                    break;

                case 3:
                    do {
                        opcionPaciente = Integer.parseInt(JOptionPane.showInputDialog("""
                                 1 - Crear paciente 
                                 2 - Eliminar paciente 
                                 3 - Actualizar paciente  
                                 4 - Listar pacientes 
                                 5 - Buscar paciente por cédula
                                 6 - Salir 
                                 """));

                        switch (opcionPaciente){
                            case 1:
                                patientController.savePatient();
                                break;
                            case 2:
                                patientController.deletePatient();
                                break;
                            case 3:
                                patientController.updatePatient();
                                break;
                            case 4:
                                patientController.findAll();
                                break;
                            case 5:
                                patientController.findPatient();
                                break;
                        }

                    }while (opcionPaciente != 6);
                    break;

                case 4:
                    do {
                        opcionCita = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear cita
                                2 - Eliminar cita 
                                3 - Actualizar cita 
                                4 - Listar cita 
                                5 - listar cita por fecha 
                                6 - Salir
                                
                                """));

                        switch (opcionCita){
                            case 1:
                                appointmentController.saveAppointment();
                                break;
                            case 2:
                                appointmentController.deleteAppointment();
                                break;
                            case 3:
                                appointmentController.updateAppointment();
                                break;
                            case 4:
                                appointmentController.findAllAppointment();
                                break;
                            case 5:
                                appointmentController.findAppointmentByDate();
                                break;
                        }
                    }while (opcionCita != 6);
                    break;
            }


        }while (opcion != 5);
    }
}
