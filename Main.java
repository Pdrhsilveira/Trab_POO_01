import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<CarroEletrico> carros = new ArrayList<>();
    private static List<Motorista> motoristas = new ArrayList<>();
    private static List<Eletroposto> eletropostos = new ArrayList<>();
    private static List<Viagem> viagens = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        exibirMenu();
    }

    private static void inicializarDados() {
        // Carregar alguns dados de exemplo
        carros.add(new CarroCompacto(1, "Tesla", "Model 3", 2020, 75, 350));
        motoristas.add(new Motorista(1, "Pedro", "123456789", 5));
        eletropostos.add(new Eletroposto(1, "Centro", 2, 30));
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Adicionar Carro, Motorista, Eletroposto ou Viagem");
            System.out.println("2. Relatórios e Consultas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1 -> adicionarNovo();
                case 2 -> relatoriosEConsultas();
                case 3 -> System.out.println("Encerrando o programa.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void adicionarNovo() {
        System.out.println("\n1. Adicionar Carro");
        System.out.println("2. Adicionar Motorista");
        System.out.println("3. Adicionar Eletroposto");
        System.out.println("4. Adicionar Viagem");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> adicionarCarro();
            case 2 -> adicionarMotorista();
            case 3 -> adicionarEletroposto();
            case 4 -> adicionarViagem();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void adicionarCarro() {
        System.out.print("Informe o ID do carro: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano de Fabricação: ");
        int ano = scanner.nextInt();
        System.out.print("Capacidade da Bateria: ");
        double capacidade = scanner.nextDouble();
        System.out.print("Autonomia Máxima: ");
        double autonomiaMaxima = scanner.nextDouble();

        CarroEletrico novoCarro = new CarroCompacto(id, marca, modelo, ano, capacidade, autonomiaMaxima);
        carros.add(novoCarro);
        System.out.println("Carro adicionado com sucesso.");
    }

    private static void adicionarMotorista() {
        System.out.print("Informe o ID do motorista: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do motorista: ");
        String nome = scanner.nextLine();
        System.out.print("Número da habilitação: ");
        String numeroHabilitacao = scanner.nextLine();
        System.out.print("Anos de experiência: ");
        int experiencia = scanner.nextInt();

        Motorista novoMotorista = new Motorista(id, nome, numeroHabilitacao, experiencia);
        motoristas.add(novoMotorista);
        System.out.println("Motorista adicionado com sucesso.");
    }

    private static void adicionarEletroposto() {
        System.out.print("Informe o ID do eletroposto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Localização do eletroposto: ");
        String local = scanner.nextLine();
        System.out.print("Número de vagas: ");
        int numVagas = scanner.nextInt();
        System.out.print("Tempo de carga (em minutos): ");
        int tempoCarga = scanner.nextInt();

        Eletroposto novoEletroposto = new Eletroposto(id, local, numVagas, tempoCarga);
        eletropostos.add(novoEletroposto);
        System.out.println("Eletroposto adicionado com sucesso.");
    }

    private static void adicionarViagem() {
        System.out.print("Informe o ID do carro para a viagem: ");
        int carroId = scanner.nextInt();
        System.out.print("Informe o ID do motorista para a viagem: ");
        int motoristaId = scanner.nextInt();
        System.out.print("Distância total da viagem (km): ");
        double distanciaTotal = scanner.nextDouble();

        CarroEletrico carro = carros.stream().filter(c -> c.id == carroId).findFirst().orElse(null);
        Motorista motorista = motoristas.stream().filter(m -> m.getId() == motoristaId).findFirst().orElse(null);

        if (carro != null && motorista != null) {
            Viagem novaViagem = new Viagem(carro, motorista, distanciaTotal);
            viagens.add(novaViagem);
            System.out.println("Viagem adicionada com sucesso.");
        } else {
            System.out.println("Carro ou motorista não encontrado.");
        }
    }

    private static void relatoriosEConsultas() {
        System.out.println("\n---- Relatórios e Consultas ----");
        System.out.println("1. Carros com autonomia abaixo de 20%");
        System.out.println("2. Histórico de viagens de um motorista");
        System.out.println("3. Histórico de recargas de um veículo");
        System.out.println("4. Carros que precisam de manutenção");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> carrosAutonomiaBaixa();
            case 2 -> historicoViagensMotorista();
            case 3 -> historicoRecargasVeiculo();
            case 4 -> carrosNecessitamManutencao();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void carrosAutonomiaBaixa() {
        System.out.println("Carros com autonomia abaixo de 20%:");
        for (CarroEletrico carro : carros) {
            if (carro.getAutonomiaAtual() / carro.autonomiaMaxima < 0.2) {
                System.out.println("Carro ID " + carro.id + " - " + carro.marca + " " + carro.modelo);
            }
        }
    }

    private static void historicoViagensMotorista() {
        System.out.print("Informe o ID do motorista: ");
        int idMotorista = scanner.nextInt();
        System.out.println("Histórico de viagens do motorista ID " + idMotorista + ":");
        for (Viagem viagem : viagens) {
            if (viagem.getMotorista().getId() == idMotorista) {
                System.out.println("Viagem de " + viagem.getDistanciaTotal() + " km com carro ID " + ((CarroEletrico) viagem.getCarro()).getId());
            }
            
        }
    }

    private static void historicoRecargasVeiculo() {
        System.out.println("Histórico de recargas ainda não implementado.");
    }

    private static void carrosNecessitamManutencao() {
        System.out.println("Carros que precisam de manutenção ainda não implementado.");
    }
}
