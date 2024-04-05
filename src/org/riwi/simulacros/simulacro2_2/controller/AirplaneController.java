package org.riwi.simulacros.simulacro2_2.controller;

import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.model.AirplaneModel;

import javax.swing.*;

public class AirplaneController {
    private final AirplaneModel airplaneModel;

    public AirplaneController() {
        this.airplaneModel = new AirplaneModel();
    }

    public void saveAirplane(){
        String model = JOptionPane.showInputDialog("type the airplane model");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("Type the airplane capacity"));

        Airplane airplane = new Airplane(model, capacity);
        airplaneModel.save(airplane);
    }

    public void updateAirplane(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿which airplane do you want to update?"));
        String model = JOptionPane.showInputDialog("type the airplane model");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("Type the airplane capacity"));

        Airplane airplane = new Airplane(id,model, capacity);
        airplaneModel.update(airplane);
    }

    public void deleteAirplane(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿which airplane do you want to delete?"));
        airplaneModel.delete(id);
    }

    public void findAirplane(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿which airplane do you want to find?"));
        Airplane airplane = (Airplane) airplaneModel.find(id);
        JOptionPane.showMessageDialog(null, airplane.toString());
    }

    public void findAll(){
        String airplanes = "AIRPLANES \n";
        for(Object airplane : airplaneModel.findAll() ){
            airplanes += airplane.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, airplanes);
    }
}
