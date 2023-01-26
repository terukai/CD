package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CD;

public class CDDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int registerCD(CD cd) {
		String sql = "INSERT INTO cd VALUES(default,?,?,?,?,?)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,cd.getTitle());
			pstmt.setString(2,cd.getComposter());
			pstmt.setString(3,cd.getSinger());
			pstmt.setInt(4, cd.getRelease());
			pstmt.setInt(5, cd.getLength());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static int deleteCD(int id) {
		
		String sql = "DELETE FROM cd WHERE id = ?";
		int result = 0;
		try (Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(0,id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static List<CD> selectListCD(){
		String sql = "SELECT * FROM cd";
		List<CD> list = new ArrayList<>();
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String composter = rs.getString("composter");
					String singer = rs.getString("singer");
					int release = rs.getInt("release");
					int length = rs.getInt("length");
					
					CD cd = new CD(id,title,composter,singer,release,length);
					list.add(cd);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return list;
		}
		
	}

