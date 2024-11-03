public class Main {
    public static void main(String[] args) {
        // Criação de carros
        CarroCompacto carro1 = new CarroCompacto(1, "Tesla", "Model 3", 2020, 75, 350);
        
        // Criação de motorista
        Motorista motorista = new Motorista(1, "Pedro", "123456789", 5);

        // Criação de eletropostos
        Eletroposto eletroposto1 = new Eletroposto(1, "Centro", 2, 30);

        // Criação de viagem
        Viagem viagem = new Viagem(carro1, motorista, 500);
        viagem.adicionarParada(eletroposto1);

        // Iniciar viagem
        viagem.iniciarViagem();
    }
}
