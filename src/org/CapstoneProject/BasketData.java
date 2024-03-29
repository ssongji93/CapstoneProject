package org.CapstoneProject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary, quary2;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> Basketdata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> BasketdataSet;

	public static List<Map<String, Serializable>> BasketListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	static void createBasket(String user_num, String pro_num, String bk_option, String bk_price, String bk_allPrice,
			double bk_point) {

		quary = "insert into bsk values ('" + user_num + "', '" + pro_num + "', '" + bk_option + "', '" + bk_price
				+ "', '" + bk_allPrice + "', '" + bk_point + "')";

		quary2 = "commit";

		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		try {
			pstm = conn.prepareStatement(quary2);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("commit문에서 예외 발생");
			sqle.printStackTrace();
		}

	}

	static List<Map<String, Serializable>> deleteBasket(String pro_nm) {

		quary = "delete bsk "
				+ "where bsk.PRO_NUM = (select pro.pro_num from pro where bsk.pro_num = pro.pro_num and PRO_NM = '"
				+ pro_nm + "') ";
		
		quary2 = "commit";

		BasketListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		try {
			pstm = conn.prepareStatement(quary2);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("commit문에서 예외 발생");
			sqle.printStackTrace();
		}

		return BasketListData;

	}

	static List<Map<String, Serializable>> deleteBasket2(String cust_num) {

		quary = "delete from bsk where cust_num = '" + cust_num + "'";
		
		quary2 = "commit";

		BasketListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		try {
			pstm = conn.prepareStatement(quary2);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("commit문에서 예외 발생");
			sqle.printStackTrace();
		}

		return BasketListData;

	}

	static List<Map<String, Serializable>> selectBasket(String cust_num) {

		quary = "select MODEL_IMG1, PRO_NM, QUANT, UP, PR, POINT, pro.pro_num from model join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join bsk on PRO.PRO_NUM = bsk.PRO_NUM where cust_num = '" + cust_num + "'";
		
		quary2 = "commit";
		
		BasketListData.clear();

		try {
//			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			conn.commit();

			while (rs.next()) {

				BasketdataSet = new HashMap<String, Serializable>();

				BasketdataSet.put("MODEL_IMG1", rs.getString(1));
//				BasketdataSet.put("MODEL_NICK", rs.getString(2));
				BasketdataSet.put("PRO_NM", rs.getString(2));
				BasketdataSet.put("QUANT", rs.getString(3));
				BasketdataSet.put("UP", rs.getString(4));
				BasketdataSet.put("PR", rs.getString(5));
				BasketdataSet.put("POINT", rs.getString(6));
				BasketdataSet.put("pro.pro_num", rs.getString(7));

				BasketListData.add(BasketdataSet);
//				System.out.println(BasketListData);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		try {
			pstm = conn.prepareStatement(quary2);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("commit문에서 예외 발생");
			sqle.printStackTrace();
		}

		return BasketListData;

	}

}