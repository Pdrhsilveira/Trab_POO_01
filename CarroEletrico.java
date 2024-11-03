class CarroEletrico {
    protected int id;
    protected String marca;
    protected String modelo;
    protected int anoFabricacao;
    protected double capacidadeBateria;
    protected double autonomiaMaxima;
    protected double autonomiaAtual;

    public CarroEletrico(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMaxima) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidadeBateria = capacidadeBateria;
        this.autonomiaMaxima = autonomiaMaxima;
        this.autonomiaAtual = autonomiaMaxima; // Começa com a autonomia máxima
    }

    public void recarregarBateria() {
        autonomiaAtual = autonomiaMaxima;
        System.out.println("Bateria recarregada. Autonomia atual: " + autonomiaAtual);
    }

    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public void reduzirAutonomia(double distancia) {
        autonomiaAtual -= distancia;
    }
}

class CarroCompacto extends CarroEletrico {
    public CarroCompacto(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMaxima) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, autonomiaMaxima);
    }
}

class CarroSedan extends CarroEletrico {
    public CarroSedan(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMaxima) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, autonomiaMaxima);
    }
}

class CarroSUV extends CarroEletrico {
    public CarroSUV(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMaxima) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, autonomiaMaxima);
    }
}
