import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste UsuarioTest.
 * @author  Ícaro Pereira

 */
public class UsuarioTeste
{
    
    @Test
    public void testeGetNome()
    {
        Usuario usuario2 = new Usuario("Icaro", "62986277452");
        assertEquals("Icaro", usuario2.getNome());
        
    }
     
    @Test
    public void testeGetContato()
    {
        Usuario usuario2 = new Usuario("Icaro", "62986277452");
        assertEquals("62986277452", usuario2.getContato());
        
    }
    
  
}

