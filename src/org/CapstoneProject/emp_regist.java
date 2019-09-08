package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class emp_regist extends JPanel implements ActionListener{

   private JLabel mb_regist, mb_lookup, mb_regist2, Lemp_no, Lemp_nm, Lemp_dt, Lemp_ph_num, Lemp_tp, Lemp_addr,
   Lreg_tp,Lreg_id,Lreg_pw;      
         
   private JTextField  Temp_no, Temp_nm, Temp_dt, Temp_ph_num, Temp_addr, Treg_id, Treg_pw;      
   
   private String[] emp_tp = {"정규직", "계약직"};    
   private String[] reg_tp = {"스타일리스트", "웹디자이너", "포토그래퍼", "물류관리담당", "고객센터담당"};  
         
   private JButton Bregist,Bcancel; 
   
   private JComboBox<String> CBemp_tp, CBreg_tp;   
   
   String EMP_NO,  EMP_NM,  EMP_DT,  EMP_PH_NUM,  EMP_TP,  EMP_ADDR,  REG_TP,  REG_ID,  REG_PW;
   
   int close;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public emp_regist() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         mb_regist2 = new JLabel("사원등록");
         mb_regist2.setPreferredSize(new Dimension(200,28));
         
         Lemp_no = new JLabel("사원번호");
         Lemp_no.setPreferredSize(new Dimension(100,30));
         Lemp_nm = new JLabel("사원명");
         Lemp_nm.setPreferredSize(new Dimension(100,30));
         Lemp_dt = new JLabel("입사일자(8자)");
         Lemp_dt.setPreferredSize(new Dimension(100,30));
         Lemp_ph_num = new JLabel("휴대폰 번호");
         Lemp_ph_num.setPreferredSize(new Dimension(100,30));
         Lemp_tp = new JLabel("사원구분");
         Lemp_tp.setPreferredSize(new Dimension(100,30));
         Lemp_addr = new JLabel("주소");
         Lemp_addr.setPreferredSize(new Dimension(100,30));
         Lreg_tp = new JLabel("정규직 구분");
         Lreg_tp.setPreferredSize(new Dimension(100,30));
         Lreg_id = new JLabel("아이디");
         Lreg_id.setPreferredSize(new Dimension(100,30));
         Lreg_pw = new JLabel("초기 비밀번호");
         Lreg_pw.setPreferredSize(new Dimension(100,30));
         
         CBemp_tp = new JComboBox<String>(emp_tp);
         CBemp_tp.setPreferredSize(new Dimension(100,30));
         CBemp_tp.addActionListener(this);
         CBreg_tp = new JComboBox<String>(reg_tp);
         CBreg_tp.setPreferredSize(new Dimension(100,30));
         
         Temp_no = new JTextField(20);
         Temp_no.setPreferredSize(new Dimension(100,30));
         Temp_nm = new JTextField(20);
         Temp_nm.setPreferredSize(new Dimension(100,30));
         Temp_dt = new JTextField(20);
         Temp_dt.setPreferredSize(new Dimension(100,30));
         Temp_ph_num = new JTextField(20);
         Temp_ph_num.setPreferredSize(new Dimension(100,30));
         Temp_addr = new JTextField(20);
         Temp_addr.setPreferredSize(new Dimension(100,30));
         Treg_id = new JTextField(20);
         Treg_id.setPreferredSize(new Dimension(100,30));
         Treg_pw = new JTextField(20);
         Treg_pw.setPreferredSize(new Dimension(100,30));
         
         Bregist = new JButton("등록");
         Bregist.setPreferredSize(new Dimension(100,28));
         Bregist.addActionListener(this);
         Bcancel = new JButton("취소");
         Bcancel.setPreferredSize(new Dimension(100,28)); 
         Bcancel.addActionListener(this);
        
         
         CBreg_tp.setEnabled(true);
         CBreg_tp.setVisible(true);
         EmpRegisterView();
         
         
         
         
      }   
         
   private void EmpRegisterView() {      
         
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;

         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagAdd(mb_regist2, 1, 1, 1, 1);
//         gridbagAdd(Lemp_no, 1, 2, 1, 1);
         gridbagAdd(Lemp_nm, 1, 3, 1, 1);
         gridbagAdd(Lemp_dt, 1, 4, 1, 1);
         gridbagAdd(Lemp_ph_num, 1, 5, 1, 1);
         gridbagAdd(Lemp_addr, 1, 6, 1, 1);
         gridbagAdd(Lemp_tp, 1, 7, 1, 1);
         gridbagAdd(Lreg_tp, 1, 8, 1, 1);
         gridbagAdd(Lreg_id, 1, 9, 1, 1);
         gridbagAdd(Lreg_pw, 1, 10, 1, 1);
         gridbagAdd(CBreg_tp, 2, 8, 1, 1);
//         gridbagAdd(Temp_no, 2, 2, 1, 1);
         gridbagAdd(Temp_nm, 2, 3, 1, 1);
         gridbagAdd(Temp_dt, 2, 4, 1, 1);
         gridbagAdd(Temp_ph_num, 2, 5, 1, 1);
         gridbagAdd(Temp_addr, 2, 6, 1, 1);
         gridbagAdd(CBemp_tp, 2, 7, 1, 1);
         
         gridbagAdd(Treg_id, 2, 9, 1, 1);
         gridbagAdd(Treg_pw, 2, 10, 1, 1);
         

         gridbagAdd(Bregist, 2, 11, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Bcancel, 2, 11, 1, 1);

         setVisible(true);
      }   
         
      private void gridbagAdd(Component c, int x, int y, int w, int h) {   
         
         gridbagconstraints.gridx = x;
         gridbagconstraints.gridy = y; 
            //가장 왼쪽 위 gridx, gridy값은 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
         
         add(c);   
         
         }   
      
      public static void main(String[] args) {
    	  new emp_regist();
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == CBemp_tp ) {
			if(CBemp_tp.getSelectedItem() == "정규직") {
				CBreg_tp.setEnabled(true);
		        CBreg_tp.setVisible(true);
		        Lreg_tp.setVisible(true);
		        Lreg_id.setVisible(true);
		        Lreg_pw.setVisible(true);
		        Treg_id.setVisible(true);
		        Treg_pw.setVisible(true);
			}else if(CBemp_tp.getSelectedItem() == "계약직") {
				CBreg_tp.setEnabled(false);
		        CBreg_tp.setVisible(false);
		        Lreg_tp.setVisible(false);
		        Lreg_id.setVisible(false);
		        Lreg_pw.setVisible(false);
		        Treg_id.setVisible(false);
		        Treg_pw.setVisible(false);
				}
		}else if(e.getSource() == Bregist) {
			
			int result = JOptionPane.showConfirmDialog(null, "해당 사원 정보를 등록하시겠습니까?", "사원 등록 확인", JOptionPane.YES_NO_OPTION,
				    JOptionPane.INFORMATION_MESSAGE);
					if(result == 0) {
						//변수에 콤보박스 값 저장
						
						EMP_NO = Temp_no.getText();
						EMP_NM = Temp_nm.getText();
						EMP_DT = Temp_dt.getText();
						EMP_PH_NUM = Temp_ph_num.getText();
						EMP_TP = (String) CBemp_tp.getSelectedItem();
						EMP_ADDR = Temp_addr.getText();
						REG_TP = (String) CBreg_tp.getSelectedItem();
						REG_ID = Treg_id.getText();
						REG_PW = Treg_pw.getText();
						
						empData.initempData(EMP_NO,  EMP_NM,  EMP_DT,  EMP_PH_NUM,  EMP_TP,  EMP_ADDR,  REG_TP,  REG_ID,  REG_PW);
						empData.createemp();
						JOptionPane.showMessageDialog(null, "사원이 등록되었습니다.", "사원 등록",
					               JOptionPane.WARNING_MESSAGE);
						Temp_no.setText("");
						Temp_nm.setText("");
						Temp_dt.setText("");
						Temp_ph_num.setText("");
						Temp_addr.setText("");
						Treg_id.setText("");
						Treg_pw.setText("");
			
		}
		else if(result ==1) {
			JOptionPane.getRootFrame().dispose(); 
		}
	}else if(e.getSource() == Bcancel) {
   }
}
}