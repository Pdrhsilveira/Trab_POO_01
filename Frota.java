import java.util.ArrayList;
import java.util.List;

// Classe que gerencia a frota dos veículos e motoristas cadastrados
public class Frota {
    private List<CarroEletrico> veiculos; // Lista de veículos na frota
    private List<Motoristas> motoristas;  // Lista de motoristas da frota

    // Construtor que inicializa as listas de veículos e motoristas
    public Frota() {
        this.veiculos = new ArrayList<>();
        this.motoristas = new ArrayList<>();
    }

    // Adiciona um veículo à frota, verificando se o veículo não é nulo
    public void addVeiculo(CarroEletrico veiculo) {
        if (veiculo != null) {
            veiculos.add(veiculo);
        } else {
            System.out.println("Veículo inválido.");
        }
    }

    // Adiciona um motorista à frota, verificando se o motorista não é nulo
    public void addMotorista(Motoristas motorista) {
        if (motorista != null) {
            motoristas.add(motorista);
        } else {
            System.out.println("Motorista inválido.");
        }
    }

    // Exibe informações de todos os veículos cadastrados na frota
    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo registrado.");
        } else {
            for (CarroEletrico v : veiculos) {
                System.out.println(v.getModelo() + ", " + v.getMarca() + ", " + v.getAnoFabricacao());
            }
        }
    }

    // Exibe informações de todos os motoristas cadastrados na frota
    public void listarMotoristas() {
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista registrado.");
        } else {
            for (Motoristas m : motoristas) {
                System.out.println(m.getNome() + ", " + m.getExpertise());
            }
        }
    }

    // Retorna a lista de veículos da frota
    public List<CarroEletrico> getVeiculos() {
        return veiculos;
    }

    // Retorna a lista de motoristas da frota
    public List<Motoristas> getMotoristas() {
        return motoristas;
    }

    // Lista veículos com autonomia abaixo de 20% da capacidade total da bateria
    public void listarVeiculosComAutonomiaInferior() {
        System.out.println("Veículos com autonomia abaixo de 20%:");
        for (CarroEletrico v : veiculos) {
            double limiteAutonomia = v.getCapacidadeTotalBateria() * 0.2;
            if (v.getAutonomiaMaxima() < limiteAutonomia) {
                System.out.println(v.getModelo() + ", " + v.getMarca() + ", " + v.getAutonomiaMaxima());
            }
        }
    }
}
