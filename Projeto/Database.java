import java.io.*;
import java.util.HashMap;
import java.util.Map;
//Data base do sistema todo.
public class Database<T> {
    private String fileName;

    public Database(String fileName) {
        this.fileName = fileName;
    }

    public void salvarDados(Map<String, T> dados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, T> carregarDados() {
        Map<String, T> dados = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            dados = (Map<String, T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe, retorna o mapa vazio
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dados;
    }
}
