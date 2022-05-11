package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_ThiSinhDuThi;

public class DAO_ThiSinhDuThi {

	static final String TABLE_NAME = "thisinhduthi";

	public static ArrayList<DTO_ThiSinhDuThi> search(DTO_ThiSinhDuThi thisinhduthi){
		ArrayList<DTO_ThiSinhDuThi> arr = new ArrayList<>();
		String sql = "SELECT `maThiSinh`, TSDT.`cmnd`, TSDT.`maPhongThi`, `maBaiThi`, `sbd`, CONCAT(`ho`, ' ', `ten`) as hoTen, sdt, tenPhongThi from " + TABLE_NAME + " TSDT, thisinh TS, phongthi PT  where TS.cmnd = TSDT.cmnd and "
				+ "PT.maphongthi = TSDT.maphongthi having ";
		String where = ""
			+ (thisinhduthi.getmaThiSinh() != -1 ? ("`maThiSinh` = " + String.valueOf(thisinhduthi.getmaThiSinh()) + " and ") : " 1 and ")
			+ (thisinhduthi.getcmnd() != null && ! thisinhduthi.getcmnd().contentEquals("") ? ("`cmnd` like N\'%" + thisinhduthi.getcmnd() + "%\'" + " and ") : "1 and ")
			+ (thisinhduthi.getSdt() != null && ! thisinhduthi.getSdt().contentEquals("") ? ("`sdt` like N\'%" + thisinhduthi.getSdt() + "%\'" + " and ") : "1 and ")
			+ (thisinhduthi.getHoTen() != null && ! thisinhduthi.getHoTen().contentEquals("") ? ("`hoTen` like N\'%" + thisinhduthi.getHoTen() + "%\'" + " and ") : "1 and ")
			+ (thisinhduthi.getmaPhongThi() != -1 ? ("`maPhongThi` = " + String.valueOf(thisinhduthi.getmaPhongThi()) + " and ") : " 1 and ")
			+ (thisinhduthi.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(thisinhduthi.getmaBaiThi()) + " and ") : " 1 and ")
			+ (thisinhduthi.getsbd() != null && ! thisinhduthi.getsbd().contentEquals("") ? ("`sbd` like N\'%" + thisinhduthi.getsbd() + "%\'" + "") : "1")
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
					arr.add(new  DTO_ThiSinhDuThi(rs.getInt("maThiSinh"), rs.getString("cmnd"), rs.getInt("maPhongThi"), rs.getInt("maBaiThi"), rs.getString("sbd"), rs.getString("hoTen"), rs.getString("sdt"), rs.getString("tenPhongThi")));
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

	public static int create(DTO_ThiSinhDuThi thisinhduthi) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (thisinhduthi.getmaThiSinh() != -1 ? "`maThiSinh`, " : "")
			+ (thisinhduthi.getcmnd() != null && ! thisinhduthi.getcmnd().contentEquals("") ? "`cmnd`, " : "")
			+ (thisinhduthi.getmaPhongThi() != -1 ? "`maPhongThi`, " : "")
			+ (thisinhduthi.getmaBaiThi() != -1 ? "`maBaiThi`, " : "")
			+ (thisinhduthi.getsbd() != null && ! thisinhduthi.getsbd().contentEquals("") ? "`sbd`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (thisinhduthi.getmaThiSinh() != -1 ? String.valueOf(thisinhduthi.getmaThiSinh()) + ", " : "")
			+ (thisinhduthi.getcmnd() != null && ! thisinhduthi.getcmnd().contentEquals("") ? "N'" + thisinhduthi.getcmnd() + "', " : "")
			+ (thisinhduthi.getmaPhongThi() != -1 ? String.valueOf(thisinhduthi.getmaPhongThi()) + ", " : "")
			+ (thisinhduthi.getmaBaiThi() != -1 ? String.valueOf(thisinhduthi.getmaBaiThi()) + ", " : "")
			+ (thisinhduthi.getsbd() != null && ! thisinhduthi.getsbd().contentEquals("") ? "N'" + thisinhduthi.getsbd() + "', " : "")
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

	public static int update(DTO_ThiSinhDuThi thisinhduthinew, DTO_ThiSinhDuThi thisinhduthiold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (thisinhduthinew.getmaThiSinh() != -1 ? ("`maThiSinh` = " + String.valueOf(thisinhduthinew.getmaThiSinh()) + ", ") : "")
			+ (thisinhduthinew.getcmnd() != null && ! thisinhduthinew.getcmnd().contentEquals("") ? ("`cmnd` = N'" + thisinhduthinew.getcmnd() + "', ") : "")
			+ (thisinhduthinew.getmaPhongThi() != -1 ? ("`maPhongThi` = " + String.valueOf(thisinhduthinew.getmaPhongThi()) + ", ") : "")
			+ (thisinhduthinew.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(thisinhduthinew.getmaBaiThi()) + ", ") : "")
			+ (thisinhduthinew.getsbd() != null && ! thisinhduthinew.getsbd().contentEquals("") ? ("`sbd` = N'" + thisinhduthinew.getsbd() + "', ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (thisinhduthiold.getmaThiSinh() != -1 ? ("`maThiSinh` = " + String.valueOf(thisinhduthiold.getmaThiSinh()) + " and ") : "1 and ")
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

	public static int delete(DTO_ThiSinhDuThi thisinhduthi) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (thisinhduthi.getmaThiSinh() != -1 ? ("`maThiSinh` = " + String.valueOf(thisinhduthi.getmaThiSinh()) + " and ") : "1 and ")
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
	
	public static void create(String cmnd, int maTrinhDo, int maKhoaThi) {
		Connection conn = Connector.connect();
		
		if( conn != null) {
			try {
				CallableStatement callStmt = conn.prepareCall("call proc_insert_thisinhduthi(?, ?, ?);");
				callStmt.setString(1, cmnd);
				callStmt.setInt(2, maTrinhDo);
				callStmt.setInt(3, maKhoaThi);
				callStmt.executeQuery();;
			} catch (SQLException e) {
				System.out.println("Create: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Create: " + e.getMessage());
			}
		}
	}
	
	

}