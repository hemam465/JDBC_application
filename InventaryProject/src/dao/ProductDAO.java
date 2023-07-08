package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.Product;

public class ProductDAO 
{
public void addProduct(Product product) throws ClassNotFoundException, SQLException
{
	ConnectionManager conm=new ConnectionManager();
	Connection con=conm.establishConnection();
	
	String sql_query="insert into Product(productId,productName,minSellQuantity,price,quantity) values (?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql_query);
	ps.setInt(1,product.getProductId());
	ps.setString(2,product.getProductName());
	ps.setInt(3,product.getMinSellQuantity());
	ps.setInt(4,product.getPrice());
	ps.setInt(5,product.getQuantity());
	
	ps.executeUpdate();
	
    conm.closeConnection();

}
public void display() throws ClassNotFoundException, SQLException {
	
	ConnectionManager conm=new ConnectionManager();
	Connection con=conm.establishConnection();
	
	Statement st=con.createStatement();
	
    //ResultSet class
	ResultSet rt=st.executeQuery("select * from product");
	
	while(rt.next())
	{
		System.out.println(rt.getInt("ProductId")+"|"+rt.getString("ProductName")+"|"+rt.getInt("MinSellQuantity")+"|"+rt.getInt("Price")+"|"+rt.getInt("Quantity"));
	}
	conm.closeConnection();
}
}
