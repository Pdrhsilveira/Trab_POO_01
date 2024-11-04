// Classe Viagem: Representa uma viagem realizada com um veículo elétrico, em uma rota específica, por um motorista específico
public class Viagem {
  private Rota rota;             // Rota da viagem
  private Motoristas motorista;  // Motorista responsável pela viagem
  private CarroEletrico veiculo; // Veículo elétrico utilizado na viagem

  // Construtor da classe Viagem: Inicializa a viagem com uma rota, um motorista e um veículo específico
  public Viagem(Rota rota, Motoristas motorista, CarroEletrico veiculo) {
    this.rota = rota;
    this.motorista = motorista;
    this.veiculo = veiculo;
  }
 
  // Métodos Getters
  public Rota getRota() {
    return rota;
  }
  
  public Motoristas getMotorista() {
    return motorista;
  }

  // Método exibirViagem: Exibe os detalhes da viagem, incluindo a origem, destino, distância percorrida, e o modelo e marca do veículo
  public void exibirViagem() {
      System.out.println("-> Origem: " + rota.getOrigem() + ", Destino: " + rota.getDestino() + ", Distancia:" + rota.getKmPercorrido() + "KM" + 
      "\nVEICULO UTILIZADO - " + " Modelo: " + veiculo.getModelo() + ", Marca: " + veiculo.getMarca() + "\n");
  }
  
}
