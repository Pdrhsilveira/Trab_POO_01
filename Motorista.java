class Motorista {
    private String nome;
    private int id;
    private String numeroHabilitacao;
    private int experiencia;

    public Motorista(int id, String nome, String numeroHabilitacao, int experiencia) {
        this.id = id;
        this.nome = nome;
        this.numeroHabilitacao = numeroHabilitacao;
        this.experiencia = experiencia;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
