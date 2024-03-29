
package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class Basket extends JPanel implements MouseListener, ActionListener {

	private JLabel vProPrice, vDiscount, vPrice, vPoint, vSpace;
	private static JTextField xProPrice, xDiscount, xPrice, xPoint;

	private static String[] col1 = { "이미지", "상품정보", "수량", "단가", "금액", "포인트", "삭제" };
//   private String[] col2 = {"부서명", "성명"};      
	private String[] div = { "관리자", "유저" }; // 사원구분 콤보박스의 목록

	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
//   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tProInfo;
	private JScrollPane scrollpane1;

	private JButton BtOrder, BtShopping, BtDelBasket, del;
//   private JComboBox<String> cbSel;      

	int check, row;
	static double sum_price, sum_point;
	static String pro_price, pro_price2, mb_disc_rt;
	static String ar[];
//   static ArrayList<String> ar;
	static ArrayList<String> ar2 = new ArrayList<String>();
	static Double sum[];

	static String cust_num, user_id;
	static double disc_rt, price;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	static void getData(List<Map<String, Serializable>> BasketListData) {
		model1.setRowCount(0);
		ar = new String[BasketListData.size()];
		sum_price = 0;
		sum_point = 0;
		for (int i = 0; i < BasketListData.size(); i++) {
			sum_price += Double.valueOf(BasketListData.get(i).get("PR").toString());
			sum_point += Double.valueOf(BasketListData.get(i).get("POINT").toString());
			
			model1.addRow(new Object[] { 
					BasketListData.get(i).get("MODEL_IMG1"),
					BasketListData.get(i).get("PRO_NM"),
					BasketListData.get(i).get("QUANT"), 
					BasketListData.get(i).get("UP"),
					BasketListData.get(i).get("PR"),
					BasketListData.get(i).get("POINT"), });
		}
		
		xProPrice.setText(String.valueOf(sum_price));
		xDiscount.setText(mb_disc_rt + "%");
		disc_rt = Double.valueOf(Login.user_disc_rt) * 0.01;
		price = sum_price - (sum_price * disc_rt);
		xPrice.setText(String.valueOf(price));
		xPoint.setText(String.valueOf(sum_point));
	}

	public Basket() {
		
		mb_disc_rt = Login.user_disc_rt;
		cust_num = Login.user_num;
//      System.out.println(mb_disc_rt);

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		vProPrice = new JLabel("총 상품가격");
		vProPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		vDiscount = new JLabel("등급 할인");
		vDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		vPrice = new JLabel("최종 금액");
		vPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		vPoint = new JLabel("적립 포인트");
		vPoint.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		vSpace = new JLabel("");
		vSpace.setPreferredSize(new Dimension(15, 5));
		

		xProPrice = new JTextField(10);
		xDiscount = new JTextField(10);
		xDiscount.setEnabled(false);
		xDiscount.setText(mb_disc_rt + "%");
		xPrice = new JTextField(10);
		xPoint = new JTextField(10);

		tProInfo = new JTable(model1);
		scrollpane1 = new JScrollPane(tProInfo);
		scrollpane1.setPreferredSize(new Dimension(750, 250));

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = tProInfo.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		tProInfo.getColumnModel().getColumn(6).setCellRenderer(new TableCell2());
		tProInfo.getColumnModel().getColumn(6).setCellEditor(new TableCell2());

		tProInfo.setRowHeight(25);

		JTableHeader th = tProInfo.getTableHeader();
		th.setPreferredSize(new Dimension(750, 30));
		th.setFont(new Font("맑은 고딕", Font.PLAIN, 17));

		BtOrder = new JButton("주문하기");
		BtOrder.setBackground(Color.white);
		BtOrder.addActionListener(this);
		BtOrder.setPreferredSize(new Dimension(130, 28));
//      BtShopping = new JButton("쇼핑 계속하기");
//      BtShopping.setPreferredSize(new Dimension(130, 28));
//      BtShopping.addActionListener(this);
		BtDelBasket = new JButton("장바구니 비우기");
		BtDelBasket.setBackground(Color.white);
		BtDelBasket.addActionListener(this);
		BtDelBasket.setPreferredSize(new Dimension(130, 28));
//        regist.addActionListener(this);

		getData(BasketData.selectBasket(cust_num));
		BasketView();
	}

	private void BasketView() {

//      setTitle("장바구니");

//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(scrollpane1, 0, 0, 12, 1);
		gridbagAdd(xProPrice, 1, 12, 1, 1);
		gridbagAdd(xDiscount, 1, 13, 1, 1);
		gridbagAdd(vSpace, 2, 13, 1, 1);
		gridbagAdd(xPrice, 4, 12, 1, 1);
		gridbagAdd(xPoint, 4, 13, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtDelBasket, 11, 12, 1, 1);
		gridbagAdd(BtOrder, 11, 13, 1, 1);
//      gridbagAdd(BtShopping, 11, 13, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(vProPrice, 0, 12, 1, 1);
		gridbagAdd(vDiscount, 0, 13, 1, 1);
		gridbagAdd(vPrice, 3, 12, 1, 1);
		gridbagAdd(vPoint, 3, 13, 1, 1);

//      setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {
		gridbagconstraints.gridx = x;
		gridbagconstraints.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gridbagconstraints.gridwidth = w;
		gridbagconstraints.gridheight = h;

		gridbaglayout.setConstraints(c, gridbagconstraints); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

	public static void main(String[] args) {

		new Basket();
	}

	class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton del;

		public TableCell2() {
			// TODO Auto-generated constructor stub
			del = new JButton("X");
			del.setHorizontalAlignment(JLabel.CENTER);
			del.setBackground(Color.white);

			del.addActionListener(e -> {
				cust_num = Login.user_num;
				String pro_nm = "";
				pro_nm += (String) tProInfo.getValueAt(row, 1);
				BasketData.deleteBasket(pro_nm);
				model1.removeRow(row);
				getData(BasketData.selectBasket(cust_num));
			});
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			return del;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return del;
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tProInfo) {
			row = tProInfo.getSelectedRow();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtShopping) {
			new home_user();
		} else if (e.getSource() == BtDelBasket) {
			int check = JOptionPane.showConfirmDialog(null, "장바구니에 담긴 모든 상품을 지우시겠습니까?", "", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (check == 0) {
				cust_num = Login.user_num;
				BasketData.deleteBasket2(cust_num);
				model1.removeRow(row);
				getData(BasketData.selectBasket(cust_num));

			}
		} else if (e.getSource() == BtOrder) {
			new MemOrdPg();
		}
	}
}