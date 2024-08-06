import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String contato;
    //Dados do usuário basicos, metodo construtor.
    public Usuario(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }
    //getters e setters
    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "Usuario: " + nome + " - " + contato;
    }
}
