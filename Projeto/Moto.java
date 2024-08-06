public class Moto extends Veiculo {
    public Moto(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }
    
    @Override
    public double getTarifaPorMinuto() {
        return 0.10; //10 centavos por minuto -> 6 reais a hora 
    }

    @Override
    public String toString() {
        return "Moto: " + getModelo() + " - " + getPlaca() + " - " + getCor();
    }
}
