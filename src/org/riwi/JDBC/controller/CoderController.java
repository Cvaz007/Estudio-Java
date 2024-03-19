package org.riwi.JDBC.controller;

import org.riwi.JDBC.entity.Coder;
import org.riwi.JDBC.model.CoderModel;

import java.util.List;

public class CoderController {
    CoderModel objCoder;

    public CoderController() {
        this.objCoder = new CoderModel();
    }

    public void getAll() {
        List<Object> list = objCoder.findAll();

        System.out.println("==== CODERS =====");
        for (Object obj : list) {
            Coder coder = (Coder) obj;
            System.out.println("Id: " + coder.getId());
            System.out.println("Name: " + coder.getName());
            System.out.println("Age: " + coder.getAge());
            System.out.println("Clan: " + coder.getClan());
            System.out.println("--------------------------");
        }
    }

    public void getById(int id) {

        Object obj = objCoder.findById(id);

        Coder coder = (Coder) obj;
        System.out.println("Id: " + coder.getId());
        System.out.println("Name: " + coder.getName());
        System.out.println("Age: " + coder.getAge());
        System.out.println("Clan: " + coder.getClan());
        System.out.println("--------------------------");
    }

    public void insert(Object object){
        objCoder.insert(object);
    }

    public boolean update(Object object){
        return objCoder.update(object);
    }

    public boolean delete(int id){
        return objCoder.delete(id);
    }
}
