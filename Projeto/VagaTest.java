import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste VagaTest.
 *
 * @author  Icaro Pereira
 */
public class VagaTest
{
    @Test
    public void testeGetNumero()
    {
        Vaga vaga2 = new Vaga(5, false);
        assertEquals(5, vaga2.getNumero());
        
    }
   
    @Test
    public void testeEstaOcupada()
    {
        Vaga vaga3 = new Vaga(5, false);
        assertEquals(false, vaga3.isOcupada());
        vaga3.ocupar();
        assertEquals(true, vaga3.isOcupada());
    }
}

