 

import java.util.Map;

public class CadastroUsuario {
    private Map<String, Usuario> usuarios;
    private Database<Usuario> database;

    public CadastroUsuario(String fileName) {
        database = new Database<>(fileName);
        usuarios = database.carregarDados();
    }

    public void cadastrarUsuario(String placa, Usuario usuario) {
        usuarios.put(placa, usuario);
        database.salvarDados(usuarios);
    }

    public Usuario buscarUsuarioPorPlaca(String placa) {
        return usuarios.get(placa);
    }

    //public Map<String, Usuario> getUsuarios() {
        //return usuarios;
    //}
}
