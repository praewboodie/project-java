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
public class ListOfBill {
    private String prodName ;
    private double price;
    private int prodNo;

    public int getProdNo() {
        return prodNo;
    }

    public void setProdNo(int prodNo) {
        this.prodNo = prodNo;
    }

    public ListOfBill(String prodName, double price, int prodNo) {
        this.prodName = prodName;
        this.price = price;
        this.prodNo = prodNo;
    }

    public ListOfBill() {
        ListOfBill listofbill = new ListOfBill(null,0);
    }

    public ListOfBill(String prodName, double price) {
        this.prodName = prodName;
        this.price = price;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
