/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author watjakorn
 */
public class DetailOrder {
    private int billNo;
    private int posNO;
    private int staffNo;
    private String nameOfProd;
    private double price;
    private int amount;
    private String date;
    private double totalPrice;
    private double change;

    public DetailOrder() {
        DetailOrder de = new DetailOrder(0,0,0,null,0,0,null,0,0);
    }

    
    public DetailOrder(int billNo, int posNO, int staffNo, String nameOfProd, double price, int amount, String date, double totalPrice, double change) {
        this.billNo = billNo;
        this.posNO = posNO;
        this.staffNo = staffNo;
        this.nameOfProd = nameOfProd;
        this.price = price;
        this.amount = amount;
        this.date = date;
        this.totalPrice = totalPrice;
        this.change = change;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public int getPosNO() {
        return posNO;
    }

    public void setPosNO(int posNO) {
        this.posNO = posNO;
    }

    public int getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public String getNameOfProd() {
        return nameOfProd;
    }

    public void setNameOfProd(String nameOfProd) {
        this.nameOfProd = nameOfProd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}
