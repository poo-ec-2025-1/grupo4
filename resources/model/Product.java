package model;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "produtos")
public class Product
{  
    @DatabaseField(generatedId = true)
    private int Id;
       
    @DatabaseField
    private String name;
    
    @DatabaseField
    private String code;
    
    @DatabaseField
    private String section;
    
    @DatabaseField
    private String gondola;
    
    @DatabaseField
    private String shelf;
    
    @DatabaseField
    private String sectionE;
    
    @DatabaseField
    private String gondolaE;
    
    @DatabaseField
    private String shelfE;
    
    @DatabaseField
    private double store_quantity;
    
    @DatabaseField
    private double stock_quantity;
    
    @DatabaseField(dataType=DataType.DATE)
    private Date expiration;
    
    @DatabaseField
    private double unit_price;

    @DatabaseField
    private String observation;
    
    public String printExpiration() {
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
        return dateFor.format(expiration);
    }
    
    public Product(){}

    
    public Product(String name, String code,String section, String gondola,
    String shelf, double store_quantity, double stock_quantity, String expiration,
    double unit_price, String observation, String sectionE, String gondolaE,
    String shelfE){
        this.name = name;
        this.code = code;
        this.section = section;
        this.gondola = gondola;
        this.shelf = shelf;
        this.store_quantity = store_quantity;
        this.stock_quantity = stock_quantity;
        this.unit_price = unit_price;
        this.setExpiration(expiration);
        this.observation = observation;
        this.sectionE = sectionE;
        this.gondolaE = gondolaE;
        this.shelfE = shelfE;
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
    
    /**GET Method Propertie section*/
    public String getSection(){
        return this.section;
    }

    /**SET Method Propertie section*/
    public void setSection(String section){
        this.section = section;
    }
    
    /**GET Method Propertie shelf*/
    public String getShelf(){
        return this.shelf;
    }

    /**SET Method Propertie shelf*/
    public void setShelf(String shelf){
        this.shelf = shelf;
    }
    
    /**GET Method Propertie gondola*/
    public String getGondola(){
        return this.gondola;
    }

    /**SET Method Propertie gondola*/
    public void setGondola(String gondola){
        this.gondola = gondola;
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
    public String getExpiration(){
        String data = DateToString(this.expiration);
        return data;
    }

    /**SET Method Propertie expiration*/
    public void setExpiration(String data){
        expiration = StringToDate(data);
    }
    
    /**GET Method Propertie unit_price*/
    public double getPrice(){
        return this.unit_price;
    }

    /**SET Method Propertie unit_price*/
    public void setPrice(double unit_price){
        this.unit_price = unit_price;
    }
    
    public static Date StringToDate(String dataEmTexto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); 

        try {
            return formato.parse(dataEmTexto);
        } catch (ParseException e) {
            System.out.println("Data inválida: " + dataEmTexto);
            return null; 
        }
    }
    
    public static String DateToString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }

    public int getId(){
        return this.Id;
    }

    public String getObservation(){
        return observation;
    }

    public void setObservation(String observation){
        this.observation = observation;
    }
    
    /**GET Method Propertie sectionE*/
    public String getSectionE(){
        return this.sectionE;
    }

    /**SET Method Propertie sectionE*/
    public void setSectionE(String sectionE){
        this.sectionE = sectionE;
    }
    
    /**GET Method Propertie shelfE*/
    public String getShelfE(){
        return this.shelfE;
    }

    /**SET Method Propertie shelfE*/
    public void setShelfE(String shelfE){
        this.shelfE = shelfE;
    }
    
    /**GET Method Propertie gondolaE*/
    public String getGondolaE(){
        return this.gondolaE;
    }

    /**SET Method Propertie gondolaE*/
    public void setGondolaE(String gondolaE){
        this.gondolaE = gondolaE;
    }
}
