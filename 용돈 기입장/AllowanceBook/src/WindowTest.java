import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest extends JFrame {
	
	JTextField textField;	// 텍스트 입력을 하는 곳
	JTextArea textArea;	// 대화가 보이는 곳
	
	JButton btn1, btn2;
	
	public WindowTest() {
		super("간단한 예제");
		
		// Panel : textArea + ScrollPane
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);	
        // true : 글자가 textArea에 꽉차면 자동으로 다음줄로 가게해 줌
		
		// 스크롤 만들기
		JScrollPane scrPane = new JScrollPane(textArea);	
        // 스크롤을 생성할 곳을 textArea로 지정
		scrPane.setPreferredSize(new Dimension(100,300));	
        // 스크롤 할 textArea의 크기
		panel.add(scrPane);	
        // textArea를 패널에 추가
		
		
		// botPan : button + textField
		
		// 버튼과 텍스트필드를 담을 패널
		JPanel botpan = new JPanel();
		
		textField = new JTextField(20);	
		// JTextField(숫자) : getter, textField의 사이즈를 들어갈 문자의 개수로 표현
		// JTextField(문자) : 텍스트필드에 미리 입력해서 나타낼 문자
		
		
		// 버튼1에 액션 추가 ( 액션: 문자를 뒤에 추가)
		btn1 = new JButton("next insert");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼이 눌리는 지 확인하는 메세지 띄우기
				// JOptionPane.showMessageDialog(null, "눌림");
				
				if( !textField.getText().equals("") ) {	// 들어가는 문자가 있을 때
					String msg = textField.getText()+"\n";
					// append : 뒤에 메세지 추가
					textArea.append(msg);
				}
			}
		});
		
		
		// 버튼2에 액션 추가 (액션 : 문자를 앞에 추가)
		btn2 = new JButton("prev insert");	// 앞에 글 추가
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼이 눌리는 지 확인하는 메세지 띄우기
				// JOptionPane.showMessageDialog(null, "눌림");
				
				// 빈 문자열일때는 
				if( textField.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "문자를 입력하세요!");
					return;
				}
                
				// 문자를 앞에 추가하기
				String msg = textField.getText()+"\n";
				// insert() : 메세지 넣을 위치 지정
                
				try {
               		// 맨 앞에 넣기 
					textArea.insert(msg, textArea.getLineStartOffset(0));
                    // getLineStartOffset(int lineNum)
                    // 지정된 행의 개시 오프셋(offset)를 리턴
                    
					textField.setText("");
					
					
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		
        // container 이용해서 Layout 잡기
        
		Container contentPane = getContentPane();
		
		contentPane.add(panel, BorderLayout.CENTER);	// 중간
		contentPane.add(botpan, BorderLayout.SOUTH);	// 아래쪽
        contentPane.add(botpan, BorderLayout.NORTH);	// 위쪽
        contentPane.add(botpan, BorderLayout.WEST);		// 왼쪽
        contentPane.add(botpan, BorderLayout.EAST);		// 오른쪽
        
		
		
		setSize(640, 480);	// 윈도우 크기 (폭, 높이)
		setLocation(0, 0);	// 윈도우 실행위치(0,0): 좌측 상단
		setVisible(true);	// 윈도우 시각화
		
		// JFrame 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
	}
	public static void main(String args[]) {
		new WindowTest();
	}
}