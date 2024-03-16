package org.udemy.pooclasesabstractas.form.elementos;

import org.udemy.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementosForm{
    private List<Opcion> opciones;

    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<>();
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }
    public SelectForm addOpciones(Opcion opcion){
        this.opciones.add(opcion);
        return this;
    }
    @Override
    public String dibujatHtml() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name='").append(this.nombre).append("'>");

        for(Opcion opcion :this.opciones){
            sb.append("\n<option value='").append(opcion.getValor()).append("'");
            if(opcion.isSelected()) sb.append("selected");

            sb.append(opcion.getNombre()).append("</option>");
        }
        sb.append("</sleect>");
        return sb.toString();
    }
}
