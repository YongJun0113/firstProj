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

import dto_p.MemberDTO;


public class MemberDAO {

	private static MemberDAO dao;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	private int result;
	

	public static synchronized MemberDAO getInstance() {
		// TODO Auto-generated method stub
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	public MemberDAO() {
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
	
	//회원목록
	public ArrayList<MemberDTO> list() {
		ArrayList<MemberDTO> res = new ArrayList<MemberDTO>();
		sql = "select * from member";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setPw(rs.getString("pw"));
				dto.setUsername(rs.getString("username"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setPostNum(rs.getString("postNum"));
				dto.setStreetAddr(rs.getString("streetAddr"));
				dto.setAddr(rs.getString("addr"));
				dto.setDtailAddr(rs.getString("dtailaddr"));
				dto.setStatus(rs.getString("Status"));
				dto.setAdmin(rs.getString("admin"));
				dto.setBirth(rs.getString("birth"));
				dto.setCreateDate(rs.getTimestamp("createDate"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	//회원가입
	public int join(MemberDTO dto) {
		
		sql = "insert into member(userid, pw, username, gender, birth, tel, email, postNum, streetAddr, addr, dtailAddr,  status, admin) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,  dto.getUserid());
			psmt.setString(2,  dto.getPw());
			psmt.setString(3,  dto.getUsername());
			psmt.setString(4,  dto.getGender());
			psmt.setString(5,  dto.getTel());
			psmt.setString(6,  dto.getEmail());
			psmt.setString(7,  dto.getPostNum());
			psmt.setString(8,  dto.getStreetAddr());
			psmt.setString(9,  dto.getAddr());
			psmt.setString(10, dto.getDtailAddr());
			psmt.setString(11, dto.getStatus());
			psmt.setString(12, dto.getAdmin());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	/*
	public void memberJoin(MemberDTO dto) {
		
		sql = "insert into member(userid, pw, username, gender, birth, tel, email, postNum, streetAddr, addr, dtailAddr,  status, admin) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getGender());
			psmt.setString(4, dto.getTel());
			psmt.setString(5, dto.getBirth());
			psmt.setString(6, dto.getEmail());
			psmt.setString(7, dto.getPostNum());
			psmt.setString(8, dto.getStreetAddr());
			psmt.setString(9, dto.getAddr());
			psmt.setString(10, dto.getDtailAddr());
			psmt.setString(11, dto.getStatus());
			psmt.setString(12, dto.getAdmin());
			
			
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	*/

	
	
	//로그인
	public int login(String userid, String pw) {
		
		/*
		0StringBuffer query = new StringBuffer();
		query.append("SELECT pw").append(" FROM member").append(" WHERE ID = ?");
		*/
		sql = "select pw from member where userid = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					return 1;
				} else {
					return 0;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return -1;
	}
	
	
	
	
	
	
	/*
	public String loginCheck(String userid, String pw) {
		
		sql = "select pw from member where userid = ?";
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return 
	}
	*/
	
	//회원탈퇴
	
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
	
	
	
}
