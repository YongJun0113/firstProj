package dao_p;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto_p.BoardDTO;


public class BoardDAO {
	Connection connection;
	PreparedStatement preparedStatement;//미리 컴파일/ 준비
	ResultSet resultSet;
	String query;
	public BoardDAO() {
		
		try {
			Context init = new InitialContext();
			DataSource dataSource = (DataSource)init.lookup("java:comp/env/zaq");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void close() {
		if(resultSet!=null) { try {resultSet.close();} catch (SQLException e) {}}
		if(preparedStatement!=null) { try {preparedStatement.close();} catch (SQLException e) {}}
		if(connection!=null) { try {connection.close();} catch (SQLException e) {}}
	}
	
	//게시판 목록
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		query = "select * from personal order by perNum desc";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setPerNum(((resultSet.getInt("perNum"))));
				dto.setBoardCate(((resultSet.getString("boardCate"))));
				dto.setPerTitle((resultSet.getString("perTitle")));
				dto.setUserId(resultSet.getString("userId"));
				dto.setPerDate(((resultSet.getTimestamp("perDate"))));
				dto.setPerFile((resultSet.getString("perFile")));
				result.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(); // 예외가 발생하지 않더라도 데이터베이스를 닫도록 finally 선언
		}
		return result;
	}
	//게시판 글쓰기
	public void writePost(BoardDTO dto) {
		query = "insert into personal (boardCate, perTitle, perContent, perFile) values (?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dto.getBoardCate());
			preparedStatement.setString(2, dto.getPerTitle());
			preparedStatement.setString(3, dto.getPerContent());
			preparedStatement.setString(4, dto.getPerFile());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	//게시판 자세히보기
	public BoardDTO getPostDetails(int perNum) {
		BoardDTO dto = null;
		query = "select * from personal where perNum = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, perNum);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dto = new BoardDTO();
				dto.setPerNum(resultSet.getInt("perNum"));
				dto.setPerTitle(resultSet.getString("perTitle"));
				dto.setUserId(resultSet.getString("userId"));
				dto.setPerDate(resultSet.getTimestamp("perDate"));
				dto.setPerFile((resultSet.getString("perFile")));
				dto.setPerContent(resultSet.getString("perContent"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	//게시물 삭제하기
	public void deletePost(int perNum) {
		query = "delete from personal where perNum = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, perNum);
			resultSet = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	//게시물 수정하기
	public void editPost(BoardDTO dto) {
		query = "update personal set perTitle=?, userId=?, perContent=?, perFile=? where perNum=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dto.getPerTitle());
			preparedStatement.setString(2, dto.getUserId());
			preparedStatement.setString(3, dto.getPerContent());
			preparedStatement.setString(4, dto.getPerFile());
			preparedStatement.setInt(5, dto.getPerNum());
			preparedStatement.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
			
	}
	
	//제목 검색
	public ArrayList<BoardDTO> serachList(String title){
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		query = "select * from personal where perTitle like ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%"+title+"%");
			resultSet = preparedStatement.executeQuery();
				
			while(resultSet.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setPerNum(((resultSet.getInt("perNum"))));
				dto.setBoardCate(((resultSet.getString("boardCate"))));
				dto.setPerTitle((resultSet.getString("perTitle")));
				dto.setUserId(resultSet.getString("userId"));
				dto.setPerDate(((resultSet.getTimestamp("perDate"))));
				dto.setPerFile((resultSet.getString("perFile")));					
				result.add(dto);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}		
	
}
