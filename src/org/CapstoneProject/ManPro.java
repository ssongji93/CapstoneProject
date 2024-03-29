package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.CapstoneProject.Basket.TableCell2;

public class ManPro extends JPanel {
	private JLabel vAdminPro2;
	private JTextField xSearch;

//	private JPasswordField xMemPw1, xMemPw2;
//	private String[] ctgr1 = {"상의", "하의", "셔츠", "아우터", "신발"};
//	private String[] ctgr2_1 = {"맨투맨", "반팔", "긴팔", "니트", "후드"};
//	private String[] ctgr2_2 = {"청바지", "슬랙스", "면바지", "운동복", "반바지"};
//	private String[] ctgr2_3 = {"반팔셔츠", "체크", "긴팔셔츠", "스트라이프"};
//	private String[] ctgr2_4 = {"코트", "가디건", "조끼", "집업", "패딩", "점퍼", "야상", "재킷"};
//	private String[] ctgr2_5 = {"스티커즈", "운동화", "슬리퍼", "로퍼", "구두", "워커", "부츠", "샌들"};

	private String[] col1 = { "모델명", "상품명", "색상", "사이즈", "단가" };
	private String[] search = { "모델명", "색상", "사이즈" };

//  private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tModelInfo;
	private JScrollPane scrollpane1, scrollpane2;

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JButton BtSearch, BtReg;
	private JComboBox<String> CbSearch, Cbctgr1, CbCbctgr2_1, CbCbctgr2_2, CbCbctgr2_3, CbCbctgr2_4, CbCbctgr2_5;

	int row;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;

	public ManPro() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();

		getData(ProData.selectProMod());

		vAdminPro2 = new JLabel("상품조회");
		vAdminPro2.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		CbSearch = new JComboBox<String>(search);
		CbSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CbSearch.setPreferredSize(new Dimension(150, 40));
		CbSearch.setBackground(Color.WHITE);

		xSearch = new JTextField(15);
		xSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		xSearch.setPreferredSize(new Dimension(150, 40));

		tModelInfo = new JTable(model1);
		scrollpane1 = new JScrollPane(tModelInfo);
		scrollpane1.setPreferredSize(new Dimension(1000, 300));
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = tModelInfo.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		tModelInfo.setRowHeight(25);

		JTableHeader th = tModelInfo.getTableHeader();
		th.setPreferredSize(new Dimension(1000, 30));
		th.setFont(new Font("맑은 고딕", Font.PLAIN, 17));

		BtSearch = new JButton("검색");
		BtSearch.setFocusPainted(false);
		BtSearch.setBackground(Color.white);
		BtSearch.setPreferredSize(new Dimension(80, 40));
		BtSearch.setFont(new Font("휴먼매직체", Font.BOLD, 22));

//		BtCancel = new JButton("닫기");
		ManProView();
	}

	private void ManProView() {

		setLayout(gbl);


		gridbagAdd(CbSearch, 1, 2, 1, 1);
		gridbagAdd(xSearch, 2, 2, 1, 1);

		gbc.anchor = GridBagConstraints.CENTER;

		gbc.anchor = GridBagConstraints.WEST;
		gridbagAdd(vAdminPro2, 1, 1, 1, 1);
		gridbagAdd(BtSearch, 3, 2, 1, 1);
		gridbagAdd(scrollpane1, 1, 3, 5, 5);

		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gbc.gridx = x;
		gbc.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}
	
	private void getData(List<Map<String, Serializable>> ProListData) {

		for (int i = 0; i < ProListData.size(); i++) {
			model1.addRow(new Object[] {
					
					ProListData.get(i).get("MODEL_NM"),
					ProListData.get(i).get("PRO_NM"),
					ProListData.get(i).get("CLR"),
					ProListData.get(i).get("SIZ"),
					ProListData.get(i).get("up") });
		}
	}

	public static void main(String[] args) {
		new ManPro();
	}
}
