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

import org.apache.catalina.tribes.Member;

import member_p.MemberDTO;


public class MemberDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	//ArrayList<Member> alm = null;
	String sql;
	
	public MemberDAO() {
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
	/*
	public int login(String userid, String pw) {
		 System.out.println("login 메서드 호출 완료");
		
		MemberDTO dto = null;
		sql = "select pw from member where userid = ?";
		//String SQL = "select pw from member where userid = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).contentEquals(pw)) {
					return dto;  //로그인성공
				} else {
					return 0; //비밀번호 틀림
				}
			}
			return -1; //아이디가존재하지않음
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto; //db오류
	}
	*/
	public MemberDTO selectMem(String userid) {
		con=null;
		psmt=null;
		rs=null;
		MemberDTO dto=null;
		
		try {
			
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).contentEquals(pw)) {
					return dto;  //로그인성공
				} else {
					return 0; //비밀번호 틀림
				}
			}
			return -1; //아이디가존재하지않음
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto; //db오류
	}
	
	
}
