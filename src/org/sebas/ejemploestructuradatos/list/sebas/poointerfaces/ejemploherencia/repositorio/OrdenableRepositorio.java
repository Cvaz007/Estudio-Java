package org.sebas.ejemploestructuradatos.list.sebas.poointerfaces.ejemploherencia.repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);
}
