import java.util.ArrayList;
import java.util.List;


//Classe que representa um carro elétrico com seus atributos
 
public class CarroEletrico {

  protected int id;                        // ID do carro
  protected String marca;                  // Marca do carro
  protected String modelo;                 // Modelo do carro
  protected int anoFabricacao;             // Ano de fabricação
  protected double capacidadeTotalBateria; // Capacidade da bateria em kWh
  protected double autonomiaMaxima;        // Autonomia máxima em km
  protected double tempoMedioRecarga;      // Tempo médio de recarga em horas

  
  //Construtor que inicializa os dados do carro e o adiciona a uma frota
  
  public CarroEletrico(int id, String marca, String modelo, int anoFabricacao, double autonomiaMaxima,
                       double capacidadeTotalBateria, double tempoMedioRecarga, Frota frota) {
    this.id = id;
    this.marca = marca;
    this.modelo = modelo;
    this.anoFabricacao = anoFabricacao;
    this.autonomiaMaxima = autonomiaMaxima;
    this.capacidadeTotalBateria = capacidadeTotalBateria;
    this.tempoMedioRecarga = tempoMedioRecarga;
    frota.addVeiculo(this);  // Adiciona o carro à frota
  }

  // Métodos Getters para obter os atributos do carro
  public String getModelo() {
     return modelo; 

    }

  public int getId() {
     return id;

    }
  public String getMarca() { 
    return marca; 

  }

  public int getAnoFabricacao() { 
    return anoFabricacao;

   }

  public double getCapacidadeTotalBateria() { 
    return capacidadeTotalBateria;

   }

  public double getAutonomiaMaxima() { 
    return autonomiaMaxima;

   }

  public double getTempoMedioRecarga() { 
    return tempoMedioRecarga;

  }

  //Verifica se o carro consegue completar uma rota específica, considerando todas0 as paradas de recarga
  
  public boolean verificarAutonomia(Rota rota, Registro r) {
    List<Eletropostos> listEletropostos = rota.getEletropostos();
    List<Eletropostos> eletropostosParada = new ArrayList<>();
    double distancia = rota.getKmPercorrido();
    int contador = 0;

    // Laço para verificar se o carro possui autonomia suficiente para chegar até o próximo eletroposto
    while (autonomiaMaxima < distancia && contador < listEletropostos.size()) {
      Eletropostos eletroposto = listEletropostos.get(contador);
      eletropostosParada.add(eletroposto);

      // Verifica se o carro consegue chegar ao eletroposto
      if (autonomiaMaxima < eletroposto.getDistancia()) {
        return false;  // Retorna False, caso a autonomia for suficiente
      }
      autonomiaMaxima -= eletroposto.getDistancia();
      distancia -= eletroposto.getDistancia();
      contador++;
    }

    // Exibe as paradas de recarga
    System.out.println("Paradas:");
    for (Eletropostos e : eletropostosParada) {
      System.out.println("Distancia Eletroposto: " + e.getDistancia());
      r.addRegistroRecarga("Eletroposto da Rota: " + rota.getOrigem() + "/" + rota.getDestino() + 
                           ", Veiculo Modelo: " + modelo + ", Marca: " + marca);
    }

    // Retorna se conseguiu completar a rota
    if (autonomiaMaxima < distancia) {
      return false;
    } else {
      capacidadeTotalBateria -= rota.getKmPercorrido();
      return true;
    }
  }

  
  // Define a capacidade total da bateria do carro
  
  public void setCapacidadeTotalBateria(double capacidadeTotalBateria) {
    this.capacidadeTotalBateria = capacidadeTotalBateria;
  }
}
