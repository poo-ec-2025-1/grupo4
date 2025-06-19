package model;

 

import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "produtos")
public class Product
{     
    @DatabaseField
    private String name;
    
    @DatabaseField
    private String code;
    
    @DatabaseField
    private String shelf;
    
    @DatabaseField
    public double store_quantity;
    
    @DatabaseField
    public double stock_quantity;
    
    @DatabaseField(dataType=DataType.DATE)
    public Date expiration;
    
    @DatabaseField
    public double unit_price;
    
    public String printExpiration() {
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
        return dateFor.format(expiration);
    }
    
    public Product(){}
    
    public Product(String name, String code, String shelf,
    double store_quantity, double stock_quantity, Date expiration, double unit_price){
        this.name = name;
        this.code = code;
        this.shelf = shelf;
        this.store_quantity = store_quantity;
        this.stock_quantity = stock_quantity;
        this.expiration = expiration;
        this.unit_price = unit_price;
    }

    /**GET Method Propertie name*/
    public String getName(){
        return this.name;
    }

    /**SET Method Propertie name*/
    public void setName(String name){
        this.name = name;
    }
    
    /**GET Method Propertie code*/
    public String getCode(){
        return this.code;
    }

    /**SET Method Propertie code*/
    public void setCode(String code){
        this.code = code;
    }
    
    /**GET Method Propertie shelf*/
    public String getShelf(){
        return this.shelf;
    }

    /**SET Method Propertie shelf*/
    public void setShelf(String shelf){
        this.shelf = shelf;
    }

    /**GET Method Propertie store_quantity*/
    public double getStoreQuantity(){
        return this.store_quantity;
    }

    /**SET Method Propertie store_quantity*/
    public void setStoreQuantity(double store_quantity){
        this.store_quantity = store_quantity;
    }
    
    /**GET Method Propertie stock_quantity*/
    public double getStockQuantity(){
        return this.stock_quantity;
    }

    /**SET Method Propertie stock_quantity*/
    public void setStockQuantity(double stock_quantity){
        this.stock_quantity = stock_quantity;
    }

    /**GET Method Propertie expiration*/
    public Date getExpiration(){
        return this.expiration;
    }

    /**SET Method Propertie expiration*/
    public void setExpiration(Date expiration){
        this.expiration = expiration;
    }
    
    /**GET Method Propertie unit_price*/
    public double getPrice(){
        return this.unit_price;
    }

    /**SET Method Propertie unit_price*/
    public void setPrice(double unit_price){
        this.unit_price = unit_price;
    }

}
