package org.CapstoneProject;

import java.awt.BorderLayout;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

public class QnA_answer_write extends Dialog implements ActionListener, MouseListener {
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	   
	private JLabel vQTitle, vTitle, vContent, vSpace1, vSpace2, vWriter, vDate;
	private JTextField tTitle, tWriter, tDate;
	private JTextArea tContent;              
	private JScrollPane Scroll;
	
	private JButton  bRegist, bCancel;
	
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;
	
	public QnA_answer_write(JFrame fr) {
		
		super(fr, "", true);
		
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints(); 
		
		vTitle = new JLabel("제목");
		vTitle.setHorizontalAlignment(JLabel.CENTER);
		vTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vTitle.setPreferredSize(new Dimension(100, 40));

		vContent = new JLabel("내용");
		vContent.setHorizontalAlignment(JLabel.CENTER);
		vContent.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vContent.setPreferredSize(new Dimension(100, 40));

		vWriter = new JLabel("작성자");
		vWriter.setHorizontalAlignment(JLabel.CENTER);
		vWriter.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vWriter.setPreferredSize(new Dimension(100, 40));

		vDate = new JLabel("작성일");
		vDate.setHorizontalAlignment(JLabel.CENTER);
		vDate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vDate.setPreferredSize(new Dimension(100, 40));

		vSpace1 = new JLabel("");
		vSpace1.setPreferredSize(new Dimension(100, 20));
		vSpace2 = new JLabel("");
		vSpace2.setPreferredSize(new Dimension(100, 20));
		
		tTitle = new JTextField(20);
		tTitle.setText("re) "+QnA_view_admin.sTitle);
		tTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		tWriter = new JTextField(5);
		tWriter.setText(Login.admin_nm);
		tWriter.setHorizontalAlignment(JTextField.CENTER);
		tWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
	
		tDate = new JTextField(9);
		tDate.setText(strToday);
		tDate.setHorizontalAlignment(JTextField.CENTER);
		tDate.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		tContent = new JTextArea(15, 20);
		tContent.setLineWrap(true);
		tContent.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		Scroll = new JScrollPane(tContent);
		
		bRegist = new JButton("등록");
		bRegist.addActionListener(this);
		bRegist.setFocusPainted(false);
		bRegist.setBackground(Color.white);
		bRegist.setPreferredSize(new Dimension(80,30));
		bRegist.setFont(new Font("맑은 고딕", Font.BOLD , 17));
		
		bCancel = new JButton("취소");
		bCancel.addActionListener(this);
		bCancel.setFocusPainted(false);
		bCancel.setBackground(Color.white);
		bCancel.setPreferredSize(new Dimension(80,30));
		bCancel.setFont(new Font("맑은 고딕", Font.BOLD , 17));
		
		tTitle.setBorder(new LineBorder(Color.black));
		tWriter.setBorder(new LineBorder(Color.black));
		tDate.setBorder(new LineBorder(Color.black));
		tContent.setBorder(new LineBorder(Color.black));
		bRegist.setBorder(new LineBorder(Color.black));
		bCancel.setBorder(new LineBorder(Color.black));
		
		tTitle.setEnabled(false);
		tWriter.setEnabled(false);
		tDate.setEnabled(false);
		
		home_adminView();
	}
	
	private void home_adminView() {

		setTitle("홈페이지 관리자");
		
		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(vTitle, 0, 0, 1, 1);
	    gridbagAdd(tTitle, 1, 0, 3, 1);
		gridbagAdd(vWriter, 0, 2, 1, 1);
		gridbagAdd(tWriter, 1, 2, 1, 1);
		gridbagAdd(vDate, 2, 2, 1, 1);
		gridbagAdd(tDate, 3, 2, 1, 1);
		gridbagAdd(vContent, 0, 4, 1, 1);
	    gridbagAdd(Scroll, 1, 4, 3, 1);
	    gridbagAdd(bRegist, 1, 5, 1, 1);
		
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vSpace1, 0, 1, 1, 1);
		gridbagAdd(vSpace2, 0, 3, 1, 1);
		

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(bCancel, 3, 5, 1, 1);
	    
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
		new QnA_answer_write(new JFrame());
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
			String writer = Login.admin_nm;
			String POST_NUM = QnA_admin.POST_NUM + "-re";
			int result = JOptionPane.showConfirmDialog(null, "답변을 등록하시겠습니까?", "답변 등록 확인", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == 0) {
				QnAData.createA(POST_NUM, tTitle.getText(), tContent.getText(), writer);
				JOptionPane.showMessageDialog(null, "답변이 등록되었습니다.", "답변 등록", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			else {
				JOptionPane.getRootFrame().dispose();
			}
			
		}
		
	}   
}	

	
			