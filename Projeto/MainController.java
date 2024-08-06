import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.Optional;

public class MainController {

    @FXML
    private Button estacionarVeiculoButton;

    @FXML
    private Button retirarVeiculoButton;

    @FXML
    private Button verVagasButton;

    @FXML
    private Button cadastrarUsuarioButton;

    @FXML
    private Button cadastrarVeiculoButton;

    private Estacionamento estacionamento = new Estacionamento(10); // 10 vagas
    private CadastroUsuario cadastroUsuario = new CadastroUsuario("usuarios.dat");
    private CadastroVeiculo cadastroVeiculo = new CadastroVeiculo("veiculos.dat");

    @FXML
    private void handleEstacionarVeiculo() throws IOException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Estacionar Ve�culo");
        dialog.setHeaderText("Estacionar Ve�culo");
        dialog.setContentText("Digite a placa:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String placa = result.get();
            Veiculo veiculo = cadastroVeiculo.buscarVeiculoPorPlaca(placa);
            if (veiculo == null) {
                mostrarAlerta("Erro", "Ve�culo n�o encontrado. Cadastre o ve�culo primeiro.");
                return;
            }
            Ticket ticket = estacionamento.estacionarVeiculo(veiculo);
            if (ticket != null) {
                mostrarAlerta("Sucesso", "Ve�culo estacionado na vaga " + ticket.getVaga().getNumero());
            } else {
                mostrarAlerta("Erro", "Sem vagas dispon�veis.");
            }
        }
    }

    @FXML
    private void handleRetirarVeiculo() throws IOException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Retirar Ve�culo");
        dialog.setHeaderText("Retirar Ve�culo");
        dialog.setContentText("Digite a placa:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String placaRetirada = result.get();
            Ticket ticketEncontrado = null;
            for (Ticket t : estacionamento.getTickets()) {
                if (t.getVeiculo().getPlaca().equals(placaRetirada) && t.getHoraSaida() == null) {
                    ticketEncontrado = t;
                    break;
                }
            }
            if (ticketEncontrado != null) {
                double tarifa = estacionamento.retirarVeiculo(ticketEncontrado);
                mostrarAlerta("Sucesso", "Ve�culo retirado. Tarifa total: R$" + tarifa);
            } else {
                mostrarAlerta("Erro", "Ve�culo n�o encontrado.");
            }
        }
    }

    @FXML
    private void handleVerVagas() {
        StringBuilder vagasDisponiveis = new StringBuilder("Vagas dispon�veis:\n");
        for (Vaga vaga : estacionamento.getVagasDisponiveis()) {
            vagasDisponiveis.append("Vaga ").append(vaga.getNumero()).append("\n");
        }
        mostrarAlerta("Vagas Dispon�veis", vagasDisponiveis.toString());
    }

    @FXML
    private void handleCadastrarUsuario() throws IOException {
        TextInputDialog nomeDialog = new TextInputDialog();
        nomeDialog.setTitle("Cadastrar Usu�rio");
        nomeDialog.setHeaderText("Cadastrar Usu�rio");
        nomeDialog.setContentText("Digite o nome do usu�rio:");

        Optional<String> nomeResult = nomeDialog.showAndWait();
        if (!nomeResult.isPresent()) return;

        TextInputDialog contatoDialog = new TextInputDialog();
        contatoDialog.setTitle("Cadastrar Usu�rio");
        contatoDialog.setHeaderText("Cadastrar Usu�rio");
        contatoDialog.setContentText("Digite o contato do usu�rio:");

        Optional<String> contatoResult = contatoDialog.showAndWait();
        if (!contatoResult.isPresent()) return;

        TextInputDialog placaDialog = new TextInputDialog();
        placaDialog.setTitle("Cadastrar Usu�rio");
        placaDialog.setHeaderText("Cadastrar Usu�rio");
        placaDialog.setContentText("Digite a placa do ve�culo do usu�rio:");

        Optional<String> placaResult = placaDialog.showAndWait();
        if (!placaResult.isPresent()) return;

        Usuario novoUsuario = new Usuario(nomeResult.get(), contatoResult.get());
        cadastroUsuario.cadastrarUsuario(placaResult.get(), novoUsuario);
        mostrarAlerta("Sucesso", "Usu�rio cadastrado com sucesso.");
    }

    @FXML
    private void handleCadastrarVeiculo() throws IOException {
        TextInputDialog placaDialog = new TextInputDialog();
        placaDialog.setTitle("Cadastrar Ve�culo");
        placaDialog.setHeaderText("Cadastrar Ve�culo");
        placaDialog.setContentText("Digite a placa:");

        Optional<String> placaResult = placaDialog.showAndWait();
        if (!placaResult.isPresent()) return;

        Usuario usuario = cadastroUsuario.buscarUsuarioPorPlaca(placaResult.get());
        if (usuario == null) {
            mostrarAlerta("Erro", "Usu�rio n�o encontrado. Cadastre o usu�rio primeiro.");
            return;
        }

        TextInputDialog tipoDialog = new TextInputDialog();
        tipoDialog.setTitle("Cadastrar Ve�culo");
        tipoDialog.setHeaderText("Cadastrar Ve�culo");
        tipoDialog.setContentText("Digite o tipo de ve�culo (1 para Carro, 2 para Moto):");

        Optional<String> tipoResult = tipoDialog.showAndWait();
        if (!tipoResult.isPresent()) return;

        int tipoVeiculo = Integer.parseInt(tipoResult.get());
        TextInputDialog modeloDialog = new TextInputDialog();
        modeloDialog.setTitle("Cadastrar Ve�culo");
        modeloDialog.setHeaderText("Cadastrar Ve�culo");
        modeloDialog.setContentText("Digite o modelo:");

        Optional<String> modeloResult = modeloDialog.showAndWait();
        if (!modeloResult.isPresent()) return;

        TextInputDialog corDialog = new TextInputDialog();
        corDialog.setTitle("Cadastrar Ve�culo");
        corDialog.setHeaderText("Cadastrar Ve�culo");
        corDialog.setContentText("Digite a cor:");

        Optional<String> corResult = corDialog.showAndWait();
        if (!corResult.isPresent()) return;

        Veiculo veiculoNovo;
        if (tipoVeiculo == 1) {
            veiculoNovo = new Carro(placaResult.get(), modeloResult.get(), corResult.get());
        } else if (tipoVeiculo == 2) {
            veiculoNovo = new Moto(placaResult.get(), modeloResult.get(), corResult.get());
        } else {
            mostrarAlerta("Erro", "Tipo de ve�culo inv�lido.");
            return;
        }

        cadastroVeiculo.cadastrarVeiculo(placaResult.get(), veiculoNovo);
        mostrarAlerta("Sucesso", "Ve�culo cadastrado com sucesso.");
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
