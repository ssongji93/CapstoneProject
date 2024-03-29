package org.CapstoneProject;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class QnA_question_write extends Dialog implements ActionListener, MouseListener {
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	   
//	JMenuBar MenuBar = new JMenuBar();
//	JMenu Home = new JMenu(" 홈 ");
//	JMenu Mn_Manage = new JMenu(" 쇼핑몰관리 ");
//	JMenu Mn_Center = new JMenu(" 고객센터 ");
//	JMenu Mn_Basket = new JMenu(" 장바구니 ");
//	JMenu Mn_Mypage = new JMenu(" 마이페이지 ");
//	JMenu Mn_Logout = new JMenu(" 로그아웃 ");
	   
	private JLabel vTitle, vContent, vSpace1, vSpace2, vWriter, vDate;
	private JTextField tTitle, tWriter, tDate;
	private JTextArea tContent;              
	private JScrollPane Scroll;
	
	private JButton  bRegist, bCancel;
	
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;
	
	public QnA_question_write(JFrame fr) {
	    
        super(fr, "", true);
		
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints(); 
		
		vTitle = new JLabel("제목");
		vTitle.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vTitle.setPreferredSize(new Dimension(100,40));
		vContent = new JLabel("내용");
		vContent.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vContent.setPreferredSize(new Dimension(100,40));
		vWriter = new JLabel("작성자");
		vWriter.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vWriter.setPreferredSize(new Dimension(100,40));
		vDate = new JLabel("작성일");
		vDate.setHorizontalAlignment(JLabel.CENTER);
		vDate.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vDate.setPreferredSize(new Dimension(100,40));
		
		vSpace1 = new JLabel("");
		vSpace1.setPreferredSize(new Dimension(100,20));
		vSpace2 = new JLabel("");
		vSpace2.setPreferredSize(new Dimension(100,20));
		
		tTitle = new JTextField(20);
		tTitle.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		tWriter = new JTextField(5);
		tWriter.setText(Login.user_nm);
		tWriter.setHorizontalAlignment(JTextField.CENTER);
		tWriter.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
	
		tDate = new JTextField(9);
		tDate.setText(strToday);
		tDate.setHorizontalAlignment(JTextField.CENTER);
		tDate.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		
		tContent = new JTextArea(15, 20);
		tContent.setLineWrap(true);
		tContent.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Scroll = new JScrollPane(tContent);
		
		bRegist = new JButton("등록");
		bRegist.addActionListener(this);
		bRegist.setFocusPainted(false);
		bRegist.setBackground(Color.white);
		bRegist.setPreferredSize(new Dimension(80,30));
		bRegist.setFont(new Font("휴먼매직체", Font.BOLD , 17));
		
		bCancel = new JButton("취소");
		bCancel.addActionListener(this);
		bCancel.setFocusPainted(false);
		bCancel.setBackground(Color.white);
		bCancel.setPreferredSize(new Dimension(80,30));
		bCancel.setFont(new Font("휴먼매직체", Font.BOLD , 17));
		
		tTitle.setBorder(new LineBorder(Color.black));
		tWriter.setBorder(new LineBorder(Color.black));
		tDate.setBorder(new LineBorder(Color.black));
		tContent.setBorder(new LineBorder(Color.black));
		bRegist.setBorder(new LineBorder(Color.black));
		bCancel.setBorder(new LineBorder(Color.black));
		
		tTitle.setOpaque(false);
		tWriter.setOpaque(false);
		tDate.setOpaque(false);
		tContent.setOpaque(false);

		home_adminView();
	}
	
	private void home_adminView() {

		setTitle("홈페이지 관리자");
		
		setLayout(gridbaglayout);
		

//		Home.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Home.setHorizontalAlignment(SwingConstants.CENTER);
//		Home.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Manage.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Manage.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Manage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Center.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Center.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Center.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Basket.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Basket.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Basket.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Mypage.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Mypage.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Mypage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Logout.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Logout.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Logout.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//		gridbagAdd(MenuBar, 0, 0, 7, 1);
		gridbagAdd(vTitle, 0, 0, 1, 1);
	    gridbagAdd(tTitle, 1, 0, 3, 1);
		gridbagAdd(vWriter, 0, 2, 1, 1);
		gridbagAdd(tWriter, 1, 2, 1, 1);
		gridbagAdd(vDate, 2, 2, 1, 1);
		gridbagAdd(tDate, 3, 2, 1, 1);
		gridbagAdd(vContent, 0, 4, 1, 1);
	    gridbagAdd(Scroll, 1, 4, 3, 1);
		
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vSpace1, 0, 1, 1, 1);
		gridbagAdd(vSpace2, 0, 3, 1, 1);
		

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(bRegist, 0, 5, 3, 1);
		gridbagAdd(bCancel, 0, 5, 4, 1);
	    
		pack();
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
		new QnA_question_write(new JFrame());
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		if(e.getSource() == bCancel) {
			dispose();
		} else 	if(e.getSource() == bRegist) {
			String writer = Login.user_nm;
			int result = JOptionPane.showConfirmDialog(null, "문의를 등록하시겠습니까?", "문의 등록 확인", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == 0) {
				QnAData.createQ(tTitle.getText(), tContent.getText(), writer);
				JOptionPane.showMessageDialog(null, "문의가 등록되었습니다.", "문의 등록", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			else {
				JOptionPane.getRootFrame().dispose();
			}
			
		}
		
	}   
}	

	
			