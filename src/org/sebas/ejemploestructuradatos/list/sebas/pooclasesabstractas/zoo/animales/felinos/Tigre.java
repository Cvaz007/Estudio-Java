package org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.felinos;

public class Tigre extends Felino{
    private String especieTigre;

    public Tigre(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    public Tigre(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad, String especieTigre) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    public void setEspecieTigre(String especieTigre) {
        this.especieTigre = especieTigre;
    }

    public Tigre() {
        super();
    }

    @Override
    public String comer() {
        return "El tigre como trigo, por lo que pesa "+peso;
    }

    @Override
    public String dormir() {
        return "La mayor debilidad del tigre es su sueño, lo que hace que duerma largas jornadas en el día, por lo que es imposible saber su largo"+largo;
    }

    @Override
    public String correr() {
        return "El tigre es veloz, con una velocidad de "+velocidad;
    }

    @Override
    public String comunicarse() {
        return "Los animales se comunican, tales como el "+nombreCientifico;
    }
}
