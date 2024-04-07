package org.riwi.simulacros.simulacro2_2.controller;

import org.riwi.simulacros.simulacro2_2.entity.Reservation;
import org.riwi.simulacros.simulacro2_2.model.ReservationModel;
import org.riwi.simulacros.simulacro2_2.utils.Utils;

import javax.swing.*;

public class ReservationController extends Utils {
    ReservationModel model;

    public ReservationController() {
        this.model = new ReservationModel();
    }

    public void getBySomething() {
        Object[] options = listToArray(model.findAll());
        Reservation option = (Reservation) JOptionPane.showInputDialog(
                null,
                "Select one option",
                "Inner join",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );


        String listString = "LIST OF REGISTERS \n";
        for (Object item : model.findEntityBySomething(option)) {
            listString += item.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listString);
    }
}
