import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar o arquivo FXML principal
        Parent root = FXMLLoader.load(getClass().getResource("/view/InterfaceEstacionamento.fxml"));

        // Definir o título da janela
        primaryStage.setTitle("Sistema de Estacionamento");

        // Configurar a cena e mostrar o palco
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
