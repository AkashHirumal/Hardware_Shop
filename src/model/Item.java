/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Akash
 */
public class Item {
    private int id;
    private String itemName;
    private String itemDesc;
    private Integer itemQty;
    private Double itemPrice;

    public Item(int id, String itemName, String itemDesc, Integer itemQty, Double itemPrice){
        this.id=id;
        this.itemName=itemName;
        this.itemDesc=itemDesc;
        this.itemPrice=itemPrice;
        this.itemQty=itemQty;
    } 
    
    public Item(){
    
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * @return the itemQty
     */
    public Integer getItemQty() {
        return itemQty;
    }

    /**
     * @param itemQty the itemQty to set
     */
    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    /**
     * @return the itemPrice
     */
    public Double getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public String toString() {
        return "" +itemName+ " (ID: " +getId()+ ") - Qty: " +itemQty+ " Price : LKR" + itemPrice;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }



 
    
}
