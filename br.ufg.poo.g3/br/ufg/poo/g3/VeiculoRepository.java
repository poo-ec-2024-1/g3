/** 
 * @author (Ícaro Pereira) 

 */
package br.ufg.poo.g3;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class VeiculoRepository
{
    private static Database database;
    private static Dao<Veiculo, Integer> dao;
    private List<Veiculo> loadedVeiculos;
    private Veiculo loadedVeiculo; 
    
    public VeiculoRepository(Database database) {
        VeiculoRepository.setDatabase(database);
        loadedVeiculos = new ArrayList<Veiculo>();
    }
    
    public static void setDatabase(Database database) {
        VeiculoRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Veiculo.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Veiculo.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Veiculo create(Veiculo veiculo) {
        int nrows = 0;
        try {
            nrows = dao.create(veiculo);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedVeiculo = veiculo;
            loadedVeiculos.add(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return veiculo;
    }    

    public void update(Veiculo veiculo) {
      // TODO
    }

    public void delete(Veiculo veiculo) {
      // TODO
    }
    
    public Veiculo loadFromVeiculo(int Passageiro) {
        try {
            this.loadedVeiculo = dao.queryForId(Passageiro);
            if (this.loadedVeiculo != null)
                this.loadedVeiculos.add(this.loadedVeiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculo;
    }    
    
    public List<Veiculo> loadAll() {
        try {
            this.loadedVeiculos =  dao.queryForAll();
            if (this.loadedVeiculos.size() != 0)
                this.loadedVeiculo = this.loadedVeiculos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculos;
    }

    // getters and setters ommited...        
}