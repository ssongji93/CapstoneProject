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

public class ImageData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> Imagedata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> ImagedataSet;

	public static List<Map<String, Serializable>> ImageListData = new ArrayList<Map<String, Serializable>>();

	/* ������ȣ�� �ִ� ��ũ ����Ʈ ���� */
	public static void initImageData(String pro_NUM, String pro_CTGR_NUM, String pro_NM, String pro_EXP) {

	}

	/* ���������� �����ϴ� ���Ǿ� */
	static void createImage(String Pro_num, String PRO_NM, String CLR, String SIZ, String SIZ_DET_INFO) {

		quary = "insert into pro values (SEQ_PRO_NUM.NEXTVAL, '" + Pro_num + "', '" + PRO_NM + "', '" + CLR + "', '"
				+ SIZ + "', '" + SIZ_DET_INFO + ")";

		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}

	static List<Map<String, Serializable>> selectImage(String fileName2) {

		quary = "select MODEL_IMG1, MODEL_IMG2 from model where MODEL_IMG1 = '" + fileName2 + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_IMG1", rs.getString(1));
				ImagedataSet.put("MODEL_IMG2", rs.getString(2));

				ImageListData.add(ImagedataSet);
//				System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return ImageListData;

	}
	
	static List<Map<String, Serializable>> selectNickname(String fileName2) {

		quary = "select MODEL_NICK from model where MODEL_IMG1 = '" + fileName2 + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_NICK", rs.getString(1)); 

				ImageListData.add(ImagedataSet);
//				System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return ImageListData;

	}
	
	static List<Map<String, Serializable>> selectCtgr(String fileName2) {

		quary = "select FIRST_CTGR, MODEL_NUM, MODEL_NM, model_img1 from model_ctgr "
				+ "join model on model.MODEL_CTGR_NUM = model_ctgr.MODEL_CTGR_NUM where MODEL_IMG1 = '" + fileName2 + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("FIRST_CTGR", rs.getString(1)); 

				ImageListData.add(ImagedataSet);
//				System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return ImageListData;

	}
	
	static List<Map<String, Serializable>> selectSize(String fileName2) {

		quary = "select distinct SIZ from model "
				+ "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + fileName2 + "' order by SIZ asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();


				ImagedataSet.put("SIZ", rs.getString(1)); 



				ImageListData.add(ImagedataSet);
//				System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return ImageListData;

	}
	
	static List<Map<String, Serializable>> selectColor(String fileName2) {

		quary = "select CLR from model "
				+ "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + fileName2 + "' order by clr asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("CLR", rs.getString(1)); 


				ImageListData.add(ImagedataSet);
//				System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return ImageListData;

	}
	
	static List<Map<String, Serializable>> selectPrice(String fileName2) {

		quary = "select UP from model "
				+ "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + fileName2 + "' order by UP asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("UP", rs.getString(1)); 


				ImageListData.add(ImagedataSet);
//				System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return ImageListData;

	}
}