public class Carro extends Veiculo {
    public Carro(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getTarifaPorMinuto() {
        return 0.20; //20 centavos por minuto -> 12 reais a hora 
    }

    @Override
    public String toString() {
        return "Carro: " + getModelo() + " - " + getPlaca() + " - " + getCor();
    }
}
