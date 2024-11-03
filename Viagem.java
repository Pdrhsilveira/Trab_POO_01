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
        System.out.println("Iniciando viagem com o motorista " + motorista.getNome() + ", habilitação nº " + motorista.getNumeroHabilitacao() +
                " com " + motorista.getExperiencia() + " anos de experiência.");
        while (distanciaPercorrida < distanciaTotal) {
            double autonomiaAtual = carro.getAutonomiaAtual();
    
            // Verifica se a autonomia atual é suficiente para completar a viagem
            if (autonomiaAtual >= (distanciaTotal - distanciaPercorrida)) {
                carro.reduzirAutonomia(distanciaTotal - distanciaPercorrida);
                distanciaPercorrida = distanciaTotal;
                System.out.println("Viagem concluída sem paradas.");
            } else {
                // Se a autonomia não for suficiente, busca uma parada para recarga
                System.out.println("Autonomia insuficiente, buscando parada.");
    
                boolean recarregou = false;
                for (Eletroposto parada : paradas) {
                    if (parada.verificarDisponibilidade()) {
                        carro.recarregarBateria();
                        parada.liberarVaga();
                        recarregou = true;
                        break;
                    }
                }
    
                if (!recarregou) {
                    System.out.println("Nenhuma parada disponível para recarga. Viagem interrompida.");
                    break;
                }
    
                // Atualiza a distância percorrida após recarga
                carro.reduzirAutonomia(autonomiaAtual);
                distanciaPercorrida += autonomiaAtual;
                System.out.println("Distância percorrida até agora: " + distanciaPercorrida + " km.");
            }
        }
    
        if (distanciaPercorrida >= distanciaTotal) {
            System.out.println("Viagem concluída com sucesso.");
        }
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }
}
