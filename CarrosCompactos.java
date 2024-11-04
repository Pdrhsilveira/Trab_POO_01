// Classe que representa carros elétricos Hatch, herdando as propriedades de CarroEletrico
// Define valores fixos para autonomia máxima e tempo médio de recarga específicos para este tipo de carro

public class CarrosCompactos extends CarroEletrico {

    // Construtor da classe CarrosCompactos
    // Define os parâmetros padrão de autonomia máxima (200 km) e tempo médio de recarga (4 horas)
    // Adiciona o carro na frota especificada
     
    public CarrosCompactos(int id, String marca, String modelo, int anoFabricacao, double capacidadeTotalBateria, Frota frota) {
        super(id, marca, modelo, anoFabricacao, 200, capacidadeTotalBateria, 4, frota); 
    }  
}
