import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CarroTest.
 *
 * @author  Icaro Pereira 
 * @version (um número da versão ou uma data)
 */
public class CarroTest
{
    
    @Test
    public void getPlaca()
    {
        Carro carro1 = new Carro("NRG1234", "Onix", "Azul");
        assertEquals("NRG1234", carro1.getPlaca());
    }
    
    @Test
    public void getModelo()
    {
        Carro carro1 = new Carro("NRG1234", "Onix", "Azul");
        assertEquals("Onix", carro1.getModelo());
    }
    
    @Test
    public void getCor()
    {
        Carro carro1 = new Carro("NRG1234", "Onix", "Azul");
        assertEquals("Azul", carro1.getCor());
    }

    @Test
    public void getTarifaPorMinuto()
    {
        Carro carro1 = new Carro("NRG1234", "Onix", "Azul");
        assertEquals(0.2, carro1.getTarifaPorMinuto());
    }
}


