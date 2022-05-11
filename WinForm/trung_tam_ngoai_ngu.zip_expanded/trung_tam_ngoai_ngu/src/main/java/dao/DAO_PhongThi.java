package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_PhongThi;

public class DAO_PhongThi {

	static final String TABLE_NAME = "phongthi";

	public static ArrayList<DTO_PhongThi> search(DTO_PhongThi phongthi){
		ArrayList<DTO_PhongThi> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (phongthi.getmaPhongThi() != -1 ? ("`maPhongThi` = " + String.valueOf(phongthi.getmaPhongThi()) + " and ") : " 1 and ")
			+ (phongthi.getmaKhoaThi() != -1 ? ("`maKhoaThi` = " + String.valueOf(phongthi.getmaKhoaThi()) + " and ") : " 1 and ")
			+ (phongthi.getmaTrinhDo() != -1 ? ("`maTrinhDo` = " + String.valueOf(phongthi.getmaTrinhDo()) + " and ") : " 1 and ")
			+ (phongthi.gettenPhongThi() != null && ! phongthi.gettenPhongThi().contentEquals("") ? ("`tenPhongThi` like N\'%" + phongthi.gettenPhongThi() + "%\'" + " and ") : "1 and ")
			+ (phongthi.getcaThi() != -1 ? ("`caThi` = " + String.valueOf(phongthi.getcaThi()) + "") : " 1")
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
					arr.add(new  DTO_PhongThi(rs.getInt("maPhongThi"), rs.getInt("maKhoaThi"), rs.getInt("maTrinhDo"), rs.getString("tenPhongThi"), rs.getInt("caThi")));
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

	public static int create(DTO_PhongThi phongthi) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (phongthi.getmaPhongThi() != -1 ? "`maPhongThi`, " : "")
			+ (phongthi.getmaKhoaThi() != -1 ? "`maKhoaThi`, " : "")
			+ (phongthi.getmaTrinhDo() != -1 ? "`maTrinhDo`, " : "")
			+ (phongthi.gettenPhongThi() != null && ! phongthi.gettenPhongThi().contentEquals("") ? "`tenPhongThi`, " : "")
			+ (phongthi.getcaThi() != -1 ? "`caThi`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (phongthi.getmaPhongThi() != -1 ? String.valueOf(phongthi.getmaPhongThi()) + ", " : "")
			+ (phongthi.getmaKhoaThi() != -1 ? String.valueOf(phongthi.getmaKhoaThi()) + ", " : "")
			+ (phongthi.getmaTrinhDo() != -1 ? String.valueOf(phongthi.getmaTrinhDo()) + ", " : "")
			+ (phongthi.gettenPhongThi() != null && ! phongthi.gettenPhongThi().contentEquals("") ? "N'" + phongthi.gettenPhongThi() + "', " : "")
			+ (phongthi.getcaThi() != -1 ? String.valueOf(phongthi.getcaThi()) + ", " : "")
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

	public static int update(DTO_PhongThi phongthinew, DTO_PhongThi phongthiold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (phongthinew.getmaPhongThi() != -1 ? ("`maPhongThi` = " + String.valueOf(phongthinew.getmaPhongThi()) + ", ") : "")
			+ (phongthinew.getmaKhoaThi() != -1 ? ("`maKhoaThi` = " + String.valueOf(phongthinew.getmaKhoaThi()) + ", ") : "")
			+ (phongthinew.getmaTrinhDo() != -1 ? ("`maTrinhDo` = " + String.valueOf(phongthinew.getmaTrinhDo()) + ", ") : "")
			+ (phongthinew.gettenPhongThi() != null && ! phongthinew.gettenPhongThi().contentEquals("") ? ("`tenPhongThi` = N'" + phongthinew.gettenPhongThi() + "', ") : "")
			+ (phongthinew.getcaThi() != -1 ? ("`caThi` = " + String.valueOf(phongthinew.getcaThi()) + ", ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (phongthiold.getmaPhongThi() != -1 ? ("`maPhongThi` = " + String.valueOf(phongthiold.getmaPhongThi()) + " and ") : "1 and ")
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

	public static int delete(DTO_PhongThi phongthi) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (phongthi.getmaPhongThi() != -1 ? ("`maPhongThi` = " + String.valueOf(phongthi.getmaPhongThi()) + " and ") : "1 and ")
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