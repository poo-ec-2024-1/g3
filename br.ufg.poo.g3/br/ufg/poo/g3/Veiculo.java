package br.ufg.poo.g3;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "placa")
public class Veiculo
{   
    @DatabaseField(generatedId = true)
    private String cor;
    
     @DatabaseField
    private String modelo;
    
    
    @DatabaseField
    private String placa;
    
//Start GetterSetterExtension Source Code

    /**GET Method Propertie Cor*/
    public String getCor(){
        return this.cor;
    }//end method getCor

    /**SET Method Propertie Cor*/
    public void setCor(String cor){
        this.cor = cor;
    }//end method setId

    /**GET Method Propertie Cor*/
    public String getModelo(){
        return this.modelo;
    }//end method getModelo

    /**SET Method Propertie Cor*/
    public void setModelo(String modelo){
        this.modelo = modelo;
    }//end method setModelo
    /**GET Method Propertie Placa*/
    public String getPlaca(){
        return this.placa;
    }//end method getFullName

    /**SET Method Propertie Placa*/
    public void setPlaca(String placa){
        this.placa = placa;
    }//end method placa


//End GetterSetterExtension Source Code


}//End class
