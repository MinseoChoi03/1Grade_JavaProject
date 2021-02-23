package AllowanceBook;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainScreen extends JFrame{
	private JPanel Panel;
	private JButton startBtn, exitBtn, helpBtn;
	private JLabel mainName;
	
	private ImageIcon startBtnE = new ImageIcon(getClass().getResource("../image/startBtnE.png"));
	private ImageIcon startBtnB = new ImageIcon(getClass().getResource("../image/startBtnB.png"));
	
	private ImageIcon exitBtnE = new ImageIcon(getClass().getResource("../image/exitBtnE.png"));
	private ImageIcon exitBtnB = new ImageIcon(getClass().getResource("../image/exitBtnB.png"));

	private Image MainBackground = new ImageIcon(getClass().getResource("../image/MainBackground.png")).getImage();

	
	public MainScreen() {
		setTitle("용돈 기입장");
		setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/image/MoneyGun.png")));
		Panel = new JPanel();
		Panel.setBackground(new Color(0x99FFDEEF, true));
		
		
		Panel.setLayout(null);
		
		startBtn = new JButton();
		exitBtn = new JButton();
		helpBtn = new JButton();
		
		startBtn.setBounds(75, 350, 300, 70);	
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				startBtn.setIcon(startBtnE);
				startBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				startBtn.setIcon(startBtnB);
				startBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					new ActionScreen();
					
					File income = new File("수입 내역.txt");
					income.createNewFile();
					
					File spend = new File("지출 내역.txt");
					spend.createNewFile();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		
		exitBtn.setBounds(75, 470, 300, 70);
		exitBtn.setBorderPainted(false);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setFocusable(false);
		exitBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitBtn.setIcon(exitBtnE);
				exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn.setIcon(exitBtnB);
				exitBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				};
				System.exit(0);
			}
		});

		Panel.add(startBtn);
		Panel.add(exitBtn);
		
		add(Panel);
		setResizable(false);
		setBounds(500, 70, 450, 650);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(MainBackground, 0, 0, null);
	}
}
