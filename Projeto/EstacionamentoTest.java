

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste EstacionamentoTest.
 *
 * @author  Icaro Pereira
 */
public class EstacionamentoTest
{

    @Test
    public void TesteGetHoraEntrada()
    {
        Estacionamento estacion1 = new Estacionamento(20);
        Moto moto1 = new Moto("KYD1234", "Bis", "Vermelha");
        Ticket ticket1 = estacion1.estacionarVeiculo(moto1);
        assertEquals(moto1, ticket1);
        assertNotSame("20:20:20.2000", ticket1.getHoraEntrada());
    }
}

