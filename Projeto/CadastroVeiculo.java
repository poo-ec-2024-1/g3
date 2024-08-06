import java.util.Map;

public class CadastroVeiculo {
    private Map<String, Veiculo> veiculos;
    private Database<Veiculo> database;
    //Envia o cadastro do ve�culo e manda para a database.
    public CadastroVeiculo(String fileName) {
        database = new Database<>(fileName);
        veiculos = database.carregarDados();
    }

    public void cadastrarVeiculo(String placa, Veiculo veiculo) {
        veiculos.put(placa, veiculo);
        database.salvarDados(veiculos);
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculos.get(placa);
    }

    //public Map<String, Veiculo> getVeiculos() {
        //return veiculos;
    //}
}
