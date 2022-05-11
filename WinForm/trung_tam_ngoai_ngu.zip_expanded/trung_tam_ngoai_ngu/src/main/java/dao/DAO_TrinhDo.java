package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_TrinhDo;

public class DAO_TrinhDo {

	static final String TABLE_NAME = "trinhdo";

	public static ArrayList<DTO_TrinhDo> search(DTO_TrinhDo trinhdo){
		ArrayList<DTO_TrinhDo> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (trinhdo.getmaTrinhDo() != -1 ? ("`maTrinhDo` = " + String.valueOf(trinhdo.getmaTrinhDo()) + " and ") : " 1 and ")
			+ (trinhdo.gettenTrinhDo() != null && ! trinhdo.gettenTrinhDo().contentEquals("") ? ("`tenTrinhDo` like N\'%" + trinhdo.gettenTrinhDo() + "%\'" + "") : "1")
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
					arr.add(new  DTO_TrinhDo(rs.getInt("maTrinhDo"), rs.getString("tenTrinhDo")));
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

	public static int create(DTO_TrinhDo trinhdo) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (trinhdo.getmaTrinhDo() != -1 ? "`maTrinhDo`, " : "")
			+ (trinhdo.gettenTrinhDo() != null && ! trinhdo.gettenTrinhDo().contentEquals("") ? "`tenTrinhDo`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (trinhdo.getmaTrinhDo() != -1 ? String.valueOf(trinhdo.getmaTrinhDo()) + ", " : "")
			+ (trinhdo.gettenTrinhDo() != null && ! trinhdo.gettenTrinhDo().contentEquals("") ? "N'" + trinhdo.gettenTrinhDo() + "', " : "")
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

	public static int update(DTO_TrinhDo trinhdonew, DTO_TrinhDo trinhdoold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (trinhdonew.getmaTrinhDo() != -1 ? ("`maTrinhDo` = " + String.valueOf(trinhdonew.getmaTrinhDo()) + ", ") : "")
			+ (trinhdonew.gettenTrinhDo() != null && ! trinhdonew.gettenTrinhDo().contentEquals("") ? ("`tenTrinhDo` = N'" + trinhdonew.gettenTrinhDo() + "', ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (trinhdoold.getmaTrinhDo() != -1 ? ("`maTrinhDo` = " + String.valueOf(trinhdoold.getmaTrinhDo()) + " and ") : "1 and ")
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

	public static int delete(DTO_TrinhDo trinhdo) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (trinhdo.getmaTrinhDo() != -1 ? ("`maTrinhDo` = " + String.valueOf(trinhdo.getmaTrinhDo()) + " and ") : "1 and ")
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