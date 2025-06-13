 import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "usuario")
public class Usuario
{   

    
    @DatabaseField
    private String nomeUsuario;
    
   @DatabaseField
    private String senha;
    
   @DatabaseField
    private String tipo;
    
    
    public Usuario(String nomeUsuario, String senha, String tipo){
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public Usuario(){}
    
    /**GET Method Propertie nomeUsuario*/
    public String getNomeUsuario(){
        return this.nomeUsuario;
    }

    /**SET Method Propertie nomeUsuario*/
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    /**GET Method Propertie senha*/
    public String getSenha(){
        return this.senha;
    }

    /**SET Method Propertie senha*/
    public void setSenha(String senha){
        this.senha = senha;
    } 

    /**GET Method Propertie tipo*/
    public String getTipo(){
        return this.tipo;
    }

    /**SET Method Propertie tipo*/
    public void setTipo(String tipo){
        this.tipo = tipo;
    } 



}                                                                                                                         