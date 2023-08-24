package org.udemy.pooclasesabstractas.zoo.animales.caninos;

public class Perro extends Canino{
    private int fuerzaMordida;

    public Perro(String habitad, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos) {
        super(habitad, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
    }

    public Perro(String habitad, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos, int fuerzaMordida) {
        super(habitad, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    public void setFuerzaMordida(int fuerzaMordida) {
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "Perro COME{" +
                "fuerzaMordida=" + fuerzaMordida +
                ", color='" + color + '\'' +
                ", tamanoColmillos=" + tamanoColmillos +
                ", habitad='" + habitad + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}';
    }

    @Override
    public String dormir() {
        return "Perro DUERME{" +
                "fuerzaMordida=" + fuerzaMordida +
                ", color='" + color + '\'' +
                ", tamanoColmillos=" + tamanoColmillos +
                ", habitad='" + habitad + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}';
    }

    @Override
    public String correr() {
        return "Perro CORRE{" +
                "fuerzaMordida=" + fuerzaMordida +
                ", color='" + color + '\'' +
                ", tamanoColmillos=" + tamanoColmillos +
                ", habitad='" + habitad + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}';
    }

    @Override
    public String comunicarse() {
        return "Perro COMUNICARSE{" +
                "fuerzaMordida=" + fuerzaMordida +
                ", color='" + color + '\'' +
                ", tamanoColmillos=" + tamanoColmillos +
                ", habitad='" + habitad + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}';
    }
}
