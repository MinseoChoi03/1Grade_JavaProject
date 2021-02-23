package AllowanceBook;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class LookScreen extends JFrame {

	private JPanel Panel;
	private JButton nowDate, nowTime, insert, explan, incomeT, spendT;
	private JButton closeBtn, findBtn, todayBtn, resultBtn ;
	private JTextArea incomeA, spendA;
	private JTextField insertDate;
	
	private SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	private SimpleDateFormat Fyear = new SimpleDateFormat("yyyyMMdd");
	private Date now = new Date();
	private String time = format.format(now);
	private String Ryear = Fyear.format(now);
	
	private String year, money, content;
	
	private ImageIcon closeBtnE = new ImageIcon(getClass().getResource("../image/closeBtnE.png"));
	private ImageIcon closeBtnB = new ImageIcon(getClass().getResource("../image/closeBtnB.png"));
	
	private ImageIcon findBtnE = new ImageIcon(getClass().getResource("../image/findBtnE.png"));
	private ImageIcon findBtnB = new ImageIcon(getClass().getResource("../image/findBtnB.png"));
	
	private ImageIcon todayBtnE = new ImageIcon(getClass().getResource("../image/todayBtnE.png"));
	private ImageIcon todayBtnB = new ImageIcon(getClass().getResource("../image/todayBtnB.png"));
	
	private ImageIcon resultBtnE = new ImageIcon(getClass().getResource("../image/resultBtnE.png"));
	private ImageIcon resultBtnB = new ImageIcon(getClass().getResource("../image/resultBtnB.png"));

	public LookScreen() {
		setTitle("한 눈에 보기");
		setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/image/MoneyGun.png")));
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 222, 239));
		
		closeBtn = new JButton();
		closeBtn.setBounds(171, 545, 100, 40);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusable(false);	
		closeBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				closeBtn.setIcon(closeBtnE);
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setIcon(closeBtnB);
				closeBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});	
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)   {		
				try {
		            dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				};
			}
		});
		
		findBtn = new JButton();
		findBtn.setBounds(340, 48, 70, 35);
		findBtn.setBorderPainted(false);
		findBtn.setContentAreaFilled(false);
		findBtn.setFocusable(false);	
		findBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				findBtn.setIcon(findBtnE);
				findBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				findBtn.setIcon(findBtnB);
				findBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});	
		findBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)   {
				incomeA.removeAll();
				spendA.removeAll();
				try { 

					BufferedReader income = new BufferedReader(new FileReader("수입 내역.txt"));
					BufferedReader spend = new BufferedReader(new FileReader("지출 내역.txt"));
					
					String incomeS, spendS;
					
					while ((incomeS = income.readLine()) != null) {
						
					String[] split = incomeS.split("\t");

					year = split[0];
					money = split[1];
					content = split[2];
					
					if(year.equals(insertDate.getText())) {
						incomeA.append(incomeS + "\n");
						}
					else {
						JOptionPane.showMessageDialog(null, "입력한 날짜와 맞는 수입 내역이 없습니다!");
						break;
						}
					}
					while ((spendS = spend.readLine()) != null) {
					
						String[] split = spendS.split("\t");

						year = split[0]; 
						money = split[1]; 
						content = split[2];

						if(year.equals(insertDate.getText())) {
							spendA.append(spendS + "\n");
						}
						else {
							JOptionPane.showMessageDialog(null, "입력한 날짜와 맞는 지출 내역이 없습니다!");
							break;
						}
					}
					
					income.close();
					spend.close();
					
					} catch (IOException ioe) {
						System.err.println(ioe);
					}
				}
		});
		
		todayBtn = new JButton();
		todayBtn.setBounds(260, 48, 70, 35);
		todayBtn.setBorderPainted(false);
		todayBtn.setContentAreaFilled(false);
		todayBtn.setFocusable(false);	
		todayBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				todayBtn.setIcon(todayBtnE);
				todayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				todayBtn.setIcon(todayBtnB);
				todayBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});	
		todayBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)   {		
				incomeA.removeAll();
				spendA.removeAll();
				
				try { 

				BufferedReader income = new BufferedReader(new FileReader("수입 내역.txt"));
				BufferedReader spend = new BufferedReader(new FileReader("지출 내역.txt"));
				
				String incomeS, spendS;
				
				while ((incomeS = income.readLine()) != null) {
					
				String[] split = incomeS.split("\t");

				year = split[0];
				money = split[1];
				content = split[2];

				if(year.equals(Ryear)) {
					incomeA.append(incomeS+ "\n");
					}
				else {
					JOptionPane.showMessageDialog(null, "입력한 날짜와 맞는 수입 내역이 없습니다!");
					break;
					}
				}
				while ((spendS = spend.readLine()) != null) {
				
					String[] split = spendS.split("\t");

					year = split[0]; 
					money = split[1]; 
					content = split[2];

					if(year.equals(Ryear)) {
						spendA.append(spendS + "\n");
					}
					else {
						JOptionPane.showMessageDialog(null, "입력한 날짜와 맞는 지출 내역이 없습니다!");
						break;
					}
				}
				
				income.close();
				spend.close();
				
				} catch (IOException ioe) {
					System.err.println(e);
				}
			}
		});
		
		resultBtn = new JButton();
		resultBtn.setBounds(260, 10, 150, 35);
		resultBtn.setBorderPainted(false);
		resultBtn.setContentAreaFilled(false);
		resultBtn.setFocusable(false);	
		resultBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resultBtn.setIcon(resultBtnE);
				resultBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				resultBtn.setIcon(resultBtnB);
				resultBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});	
		resultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)   {		
				try {
					new ResultScreen();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		nowDate = new JButton("오늘");
		nowDate.setHorizontalAlignment(SwingConstants.LEFT);
		nowDate.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		nowDate.setBounds(2, 10, 75, 25);
		nowDate.setBorderPainted(false);
		nowDate.setContentAreaFilled(false);
		nowDate.setFocusable(false);
		
		nowTime = new JButton(time);
		nowTime.setHorizontalAlignment(SwingConstants.LEFT);
		nowTime.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 16));
		nowTime.setBounds(52, 10, 140, 25);
		nowTime.setBorderPainted(false);
		nowTime.setContentAreaFilled(false);
		nowTime.setFocusable(false);
		
		insert = new JButton("날짜 입력");
		insert.setHorizontalAlignment(SwingConstants.LEFT);
		insert.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 18));
		insert.setBounds(2, 48, 150, 35);
		insert.setBorderPainted(false);
		insert.setContentAreaFilled(false);
		insert.setFocusable(false);
		
		insertDate = new JTextField();
		insertDate.setBounds(110, 48, 130, 35);
		insertDate.setColumns(10);
		
		explan = new JButton("ex 20200210");
		explan.setForeground(Color.LIGHT_GRAY);
		explan.setHorizontalAlignment(SwingConstants.LEFT);
		explan.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 13));
		explan.setBounds(100, 80, 135, 20);
		explan.setBorderPainted(false);
		explan.setContentAreaFilled(false);
		explan.setFocusable(false);
		
		incomeT = new JButton("수입");
		incomeT.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 18));
		incomeT.setFocusable(false);
		incomeT.setContentAreaFilled(false);
		incomeT.setBorderPainted(false);
		incomeT.setBounds(2, 184, 100, 35);
		
		
		spendT = new JButton("지출");
		spendT.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 18));
		spendT.setFocusable(false);
		spendT.setContentAreaFilled(false);
		spendT.setBorderPainted(false);
		spendT.setBounds(2, 415, 100, 35);
		
		incomeA = new JTextArea();
		incomeA.setBounds(110, 110, 312, 205);
		incomeA.setEditable(false);
		incomeA.setLineWrap(true);
		
		spendA = new JTextArea();
		spendA.setBounds(110, 330, 312, 205);
		spendA.setEditable(false);
		spendA.setLineWrap(true);
		
		Panel.add(nowDate);
		Panel.add(nowTime);
		Panel.add(insert);
		Panel.add(incomeT);
		Panel.add(spendT);
		Panel.add(insertDate);
		Panel.add(explan);
		
		Panel.add(resultBtn);
		Panel.add(todayBtn);
		Panel.add(findBtn);
		Panel.add(closeBtn);
		Panel.add(incomeA);
		Panel.add(spendA);
		
		Panel.setLayout(null);
		getContentPane().add(Panel);
		
		setResizable(false);
		setBounds(630, 120, 450, 650);
		setVisible(true);
	}
}
