package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_CanhThi;

public class DAO_CanhThi {

	static final String TABLE_NAME = "canhthi";

	public static ArrayList<DTO_CanhThi> search(DTO_CanhThi canhthi){
		ArrayList<DTO_CanhThi> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (canhthi.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(canhthi.getmaCanhThi()) + " and ") : " 1 and ")
			+ (canhthi.getmaGiaoVien1() != -1 ? ("`maGiaoVien1` = " + String.valueOf(canhthi.getmaGiaoVien1()) + " and ") : " 1 and ")
			+ (canhthi.getmaGiaoVien2() != -1 ? ("`maGiaoVien2` = " + String.valueOf(canhthi.getmaGiaoVien2()) + "") : " 1")
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
					arr.add(new  DTO_CanhThi(rs.getInt("maCanhThi"), rs.getInt("maGiaoVien1"), rs.getInt("maGiaoVien2")));
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

	public static int create(DTO_CanhThi canhthi) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (canhthi.getmaCanhThi() != -1 ? "`maCanhThi`, " : "")
			+ (canhthi.getmaGiaoVien1() != -1 ? "`maGiaoVien1`, " : "")
			+ (canhthi.getmaGiaoVien2() != -1 ? "`maGiaoVien2`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (canhthi.getmaCanhThi() != -1 ? String.valueOf(canhthi.getmaCanhThi()) + ", " : "")
			+ (canhthi.getmaGiaoVien1() != -1 ? String.valueOf(canhthi.getmaGiaoVien1()) + ", " : "")
			+ (canhthi.getmaGiaoVien2() != -1 ? String.valueOf(canhthi.getmaGiaoVien2()) + ", " : "")
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

	public static int update(DTO_CanhThi canhthinew, DTO_CanhThi canhthiold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (canhthinew.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(canhthinew.getmaCanhThi()) + ", ") : "")
			+ (canhthinew.getmaGiaoVien1() != -1 ? ("`maGiaoVien1` = " + String.valueOf(canhthinew.getmaGiaoVien1()) + ", ") : "")
			+ (canhthinew.getmaGiaoVien2() != -1 ? ("`maGiaoVien2` = " + String.valueOf(canhthinew.getmaGiaoVien2()) + ", ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (canhthiold.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(canhthiold.getmaCanhThi()) + " and ") : "1 and ")
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

	public static int delete(DTO_CanhThi canhthi) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (canhthi.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(canhthi.getmaCanhThi()) + " and ") : "1 and ")
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