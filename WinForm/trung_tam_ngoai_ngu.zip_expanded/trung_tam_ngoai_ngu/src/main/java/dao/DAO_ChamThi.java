package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_ChamThi;

public class DAO_ChamThi {

	static final String TABLE_NAME = "chamthi";

	public static ArrayList<DTO_ChamThi> search(DTO_ChamThi chamthi){
		ArrayList<DTO_ChamThi> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (chamthi.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(chamthi.getmaChamThi()) + " and ") : " 1 and ")
			+ (chamthi.getmaGiaoVien1() != -1 ? ("`maGiaoVien1` = " + String.valueOf(chamthi.getmaGiaoVien1()) + " and ") : " 1 and ")
			+ (chamthi.getmaGiaoVien2() != -1 ? ("`maGiaoVien2` = " + String.valueOf(chamthi.getmaGiaoVien2()) + "") : " 1")
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
					arr.add(new  DTO_ChamThi(rs.getInt("maChamThi"), rs.getInt("maGiaoVien1"), rs.getInt("maGiaoVien2")));
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

	public static int create(DTO_ChamThi chamthi) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (chamthi.getmaChamThi() != -1 ? "`maChamThi`, " : "")
			+ (chamthi.getmaGiaoVien1() != -1 ? "`maGiaoVien1`, " : "")
			+ (chamthi.getmaGiaoVien2() != -1 ? "`maGiaoVien2`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (chamthi.getmaChamThi() != -1 ? String.valueOf(chamthi.getmaChamThi()) + ", " : "")
			+ (chamthi.getmaGiaoVien1() != -1 ? String.valueOf(chamthi.getmaGiaoVien1()) + ", " : "")
			+ (chamthi.getmaGiaoVien2() != -1 ? String.valueOf(chamthi.getmaGiaoVien2()) + ", " : "")
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

	public static int update(DTO_ChamThi chamthinew, DTO_ChamThi chamthiold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (chamthinew.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(chamthinew.getmaChamThi()) + ", ") : "")
			+ (chamthinew.getmaGiaoVien1() != -1 ? ("`maGiaoVien1` = " + String.valueOf(chamthinew.getmaGiaoVien1()) + ", ") : "")
			+ (chamthinew.getmaGiaoVien2() != -1 ? ("`maGiaoVien2` = " + String.valueOf(chamthinew.getmaGiaoVien2()) + ", ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (chamthiold.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(chamthiold.getmaChamThi()) + " and ") : "1 and ")
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

	public static int delete(DTO_ChamThi chamthi) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (chamthi.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(chamthi.getmaChamThi()) + " and ") : "1 and ")
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