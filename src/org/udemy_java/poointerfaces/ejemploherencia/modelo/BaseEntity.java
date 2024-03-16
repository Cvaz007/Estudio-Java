package org.udemy_java.poointerfaces.ejemploherencia.modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int ultimoId;
    public BaseEntity() {
        this.id= ++ultimoId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return Objects.equals(id, cliente.id);
    }
}
