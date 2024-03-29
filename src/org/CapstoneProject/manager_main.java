package org.CapstoneProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class manager_main extends JFrame implements ActionListener, MouseListener {

	static JPanel menu_b = new JPanel();
	static Image img;
	Container win = getContentPane();
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	static JPanel N_A = new Notice_admin();
	static JPanel Q_A = new QnA_admin();
	static JPanel R_A = new Review_admin();

	private static Image originImg, changedImg;
	private static ImageIcon originIcon, Icon;
	JPanel Label = new JPanel();
	JLabel vNotice, vQnA, vReview, vSpace;
	JLabel img_top;

//	static JLabel img_back;

	BackgroundMenuBar MenuBar = new BackgroundMenuBar();
	// 거래처 메뉴
	JMenu Mn_corr = new JMenu("거래처");
	JMenuItem corr_look = new JMenuItem("거래처조회");
	JMenuItem corr_regist = new JMenuItem("거래처등록");
	JMenuItem pur_regist = new JMenuItem("구매내역등록");

	// 상품 메뉴
	JMenu Mn_pro = new JMenu("상품");
	JMenuItem model_regist = new JMenuItem("모델등록");
	JMenuItem model_look = new JMenuItem("모델조회");
	JMenuItem pro_regist = new JMenuItem("상품등록");
	JMenuItem pro_look = new JMenuItem("상품조회");
	JMenuItem pro_up_rec_reg = new JMenuItem("상품단가등록");
	JMenuItem pro_up_rec = new JMenuItem("상품단가내역");
	// 주문 메뉴
	JMenu Mn_Od = new JMenu("주문");
	JMenuItem Od_deposit = new JMenuItem("통장미입금");
	JMenuItem Od_pre = new JMenuItem("상품준비중");
	JMenuItem deliv = new JMenuItem("배송중");
	JMenuItem deliv_fin = new JMenuItem("배송완료");
	JMenuItem Od_change = new JMenuItem("교환");
	JMenuItem Od_refund = new JMenuItem("환불");
	JMenuItem Od_cancel = new JMenuItem("취소");

	// 사원 메뉴
	JMenu Mn_Emp = new JMenu("사원");
	JMenuItem Emp_look = new JMenuItem("사원조회");
	JMenuItem Emp_regist = new JMenuItem("사원등록");

	// 회원 메뉴
	JMenu Mn_Mb = new JMenu("회원 ");
	JMenuItem Mb_look = new JMenuItem("회원조회");
	JMenuItem Mb_grade = new JMenuItem("등급관리");

	// 이벤트
	JMenu Mn_EVT = new JMenu("이벤트");
	JMenuItem EVT_look = new JMenuItem("이벤트조회");
	JMenuItem EVT_regist = new JMenuItem("이벤트등록");

	JMenu Mn_POST = new JMenu("게시판");

	JMenu Logout = new JMenu("로그아웃");

//   JButton Logout;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public manager_main() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		vNotice = new JLabel("· 공지사항");
		vNotice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vNotice.addMouseListener(this);
		vQnA = new JLabel("· QnA");
		vQnA.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vQnA.addMouseListener(this);
		vReview = new JLabel("· 후기게시판");
		vReview.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vReview.addMouseListener(this);
		Label.setLayout(new BoxLayout(Label, BoxLayout.Y_AXIS));
		Label.add(vNotice);
		Label.add(vQnA);
		Label.add(vReview);

		img_top = new JLabel("");
		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\관리자 상단.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width, 100, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		img_top.setIcon(Icon);
		img_top.setBounds(0, 0, d.width, 100);

		corr_look.addActionListener(this);
		corr_regist.addActionListener(this);
		pur_regist.addActionListener(this);
		model_look.addActionListener(this);
		model_regist.addActionListener(this);
		pro_look.addActionListener(this);
		pro_regist.addActionListener(this);
		pro_up_rec_reg.addActionListener(this);
		pro_up_rec.addActionListener(this);
		Od_deposit.addActionListener(this);
		Od_pre.addActionListener(this);
		deliv.addActionListener(this);
		deliv_fin.addActionListener(this);
		Od_change.addActionListener(this);
		Od_refund.addActionListener(this);
		Od_cancel.addActionListener(this);
		Emp_look.addActionListener(this);
		Emp_regist.addActionListener(this);
		Mb_look.addActionListener(this);
		Mb_grade.addActionListener(this);
		EVT_look.addActionListener(this);
		EVT_regist.addActionListener(this);
		Mn_POST.addMouseListener(this);
		Logout.addMouseListener(this);

		Mn_corr.add(corr_look);
		Mn_corr.add(corr_regist);
		Mn_corr.add(pur_regist);
		Mn_corr.setPreferredSize(new Dimension(d.width / 8, Mn_corr.getPreferredSize().height));
//		corr_look.setPreferredSize(new Dimension(d.width / 8, corr_look.getPreferredSize().height));

		Mn_pro.add(model_regist);
		Mn_pro.add(model_look);
		Mn_pro.add(pro_regist);
		Mn_pro.add(pro_look);
		Mn_pro.add(pro_up_rec_reg);
		Mn_pro.add(pro_up_rec);
		Mn_pro.setPreferredSize(new Dimension(d.width / 8, Mn_pro.getPreferredSize().height));
//		pro_up_rec.setPreferredSize(new Dimension(d.width / 8, pro_up_rec.getPreferredSize().height));

		Mn_Od.add(Od_deposit);
		Mn_Od.add(Od_pre);
		Mn_Od.add(deliv);
		Mn_Od.add(deliv_fin);
		Mn_Od.add(Od_change);
		Mn_Od.add(Od_refund);
		Mn_Od.add(Od_cancel);
		Mn_Od.setPreferredSize(new Dimension(d.width / 8, Mn_Od.getPreferredSize().height));
//		Od_deposit.setPreferredSize(new Dimension(d.width / 8, Od_deposit.getPreferredSize().height));

		Mn_Emp.add(Emp_look);
		Mn_Emp.add(Emp_regist);
		Mn_Emp.setPreferredSize(new Dimension(d.width / 8, Mn_Emp.getPreferredSize().height));
//		Emp_look.setPreferredSize(new Dimension(d.width / 8, Emp_look.getPreferredSize().height));

		Mn_Mb.add(Mb_look);
		Mn_Mb.add(Mb_grade);
		Mn_Mb.setPreferredSize(new Dimension(d.width / 8, Mn_Mb.getPreferredSize().height));
//		Mb_look.setPreferredSize(new Dimension(d.width / 8, Mb_look.getPreferredSize().height));

		Mn_EVT.add(EVT_look);
		Mn_EVT.add(EVT_regist);
		Mn_EVT.setPreferredSize(new Dimension(d.width / 8, Mn_EVT.getPreferredSize().height));
//		EVT_look.setPreferredSize(new Dimension(d.width / 8, EVT_look.getPreferredSize().height));

		Mn_POST.setPreferredSize(new Dimension(d.width / 8, Mn_EVT.getPreferredSize().height));
		Logout.setPreferredSize(new Dimension(d.width / 8, Mn_EVT.getPreferredSize().height));

		MenuBar.add(Mn_corr);
		MenuBar.add(Mn_pro);
		MenuBar.add(Mn_Od);
		MenuBar.add(Mn_Emp);
		MenuBar.add(Mn_Mb);
		MenuBar.add(Mn_EVT);
		MenuBar.add(Mn_POST);
		MenuBar.add(Logout);

		MenuBar.setBounds(0, 0, d.width, 40);
		menu_b.add(MenuBar);

		EmpRegisterView();
	}

	private void EmpRegisterView() {

		setTitle("관리자 메인화면");
		setSize(d.width, d.height);
		// 크기설정
		// 거래처 메뉴
		MenuBar.setBounds(0, 100, d.width, 40);

		Mn_corr.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_corr.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_corr.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		corr_look.setBackground(new Color(255, 255, 255));
		corr_look.setHorizontalAlignment(SwingConstants.CENTER);
		corr_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		corr_regist.setBackground(new Color(255, 255, 255));
		corr_regist.setHorizontalAlignment(SwingConstants.CENTER);
		corr_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pur_regist.setBackground(new Color(255, 255, 255));
		pur_regist.setHorizontalAlignment(SwingConstants.CENTER);
		pur_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 상품메뉴
		Mn_pro.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_pro.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_pro.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		model_look.setBackground(new Color(255, 255, 255));
		model_look.setHorizontalAlignment(SwingConstants.CENTER);
		model_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		model_regist.setBackground(new Color(255, 255, 255));
		model_regist.setHorizontalAlignment(SwingConstants.CENTER);
		model_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_look.setBackground(new Color(255, 255, 255));
		pro_look.setHorizontalAlignment(SwingConstants.CENTER);
		pro_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_regist.setBackground(new Color(255, 255, 255));
		pro_regist.setHorizontalAlignment(SwingConstants.CENTER);
		pro_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_up_rec_reg.setBackground(new Color(255, 255, 255));
		pro_up_rec_reg.setHorizontalAlignment(SwingConstants.CENTER);
		pro_up_rec_reg.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_up_rec.setBackground(new Color(255, 255, 255));
		pro_up_rec.setHorizontalAlignment(SwingConstants.CENTER);
		pro_up_rec.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 주문 메뉴
		Mn_Od.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Od.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Od.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		Od_deposit.setBackground(new Color(255, 255, 255));
		Od_deposit.setHorizontalAlignment(SwingConstants.CENTER);
		Od_deposit.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Od_pre.setBackground(new Color(255, 255, 255));
		Od_pre.setHorizontalAlignment(SwingConstants.CENTER);
		Od_pre.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		deliv.setBackground(new Color(255, 255, 255));
		deliv.setHorizontalAlignment(SwingConstants.CENTER);
		deliv.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		deliv_fin.setBackground(new Color(255, 255, 255));
		deliv_fin.setHorizontalAlignment(SwingConstants.CENTER);
		deliv_fin.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Od_change.setBackground(new Color(255, 255, 255));
		Od_change.setHorizontalAlignment(SwingConstants.CENTER);
		Od_change.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Od_change.setHorizontalAlignment(JLabel.CENTER);

		Od_refund.setBackground(new Color(255, 255, 255));
		Od_refund.setHorizontalAlignment(SwingConstants.CENTER);
		Od_refund.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Od_refund.setHorizontalAlignment(JLabel.CENTER);

		Od_cancel.setBackground(new Color(255, 255, 255));
		Od_cancel.setHorizontalAlignment(SwingConstants.CENTER);
		Od_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Od_cancel.setHorizontalAlignment(JLabel.CENTER);

		// 사원메뉴
		Mn_Emp.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Emp.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Emp.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		Emp_look.setBackground(new Color(255, 255, 255));
		Emp_look.setHorizontalAlignment(SwingConstants.CENTER);
		Emp_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Emp_regist.setBackground(new Color(255, 255, 255));
		Emp_regist.setHorizontalAlignment(SwingConstants.CENTER);
		Emp_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 회원메뉴
		Mn_Mb.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Mb.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Mb.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		Mb_look.setBackground(new Color(255, 255, 255));
		Mb_look.setHorizontalAlignment(SwingConstants.CENTER);
		Mb_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Mb_grade.setBackground(new Color(255, 255, 255));
		Mb_grade.setHorizontalAlignment(SwingConstants.CENTER);
		Mb_grade.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 이벤트메뉴
		Mn_EVT.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_EVT.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_EVT.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		EVT_look.setBackground(new Color(255, 255, 255));
		EVT_look.setHorizontalAlignment(SwingConstants.CENTER);
		EVT_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		EVT_regist.setBackground(new Color(255, 255, 255));
		EVT_regist.setHorizontalAlignment(SwingConstants.CENTER);
		EVT_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Mn_POST.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_POST.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_POST.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		Logout.setBorder(new LineBorder(new Color(0, 0, 0)));
		Logout.setHorizontalAlignment(SwingConstants.CENTER);
		Logout.setFont(new Font("맑은 고딕", Font.BOLD, 25));

//		img_back = new JLabel("");
//		originIcon = new ImageIcon("C:\\Users\\kibum\\Desktop\\메인 배경.jpg");
//		originImg = originIcon.getImage();
//		img = originImg.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);
//		Icon = new ImageIcon(img);
//		img_back.setIcon(Icon);
//		img_back.setBounds(0, 140, d.width, d.height);

		getContentPane().setLayout(null);

		win.add(MenuBar);
		win.add(img_top);
//		win.add(img_back);

		setExtendedState(MAXIMIZED_BOTH);
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
		new manager_main();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == corr_look) {
			getContentPane().removeAll();
			JPanel Pcorr_look = new corr_look();
			win.add(MenuBar);
			win.add(img_top);
//			Pcorr_look.setSize(d.width / 2, d.height - 140);
			Pcorr_look.setBounds(170, 170, 1060, 470);
			win.add(Pcorr_look);
			repaint();
			revalidate();

		} else if (e.getSource() == corr_regist) {
			new corr_regist(new JFrame());
		} else if (e.getSource() == pur_regist) {
			new pur_brkdwn_regist(new JFrame());
		}
		//
		else if (e.getSource() == model_look) {
			getContentPane().removeAll();
			JPanel Pmodel_look = new ManModel();
			add(MenuBar);
			add(img_top);
			Pmodel_look.setSize(d.width / 2, d.height - 140);
			Pmodel_look.setBounds(170, 150, 1060, 470);
			add(Pmodel_look);
			repaint();
			revalidate();
		} else if (e.getSource() == model_regist) {
			new RegModel(new JFrame());
//			getContentPane().removeAll();
//			add(MenuBar);
//			add(img_top);
//			Pmodel_regist.setSize(d.width / 2, d.height - 140);
//			Pmodel_regist.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
//			add(Pmodel_regist);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_look) {
			getContentPane().removeAll();
			JPanel Ppro_look = new ManPro();
			add(MenuBar);
			add(img_top);
			Ppro_look.setSize(d.width / 2, d.height - 140);
			Ppro_look.setBounds(170, 150, 1060, 470);
			add(Ppro_look);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_regist) {
			new RegPro(new JFrame());
//			getContentPane().removeAll();
//			add(MenuBar);
//			add(img_top);
//			Ppro_regist.setSize(d.width / 2, d.height - 140);
//			Ppro_regist.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
//			add(Ppro_regist);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_up_rec) {
//			new RegProPrice(new JFrame());
			getContentPane().removeAll();
			JPanel Ppro_up_rec = new Pro_up_rec();
			add(MenuBar);
			add(img_top);
			Ppro_up_rec.setSize(d.width / 2, d.height - 140);
			Ppro_up_rec.setBounds(170, 170, 1060, 470);
			add(Ppro_up_rec);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_up_rec_reg) {
			new RegProPrice(new JFrame());

		} else if (e.getSource() == Od_deposit) {
			getContentPane().removeAll();
			JPanel POd_deposit = new Od_list_no_deposit();
			add(MenuBar);
			add(img_top);
//			POd_deposit.setSize(d.width / 2, d.height - 140);
			POd_deposit.setBounds(200, 150, 1000, 470);
			add(POd_deposit);
			repaint();
			revalidate();
		} else if (e.getSource() == Od_pre) {
			getContentPane().removeAll();
			JPanel POd_pre = new Od_list_pre_pro();
			add(MenuBar);
			add(img_top);
//			POd_pre.setSize(d.width / 2, d.height - 140);
			POd_pre.setBounds(200, 150, 1000, 470);
			add(POd_pre);
			repaint();
			revalidate();
		} else if (e.getSource() == deliv) {
			getContentPane().removeAll();
			JPanel POd_deliv = new Od_list_Deliv();
			add(MenuBar);
			add(img_top);
			POd_deliv.setSize(d.width / 2, d.height - 140);
			POd_deliv.setBounds(200, 150, 1000, 470);
			add(POd_deliv);
			repaint();
			revalidate();
		} else if (e.getSource() == deliv_fin) {
//			getContentPane().removeAll();
//			JPanel POd_refund = new od_list_od_refund();
//			add(MenuBar);
//			add(img_top);
//			POd_refund.setSize(d.width / 2, d.height - 140);
//			POd_refund.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
//			add(POd_refund);
//			repaint();
//			revalidate();
		} else if (e.getSource() == Od_cancel) {
//			getContentPane().removeAll();
//			JPanel POd_cancel = new od_list_od_cancel();
//			add(MenuBar);
//			add(img_top);
//			POd_cancel.setSize(d.width / 2, d.height - 140);
//			POd_cancel.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
//			add(POd_cancel);
//			repaint();
//			revalidate();
		} else if (e.getSource() == Emp_look) {
			getContentPane().removeAll();
			JPanel PEmp_look = new emp_look();
			add(MenuBar);
			add(img_top);
			PEmp_look.setSize(d.width / 2, d.height - 140);
			PEmp_look.setBounds(170, 150, 1060, 470);
			add(PEmp_look);
			repaint();
			revalidate();
		} else if (e.getSource() == Emp_regist) {
			new emp_re(new JFrame());
//			getContentPane().removeAll();
//			JPanel PEmp_regist = new emp_re();
//			add(MenuBar);
//			add(img_top);
//			Dimension d = getSize();
//			PEmp_regist.setSize(d.width / 2, d.height - 140);
//			PEmp_regist.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
//			add(PEmp_regist);
//			repaint();
//			revalidate();
		} else if (e.getSource() == Mb_look) {
			getContentPane().removeAll();
			JPanel PMb_look = new mb_look();
			add(MenuBar);
			add(img_top);
//			PMb_look.setSize(d.width / 2, d.height - 140);
			PMb_look.setBounds(200, 150, 1000, 470);
			add(PMb_look);
			repaint();
			revalidate();
		} else if (e.getSource() == Mb_grade) {
			getContentPane().removeAll();
			JPanel PMb_gra = new mb_gra();
			add(MenuBar);
			add(img_top);
			PMb_gra.setSize(d.width / 2, d.height - 140);
			PMb_gra.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
			add(PMb_gra);
			repaint();
			revalidate();
		} else if (e.getSource() == EVT_look) {
			getContentPane().removeAll();
			JPanel PEvt_look = new evt_look();
			add(MenuBar);
			add(img_top);
			PEvt_look.setSize(d.width / 2, d.height - 140);
			PEvt_look.setBounds(170, 150, 1060, 470);
			add(PEvt_look);
			repaint();
			revalidate();
		} else if (e.getSource() == EVT_regist) {
			new evt_regist(new JFrame());
//			getContentPane().removeAll();
//			JPanel PEvt_regist = new evt_regist();
//			add(MenuBar);
//			add(img_top);
//			PEvt_regist.setSize(d.width / 2, d.height - 140);
//			PEvt_regist.setBounds(d.width / 4, 140, d.width / 2, d.height - 140);
//			add(PEvt_regist);
//			repaint();
//			revalidate();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Logout) {
			dispose();
		} else if (e.getSource() == Mn_POST) {
			getContentPane().removeAll();
			add(MenuBar);
			add(img_top);
			Label.setBounds(70, 210, 130, 85);
//			N_A.setSize(d.width * 3 / 4, d.height - 200);
			N_A.setBounds(235, 170, 1060, 470);
			win.add(Label);
			win.add(N_A);
			repaint();
			revalidate();
		} else if (e.getSource() == vNotice) {
			getContentPane().removeAll();
			add(MenuBar);
			add(img_top);
			Label.setBounds(70, 210, 130, 85);
//			N_A.setSize(d.width * 3 / 4, d.height - 200);
			N_A.setBounds(235, 170, 1060, 470);
			win.add(Label);
			win.add(N_A);
			repaint();
			revalidate();
		} else if (e.getSource() == vQnA) {
			getContentPane().removeAll();
			add(MenuBar);
			add(img_top);
			Label.setBounds(70, 210, 130, 85);
//			Q_A.setSize(d.width * 3 / 4, d.height - 200);
			Q_A.setBounds(235, 170, 1060, 470);
			win.add(Label);
			win.add(Q_A);
			repaint();
			revalidate();
		} else if (e.getSource() == vReview) {
			getContentPane().removeAll();
			add(MenuBar);
			add(img_top);
			Label.setBounds(70, 210, 130, 85);
//			Q_A.setSize(d.width * 3 / 4, d.height - 200);
			R_A.setBounds(235, 170, 1060, 470);
			win.add(Label);
			win.add(R_A);
			repaint();
			revalidate();
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
}