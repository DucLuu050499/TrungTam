package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTO_ThongKe;

public class DAO_ThongKe {
	public static DTO_ThongKe[] getThongKe() {
		ArrayList<DTO_ThongKe> arr = new ArrayList<>();
		String sql = "SELECT tenTrinhDo, COUNT(KT.maKhoaThi) khoaThi, COUNT(PT.maPhongThi) phongThi, COUNT(maThiSinh) thiSinh \r\n"
				+ "FROM `trinhdo` TD, `thisinhduthi` TSDT, `phongthi` PT, `khoathi` KT\r\n"
				+ "WHERE TD.maTrinhDo = PT.maTrinhDo AND KT.maKhoaThi = PT.maKhoaThi AND TSDT.maPhongThi = PT.maPhongThi\r\n"
				+ "GROUP BY tenTrinhDo;";
		Connection conn = Connector.connect();
		if( conn != null) {
			try {
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()) {
					arr.add(new  DTO_ThongKe(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
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
		return arr.toArray(new DTO_ThongKe[arr.size()]);
	}
}
