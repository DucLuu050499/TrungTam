package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_ThiSinh;

public class DAO_ThiSinh {

	static final String TABLE_NAME = "thisinh";

	public static ArrayList<DTO_ThiSinh> search(DTO_ThiSinh thisinh){
		ArrayList<DTO_ThiSinh> arr = new ArrayList<>();
		String sql = "select * from " + TABLE_NAME + " where ";
		String where = ""
			+ (thisinh.getcmnd() != null && ! thisinh.getcmnd().contentEquals("") ? ("`cmnd` like N\'%" + thisinh.getcmnd() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getho() != null && ! thisinh.getho().contentEquals("") ? ("`ho` like N\'%" + thisinh.getho() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getten() != null && ! thisinh.getten().contentEquals("") ? ("`ten` like N\'%" + thisinh.getten() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getgioiTinh() != null && ! thisinh.getgioiTinh().contentEquals("") ? ("`gioiTinh` like N\'%" + thisinh.getgioiTinh() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getngaySinh() != null ? ("`ngaySinh` = `" + thisinh.getngaySinh().toString() + "` and ") : " 1 and ")
			+ (thisinh.getnoiSinh() != null && ! thisinh.getnoiSinh().contentEquals("") ? ("`noiSinh` like N\'%" + thisinh.getnoiSinh() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getngayCap() != null ? ("`ngayCap` = `" + thisinh.getngayCap().toString() + "` and ") : " 1 and ")
			+ (thisinh.getnoiCap() != null && ! thisinh.getnoiCap().contentEquals("") ? ("`noiCap` like N\'%" + thisinh.getnoiCap() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getsdt() != null && ! thisinh.getsdt().contentEquals("") ? ("`sdt` like N\'%" + thisinh.getsdt() + "%\'" + " and ") : "1 and ")
			+ (thisinh.getemail() != null && ! thisinh.getemail().contentEquals("") ? ("`email` like N\'%" + thisinh.getemail() + "%\'" + "") : "1")
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
					arr.add(new  DTO_ThiSinh(rs.getString("cmnd"), rs.getString("ho"), rs.getString("ten"), rs.getString("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("noiSinh"), rs.getDate("ngayCap"), rs.getString("noiCap"), rs.getString("sdt"), rs.getString("email")));
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

	public static int create(DTO_ThiSinh thisinh) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (thisinh.getcmnd() != null && ! thisinh.getcmnd().contentEquals("") ? "`cmnd`, " : "")
			+ (thisinh.getho() != null && ! thisinh.getho().contentEquals("") ? "`ho`, " : "")
			+ (thisinh.getten() != null && ! thisinh.getten().contentEquals("") ? "`ten`, " : "")
			+ (thisinh.getgioiTinh() != null && ! thisinh.getgioiTinh().contentEquals("") ? "`gioiTinh`, " : "")
			+ (thisinh.getngaySinh() != null ? "`ngaySinh`, " : "")
			+ (thisinh.getnoiSinh() != null && ! thisinh.getnoiSinh().contentEquals("") ? "`noiSinh`, " : "")
			+ (thisinh.getngayCap() != null ? "`ngayCap`, " : "")
			+ (thisinh.getnoiCap() != null && ! thisinh.getnoiCap().contentEquals("") ? "`noiCap`, " : "")
			+ (thisinh.getsdt() != null && ! thisinh.getsdt().contentEquals("") ? "`sdt`, " : "")
			+ (thisinh.getemail() != null && ! thisinh.getemail().contentEquals("") ? "`email`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (thisinh.getcmnd() != null && ! thisinh.getcmnd().contentEquals("") ? "N'" + thisinh.getcmnd() + "', " : "")
			+ (thisinh.getho() != null && ! thisinh.getho().contentEquals("") ? "N'" + thisinh.getho() + "', " : "")
			+ (thisinh.getten() != null && ! thisinh.getten().contentEquals("") ? "N'" + thisinh.getten() + "', " : "")
			+ (thisinh.getgioiTinh() != null && ! thisinh.getgioiTinh().contentEquals("") ? "N'" + thisinh.getgioiTinh() + "', " : "")
			+ (thisinh.getngaySinh() != null ? "'" + thisinh.getngaySinh().toString() + "', " : "")
			+ (thisinh.getnoiSinh() != null && ! thisinh.getnoiSinh().contentEquals("") ? "N'" + thisinh.getnoiSinh() + "', " : "")
			+ (thisinh.getngayCap() != null ? "'" + thisinh.getngayCap().toString() + "', " : "")
			+ (thisinh.getnoiCap() != null && ! thisinh.getnoiCap().contentEquals("") ? "N'" + thisinh.getnoiCap() + "', " : "")
			+ (thisinh.getsdt() != null && ! thisinh.getsdt().contentEquals("") ? "N'" + thisinh.getsdt() + "', " : "")
			+ (thisinh.getemail() != null && ! thisinh.getemail().contentEquals("") ? "N'" + thisinh.getemail() + "', " : "")
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

	public static int update(DTO_ThiSinh thisinhnew, DTO_ThiSinh thisinhold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (thisinhnew.getcmnd() != null && ! thisinhnew.getcmnd().contentEquals("") ? ("`cmnd` = N'" + thisinhnew.getcmnd() + "', ") : "")
			+ (thisinhnew.getho() != null && ! thisinhnew.getho().contentEquals("") ? ("`ho` = N'" + thisinhnew.getho() + "', ") : "")
			+ (thisinhnew.getten() != null && ! thisinhnew.getten().contentEquals("") ? ("`ten` = N'" + thisinhnew.getten() + "', ") : "")
			+ (thisinhnew.getgioiTinh() != null && ! thisinhnew.getgioiTinh().contentEquals("") ? ("`gioiTinh` = N'" + thisinhnew.getgioiTinh() + "', ") : "")
			+ (thisinhnew.getngaySinh() != null ? ("`ngaySinh` = '" + thisinhnew.getngaySinh().toString() + "', ") : "")
			+ (thisinhnew.getnoiSinh() != null && ! thisinhnew.getnoiSinh().contentEquals("") ? ("`noiSinh` = N'" + thisinhnew.getnoiSinh() + "', ") : "")
			+ (thisinhnew.getngayCap() != null ? ("`ngayCap` = '" + thisinhnew.getngayCap().toString() + "', ") : "")
			+ (thisinhnew.getnoiCap() != null && ! thisinhnew.getnoiCap().contentEquals("") ? ("`noiCap` = N'" + thisinhnew.getnoiCap() + "', ") : "")
			+ (thisinhnew.getsdt() != null && ! thisinhnew.getsdt().contentEquals("") ? ("`sdt` = N'" + thisinhnew.getsdt() + "', ") : "")
			+ (thisinhnew.getemail() != null && ! thisinhnew.getemail().contentEquals("") ? ("`email` = N'" + thisinhnew.getemail() + "', ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (thisinhold.getcmnd() != null && ! thisinhold.getcmnd().contentEquals("") ? ("`cmnd` = N'" + thisinhold.getcmnd() + "' and ") : "1 and ")
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

	public static int delete(DTO_ThiSinh thisinh) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (thisinh.getcmnd() != null && ! thisinh.getcmnd().contentEquals("") ? ("`cmnd` = N'" + thisinh.getcmnd() + "' and ") : "1 and ")
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