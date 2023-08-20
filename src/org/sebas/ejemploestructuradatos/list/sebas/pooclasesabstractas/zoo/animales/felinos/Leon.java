package org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.felinos;

public class Leon extends Felino{
    private int numManada;
    private float potenciaRugidoDecibel;

    public Leon(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    public Leon(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public int getNumManada() {
        return numManada;
    }

    public void setNumManada(int numManada) {
        this.numManada = numManada;
    }

    public float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }

    public void setPotenciaRugidoDecibel(float potenciaRugidoDecibel) {
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public Leon() {
        super();
    }

    @Override
    public String comer() {
        return "El León caza junto a su grupo de " + numManada + " a individuos en las llanuras africanas, ya que su habita esta en "+habitad+
                ". Su rugido tiene una fuerza de "+potenciaRugidoDecibel+", por lo que junto a sus garras que miden "+tamanoGarras+", su velocidad ("+velocidad+")" +
                " y su tamaño "+altura+", pueden llegar a tener un peso de "+peso+"kg. Normalmente este aninmal se conoce como leon pero para lo cientificos es "+nombreCientifico;
    }

    @Override
    public String dormir() {
        return "El leon normalmente duerme alrededor de 12 horas en el día, lo que lleva adquierir gran cantidad de peso, alrededor de unos "+peso+"kg";
    }

    @Override
    public String correr() {
        return "La velocidad que tiene el leon es de "+velocidad+", por lo que pocas presas son capaz de escaparse de sus grandes garras";
    }

    @Override
    public String comunicarse() {
        return "Todos los animales son muy inteligentes, hasta el leon que otras personas lo llaman "+nombreCientifico;
    }
}
