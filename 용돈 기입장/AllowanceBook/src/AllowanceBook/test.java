package AllowanceBook;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AllowanceBook.MainScreen;
import java.awt.Font;
import javax.swing.SwingConstants;

public class test extends JFrame{
	private JPanel Panel;
	private JButton startBtn, closeBtn;
	private JLabel mainName;
	
	private ImageIcon startBtnE = new ImageIcon(getClass().getResource("../image/startBtnE.png"));
	private ImageIcon startBtnB = new ImageIcon(getClass().getResource("../image/startBtnB.png"));
	
	private ImageIcon closeBtnE = new ImageIcon(getClass().getResource("../image/closeBtnE.png"));
	private ImageIcon closeBtnB = new ImageIcon(getClass().getResource("../image/closeBtnB.png"));

	private Image MainBackground = new ImageIcon(getClass().getResource("../image/MainBackground.png")).getImage();

	
	public test() {
		setTitle("용돈 기입장");
		Panel = new JPanel();
		
		Panel.setLayout(null);
		
		startBtn = new JButton();
		closeBtn = new JButton();
		
		startBtn.setBounds(75, 350, 300, 70);	
		startBtn.setBorderPainted(false);//버튼 테두리를 그리지 않음
		startBtn.setContentAreaFilled(false);//버튼을 투명하게 하기 위해 false
		startBtn.setFocusPainted(false);//버튼이 포커스(마우스가 올라간 상태) 시 생기는 테두리를 안 보이게 설정함
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
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		
		closeBtn.setBounds(75, 470, 300, 70);
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
		Panel.add(closeBtn);
		
		getContentPane().add(Panel);
		
		JLabel lblNewLabel = new JLabel("\uBA38\uB2C8 \uC0F7");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 51));
		lblNewLabel.setBounds(75, 87, 282, 173);
		Panel.add(lblNewLabel);
		setResizable(false);
		setBounds(500, 70, 450, 650);
		setVisible(true);
	}
	
public static void main(String[] args) {
		
		new test();
	}
}
