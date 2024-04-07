package org.riwi.simulacros.simulacro2_2.controller;

import org.riwi.simulacros.simulacro2_2.repository.CrudRepository;
import org.riwi.simulacros.simulacro2_2.repository.JoinTest;
import org.riwi.simulacros.simulacro2_2.utils.AttributeInfo;
import org.riwi.simulacros.simulacro2_2.utils.Utils;

import javax.swing.*;
import java.util.List;

public class GenericController extends Utils {

    public void getAll(CrudRepository model) {
        List<Object> list = model.findAll();
        String listString = "LIST OF REGISTERS \n";
        for (Object item : list) {
            listString += item.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listString);
    }

    public void get(CrudRepository model) {
        Object id = JOptionPane.showInputDialog("\n¿which do you want to find?");
        JOptionPane.showMessageDialog(null, model.find(id).toString());
    }

    public void delete(CrudRepository model) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿which do you want to delete?"));
        model.delete(model.find(id));
    }

    public void save(CrudRepository model, Class<?> entity) {
        List<AttributeInfo> list = extractAttributesInfo(entity);

        model.save(createObjectDynamically(entity, list));
    }

    public void update(CrudRepository model, Class<?> entity) {
        List<AttributeInfo> list = extractAttributesInfo(entity);
        model.update(createObjectDynamically(entity, list));
    }
}
