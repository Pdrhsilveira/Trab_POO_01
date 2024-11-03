import java.util.ArrayList;
import java.util.List;

class Viagem {
    private CarroEletrico carro;
    private Motorista motorista;
    private List<Eletroposto> paradas;
    private double distanciaTotal;
    private double distanciaPercorrida;

    public Viagem(CarroEletrico carro, Motorista motorista, double distanciaTotal) {
        this.carro = carro;
        this.motorista = motorista;
        this.distanciaTotal = distanciaTotal;
        this.distanciaPercorrida = 0;
        this.paradas = new ArrayList<>();
    }

    public void adicionarParada(Eletroposto eletroposto) {
        if (eletroposto.verificarDisponibilidade()) {
            paradas.add(eletroposto);
            eletroposto.ocuparVaga();
        } else {
            System.out.println("Eletroposto " + eletroposto.getId() + " está cheio.");
        }
    }

    public void iniciarViagem() {
        while (distanciaPercorrida < distanciaTotal) {
            double autonomiaAtual = carro.getAutonomiaAtual();
            if (autonomiaAtual >= (distanciaTotal - distanciaPercorrida)) {
                carro.reduzirAutonomia(distanciaTotal - distanciaPercorrida);
                distanciaPercorrida = distanciaTotal;
                System.out.println("Viagem concluída sem paradas.");
            } else {
                System.out.println("Autonomia insuficiente, buscando parada.");
                for (Eletroposto parada : paradas) {
                    if (parada.verificarDisponibilidade()) {
                        carro.recarregarBateria();
                        parada.liberarVaga();
                        break;
                    }
                }
            }
        }
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }
}
