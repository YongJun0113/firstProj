package admin_model;
/*
CREATE TABLE board(
	no int AUTO_INCREMENT PRIMARY KEY,
	title varchar(100),
	pname varchar(100),
	upfile varchar(100),
	content varchar(9999),
	reg_date datetime
);

INSERT INTO board (title,pname,content,reg_date) VALUES
('첫글이다','이상훈','첫글내용','2022-05-06'),
('두글이다','삼상훈','두글내용','2000-08-01'),
('세글이다','사상훈','셋글내용','2021-04-04'),
('네글이다','박건우','넷글내용','2023-02-06'),
('오글이다','박건수','오글내용','2024-09-04');
 * */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public AdminDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds =(DataSource)init.lookup("java:comp/env/zaq");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close();
	}
	
	void close() {
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
	
	public ArrayList<AdminDTO> list(){
		ArrayList<AdminDTO> res = new ArrayList<AdminDTO>();
		
		sql = "select * from order";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				AdminDTO dto = new AdminDTO();
				dto.setOrderCnt(rs.getInt("orderCnt"));
				dto.setOrderNum(rs.getInt("orderCnt"));
				dto.setProdNum(rs.getInt("prodNum"));
				
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
