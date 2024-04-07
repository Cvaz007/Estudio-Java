package org.riwi.simulacros.simulacro2_1.controller;

import org.riwi.simulacros.simulacro2_1.repository.CrudRepository;
import org.riwi.simulacros.simulacro2_1.repository.JoinTest;

import javax.swing.*;
import java.util.List;

public class ExtensionController {

    public void getByDate(CrudRepository model, JoinTest join) {
        List<Object> list = model.findAll();
        String listString = "LIST OF REGISTERS -SELECT ONE \n";
        for (Object item : list) {
            listString += item.toString() + "\n";
        }
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, listString));

        String listRegisters= "LIST OF REGISTERS \n";

        for (Object item : join.findEntityBySomething(option)) {
            listRegisters += item.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listRegisters);
    }
}
