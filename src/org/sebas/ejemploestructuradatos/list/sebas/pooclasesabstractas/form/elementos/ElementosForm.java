package org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.form.elementos;

/*
Las clases abstractas son una característica importante de la programación orientada a objetos en Java.
Una clase abstracta es una clase que no se puede instanciar directamente y se utiliza como base para
otras clases. Una clase abstracta puede tener métodos abstractos, que son métodos que no tienen una
implementación y deben ser implementados por las clases que heredan de la clase abstracta
*/
abstract public class ElementosForm {
    protected String nombre;
    protected String valor;

    public ElementosForm() {
    }

    public ElementosForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    abstract public String dibujatHtml();
}
