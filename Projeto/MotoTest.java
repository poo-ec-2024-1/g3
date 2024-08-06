import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste MotoTest.
 *
 * @author  Icaro Pereira 
 */
public class MotoTest
{
    
    @Test
    public void getPlaca()
    {
        Moto moto1 = new Moto("PQP1234", "Harley Davidson", "Preta");
        assertEquals("PQP1234", moto1.getPlaca());
    }
    
    @Test
    public void getModelo()
    {
        Moto moto1 = new Moto("PQP1234", "Harley Davidson", "Preta");
        assertEquals("Harley Davidson", moto1.getModelo());
    }
    
    @Test
    public void getCor()
    {
        Moto moto1 = new Moto("PQP1234", "Harley Davidson", "Preta");
        assertEquals("Preta", moto1.getCor());
    }

    @Test
    public void getTarifaPorMinuto()
    {
        Moto moto1 = new Moto("PQP1234", "Harley Davidson", "Preta");
        assertEquals(0.1, moto1.getTarifaPorMinuto());
    }
}


