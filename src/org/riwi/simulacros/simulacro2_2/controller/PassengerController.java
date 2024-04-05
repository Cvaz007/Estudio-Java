package org.riwi.simulacros.simulacro2_2.controller;

import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.entity.Passenger;
import org.riwi.simulacros.simulacro2_2.model.AirplaneModel;
import org.riwi.simulacros.simulacro2_2.model.PassengerModel;
import org.riwi.simulacros.simulacro2_2.utils.Utils;

import javax.swing.*;

public class PassengerController {
    private final PassengerModel passengerModel;
    private final AirplaneModel airplaneModel;
    private final Utils utils;

    public PassengerController() {
        this.passengerModel = new PassengerModel();
        this.airplaneModel = new AirplaneModel();
        this.utils = new Utils();
    }

    public void saver(){
        String destination = JOptionPane.showInputDialog("Type the destination");
        String start = JOptionPane.showInputDialog("Type the start date (YYYY-MM-DD)");
        String time = JOptionPane.showInputDialog("Type the time: (HH-mm-ss)");
        Airplane airplaneId = (Airplane) utils.getOption(airplaneModel.findAll(),"Select one airplane");

        Passenger passenger = new Passenger(destination,)
    }
}
