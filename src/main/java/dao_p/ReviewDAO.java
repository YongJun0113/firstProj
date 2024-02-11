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
import dto_p.ReviewDTO;

public class ReviewDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public ReviewDAO() {
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
	
	public ArrayList<ReviewDTO> list(){
		ArrayList<ReviewDTO> res = new ArrayList<ReviewDTO>();
		sql = "select * from review";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {

				ReviewDTO dto = new ReviewDTO();
				dto.setProdNum(rs.getInt("prodNum"));
				dto.setReviewNum(rs.getInt("reviewNum"));
				dto.setReviewStar(rs.getInt("reviewStar"));
				dto.setReviewTitle(rs.getString("reviewTitle"));
				dto.setReviewContent(rs.getString("reviewContent"));
				dto.setUserId(rs.getString("userId"));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
//	public ProductDTO detail(int prodNum){
//		ProductDTO dto = null;
//		
//		sql = "select * from product where prodNum = ?";
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setInt(1, prodNum);
//			rs = psmt.executeQuery();
//			
//			if(rs.next()) {
//				dto = new ProductDTO();
//				dto.setProdNum(rs.getInt("prodNum"));
//				dto.setProdTitle(rs.getString("prodTitle"));
//				dto.setProdCate(rs.getString("prodCate"));
//				dto.setProdFile(rs.getString("prodFile"));
//				dto.setProdPrice(rs.getInt("prodPrice"));
//				dto.setProdInfo(rs.getString("prodInfo"));
//	
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		
//		return dto;
//	}
//	
//	public void write(ProductDTO dto){
//		sql = "insert into product (prodPrice, prodCate, prodFile, prodTitle, ProdInfo) values (?,?,?,?,?)";
//		try {
//			psmt = con.prepareStatement(sql);
//	
//	
//			psmt.setInt(1,dto.getProdPrice());
//			psmt.setString(2,dto.getProdCate());
//			psmt.setString(3,dto.getProdFile());
//			psmt.setString(4,dto.getProdTitle());
//			psmt.setString(5,dto.getProdInfo());
//	
//			psmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		
//	}
//	
//	public  void modify(ProductDTO dto){
//		
//		sql = "update product set  prodPrice = ?, prodCate = ?, prodFile = ?, prodTitle = ?, prodInfo = ? where prodNum = ?";
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setInt(1,dto.getProdPrice());
//			psmt.setString(2,dto.getProdCate());
//			psmt.setString(3,dto.getProdFile());
//			psmt.setString(4,dto.getProdTitle());
//			psmt.setString(5,dto.getProdInfo());
//			psmt.setInt(6,dto.getProdNum());
//		
//			psmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		
//		
//	}
//	
//	public  void delete(int prodNum){
//		
//		sql = "delete from product where prodNum = ?";
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setInt(1, prodNum);
//		
//			
//			psmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//	}	
}
