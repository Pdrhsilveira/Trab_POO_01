import java.util.ArrayList;
import java.util.List;

// Classe Registro: Responsável por gerenciar o registro de viagens e o histórico de recargas
public class Registro {

  // Lista para armazenar as viagens realizadas
  private List<Viagem> registroViagens;

  // Lista para armazenar o histórico de recargas
  private List<String> recargasHistorico;
 

  // Construtor: Inicializa as listas de viagens e recargas
  public Registro() {
    this.registroViagens = new ArrayList<>();
    this.recargasHistorico = new ArrayList<>();
  }

  // Método addRegistro: Adiciona uma nova viagem ao registro de viagens
  public void addRegistro(Viagem v) {
    registroViagens.add(v);
  }

  // Método consultarMotorista: Exibe todas as viagens realizadas por um motorista específico
  public void consultarMotorista(Motoristas motorista){
    System.out.println("\n::Viagens feitas por " + motorista.getNome() + "::");
  
    // Itera pelo registro de viagens e exibe as viagens associadas ao motorista
    for(Viagem v : registroViagens) {
      if(motorista.getId() == v.getMotorista().getId()){
        v.exibirViagem();  // Exibe os detalhes da viagem
      } 
    }
  }

  // Método exibirHistoricoRecargas: Exibe o histórico de recargas realizadas
  public void exibirHistoricoRecargas(){
    if(recargasHistorico.size() > 0) {
      System.out.println("\n::Histórico de Recargas::");

      // Exibe cada recarga registrada no histórico
      for(String recarga : recargasHistorico) {
        System.out.println(recarga);
      }
    } else {
      System.out.println("\n::Nenhuma recarga registrada!::");
    }
  }

  // Método addRegistroRecarga: Adiciona uma nova entrada ao histórico de recargas
  public void addRegistroRecarga(String registro) {
    recargasHistorico.add(registro);
  }
}
