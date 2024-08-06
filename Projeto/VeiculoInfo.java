public class VeiculoInfo {
    private String vaga;
    private String nome;
    private String telefone;
    private String placa;
    private String modelo;
    private String cor;

    public VeiculoInfo(String vaga, String nome, String telefone, String placa, String modelo, String cor) {
        this.vaga = vaga;
        this.nome = nome;
        this.telefone = telefone;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getVaga() {
        return vaga;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
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
}
