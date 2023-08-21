package org.sebas.poointerfaces.ejemploherencia.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
