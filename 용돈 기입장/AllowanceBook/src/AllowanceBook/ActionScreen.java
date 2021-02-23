package AllowanceBook;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionScreen extends JFrame{
	private JPanel Panel;
	private JButton incomeBtn, spendBtn, lookBtn, imgBtn;
	
	private ImageIcon incomeBtnE = new ImageIcon(getClass().getResource("../image/incomeBtnE.png"));
	private ImageIcon incomeBtnB = new ImageIcon(getClass().getResource("../image/incomeBtnB.png"));
	
	private ImageIcon spendBtnE = new ImageIcon(getClass().getResource("../image/spendBtnE.png"));
	private ImageIcon spendBtnB = new ImageIcon(getClass().getResource("../image/spendBtnB.png"));
	
	private ImageIcon lookBtnE = new ImageIcon(getClass().getResource("../image/lookBtnE.png"));
	private ImageIcon lookBtnB = new ImageIcon(getClass().getResource("../image/lookBtnB.png"));
	
	private ImageIcon imgBtnE = new ImageIcon(getClass().getResource("../image/MoneyGun.png"));
	
	public ActionScreen() {
		setTitle("øÎµ∑ ±‚¿‘¿Â");
		setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/image/MoneyGun.png")));
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 222, 239));
		
		Panel.setLayout(null);
		
		incomeBtn = new JButton();
		spendBtn = new JButton();
		lookBtn = new JButton();
		imgBtn = new JButton();
		
		incomeBtn.setBounds(75, 80, 300, 70);
		incomeBtn.setBorderPainted(false);
		incomeBtn.setContentAreaFilled(false);
		incomeBtn.setFocusable(false);
		incomeBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				incomeBtn.setIcon(incomeBtnE);
				incomeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				incomeBtn.setIcon(incomeBtnB);
				incomeBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					new IncomeScreen();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		spendBtn.setBounds(75, 180, 300, 70);
		spendBtn.setBorderPainted(false);
		spendBtn.setContentAreaFilled(false);
		spendBtn.setFocusable(false);
		spendBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				spendBtn.setIcon(spendBtnE);
				spendBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				spendBtn.setIcon(spendBtnB);
				spendBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					new SpendScreen();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		imgBtn.setBounds(105, 260, 240, 150);
		imgBtn.setBorderPainted(false);
		imgBtn.setContentAreaFilled(false);
		imgBtn.setFocusable(false);
		imgBtn.setIcon(imgBtnE);
		
		lookBtn.setBounds(75, 420, 300, 70);
		lookBtn.setBorderPainted(false);
		lookBtn.setContentAreaFilled(false);
		lookBtn.setFocusable(false);
		lookBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lookBtn.setIcon(lookBtnE);
				lookBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				lookBtn.setIcon(lookBtnB);
				lookBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					new LookScreen();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		Panel.add(incomeBtn);
		Panel.add(spendBtn);
		Panel.add(imgBtn);
		Panel.add(lookBtn);
		
		
		add(Panel);
		setResizable(false);
		setBounds(570, 120, 450, 650);
		setVisible(true);
	}
}
