/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderFunction {
    public OrderFunction() {
    }
    
    public  void add(int billNo,int prodNo, int amount) throws ClassNotFoundException, SQLException{
        String prodName = "";
        double price = 0;
        Connection con = ConnectionBuilders.getConnection();//ต่อดาต้าเบส
        Statement stm = con.createStatement();//สร้าง statement มาเตรียมรับคำสั่ง sql
        ResultSet rs = stm.executeQuery("select Prodname,price From Product Where prodNo = "+prodNo );
            //สร้าง object rs เพื่อให้รับค่าจากดาต้าเบสไปแสดงผล 
           while(rs.next()){//สั่งให้ไล่ row ลงมาเรื่อยๆ
               prodName = rs.getString("Prodname");
               price = (rs.getDouble("price"))*amount;
           }
        rs.close();//ปิดการทำงาน rs
        stm.close();//ปิดการทำงาน stm
        String insert = "INSERT INTO LISTOFBILL(BILL_BILLNO,PRODUCT_PRODNO,PRICE,AMOUNT) "
                + "VALUES(?,?,?,?)";
        PreparedStatement psm = con.prepareStatement(insert);
        psm.setInt(1,billNo);
        psm.setInt(2,prodNo);
        psm.setDouble(3,price);
        psm.setInt(4,amount);
        psm.executeUpdate();
        psm.close();
        con.close();
    }
    public List<ListOfBill> showBill(int prodNo) {
       
            //String select = "SELECT AccidentId,TypeName,Location,Detail,StatusName,Time ";
            String select = "SELECT prodNo,ProdName,price ";
            String from = "FROM Product Where prodNo = "+prodNo;
            
            
            List<ListOfBill> lob = null;
            ListOfBill a = null;
            try {
            Connection con = ConnectionBuilders.getConnection();//ต่อดาต้าเบส
            Statement stm = con.createStatement();//สร้าง statement มาเตรียมรับคำสั่ง sql
            ResultSet rs = stm.executeQuery(select+from);
            //สร้าง object rs เพื่อให้รับค่าจากดาต้าเบสไปแสดงผล
            while(rs.next()){//สั่งให้ไล่ row ลงมาเรื่อยๆ
                a = new ListOfBill();//สร้าง Object ให้ Accident เป็นค่าว่าง
                if(lob == null){//ถ้า ยังไม่ได้ new ArrayList ให้ new
                    lob = new ArrayList();
                }
                orm(a, rs);//เอาค่าที่ดึงจาก rs เข้าไปใน a;
                lob.add(a);//เอาค่า a เก็บเข้าไปใน arraylist
            }
            rs.close();//ปิดการทำงาน rs
            stm.close();//ปิดการทำงาน stm
            con.close();//ปิดการเชื่อมต่อ database
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderFunction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lob;  
    }
    public List<DetailOrder> showDetail(int billNo) {
       
            String sql = "SELECT B.dates,B.totalprice,B.Changes,P.ProdName,LSB.price,LSB.amount,B.POS_POSNO,B.STAFF_STAFFNO " +
                     "FROM LISTOFBILL LSB JOIN PRODUCT P " +
                     "ON LSB.PRODUCT_PRODNO = P.PRODNO " +
                     "JOIN BILL B ON B.BILLNO = LSB.BILL_BILLNO "
                + "WHERE B.billNo = "+billNo;
            
            
            List<DetailOrder> lob = null;
            DetailOrder a = null;
            try {
            Connection con = ConnectionBuilders.getConnection();//ต่อดาต้าเบส
            Statement stm = con.createStatement();//สร้าง statement มาเตรียมรับคำสั่ง sql
            ResultSet rs = stm.executeQuery(sql);
            //สร้าง object rs เพื่อให้รับค่าจากดาต้าเบสไปแสดงผล
            while(rs.next()){//สั่งให้ไล่ row ลงมาเรื่อยๆ
                a = new DetailOrder();//สร้าง Object ให้ Accident เป็นค่าว่าง
                if(lob == null){//ถ้า ยังไม่ได้ new ArrayList ให้ new
                    lob = new ArrayList();
                }
                orm2(a, rs);//เอาค่าที่ดึงจาก rs เข้าไปใน a;
                lob.add(a);//เอาค่า a เก็บเข้าไปใน arraylist
            }
            rs.close();//ปิดการทำงาน rs
            stm.close();//ปิดการทำงาน stm
            con.close();//ปิดการเชื่อมต่อ database
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderFunction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lob;  
    }
    private void orm2(DetailOrder lob,ResultSet rs) throws SQLException{
        lob.setDate(rs.getString("dates"));
        lob.setNameOfProd(rs.getString("prodname"));
        lob.setPrice(rs.getDouble("price"));
        lob.setAmount(rs.getInt("amount"));
        lob.setTotalPrice(rs.getDouble("totalprice"));
        lob.setChange(rs.getDouble("changes"));
        lob.setStaffNo(rs.getInt("STAFF_STAFFNO"));
        lob.setPosNO(rs.getInt("POS_POSNO"));
        
        
        
    }
    public List<ListOfBill> clearList(int prodNo) {
            List<ListOfBill> lob = null;
            ListOfBill a = null;   
        return lob;  
    }
    private void orm(ListOfBill lob,ResultSet rs) throws SQLException{
        lob.setProdName(rs.getString("prodName"));
        lob.setPrice(rs.getDouble("price"));
        lob.setProdNo(rs.getInt("prodNo"));
        
        
    }
    
}
