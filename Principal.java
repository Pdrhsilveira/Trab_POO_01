import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         // Criação de listas e objetos para armazenar dados da frota e rotas
        
        List<Rota> rotas = new ArrayList<>();
        Registro registros = new Registro();

        Frota frota = new Frota();

        // Instanciando veículos para a frota
        CarroEletrico v1 = new CarrosCompactos(1, "Tesla", "Model S", 2021, 200, frota);
        CarroEletrico v2 = new CarroSedan(2, "Porsche", "Taycan", 2023, 400, frota);
        CarroEletrico v3 = new CarroSUV(20, "Audi", "e-tron", 2022, 300, frota);
        
        // Instanciando motoristas
        Motoristas m1 = new Motoristas(200, "Profissional", 1, "Nicolas Torreto", frota);
        Motoristas m2 = new Motoristas(568, "Iniciante", 2, "Pedro Gonçalves", frota);
        Motoristas m3 = new Motoristas(101, "Psicotico", 2, "Lucas Descovi", frota);

        // Instanciando rotas
        Rota rota1 = new Rota("Porto Alegre", "Cachoeira do Sul", 350.0);
        Rota rota2 = new Rota("Recanto Maestro", "Belo Horizonte", 1780.0);
        Rota rota3 = new Rota("Florianópolis", "Curitiba", 400.0);

        // Adicionando rotas na lista
        rotas.add(rota1);
        rotas.add(rota2);
        rotas.add(rota3);
        
        int id = 1;
        int opcao = 1; 

        // Loop principal do menu de opções
        while(opcao != 0) {
            System.out.print("----GESTÃO DE GESTÃO DE FROTA----" +
            "\n1 - Adicionar Veículo" + 
            "\n2 - Adicionar Motorista" + 
            "\n3 - Listar Motoristas" + 
            "\n4 - Registrar Viagem" + 
            "\n5 - Registrar Rota" +
            "\n6 - Consultar Eletropostos" +
            "\n7 - Registrar Eletroposto" +
            "\n8 - Relatórios" + 
            "\n9 - Sair" +    
            "\nEscolha uma opção: ");
            opcao = sc.nextInt();
            
            switch(opcao) {
                case 1:
                    // Adição de novo veículo à frota
                    System.out.print("\n1- Hatch " + "\n2- Sedans " + "\n3- SUV" + "\nEscolha o tipo de carro elétrico: ");
                    int tipoCarro = sc.nextInt(); 

                    System.out.print("Ano de fabricação: "); 
                    int anoFabricacao = sc.nextInt();
                    
                    System.out.print("Capacidade total da bateria: ");
                    double capacidadeBateria = sc.nextDouble();
                    
                    System.out.print("Marca do veículo: "); 
                    String marca = sc.next();

                    System.out.print("Modelo do veículo: ");
                    String modelo = sc.next();

                    // Verifica tipo do carro para instanciar corretamente
                    CarroEletrico veiculo;
                    if(tipoCarro == 1) {
                        veiculo = new CarrosCompactos(id, marca, modelo, anoFabricacao, capacidadeBateria, frota);
                    } else if (tipoCarro == 2) {
                        veiculo = new CarroSedan(id, marca, modelo, anoFabricacao, capacidadeBateria, frota);
                    } else {
                        veiculo = new CarroSUV(id, marca, modelo, anoFabricacao, capacidadeBateria, frota);
                    }
                    System.out.println("Veículo adicionado à frota!\n");
                    id++;
                    break;

                case 2:
                    
                    // Adiciona um novo motorista na frota
                    System.out.print("Número da CNH do motorista: ");
                    int numeroCNH = sc.nextInt();

                    System.out.print("Nível de experiência do motorista: ");
                    String nivelExperiencia = sc.next();

                    System.out.print("Nome do motorista: ");
                    String nome = sc.next();
                    
                    // Criação e adição do motorista na lista
                    Motoristas motorista = new Motoristas(numeroCNH, nivelExperiencia, id, nome, frota);
                    System.out.println("Motorista adicionado com sucesso!");
                    id++;
                    break;

                case 3:
                    
                    // Listagem dos motoristas da frota
                    frota.listarMotoristas();
                    break;

                case 4:

                    // Registro de uma viagem, selecionand rota, motorista e veículo
                    System.out.println("Rotas disponíveis:");
                    for (int i = 0; i < rotas.size(); i++) {
                        Rota rota = rotas.get(i);
                        System.out.println(i + " - Origem: " + rota.getOrigem() + ", Destino: " + rota.getDestino() + ", Distância: " + rota.getKmPercorrido());
                    }
                    System.out.print("Escolha a rota para registrar a viagem: ");
                    int rotaEscolhida = sc.nextInt();
                    
                    // Listagem dos motoristas para seleção
                    System.out.println("\nMotoristas disponíveis:");
                    List<Motoristas> motoristas = frota.getMotoristas();
                    for (int i = 0; i < motoristas.size(); i++) {
                        Motoristas m = motoristas.get(i);
                        System.out.println(i + " - Nome: " + m.getNome() + ", CNH: " + m.getNumeroCNH() + ", Experiência: " + m.getExpertise());
                    }
                    System.out.print("Escolha o motorista para a viagem: "); 
                    int motoristaEscolhido = sc.nextInt();

                    // Listagem dos veículos para seleção
                    System.out.println("\nVeículos disponíveis:");
                    List<CarroEletrico> veiculos = frota.getVeiculos();
                    for (int i = 0; i < veiculos.size(); i++) {
                        CarroEletrico v = veiculos.get(i);
                        System.out.println(i + " - Marca: " + v.getMarca() + ", Modelo: " + v.getModelo() + ", Autonomia: " + v.getAutonomiaMaxima() + ", ID: #" + v.getId());
                    }
                    System.out.print("Escolha o veículo para a viagem: ");
                    int veiculoEscolhido = sc.nextInt();

                    // Verificação de autonomia do veículo para a viagem
                    boolean autonomiaSuficiente = veiculos.get(veiculoEscolhido).verificarAutonomia(rotas.get(rotaEscolhida), registros);
                    if(autonomiaSuficiente){
                        Viagem viagem = new Viagem(rotas.get(rotaEscolhida), motoristas.get(motoristaEscolhido), veiculos.get(veiculoEscolhido)); 
                        double novaCapacidadeBateria = veiculos.get(veiculoEscolhido).getCapacidadeTotalBateria() - rotas.get(rotaEscolhida).getKmPercorrido();
                        veiculos.get(veiculoEscolhido).setCapacidadeTotalBateria(novaCapacidadeBateria);
                        System.out.println("Viagem registrada com sucesso!");
                        registros.addRegistro(viagem);
                    } else {
                        System.out.println("Erro! Autonomia insuficiente!");
                    }
                    break;

                case 5:

                    // Registro de nova rota
                    System.out.print("Origem: ");
                    String origem = sc.next();

                    System.out.print("Destino: ");
                    String destino = sc.next();

                    System.out.print("Distância (KM): ");
                    double distancia = sc.nextDouble();

                    rotas.add(new Rota(origem, destino, distancia));
                    System.out.println("Rota registrada com sucesso!");
                    break;

                case 6:

                    // Consulta dos eletropostos disponíveis em uma rota
                    System.out.println("Rotas disponíveis:");
                    for (int i = 0; i < rotas.size(); i++) {
                        Rota rota = rotas.get(i);
                        System.out.println(i + " - Origem: " + rota.getOrigem() + ", Destino: " + rota.getDestino() + ", Distância: " + rota.getKmPercorrido());
                    }
                    System.out.print("Escolha a rota para consultar os eletropostos: ");
                    int rotaConsulta = sc.nextInt();
                    Rota rotaSelecionada = rotas.get(rotaConsulta);
                    List<Eletropostos> eletropostosRota = rotaSelecionada.getEletropostos();
                    if (!eletropostosRota.isEmpty()) {
                        for(Eletropostos eletroposto : eletropostosRota) {
                            eletroposto.exibirEletroposto();
                        }
                    } else {
                        System.out.println("Nenhum eletroposto encontrado nessa rota!");
                    }
                    break;

                case 7:

                    // Registro de novo eletroposto
                    System.out.println("Rotas disponíveis:");
                    for (int i = 0; i < rotas.size(); i++) {
                        Rota rota = rotas.get(i);
                        System.out.println(i + " - Origem: " + rota.getOrigem() + ", Destino: " + rota.getDestino() + ", Distância: " + rota.getKmPercorrido());
                    }
                    System.out.print("Escolha a rota para adicionar o eletroposto: ");
                    int rotaEletroposto = sc.nextInt();
                    
                    // Coleta e atribuição de dados do novo eletroposto
                    System.out.print("Número de vagas: ");
                    int numeroVagas = sc.nextInt();

                    System.out.print("Tempo de carregamento (horas): ");
                    double tempoCarregamento = sc.nextDouble();

                    System.out.print("Distância do eletroposto em relação ao ponto inicial da rota: ");
                    double distanciaEletroposto = sc.nextDouble();
                    
                    // Cria e associa eletroposto na rota
                    Eletropostos eletroposto = new Eletropostos(id, numeroVagas, tempoCarregamento);
                    Rota rotaParaEletroposto = rotas.get(rotaEletroposto);
                    boolean distanciaValida = eletroposto.setDistancia(distanciaEletroposto, rotaParaEletroposto);
                    if(distanciaValida) {
                        id++;          
                        rotaParaEletroposto.addEletroposto(eletroposto);
                        System.out.println("Eletroposto registrado com sucesso!");            
                        rotaParaEletroposto.ordenarEletropostos();  
                    }
                    break;

                case 8:
                    int relatorioOpcao = 0;
                    while(relatorioOpcao != 5) {

                        // Menu secundario para os relatórios
                        System.out.println("\n1 - Veículos com autonomia inferior a 20%" + 
                        "\n2 - Viagens realizadas por um motorista" + 
                        "\n3 - Histórico de recargas de um veículo" + 
                        "\n4 - Carros que precisam de manutenção" + 
                        "\n5 - Relatório de eletropostos" +
                        "\n6 - Relatório de motoristas" +
                        "\n7 - Relatório de veículos" +
                        "\n8 - Voltar");
                        

                        System.out.print("Escolha uma opção: ");
                        relatorioOpcao = sc.nextInt();
                        switch(relatorioOpcao) {
                            case 1:

                                // Relatório de veículos com menos de 20% da bateria
                                List<CarroEletrico> veiculosFrota = frota.getVeiculos();
                                System.out.println("Veículos com menos de 20% da bateria:");
                                boolean encontrouVeiculo = false;
                                for(CarroEletrico veiculoFrota : veiculosFrota){
                                    if (veiculoFrota.getCapacidadeTotalBateria() < 0.2 * veiculoFrota.getAutonomiaMaxima()){
                                        System.out.println("ID: " + veiculoFrota.getId() + ", Marca: " + veiculoFrota.getMarca() + ", Modelo: " + veiculoFrota.getModelo());
                                        encontrouVeiculo = true;
                                    }
                                }
                                if (!encontrouVeiculo) {
                                    System.out.println("Nenhum veículo com menos de 20% da bateria.");
                                }
                                break;

                            case 2:

                                // Consulta de viagens realizadas por um motorista específico
                                System.out.println("\nMotoristas:");
                                List<Motoristas> motoristasFrota = frota.getMotoristas();
                                for (int i = 0; i < motoristasFrota.size(); i++) {
                                    Motoristas motoristaFrota = motoristasFrota.get(i);
                                    System.out.println(i + " - Nome: " + motoristaFrota.getNome() + ", CNH: " + motoristaFrota.getNumeroCNH() + ", Experiência: " + motoristaFrota.getExpertise());
                                }
                                System.out.print("Escolha o motorista para a consulta: "); 
                                int motoristaConsulta = sc.nextInt();

                                registros.consultarMotorista(frota.getMotoristas().get(motoristaConsulta));
                                break;

                            case 3:
                                
                                // Exibe o histórico de recargas de um veículo
                                registros.exibirHistoricoRecargas();
                                break;

                            case 4:

                                // Relatório de carros que precisam de manutenção (menos de 10% de bateria)
                                System.out.println("Carros que precisam de manutenção:");
                                List<CarroEletrico> veiculosFrotaManutencao = frota.getVeiculos();
                                boolean encontrouVeiculoManutencao = false;
                                for(CarroEletrico veiculoFrotaManutencao : veiculosFrotaManutencao){
                                    if (veiculoFrotaManutencao.getCapacidadeTotalBateria() < 0.1 * veiculoFrotaManutencao.getAutonomiaMaxima()){
                                        System.out.println("ID: " + veiculoFrotaManutencao.getId() + ", Marca: " + veiculoFrotaManutencao.getMarca() + ", Modelo: " + veiculoFrotaManutencao.getModelo());
                                        encontrouVeiculoManutencao = true;
                                    }
                                }
                                break;
                            case 5:

                                // Exibe relatório detalhado dos eletropostos por rota
                                System.out.println("Relatório de eletropostos:");
                                for (Rota r : rotas) {
                                    System.out.println("Rota: " + r.getOrigem() + " - " + r.getDestino());
                                    List<Eletropostos> eletropostos = r.getEletropostos();
                                    if (!eletropostos.isEmpty()) {
                                        for (Eletropostos e : eletropostos) {
                                            e.exibirEletroposto();
                                        }
                                    } else {
                                        System.out.println("Nenhum eletroposto encontrado nessa rota!");
                                    }
                                }
                                break;

                            case 6:
                                
                                // Relatório de motoristas cadastrados
                                System.out.println("Relatório de motoristas:");
                                frota.listarMotoristas();
                                break;

                            case 7:
                                // Relatório de veículos cadastrados
                                System.out.println("Relatório de veículos:");
                                frota.listarVeiculos();
                                break;

                            case 8:
                                // Opção de voltar ao menu principal
                                System.out.println("Voltando...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;

                case 9:
                    // Encerra o sistema
                    System.out.println("Saindo...");
                    break;

                default:
                    // Caso o usuário insira uma opção inválida
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
