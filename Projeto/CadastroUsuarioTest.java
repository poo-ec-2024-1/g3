import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CadastroUsuarioTest.
 *
 * @author  Ícaro Pereira
 */
public class CadastroUsuarioTest
{
    @Test
    public void testeUsuario()
    {
        Usuario usuario4 = new Usuario("Anna Karla", "62984847009");
        CadastroUsuario cadastro = new CadastroUsuario("cadastro");
        cadastro.cadastrarUsuario("AKZ123", usuario4);
        assertEquals(usuario4, cadastro.buscarUsuarioPorPlaca("AKZ123"));
    }
}

