package AllowanceBook;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IncomeScreen extends JFrame{
	private JPanel Panel;
	private JButton okBtn, date, money, content, explan;
	private JTextField dateText, moneyText;
	private JTextArea contentText;
	
	private ImageIcon okBtnE = new ImageIcon(getClass().getResource("../image/okBtnE.png"));
	private ImageIcon okBtnB = new ImageIcon(getClass().getResource("../image/okBtnB.png"));

	public IncomeScreen() {
		setTitle("수입 내역");
		setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/image/MoneyGun.png")));
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 222, 239));
		
		okBtn = new JButton();
		okBtn.setBounds(120, 300, 100, 40);
		okBtn.setBorderPainted(false);
		okBtn.setContentAreaFilled(false);
		okBtn.setFocusable(false);
		okBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				okBtn.setIcon(okBtnE);
				okBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				okBtn.setIcon(okBtnB);
				okBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});			
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)   {
				
				if(dateText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "날짜를 입력하세요!");
				}
				else if(moneyText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "수입을 입력하세요!");
				}
				else if(contentText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "내용을 입력하세요!");
				}
				else {
					try {
					FileWriter fw=new FileWriter("수입 내역.txt", true);    //파일명과 같은 파일명이 존재할시 덧붙여쓸여부판단
		            BufferedWriter bf=new BufferedWriter(fw);
		             
		            bf.write(dateText.getText()+"\t");
		            bf.write(moneyText.getText()+"\t");
		            bf.write(contentText.getText()+"\n");    //마지막은 입력후 한줄 내린다.
		               
		            bf.close();        //저장 후 텍스트필드의 값을 가져온 자원들을 해제한다.
		               
		            dateText.setText("");
		            moneyText.setText("");
		            contentText.setText(""); 
		            
		            JOptionPane.showMessageDialog(null, "수입이 입력되었습니다.");
		            dispose();
					
					} catch (IOException e1) {
						e1.printStackTrace();
					};
				}
			}
		});
		
		date = new JButton("날 짜");
		date.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		date.setBounds(12, 40, 90, 25);
		date.setBorderPainted(false);
		date.setContentAreaFilled(false);
		date.setFocusable(false);
		
		money = new JButton("수 입");
		money.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		money.setBounds(12, 100, 90, 25);
		money.setBorderPainted(false);
		money.setContentAreaFilled(false);
		money.setFocusable(false);
		
		content = new JButton("내 용");
		content.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20));
		content.setBounds(12, 175, 90, 25);
		content.setBorderPainted(false);
		content.setContentAreaFilled(false);
		content.setFocusable(false);
		
		dateText = new JTextField();
		dateText.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		dateText.setBounds(120, 40, 185, 30);
		dateText.setColumns(10);
		
		explan = new JButton("ex 20200210");
		explan.setForeground(Color.LIGHT_GRAY);
		explan.setHorizontalAlignment(SwingConstants.LEFT);
		explan.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 13));
		explan.setBounds(102, 67, 135, 20);
		explan.setBorderPainted(false);
		explan.setContentAreaFilled(false);
		explan.setFocusable(false);
		
		moneyText = new JTextField();
		moneyText.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		moneyText.setBounds(120, 100, 185, 30);
		moneyText.setColumns(10);
		
		contentText = new JTextArea();
		contentText.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		contentText.setBounds(120, 175, 185, 100);
		contentText.setLineWrap(true);
		contentText.setColumns(20);
		
		Panel.add(date);
		Panel.add(explan);
		Panel.add(money);
		Panel.add(content);
		Panel.add(okBtn);
		Panel.add(dateText);
		Panel.add(moneyText);
		Panel.add(contentText);
		
		Panel.setLayout(null);
		getContentPane().add(Panel);
		
		setResizable(false);
		setBounds(570, 160, 350, 400);
		setVisible(true);		
	}
}
