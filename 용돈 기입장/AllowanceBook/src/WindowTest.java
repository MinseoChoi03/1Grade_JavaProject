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
	
	JTextField textField;	// �ؽ�Ʈ �Է��� �ϴ� ��
	JTextArea textArea;	// ��ȭ�� ���̴� ��
	
	JButton btn1, btn2;
	
	public WindowTest() {
		super("������ ����");
		
		// Panel : textArea + ScrollPane
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);	
        // true : ���ڰ� textArea�� ������ �ڵ����� �����ٷ� ������ ��
		
		// ��ũ�� �����
		JScrollPane scrPane = new JScrollPane(textArea);	
        // ��ũ���� ������ ���� textArea�� ����
		scrPane.setPreferredSize(new Dimension(100,300));	
        // ��ũ�� �� textArea�� ũ��
		panel.add(scrPane);	
        // textArea�� �гο� �߰�
		
		
		// botPan : button + textField
		
		// ��ư�� �ؽ�Ʈ�ʵ带 ���� �г�
		JPanel botpan = new JPanel();
		
		textField = new JTextField(20);	
		// JTextField(����) : getter, textField�� ����� �� ������ ������ ǥ��
		// JTextField(����) : �ؽ�Ʈ�ʵ忡 �̸� �Է��ؼ� ��Ÿ�� ����
		
		
		// ��ư1�� �׼� �߰� ( �׼�: ���ڸ� �ڿ� �߰�)
		btn1 = new JButton("next insert");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ư�� ������ �� Ȯ���ϴ� �޼��� ����
				// JOptionPane.showMessageDialog(null, "����");
				
				if( !textField.getText().equals("") ) {	// ���� ���ڰ� ���� ��
					String msg = textField.getText()+"\n";
					// append : �ڿ� �޼��� �߰�
					textArea.append(msg);
				}
			}
		});
		
		
		// ��ư2�� �׼� �߰� (�׼� : ���ڸ� �տ� �߰�)
		btn2 = new JButton("prev insert");	// �տ� �� �߰�
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ư�� ������ �� Ȯ���ϴ� �޼��� ����
				// JOptionPane.showMessageDialog(null, "����");
				
				// �� ���ڿ��϶��� 
				if( textField.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���!");
					return;
				}
                
				// ���ڸ� �տ� �߰��ϱ�
				String msg = textField.getText()+"\n";
				// insert() : �޼��� ���� ��ġ ����
                
				try {
               		// �� �տ� �ֱ� 
					textArea.insert(msg, textArea.getLineStartOffset(0));
                    // getLineStartOffset(int lineNum)
                    // ������ ���� ���� ������(offset)�� ����
                    
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
		
		
        // container �̿��ؼ� Layout ���
        
		Container contentPane = getContentPane();
		
		contentPane.add(panel, BorderLayout.CENTER);	// �߰�
		contentPane.add(botpan, BorderLayout.SOUTH);	// �Ʒ���
        contentPane.add(botpan, BorderLayout.NORTH);	// ����
        contentPane.add(botpan, BorderLayout.WEST);		// ����
        contentPane.add(botpan, BorderLayout.EAST);		// ������
        
		
		
		setSize(640, 480);	// ������ ũ�� (��, ����)
		setLocation(0, 0);	// ������ ������ġ(0,0): ���� ���
		setVisible(true);	// ������ �ð�ȭ
		
		// JFrame �ݱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
	}
	public static void main(String args[]) {
		new WindowTest();
	}
}