import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class memberDAO {
	
	public static final int MEMBER_NONEXISTENT  = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static memberDAO instance = new memberDAO();
	DataSource dataSource;
	
	private memberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static memberDAO getInstance(){
		return instance;
	}
	
	public int insertMember(String mId,String mPw,String mName,String mAddress,String mEmail) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into member values (?,?,?,?,?)";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			pstmt.setString(3, mName);
			pstmt.setString(4, mAddress);
			pstmt.setString(5, mEmail);
			pstmt.executeUpdate();
			ri = memberDAO.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}

	
	public int memberCheck(String mId,String mPw) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select mpw from member where mid = ? ";
		String dbPw = null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, mId);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dbPw = set.getString("mpw");
				if(dbPw.equals(mPw)) {
					ri = memberDAO.MEMBER_LOGIN_SUCCESS;			
				} else {
					ri = memberDAO.MEMBER_LOGIN_PW_NO_GOOD;		
				}
			} else {
				ri = memberDAO.MEMBER_LOGIN_IS_NOT;			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(set != null ) set.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public memberDTO getMember(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from member where mid = ?";
		memberDTO dto = null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dto = new memberDTO();
				dto.setmId(set.getString("mid"));
				dto.setmPw(set.getString("mpw"));
				dto.setmName(set.getString("mname"));
				dto.setmAddress(set.getString("maddress"));
				dto.setmEmail(set.getString("memail"));
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
}
