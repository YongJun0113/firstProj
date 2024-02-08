package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.OrderDTO;


public class OrderDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public OrderDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/zaq");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close();
	}
	
	void close() {
		if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
		if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
		if(con!=null) { try { con.close();} catch (SQLException e) {}}
	}
	
	public ArrayList<OrderDTO> detailList(){
		ArrayList<OrderDTO> res = new ArrayList<OrderDTO>();
		sql = "select * from delivery d , orderinfo o , product p where d.orderNum = o.orderNum and userId = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "lsh");
			
			rs = psmt.executeQuery();
			while(rs.next()) {

				OrderDTO dto = new OrderDTO();
				dto.setOrderDateStr(rs.getString("orderDate"));
				dto.setProdFile(rs.getString("prodFile"));
				dto.setProdInfo(rs.getString("prodInfo"));
				dto.setOrderCnt(rs.getInt("orderCnt"));
				dto.setProdPrice(rs.getInt("prodPrice"));
				dto.setDeliveryStatus(rs.getString("deliveryStatus"));
				dto.setOrderStatus(rs.getString("orderStatus"));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	public ArrayList<OrderDTO> refundList(){
		ArrayList<OrderDTO> res = new ArrayList<OrderDTO>();
		sql = "select * from delivery d , orderinfo o , product p where d.orderStatus = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "취소");
			
			rs = psmt.executeQuery();
			while(rs.next()) {

				OrderDTO dto = new OrderDTO();
				dto.setOrderDateStr(rs.getString("orderDate"));
				dto.setProdFile(rs.getString("prodFile"));
				dto.setProdInfo(rs.getString("prodInfo"));
				dto.setOrderCnt(rs.getInt("orderCnt"));
				dto.setProdPrice(rs.getInt("prodPrice"));
				dto.setDeliveryStatus(rs.getString("deliveryStatus"));
				dto.setOrderStatus(rs.getString("orderStatus"));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	public ArrayList<OrderDTO> historyList(){
		ArrayList<OrderDTO> res = new ArrayList<OrderDTO>();
		sql = "select * from delivery d , orderinfo o , product p where d.orderNum = o.orderNum and userId = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "lsh");
			
			rs = psmt.executeQuery();
			while(rs.next()) {

				OrderDTO dto = new OrderDTO();
				dto.setOrderDateStr(rs.getString("orderDate"));
				dto.setProdFile(rs.getString("prodFile"));
				dto.setProdInfo(rs.getString("prodInfo"));
				dto.setOrderCnt(rs.getInt("orderCnt"));
				dto.setProdPrice(rs.getInt("prodPrice"));
				dto.setDeliveryStatus(rs.getString("deliveryStatus"));
				dto.setOrderStatus(rs.getString("orderStatus"));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	public int total(){
		int cnt = 0;
		sql = "select count(*) from board";
		try {
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			rs.next();
			
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return cnt;
	}
	

}
