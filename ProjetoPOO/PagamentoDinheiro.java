/** 
 * @author (João Gabriel) 

 */

public class PagamentoDinheiro implements Pagamento {

    @Override
    public void processarPagamento(double valor) {
        // Implementação específica para processar pagamento com dinheiro
        System.out.println("Processando pagamento no valor de R$" + valor + " feito com Dinheiro.");
        
    }
}