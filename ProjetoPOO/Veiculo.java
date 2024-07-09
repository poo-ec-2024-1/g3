/** 
 * @author (João Gabriel) 

 */

public abstract class Veiculo{
    
String placa;
String modelo;
String cor;
    //Getters e Setters
   public void setPlaca(String placa){
       this.placa=placa;
       
   }
   public void setModelo(String modelo){
       this.modelo=modelo;
       
   }
   public void setCor(String cor){
       this.cor=cor;
       
   }
    public String getModelo() {
        return modelo;
    }
     public String getCor() {
        return cor;
    }
    public String placa() {
        return placa;
    }

}
