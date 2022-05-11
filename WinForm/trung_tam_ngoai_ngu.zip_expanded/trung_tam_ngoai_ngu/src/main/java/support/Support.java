package support;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Support {
	public static void createAPI(String table) {
		String result = "package api;\r\n"
				+ "\r\n"
				+ "import java.util.ArrayList;\r\n"
				+ "\r\n"
				+ "import org.springframework.web.bind.annotation.PostMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.RequestBody;\r\n"
				+ "import org.springframework.web.bind.annotation.ResponseBody;\r\n"
				+ "import org.springframework.web.bind.annotation.RestController;\r\n"
				+ "\r\n"
				+ "import dao.DAO_" + table + ";\r\n"
				+ "import dto.DTO_" + table + ";\r\n"
				+ "\r\n"
				+ "@RestController\r\n"
				+ "public class API_" + table + " {\r\n"
				+ "\r\n"
				+ "	@PostMapping(value = \"/" + table.toLowerCase() + "_search\")\r\n"
				+ "	@ResponseBody\r\n"
				+ "	public DTO_" + table + "[] search(@RequestBody DTO_" + table + " " + table.toLowerCase() + ") {\r\n"
				+ "		ArrayList<DTO_" + table + "> arr = DAO_" + table + ".search(" + table.toLowerCase() + ");\r\n"
				+ "		return arr.toArray(new DTO_" + table + "[arr.size()]);\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	@PostMapping(value = \"/" + table.toLowerCase() + "_create\")\r\n"
				+ "	@ResponseBody\r\n"
				+ "	public int create(@RequestBody DTO_" + table + " " + table.toLowerCase() + ") {\r\n"
				+ "		return DAO_" + table + ".create(" + table.toLowerCase() + ");\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	@PostMapping(value = \"/" + table.toLowerCase() + "_update\")\r\n"
				+ "	@ResponseBody\r\n"
				+ "	public int update(@RequestBody DTO_" + table + "[] " + table.toLowerCase() + ") {\r\n"
				+ "		return DAO_" + table + ".update(" + table.toLowerCase() + "[0], " + table.toLowerCase() + "[1]);\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	@PostMapping(value = \"/" + table.toLowerCase() + "_delete\")\r\n"
				+ "	@ResponseBody\r\n"
				+ "	public int delete(@RequestBody DTO_" + table + " " + table.toLowerCase() + ") {\r\n"
				+ "		return DAO_" + table + ".delete(" + table.toLowerCase() + ");\r\n"
				+ "	}\r\n"
				+ "}";
		
		String dir = System.getProperty("user.dir");
		dir += "\\src\\main\\java\\api\\API_";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dir + table + ".java"));
			writer.write(result);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void createModel(String name, String[] col, String[] key, String[] value) {
		String model = "const " + name + " = {\r\n";
		for(int i = 0; i < key.length; i++) {
			model += key[i] + ": " + (value[i].contentEquals("1") ? "-1,\r\n" : "null,\r\n");
		}
		model += "}\r\n";
		String field = "const Field" + " = {\r\n";
		for(int i = 0; i < key.length; i++) {
			field += "    " + key[i] + ": " + "{name: \"" + col[i] + "\", key: \"" + key[i] + "\"},\r\n";
		}
		String result = ""
				+ model
				+ "\r\n"
				+ field
				+ "}\r\n"
				+ "\r\n"
				+ "export const Model_" + name + " = {\r\n"
				+ "    Field,\r\n"
				+ "    " + name + "\r\n"
				+ "}";
		String dir = "E:\\Hoc Tap\\MoHinhPhanLop\\WebForm\\QLTour\\ql-tour_du_lich\\src\\Model\\";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dir + name + ".js"));
			writer.write(result);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void createDAO(String table, String[] col, String[] value, String[] key) {
		
		
		String search = "";
		for(int i = 0; i < col.length; i++) {
			switch (value[i]) {
			case "Int": {
				search += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + ".get" + col[i] + "()) + \"" + (i + 1 != col.length ? " and " : "") + "\") : \" 1" + (i + 1 != col.length ? " and " : "") + "\")\n";
				break;
			}
			case "String": {
				search += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null && ! " + table.toLowerCase() + ".get" + col[i] + "().contentEquals(\"\") ? (\"`" + col[i] + "` like N\\'%\" + " + table.toLowerCase() + ".get" + col[i] + "() + \"%\\'\" + \"" + (i + 1 != col.length ? " and " : "") + "\") : \"1" + (i + 1 != col.length ? " and " : "") + "\")\n";
				break;
			}
			case "Double": {
				search += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + ".get" + col[i] + "()) + \"" + (i + 1 != col.length ? " and " : "") + "\") : \" 1" + (i + 1 != col.length ? " and " : "") + "\")\n"; 
				break;
			}
			case "Date": {
				search += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null ? (\"`" + col[i] + "` = `\" + " + table.toLowerCase() + ".get" + col[i] + "().toString() + \"`" + (i + 1 != col.length ? " and " : "") + "\") : \" 1" + (i + 1 != col.length ? " and " : "") + "\")\n";
				break;
			}
			default:
				break;
			}
		}
		String searchAdd = "";
		for(int i = 0; i < col.length; i++) {
			searchAdd += "rs.get" + value[i] + "(\"" + col[i] + "\")" + (i + 1 != col.length ? ", " : "");
		}
		
		String create1 = "";
		for(int i = 0; i < col.length; i++) {
			switch (value[i]) {
			case "Int": {
				create1 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? \"`" + col[i] + "`, \" : \"\")\n";
				break;
			}
			case "String": {
				create1 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null && ! " + table.toLowerCase() + ".get" + col[i] + "().contentEquals(\"\") ? \"`" + col[i] + "`, \" : \"\")\n";
				break;
			}
			case "Double": {
				create1 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? \"`" + col[i] + "`, \" : \"\")\n";
				break;
			}
			case "Date": {
				create1 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null ? \"`" + col[i] + "`, \" : \"\")\n";
				break;
			}
			default:
				break;
			}
		}
		
		String create2 = "";
		for(int i = 0; i < col.length; i++) {
			switch (value[i]) {
			case "Int": {
				create2 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? String.valueOf(" + table.toLowerCase() + ".get" + col[i] + "()) + \", \" : \"\")\n";
				break;
			}
			case "String": {
				create2 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null && ! " + table.toLowerCase() + ".get" + col[i] + "().contentEquals(\"\") ? \"N'\" + " + table.toLowerCase() + ".get" + col[i] + "() + \"', \" : \"\")\n";
				break;
			}
			case "Double": {
				create2 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? String.valueOf(" + table.toLowerCase() + ".get" + col[i] + "()) + \", \" : \"\")\n"; 
				break;
			}
			case "Date": {
				create2 += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null ? \"'\" + " + table.toLowerCase() + ".get" + col[i] + "().toString() + \"', \" : \"\")\n";
				break;
			}
			default:
				break;
			}
		}
		
		String update1 = "";
		for(int i = 0; i < col.length; i++) {
			switch (value[i]) {
			case "Int": {
				update1 += "			+ (" + table.toLowerCase() + "new.get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + "new.get" + col[i] + "()) + \", \") : \"\")\n";
				break;
			}
			case "String": {
				update1 += "			+ (" + table.toLowerCase() + "new.get" + col[i] + "() != null && ! " + table.toLowerCase() + "new.get" + col[i] + "().contentEquals(\"\") ? (\"`" + col[i] + "` = N'\" + " + table.toLowerCase() + "new.get" + col[i] + "() + \"', \") : \"\")\n";
				break;
			}
			case "Double": {
				update1 += "			+ (" + table.toLowerCase() + "new.get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + "new.get" + col[i] + "()) + \", \") : \"\")\n";
				break;
			}
			case "Date": {
				update1 += "			+ (" + table.toLowerCase() + "new.get" + col[i] + "() != null ? (\"`" + col[i] + "` = '\" + " + table.toLowerCase() + "new.get" + col[i] + "().toString() + \"', \") : \"\")\n";
				break;
			}
			default:
				break;
			}
		}
		
		String update2 = "";
		for(int i = 0; i < key.length; i++) {
			switch (value[i]) {
			case "Int": {
				update2 += "			+ (" + table.toLowerCase() + "old.get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + "old.get" + col[i] + "()) + \" and \") : \"1 and \")\n";
				break;
			}
			case "String": {
				update2 += "			+ (" + table.toLowerCase() + "old.get" + col[i] + "() != null && ! " + table.toLowerCase() + "old.get" + col[i] + "().contentEquals(\"\") ? (\"`" + col[i] + "` = N'\" + " + table.toLowerCase() + "old.get" + col[i] + "() + \"' and \") : \"1 and \")\n";
				break;
			}
			case "Double": {
				update2 += "			+ (" + table.toLowerCase() + "old.get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + "old.get" + col[i] + "() + \" and \") : \"1 and \")\n";
				break;
			}
			case "Date": {
				update2 += "			+ (" + table.toLowerCase() + "old.get" + col[i] + "() != null ? (\"`" + col[i] + "` = '\" + " + table.toLowerCase() + "old.get" + col[i] + "().toString() + \"' and \") : \"1 and \")\n";
				break;
			}
			default:
				break;
			}
		}
		
		String delete = "";
		for(int i = 0; i < key.length; i++) {
			switch (value[i]) {
			case "Int": {
				delete += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + ".get" + col[i] + "()) + \" and \") : \"1 and \")\n";
				break;
			}
			case "String": {
				delete += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null && ! " + table.toLowerCase() + ".get" + col[i] + "().contentEquals(\"\") ? (\"`" + col[i] + "` = N'\" + " + table.toLowerCase() + ".get" + col[i] + "() + \"' and \") : \"1 and \")\n";
				break;
			}
			case "Double": {
				delete += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != -1 ? (\"`" + col[i] + "` = \" + String.valueOf(" + table.toLowerCase() + ".get" + col[i] + "() + \" and \") : \"1 and \")\n";
				break;
			}
			case "Date": {
				delete += "			+ (" + table.toLowerCase() + ".get" + col[i] + "() != null ? (\"`" + col[i] + "` = '\" + " + table.toLowerCase() + ".get" + col[i] + "().toString() + \"' and \") : \"1 and \")\n";
				break;
			}
			default:
				break;
			}
		}
		
		
		
		
		String result = "package dao;\r\n"
				+ "\r\n"
				+ "import java.sql.Connection;\r\n"
				+ "import java.sql.ResultSet;\r\n"
				+ "import java.sql.SQLException;\r\n"
				+ "import java.sql.Statement;\r\n"
				+ "import java.util.ArrayList;\r\n"
				+ "\r\n"
				+ "import dto.DTO_" + table + ";\r\n"
				+ "\r\n"
				+ "public class DAO_" + table + " {\r\n"
				+ "\r\n"
				+ "	static final String TABLE_NAME = \"" + table.toLowerCase() + "\";\r\n"
				+ "\r\n"
				+ "	public static ArrayList<DTO_" + table + "> search(DTO_" + table + " " + table.toLowerCase() + "){\r\n"
				+ "		ArrayList<DTO_" + table + "> arr = new ArrayList<>();\r\n"
				+ "		String sql = \"select * from \" + TABLE_NAME + \" where \";\r\n"
				+ "		String where = \"\"\r\n"
				+ search
				+ "			+ \"\";\n"
				+ "		if(where.contentEquals(\"\"))\r\n"
				+ "			sql = sql.substring(0, sql.length() - 7);\r\n"
				+ "		else\r\n"
				+ "			sql += where;\r\n"
				+ "		Connection conn = Connector.connect();\r\n"
				+ "		if( conn != null) {\r\n"
				+ "			try {\r\n"
				+ "				Statement stat = conn.createStatement();\r\n"
				+ "				ResultSet rs = stat.executeQuery(sql);\r\n"
				+ "				while(rs.next()) {\r\n"
				+ "					arr.add(new  DTO_" + table + "(" + searchAdd + "));\r\n"
				+ "				}\r\n"
				+ "				rs.close();\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Search: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "			try {\r\n"
				+ "				conn.close();\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "					System.out.println(\"Search: \" + e.getMessage());\r\n"
				+ "			}		}\r\n"
				+ "		return arr;\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	public static int create(DTO_" + table + " " + table.toLowerCase() + ") {\r\n"
				+ "		int code = 0;\r\n"
				+ "		String sql = \"\"\r\n"
				+ "			+ \"INSERT INTO `\" + TABLE_NAME + \"` (\" \r\n"
				+ create1
				+ "			+ \"\";\n"
				+ "		sql = sql.substring(0, sql.length() - 2);\r\n"
				+ "		sql += \"\"\r\n"
				+ "			+ \") VALUES (\"\r\n"
				+ create2
				+ "			+ \"\";\n"
				+ "		sql = sql.substring(0, sql.length() - 2);\r\n"
				+ "		sql += \"\"\r\n"
				+ "			+ \")\";\r\n"
				+ "		Connection conn = Connector.connect();\r\n"
				+ "		if( conn != null) {\r\n"
				+ "			try {\r\n"
				+ "				Statement stat = conn.createStatement();\r\n"
				+ "				code = stat.executeUpdate(sql);\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Create: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "			try {\r\n"
				+ "				conn.close();\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Create: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "		}\r\n"
				+ "		return code;\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	public static int update(DTO_" + table + " " + table.toLowerCase() + "new, DTO_" + table + " " + table.toLowerCase() + "old) {\r\n"
				+ "		int code = 0;\r\n"
				+ "		String sql = \"\"\r\n"
				+ "			+ \"UPDATE `\" + TABLE_NAME + \"` SET \"\r\n"
				+ update1
				+ "			+ \"\";\n"
				+ "		sql = sql.substring(0, sql.length() - 2);\r\n"
				+ "		sql += \"\"\r\n"
				+ "			+ \" WHERE \";\r\n"
				+ "		sql += \"\"\r\n"
				+ update2
				+ "			+ \"\";\n"
				+ "		sql = sql.substring(0, sql.length() - 5);\r\n"
				+ "		sql += \"\"\r\n"
				+ "			+\"\";\r\n"
				+ "		Connection conn = Connector.connect();\r\n"
				+ "		if( conn != null) {\r\n"
				+ "			try {\r\n"
				+ "				Statement stat = conn.createStatement();\r\n"
				+ "				code = stat.executeUpdate(sql);\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Update: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "			try {\r\n"
				+ "				conn.close();\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Update: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "		}\r\n"
				+ "		return code;\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	public static int delete(DTO_" + table + " " + table.toLowerCase() + ") {\r\n"
				+ "		int code = 0;\r\n"
				+ "		String sql = \"\"\r\n"
				+ "			+ \"DELETE FROM `\" + TABLE_NAME + \"` WHERE \";\r\n"
				+ "		sql += \"\"\r\n"
				+ delete
				+ "			+ \"\";\n"
				+ "		sql = sql.substring(0, sql.length() - 5);\r\n"
				+ "		sql += \"\"\r\n"
				+ "			+\"\";\r\n"
				+ "		Connection conn = Connector.connect();\r\n"
				+ "		if( conn != null) {\r\n"
				+ "			try {\r\n"
				+ "				Statement stat = conn.createStatement();\r\n"
				+ "				code = stat.executeUpdate(sql);\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Delete: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "			try {\r\n"
				+ "				conn.close();\r\n"
				+ "			} catch (SQLException e) {\r\n"
				+ "				System.out.println(\"Delete: \" + e.getMessage());\r\n"
				+ "			}\r\n"
				+ "		}\r\n"
				+ "		return code;\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "}";
		
		String dir = System.getProperty("user.dir");
		dir += "\\src\\main\\java\\dao\\DAO_";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dir + table + ".java"));
			writer.write(result);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void createBUS(String name) {
		String result = "package bus;\r\n"
				+ "\r\n"
				+ "import java.util.ArrayList;\r\n"
				+ "\r\n"
				+ "import dao.DAO_" + name + ";\r\n"
				+ "import dto.DTO_" + name + ";\r\n"
				+ "\r\n"
				+ "public class BUS_" + name + " {\r\n"
				+ "	\r\n"
				+ "	public DTO_" + name + "[] getData() {\r\n"
				+ "		ArrayList<DTO_" + name + "> arr = DAO_" + name + ".search(new DTO_" + name + "());\r\n"
				+ "		return arr.toArray(new DTO_" + name + "[arr.size()]);\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	public DTO_" + name + "[] getData(DTO_" + name + " dto_" + name + ") {\r\n"
				+ "		ArrayList<DTO_" + name + "> arr = DAO_" + name + ".search(dto_" + name + ");\r\n"
				+ "		return arr.toArray(new DTO_" + name + "[arr.size()]);\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	public int create(DTO_" + name + " dto_" + name + ") {\r\n"
				+ "		return DAO_" + name + ".create(dto_" + name + ");\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	public int update(DTO_" + name + " dto_" + name + ", DTO_" + name + " dto_" + name + "2) {\r\n"
				+ "		return DAO_" + name + ".update(dto_" + name + ", dto_" + name + "2);\r\n"
				+ "	}\r\n"
				+ "	public int delete(DTO_" + name + " dto_" + name + ") {\r\n"
				+ "		return DAO_" + name + ".delete(dto_" + name + ");\r\n"
				+ "	}\r\n"
				+ "}";
		String dir = System.getProperty("user.dir");
		dir += "\\src\\main\\java\\bus\\BUS_";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dir + name + ".java"));
			writer.write(result);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("table");
			String name = sc.nextLine();
			if(name.contentEquals("exit"))
				break;
			createAPI(name);
			
		}
		sc.close();
	}
}
