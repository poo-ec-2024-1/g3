import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EstacionarVeiculoController {

    @FXML
    private TextField placaInput;

    private Estacionamento estacionamento;
    private CadastroVeiculo cadastroVeiculo;

    public EstacionarVeiculoController() {
        estacionamento = new Estacionamento(10); // Supondo 10 vagas
        cadastroVeiculo = new CadastroVeiculo("veiculos.dat");
    }

    @FXML
    private void handleEstacionar() {
        String placa = placaInput.getText();
        Veiculo veiculo = cadastroVeiculo.buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            Ticket ticket = estacionamento.estacionarVeiculo(veiculo);
            if (ticket != null) {
                // Atualizar a UI com a informa��o de sucesso
            } else {
                // Atualizar a UI com a informa��o de falha (sem vagas)
            }
        } else {
            // Atualizar a UI com a informa��o de que o ve�culo n�o foi encontrado
        }
    }
}
