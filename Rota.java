import java.util.ArrayList;
import java.util.List;

// Classe Rota: Representa uma rota com uma origem, destino, distância percorrida e uma lista de eletropostos ao longo da rota
public class Rota {
  private String origem;  // Origem da rota
  private String destino;  // Destino da rota
  private double kmPercorrido;  // Distância total da rota
  private List<Eletropostos> eletropostos;  // Lista de eletropostos ao longo da rota

  // Métodos getters: Retornam os valores dos atributos privados
  public String getOrigem() {
    return origem;
  }

  public String getDestino() {
    return destino;
  }

  public double getKmPercorrido() {
    return kmPercorrido;
  }

  public List<Eletropostos> getEletropostos() {
    return eletropostos;
  }

  // Método listarEletropostos: Exibe o ID de cada eletroposto ao longo da rota
  public void listarEletropostos() {
    for (Eletropostos eletroposto : eletropostos) {
      System.out.println("Eletroposto ID: " + eletroposto.get_id());
    }
  }

  // Método ordenarEletropostos: Ordena a lista de eletropostos com base na distância do eletroposto em relação ao ponto inicial da rota
  public void ordenarEletropostos() {
    // Algoritmo de ordenação (Bubble Sort)
    for (int i = 0; i < eletropostos.size() - 1; i++) {
      for (int j = i + 1; j < eletropostos.size(); j++) {
        if (eletropostos.get(j).getDistancia() < eletropostos.get(i).getDistancia()) {
          Eletropostos temp = eletropostos.get(i);
          eletropostos.set(i, eletropostos.get(j));
          eletropostos.set(j, temp);
        }
      }
    }
  }

  // Construtor da classe Rota: Inicializa a rota com origem, destino e distância, e cria uma lista vazia de eletropostos
  public Rota(String origem, String destino, double kmPercorrido) {
    this.origem = origem;
    this.destino = destino;
    this.kmPercorrido = kmPercorrido;
    this.eletropostos = new ArrayList<>();
  }

  // Método addEletroposto: Adiciona um eletroposto à lista de eletropostos da rota
  public void addEletroposto(Eletropostos eletroposto) {
    this.eletropostos.add(eletroposto);
  }

  // Método setKmPercorrido: Permite atualizar a distância total da rota
  public void setKmPercorrido(double kmPercorrido) {
    this.kmPercorrido = kmPercorrido;
  }
}
