package org.riwi.JDBC.repository;

import java.util.List;

public interface CRUD {
    //! An interface can be implemented abstract method.
    Object insert(Object object);
    boolean update(Object object);
    boolean delete(int id);
    List<Object> findAll();
    Object findById(int id);

    public static void showSomething(Object object){
        System.out.println("This is a message: "+object);
    }
}
