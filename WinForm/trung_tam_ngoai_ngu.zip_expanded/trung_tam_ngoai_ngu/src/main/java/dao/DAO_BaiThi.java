package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_BaiThi;

public class DAO_BaiThi {

	static final String TABLE_NAME = "baithi";

	public static ArrayList<DTO_BaiThi> search(DTO_BaiThi baithi){
		ArrayList<DTO_BaiThi> arr = new ArrayList<>();
		String sql = ""
				+ "SELECT TSDT.maThiSinh, BT.maBaiThi, sbd, CONCAT(TS.ho, ' ', TS.ten) as hoTen, TS.cmnd, PT.tenPhongThi, KT.tenKhoaThi, BT.diemNghe, BT.diemNoi, BT.diemDoc, BT.diemViet,"
				+ " KT.ngayThi, PT.caThi\r\n"
				+ "FROM thisinhduthi TSDT, thisinh TS, phongthi PT, khoathi KT, baithi BT "
				+ "where KT.maKhoaThi = PT.maKhoaThi AND PT.maPhongThi = TSDT.maPhongThi AND TSDT.cmnd = TS.cmnd AND BT.maBaiThi = TSDT.maBaiThi AND ";
		String where = ""
			+ (baithi.getMaPhongThi() != -1 ? ("PT.`maPhongThi` = " + String.valueOf(baithi.getMaPhongThi()) + " and ") : " 1 and ")
			+ (baithi.getMaKhoaThi() != -1 ? ("PT.`maKhoaThi` = " + String.valueOf(baithi.getMaKhoaThi()) + " and ") : " 1 and ")
			+ (baithi.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(baithi.getmaBaiThi()) + " and ") : " 1 and ")
			+ (baithi.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(baithi.getmaCanhThi()) + " and ") : " 1 and ")
			+ (baithi.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(baithi.getmaChamThi()) + " and ") : " 1 and ")
			+ (baithi.getdiemNghe() != -1 ? ("`diemNghe` = " + String.valueOf(baithi.getdiemNghe()) + " and ") : " 1 and ")
			+ (baithi.getdiemNoi() != -1 ? ("`diemNoi` = " + String.valueOf(baithi.getdiemNoi()) + " and ") : " 1 and ")
			+ (baithi.getdiemDoc() != -1 ? ("`diemDoc` = " + String.valueOf(baithi.getdiemDoc()) + " and ") : " 1 and ")
			+ (baithi.getdiemViet() != -1 ? ("`diemViet` = " + String.valueOf(baithi.getdiemViet()) + "") : " 1")
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
					arr.add(new  DTO_BaiThi(rs.getInt("maBaiThi"), rs.getDouble("diemNghe"), rs.getDouble("diemNoi"), rs.getDouble("diemDoc"), rs.getDouble("diemViet"),
							rs.getString("maThiSinh"), rs.getString("sbd"), rs.getString("hoTen"), rs.getString("cmnd"), rs.getString("tenPhongThi"), rs.getString("tenKhoaThi")));
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
	
	public static ArrayList<DTO_BaiThi> searchAPI(DTO_BaiThi baithi){
		ArrayList<DTO_BaiThi> arr = new ArrayList<>();
		String sql = ""
				+ "SELECT TSDT.maThiSinh, BT.maBaiThi, sdt, sbd, CONCAT(TS.ho, ' ', TS.ten) as hoTen, TS.cmnd, PT.tenPhongThi, KT.tenKhoaThi, BT.diemNghe, BT.diemNoi, BT.diemDoc, BT.diemViet,"
				+ " KT.ngayThi, PT.caThi\r\n"
				+ "FROM thisinhduthi TSDT, thisinh TS, phongthi PT, khoathi KT, baithi BT "
				+ "where KT.maKhoaThi = PT.maKhoaThi AND PT.maPhongThi = TSDT.maPhongThi AND TSDT.cmnd = TS.cmnd AND BT.maBaiThi = TSDT.maBaiThi AND ";
		String where = ""
			+ (baithi.getMaPhongThi() != -1 ? ("PT.`maPhongThi` = " + String.valueOf(baithi.getMaPhongThi()) + " and ") : " 1 and ")
			+ (baithi.getMaKhoaThi() != -1 ? ("PT.`maKhoaThi` = " + String.valueOf(baithi.getMaKhoaThi()) + " and ") : " 1 and ")
			+ (baithi.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(baithi.getmaBaiThi()) + " and ") : " 1 and ")
			+ (baithi.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(baithi.getmaCanhThi()) + " and ") : " 1 and ")
			+ (baithi.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(baithi.getmaChamThi()) + " and ") : " 1 and ")
			+ (baithi.getdiemNghe() != -1 ? ("`diemNghe` = " + String.valueOf(baithi.getdiemNghe()) + " and ") : " 1 and ")
			+ (baithi.getdiemNoi() != -1 ? ("`diemNoi` = " + String.valueOf(baithi.getdiemNoi()) + " and ") : " 1 and ")
			+ (baithi.getdiemDoc() != -1 ? ("`diemDoc` = " + String.valueOf(baithi.getdiemDoc()) + " and ") : " 1 and ")
			+ (baithi.getdiemViet() != -1 ? ("`diemViet` = " + String.valueOf(baithi.getdiemViet()) + "") : " 1")
			+ " having "
			+ (baithi.getSdt() != null && ! baithi.getSdt().contentEquals("") ? ("`sdt` = N\'" + baithi.getSdt() + "\'" + " and ") : "1 and ")
			+ (baithi.getSbd() != null && ! baithi.getSbd().contentEquals("") ? ("`sbd` = N\'" + baithi.getSbd() + "\'" + " and ") : "1 and ")
			+ (baithi.getHoTen() != null && ! baithi.getHoTen().contentEquals("") ? ("`hoTen` = N\'" + baithi.getHoTen() + "\'" + " and ") : "1 and ")
			+ (baithi.getCmnd() != null && ! baithi.getCmnd().contentEquals("") ? ("`cmnd` = N\'" + baithi.getCmnd() + "\'" + "") : "1")
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
					arr.add(new  DTO_BaiThi(rs.getInt("maBaiThi"), rs.getDouble("diemNghe"), rs.getDouble("diemNoi"), rs.getDouble("diemDoc"), rs.getDouble("diemViet"),
							rs.getString("maThiSinh"), rs.getString("sbd"), rs.getString("hoTen"), rs.getString("cmnd"), rs.getString("tenPhongThi"), rs.getString("tenKhoaThi"), rs.getDate("ngayThi"), rs.getInt("caThi")));
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

	public static int create(DTO_BaiThi baithi) {
		int code = 0;
		String sql = ""
			+ "INSERT INTO `" + TABLE_NAME + "` (" 
			+ (baithi.getmaBaiThi() != -1 ? "`maBaiThi`, " : "")
			+ (baithi.getmaCanhThi() != -1 ? "`maCanhThi`, " : "")
			+ (baithi.getmaChamThi() != -1 ? "`maChamThi`, " : "")
			+ (baithi.getdiemNghe() != -1 ? "`diemNghe`, " : "")
			+ (baithi.getdiemNoi() != -1 ? "`diemNoi`, " : "")
			+ (baithi.getdiemDoc() != -1 ? "`diemDoc`, " : "")
			+ (baithi.getdiemViet() != -1 ? "`diemViet`, " : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ ") VALUES ("
			+ (baithi.getmaBaiThi() != -1 ? String.valueOf(baithi.getmaBaiThi()) + ", " : "")
			+ (baithi.getmaCanhThi() != -1 ? String.valueOf(baithi.getmaCanhThi()) + ", " : "")
			+ (baithi.getmaChamThi() != -1 ? String.valueOf(baithi.getmaChamThi()) + ", " : "")
			+ (baithi.getdiemNghe() != -1 ? String.valueOf(baithi.getdiemNghe()) + ", " : "")
			+ (baithi.getdiemNoi() != -1 ? String.valueOf(baithi.getdiemNoi()) + ", " : "")
			+ (baithi.getdiemDoc() != -1 ? String.valueOf(baithi.getdiemDoc()) + ", " : "")
			+ (baithi.getdiemViet() != -1 ? String.valueOf(baithi.getdiemViet()) + ", " : "")
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

	public static int update(DTO_BaiThi baithinew, DTO_BaiThi baithiold) {
		int code = 0;
		String sql = ""
			+ "UPDATE `" + TABLE_NAME + "` SET "
			+ (baithinew.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(baithinew.getmaBaiThi()) + ", ") : "")
			+ (baithinew.getmaCanhThi() != -1 ? ("`maCanhThi` = " + String.valueOf(baithinew.getmaCanhThi()) + ", ") : "")
			+ (baithinew.getmaChamThi() != -1 ? ("`maChamThi` = " + String.valueOf(baithinew.getmaChamThi()) + ", ") : "")
			+ (baithinew.getdiemNghe() != -1 ? ("`diemNghe` = " + String.valueOf(baithinew.getdiemNghe()) + ", ") : "")
			+ (baithinew.getdiemNoi() != -1 ? ("`diemNoi` = " + String.valueOf(baithinew.getdiemNoi()) + ", ") : "")
			+ (baithinew.getdiemDoc() != -1 ? ("`diemDoc` = " + String.valueOf(baithinew.getdiemDoc()) + ", ") : "")
			+ (baithinew.getdiemViet() != -1 ? ("`diemViet` = " + String.valueOf(baithinew.getdiemViet()) + ", ") : "")
			+ "";
		sql = sql.substring(0, sql.length() - 2);
		sql += ""
			+ " WHERE ";
		sql += ""
			+ (baithiold.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(baithiold.getmaBaiThi()) + "") : "1")
			+ "";
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

	public static int delete(DTO_BaiThi baithi) {
		int code = 0;
		String sql = ""
			+ "DELETE FROM `" + TABLE_NAME + "` WHERE ";
		sql += ""
			+ (baithi.getmaBaiThi() != -1 ? ("`maBaiThi` = " + String.valueOf(baithi.getmaBaiThi()) + " and ") : "1 and ")
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