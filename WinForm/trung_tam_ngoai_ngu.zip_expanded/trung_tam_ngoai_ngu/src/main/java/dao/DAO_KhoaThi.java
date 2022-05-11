package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_KhoaThi;

public class DAO_KhoaThi {

	static final String TABLE_NAME = "khoathi";

	public static ArrayList<DTO_KhoaThi> search(DTO_KhoaThi khoathi){
		ArrayList<DTO_KhoaThi> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (khoathi.getmaKhoaThi() != -1 ? ("`maKhoaThi` = " + String.valueOf(khoathi.getmaKhoaThi()) + " and ") : " 1 and ")
			+ (khoathi.gettenKhoaThi() != null && ! khoathi.gettenKhoaThi().contentEquals("") ? ("`tenKhoaThi` like N\'%" + khoathi.gettenKhoaThi() + "%\'" + " and ") : "1 and ")
			+ (khoathi.getngayThi() != null ? ("`ngayThi` = '" + khoathi.getngayThi().toString() + "'") : " 1")
			+ "";
		if(where.contentEquals(""))
			sql = sql.substring(0, sql.length() - 7);
		else
			sql += where;
		Connection conn = Connector.connect();
		if( conn != null) {
			try {
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()) {
					arr.add(new  DTO_KhoaThi(rs.getInt("maKhoaThi"), rs.getString("tenKhoaThi"), rs.getDate("ngayThi")));
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("Search: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
					System.out.println("Search: " + e.getMessage());
			}		}
		return arr;
	}

	public static int create(DTO_KhoaThi khoathi) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (khoathi.getmaKhoaThi() != -1 ? "`maKhoaThi`, " : "")
			+ (khoathi.gettenKhoaThi() != null && ! khoathi.gettenKhoaThi().contentEquals("") ? "`tenKhoaThi`, " : "")
			+ (khoathi.getngayThi() != null ? "`ngayThi`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (khoathi.getmaKhoaThi() != -1 ? String.valueOf(khoathi.getmaKhoaThi()) + ", " : "")
			+ (khoathi.gettenKhoaThi() != null && ! khoathi.gettenKhoaThi().contentEquals("") ? "N'" + khoathi.gettenKhoaThi() + "', " : "")
			+ (khoathi.getngayThi() != null ? "'" + khoathi.getngayThi().toString() + "', " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ")";
		Connection conn = Connector.connect();
		if( conn != null) {
			try {
				Statement stat = conn.createStatement();
				code = stat.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Create: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Create: " + e.getMessage());
			}
		}
		return code;
	}

	public static int update(DTO_KhoaThi khoathinew, DTO_KhoaThi khoathiold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (khoathinew.getmaKhoaThi() != -1 ? ("`maKhoaThi` = " + String.valueOf(khoathinew.getmaKhoaThi()) + ", ") : "")
			+ (khoathinew.gettenKhoaThi() != null && ! khoathinew.gettenKhoaThi().contentEquals("") ? ("`tenKhoaThi` = N'" + khoathinew.gettenKhoaThi() + "', ") : "")
			+ (khoathinew.getngayThi() != null ? ("`ngayThi` = '" + khoathinew.getngayThi().toString() + "', ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (khoathiold.getmaKhoaThi() != -1 ? ("`maKhoaThi` = " + String.valueOf(khoathiold.getmaKhoaThi()) + " and ") : "1 and ")
			+ "";
		sql = sql.substring(0, sql.length() - 5);
		sql += ""
			+"";
		Connection conn = Connector.connect();
		if( conn != null) {
			try {
				Statement stat = conn.createStatement();
				code = stat.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Update: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Update: " + e.getMessage());
			}
		}
		return code;
	}

	public static int delete(DTO_KhoaThi khoathi) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (khoathi.getmaKhoaThi() != -1 ? ("`maKhoaThi` = " + String.valueOf(khoathi.getmaKhoaThi()) + " and ") : "1 and ")
			+ "";
		sql = sql.substring(0, sql.length() - 5);
		sql += ""
			+"";
		Connection conn = Connector.connect();
		if( conn != null) {
			try {
				Statement stat = conn.createStatement();
				code = stat.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Delete: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Delete: " + e.getMessage());
			}
		}
		return code;
	}
	
}