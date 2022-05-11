package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_GiaoVien;

public class DAO_GiaoVien {

	static final String TABLE_NAME = "giaovien";

	public static ArrayList<DTO_GiaoVien> search(DTO_GiaoVien giaovien){
		ArrayList<DTO_GiaoVien> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (giaovien.getmaGiaoVien() != -1 ? ("`maGiaoVien` = " + String.valueOf(giaovien.getmaGiaoVien()) + " and ") : " 1 and ")
			+ (giaovien.gettenGiaoVien() != null && ! giaovien.gettenGiaoVien().contentEquals("") ? ("`tenGiaoVien` like N\'%" + giaovien.gettenGiaoVien() + "%\'" + "") : "1")
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
					arr.add(new  DTO_GiaoVien(rs.getInt("maGiaoVien"), rs.getString("tenGiaoVien")));
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

	public static int create(DTO_GiaoVien giaovien) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (giaovien.getmaGiaoVien() != -1 ? "`maGiaoVien`, " : "")
			+ (giaovien.gettenGiaoVien() != null && ! giaovien.gettenGiaoVien().contentEquals("") ? "`tenGiaoVien`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (giaovien.getmaGiaoVien() != -1 ? String.valueOf(giaovien.getmaGiaoVien()) + ", " : "")
			+ (giaovien.gettenGiaoVien() != null && ! giaovien.gettenGiaoVien().contentEquals("") ? "N'" + giaovien.gettenGiaoVien() + "', " : "")
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

	public static int update(DTO_GiaoVien giaoviennew, DTO_GiaoVien giaovienold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (giaoviennew.getmaGiaoVien() != -1 ? ("`maGiaoVien` = " + String.valueOf(giaoviennew.getmaGiaoVien()) + ", ") : "")
			+ (giaoviennew.gettenGiaoVien() != null && ! giaoviennew.gettenGiaoVien().contentEquals("") ? ("`tenGiaoVien` = N'" + giaoviennew.gettenGiaoVien() + "', ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (giaovienold.getmaGiaoVien() != -1 ? ("`maGiaoVien` = " + String.valueOf(giaovienold.getmaGiaoVien()) + " and ") : "1 and ")
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

	public static int delete(DTO_GiaoVien giaovien) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (giaovien.getmaGiaoVien() != -1 ? ("`maGiaoVien` = " + String.valueOf(giaovien.getmaGiaoVien()) + " and ") : "1 and ")
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