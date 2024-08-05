

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste EstacionamentoTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class EstacionamentoTest
{
    /**
     * Construtor default para a classe de teste EstacionamentoTest
     */
    public EstacionamentoTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void Estacionar()
    {
        Estacionamento estacion1 = new Estacionamento(20);
        Moto moto1 = new Moto("KYD1234", "Bis", "Vermelha");
        Ticket ticket1 = estacion1.estacionarVeiculo(moto1);
        assertEquals(moto1, ticket1);
        assertNotSame(1, ticket1.getHoraEntrada());
    }
}

