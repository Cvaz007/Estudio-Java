package org.sebas.poointerfaces.ejemploherencia.repositorio;

import org.sebas.poointerfaces.ejemploherencia.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrPaCrudRepositorio<T> {
    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        T resultado =  null;
        for (T cli: dataSource){
            if (cli.getId() != null && cli.getId().equals(id)){
                resultado=cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }
}
