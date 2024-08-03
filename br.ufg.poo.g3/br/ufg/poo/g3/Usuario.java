package br.ufg.poo.g3;

/** 
 * @author (João Gabriel) 

 */
public class Usuario implements Pagamento{
    String nome;
    String contato;
    double saldo;
    //Construtor
    public Usuario(String nome, String contato, double saldo){
        this.saldo=saldo;
        this.contato=contato;
        this.nome=nome;
    }
    //Getters e Setters.
    public void setNome(String nome){
        this.nome=nome;
    }
     public void setContato(String nome){
        this.contato=contato;
    } 
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }

    public double getSaldo(){
    return this.saldo;
    }
    public String getNome(){
    return this.nome;
    }  
    public String getContato(){
        return this.contato;
    }
    @Override //Método que vai fazer o processamento do pagamento.
    public void processarPagamento(double valor) {
        this.saldo=this.saldo-valor;
        System.out.println("Processando pagamento no valor de R$" + valor + ", o novo saldo de "+this.nome +" é de: "+this.saldo+" reais.");
        
    }
}
