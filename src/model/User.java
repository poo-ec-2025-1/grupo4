package model;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

@DatabaseTable(tableName = "user")
public class User
{   

    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String username;
    
   @DatabaseField
    private String password;
    
   @DatabaseField
    private String type;
    
    
    public User(String username, String password, String type){
        this.username = username;
        this.password = password;
        this.type = type;
    }
    
    public User(){}
    
    /**GET Method Propertie username*/
    public String getUsername(){
        return this.username;
    }

    /**SET Method Propertie username*/
    public void setUsername(String username){
        this.username = username;
    }

    /**GET Method Propertie password*/
    public String getPassword(){
        return this.password;
    }

    /**SET Method Propertie password*/
    public void setPassword(String password){
        this.password = password;
    } 

    /**GET Method Propertie type*/
    public String getTipo(){
        return this.type;
    }

    /**SET Method Propertie type*/
    public void setTipo(String type){
        this.type = type;
    } 



}                                                                                                                         
