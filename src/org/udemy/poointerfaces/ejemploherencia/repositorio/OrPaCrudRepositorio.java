package org.udemy.poointerfaces.ejemploherencia.repositorio;

public interface OrPaCrudRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio, CrudRepositorio<T> {

}
