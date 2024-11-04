// Classe que representa eletropostos para o carregamento do veiculos
public class Eletropostos {
  private int id;                   // Identificador único do eletroposto
  private int numeroVagas;          // Número de vagas disponíveis para carregamento
  private double tempoCarregamento; // Tempo médio de carregamento em horas
  private double distancia;         // Distância do eletroposto em relação a uma rota, em quilômetros

  // Construtor da classe Eletropostos
  public Eletropostos(int id, int numeroVagas, double tempoCarregamento) {
    this.id = id;
    this.numeroVagas = numeroVagas;
    this.tempoCarregamento = tempoCarregamento;
  }

  // Método Get para obter o ID do eletroposto
  public int get_id() {
    return this.id;
  }

  // Método para definir a distância do eletroposto em relação a uma rota
  // Retorna true se a distância for válida (maior que 0 e menor ou igual à distância total da rota)
  public Boolean setDistancia(double d, Rota rota) {
    if (d > 0 && d <= rota.getKmPercorrido()) {
      this.distancia = d;
      return true;
    }
    System.out.println("Distância inválida!");
    return false;
  }

  // Método para exibir informações do eletroposto
  public void exibirEletroposto() {
    System.out.println("ID: " + id + ", Vagas: " + numeroVagas + ", Tempo: " + tempoCarregamento + ", Distância: " + distancia + "km");
  }

  // Método Get para obter o ID do eletroposto
  public int getId() {
    return id;
  }

  // Método Get para obter o número de vagas disponíveis
  public int getNumeroVagas() {
    return numeroVagas;
  }

  // Método Get para obter o tempo médio de carregamento
  public double getTempoCarregamento() {
    return tempoCarregamento;
  }

  // Método Get para obter a distância do eletroposto
  public double getDistancia() {
    return distancia;
  }
}
