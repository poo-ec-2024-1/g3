import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CadastroVeiculoTest.
 *
 * @author  Ícaro Pereira
 */
public class CadastroVeiculoTest
{
   @Test
    public void CadastroeBuscaVeicular()
    {
        Carro carro1 = new Carro("NRG1234", "ONIX", "PRETO");
        CadastroVeiculo cadastroveicular = new CadastroVeiculo("cadastroveicular");
        cadastroveicular.cadastrarVeiculo("NRG1234", carro1);
        assertEquals(carro1, cadastroveicular.buscarVeiculoPorPlaca("NRG1234"));
    }
}

