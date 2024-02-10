package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.ProductDTO;

public class ProductDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public ProductDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/zaq");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void close() {
		if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
		if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
		if(con!=null) { try { con.close();} catch (SQLException e) {}}
	}
	
	public ArrayList<ProductDTO> list(){
		ArrayList<ProductDTO> res = new ArrayList<ProductDTO>();
		sql = "select * from product";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {

				ProductDTO dto = new ProductDTO();
				dto.setProdNum(rs.getInt("prodNum"));
				dto.setProdTitle(rs.getString("prodTitle"));
				dto.setProdCate(rs.getString("prodCate"));
				dto.setProdFile(rs.getString("prodFile"));
				dto.setProdPrice(rs.getInt("prodPrice"));
				dto.setProdInfo(rs.getString("prodInfo"));
	

				res.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	public ProductDTO detail(int prodNum){
		ProductDTO dto = null;
		
		sql = "select * from product where prodNum = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, prodNum);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setProdNum(rs.getInt("prodNum"));
				dto.setProdTitle(rs.getString("prodTitle"));
				dto.setProdCate(rs.getString("prodCate"));
				dto.setProdFile(rs.getString("prodFile"));
				dto.setProdPrice(rs.getInt("prodPrice"));
				dto.setProdInfo(rs.getString("prodInfo"));
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	
	
}
