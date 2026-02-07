package com.ProductDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
	
	Connection conn = null;
	
	public ProductDB()
	{
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learning","postgres","admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void save(Product p)
	{
		String query = "insert into product (name,type,place,warranty) values (?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, p.getName());
			st.setString(2, p.getType());
			st.setString(3, p.getPlace());
			st.setInt(4, p.getWarranty());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement("select name,type,place,warranty from product");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public Product getProduct(String name) {
		// TODO Auto-generated method stub
		Product p = new Product();
		String sql = "select * from product where name=?";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1,name);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				p.setName(rs.getString(1));
				p.setPlace(rs.getString(2));
				p.setWarranty(rs.getInt(4));
				p.setType(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
