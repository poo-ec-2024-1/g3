/** 
 * @author (João Gabriel) 

 */

// Implementação da interface Pagamento em uma classe concreta
public class PagamentoCartao implements Pagamento {

    @Override
    public void processarPagamento(double valor) {
        // Implementação específica para processar pagamento com cartão
        System.out.println("Processando pagamento no valor de R$" + valor + " feito com cartão.");
        
    }
}