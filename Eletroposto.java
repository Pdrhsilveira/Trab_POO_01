class Eletroposto {
    private int id;
    private String local;
    private int numVagas;
    private int vagasOcupadas;
    private int tempoCarga;

    public Eletroposto(int id, String local, int numVagas, int tempoCarga) {
        this.id = id;
        this.local = local;
        this.numVagas = numVagas;
        this.vagasOcupadas = 0;
        this.tempoCarga = tempoCarga;
    }

    public boolean verificarDisponibilidade() {
        return vagasOcupadas < numVagas;
    }

    public void ocuparVaga() {
        if (verificarDisponibilidade()) {
            vagasOcupadas++;
            System.out.println("Vaga ocupada no Eletroposto " + id + " localizado em " + local);
            System.out.println("Tempo estimado de carga: " + tempoCarga + " minutos.");
        } else {
            System.out.println("Eletroposto " + id + " em " + local + " está cheio.");
        }
    }

    public void liberarVaga() {
        if (vagasOcupadas > 0) {
            vagasOcupadas--;
            System.out.println("Vaga liberada no Eletroposto " + id + " localizado em " + local);
        }
    }

    public int getId() {
        return id;
    }
}
