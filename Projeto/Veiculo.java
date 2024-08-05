import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String placa;
    private String modelo;
    private String cor;

    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public abstract double getTarifaPorMinuto();
}
