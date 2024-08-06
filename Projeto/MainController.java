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
        dialog.setTitle("Estacionar Veículo");
        dialog.setHeaderText("Estacionar Veículo");
        dialog.setContentText("Digite a placa:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String placa = result.get();
            Veiculo veiculo = cadastroVeiculo.buscarVeiculoPorPlaca(placa);
            if (veiculo == null) {
                mostrarAlerta("Erro", "Veículo não encontrado. Cadastre o veículo primeiro.");
                return;
            }
            Ticket ticket = estacionamento.estacionarVeiculo(veiculo);
            if (ticket != null) {
                mostrarAlerta("Sucesso", "Veículo estacionado na vaga " + ticket.getVaga().getNumero());
            } else {
                mostrarAlerta("Erro", "Sem vagas disponíveis.");
            }
        }
    }

    @FXML
    private void handleRetirarVeiculo() throws IOException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Retirar Veículo");
        dialog.setHeaderText("Retirar Veículo");
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
                mostrarAlerta("Sucesso", "Veículo retirado. Tarifa total: R$" + tarifa);
            } else {
                mostrarAlerta("Erro", "Veículo não encontrado.");
            }
        }
    }

    @FXML
    private void handleVerVagas() {
        StringBuilder vagasDisponiveis = new StringBuilder("Vagas disponíveis:\n");
        for (Vaga vaga : estacionamento.getVagasDisponiveis()) {
            vagasDisponiveis.append("Vaga ").append(vaga.getNumero()).append("\n");
        }
        mostrarAlerta("Vagas Disponíveis", vagasDisponiveis.toString());
    }

    @FXML
    private void handleCadastrarUsuario() throws IOException {
        TextInputDialog nomeDialog = new TextInputDialog();
        nomeDialog.setTitle("Cadastrar Usuário");
        nomeDialog.setHeaderText("Cadastrar Usuário");
        nomeDialog.setContentText("Digite o nome do usuário:");

        Optional<String> nomeResult = nomeDialog.showAndWait();
        if (!nomeResult.isPresent()) return;

        TextInputDialog contatoDialog = new TextInputDialog();
        contatoDialog.setTitle("Cadastrar Usuário");
        contatoDialog.setHeaderText("Cadastrar Usuário");
        contatoDialog.setContentText("Digite o contato do usuário:");

        Optional<String> contatoResult = contatoDialog.showAndWait();
        if (!contatoResult.isPresent()) return;

        TextInputDialog placaDialog = new TextInputDialog();
        placaDialog.setTitle("Cadastrar Usuário");
        placaDialog.setHeaderText("Cadastrar Usuário");
        placaDialog.setContentText("Digite a placa do veículo do usuário:");

        Optional<String> placaResult = placaDialog.showAndWait();
        if (!placaResult.isPresent()) return;

        Usuario novoUsuario = new Usuario(nomeResult.get(), contatoResult.get());
        cadastroUsuario.cadastrarUsuario(placaResult.get(), novoUsuario);
        mostrarAlerta("Sucesso", "Usuário cadastrado com sucesso.");
    }

    @FXML
    private void handleCadastrarVeiculo() throws IOException {
        TextInputDialog placaDialog = new TextInputDialog();
        placaDialog.setTitle("Cadastrar Veículo");
        placaDialog.setHeaderText("Cadastrar Veículo");
        placaDialog.setContentText("Digite a placa:");

        Optional<String> placaResult = placaDialog.showAndWait();
        if (!placaResult.isPresent()) return;

        Usuario usuario = cadastroUsuario.buscarUsuarioPorPlaca(placaResult.get());
        if (usuario == null) {
            mostrarAlerta("Erro", "Usuário não encontrado. Cadastre o usuário primeiro.");
            return;
        }

        TextInputDialog tipoDialog = new TextInputDialog();
        tipoDialog.setTitle("Cadastrar Veículo");
        tipoDialog.setHeaderText("Cadastrar Veículo");
        tipoDialog.setContentText("Digite o tipo de veículo (1 para Carro, 2 para Moto):");

        Optional<String> tipoResult = tipoDialog.showAndWait();
        if (!tipoResult.isPresent()) return;

        int tipoVeiculo = Integer.parseInt(tipoResult.get());
        TextInputDialog modeloDialog = new TextInputDialog();
        modeloDialog.setTitle("Cadastrar Veículo");
        modeloDialog.setHeaderText("Cadastrar Veículo");
        modeloDialog.setContentText("Digite o modelo:");

        Optional<String> modeloResult = modeloDialog.showAndWait();
        if (!modeloResult.isPresent()) return;

        TextInputDialog corDialog = new TextInputDialog();
        corDialog.setTitle("Cadastrar Veículo");
        corDialog.setHeaderText("Cadastrar Veículo");
        corDialog.setContentText("Digite a cor:");

        Optional<String> corResult = corDialog.showAndWait();
        if (!corResult.isPresent()) return;

        Veiculo veiculoNovo;
        if (tipoVeiculo == 1) {
            veiculoNovo = new Carro(placaResult.get(), modeloResult.get(), corResult.get());
        } else if (tipoVeiculo == 2) {
            veiculoNovo = new Moto(placaResult.get(), modeloResult.get(), corResult.get());
        } else {
            mostrarAlerta("Erro", "Tipo de veículo inválido.");
            return;
        }

        cadastroVeiculo.cadastrarVeiculo(placaResult.get(), veiculoNovo);
        mostrarAlerta("Sucesso", "Veículo cadastrado com sucesso.");
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
