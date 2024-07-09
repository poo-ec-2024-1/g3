
/** 
 * @author (Ícaro Pereira) 

 */
public class Teste
{
    public static void main (String[]args){
        Usuario usuario1 = new Usuario("João Gabriel", "(62)99999-9999", 20);
        Usuario usuario2 = new Usuario("Sophia", "(62)98888-9999", 780);
        
        usuario1.processarPagamento(30.0);
        usuario2.processarPagamento(30.0);
        System.out.println("Saldo atualizado: R$" + usuario1.getSaldo());
        System.out.println("Saldo atualizado: R$" + usuario2.getSaldo());


    }


}

