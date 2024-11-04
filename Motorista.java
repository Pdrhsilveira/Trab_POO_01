// Classe que representa um motorista associado a uma frota de veículos
public class Motoristas {
    private String nome;      // Nome do motorista
    private int id;           // Id do motorista
    private int numeroCNH;    // Número da CNH do motorista
    private String expertise; // Experiencia no volante do motorista

    // Construtor que inicializa os atributos do motorista e o adiciona à frota
    public Motoristas(int numeroCNH, String expertise, int id, String nome, Frota frota) {
        validarParametros(numeroCNH, nome, frota); // Valida parâmetros de entrada

        this.numeroCNH = numeroCNH;
        this.expertise = expertise;
        this.id = id;
        this.nome = nome;

        // Adiciona o motorista à frota
        frota.addMotorista(this);
    }

    // Método privado para validar os parâmetros de entrada
    private void validarParametros(int numeroCNH, String nome, Frota frota) {
        if (frota == null) {
            throw new IllegalArgumentException("Ops! A frota não pode ser nula.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do motorista não pode ser vazio.");
        }
        if (numeroCNH <= 0) {
            throw new IllegalArgumentException("O número da CNH deve ser positivo.");
        }
    }

    // Métodos Getters
    // Retorna o nome do motorista
    public String getNome() {
        return nome;
    }

    // Retorna o identificador do motorista
    public int getId() {
        return id;
    }

    // Retorna o número da CNH do motorista
    public int getNumeroCNH() {
        return numeroCNH;
    }

    // Retorna a expertise do motorista
    public String getExpertise() {
        return expertise;
    }
}

