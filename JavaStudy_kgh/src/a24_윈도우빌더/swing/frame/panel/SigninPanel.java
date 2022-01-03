package a24_���������.swing.frame.panel;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import a24_���������.service.AuthService;
import a24_���������.session.Principal;
import a24_���������.swing.dto.SigninDto;
import lombok.Data;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Data
public class SigninPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static SigninPanel instance = new SigninPanel();
	
	private IndexPanel indexPanel;
	
	private JTextField usernameText;
	private JPasswordField passwordText;	
	private AuthService authService;
	private JPanel mainPanel;
	private CardLayout mainCard;
	
	private Principal principal;

	private SigninPanel() {
		setLayout(null);
		setSize(1000,600);
		
		authService = new AuthService();
		
		principal = Principal.getInstance();
		indexPanel = IndexPanel.getInstance();
		
		JLabel signinTitle = new JLabel("JAVA \uC2A4\uC719 \uC218\uC5C5");
		signinTitle.setHorizontalAlignment(SwingConstants.CENTER);
		signinTitle.setFont(new Font("���� ���", Font.BOLD, 20));
		signinTitle.setBounds(373, 100, 220, 54);
		add(signinTitle);
		
		JPanel signinItems = new JPanel();
		signinItems.setBackground(Color.WHITE);
		signinItems.setBounds(206, 168, 564, 335);
		add(signinItems);
		signinItems.setLayout(null);
		
		JLabel usernameLabel = new JLabel("\uC544\uC774\uB514");
		usernameLabel.setFont(new Font("���� ���", Font.BOLD, 16));
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setBounds(115, 85, 66, 22);
		signinItems.add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setBounds(193, 82, 249, 36);
		signinItems.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel passwordLable = new JLabel("\uBE44\uBC00\uBC88\uD638");
		passwordLable.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLable.setFont(new Font("���� ���", Font.BOLD, 16));
		passwordLable.setBounds(115, 171, 66, 22);
		signinItems.add(passwordLable);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("���� ���", Font.BOLD, 16));
		passwordText.setBounds(193, 164, 249, 36);
		signinItems.add(passwordText);
		
		JButton signinBtn = new JButton("\uB85C\uADF8\uC778");
		signinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SigninDto signinDto = new SigninDto();
				signinDto.setUsername(usernameText.getText());
				signinDto.setPassword(passwordText.getText());
				int result = authService.signin(signinDto);
				if(result == 2) {
					// �α��� ����
					JOptionPane.showMessageDialog(null, principal.getUser().getName()+"�� ȯ���մϴ�.","�α��� ����",JOptionPane.PLAIN_MESSAGE);	
					indexPanel.getProfileBtn().setText(principal.getUser().getUsername());
					usernameText.setText("");
					passwordText.setText("");
					mainCard.show(mainPanel,"indexPanel");
				}else if(result == 0) {
					JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.","���̵� ����",JOptionPane.ERROR_MESSAGE);					
				}else if(result == 1) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.","��й�ȣ ����",JOptionPane.ERROR_MESSAGE);
					System.out.println("��й�ȣ�� ��ġ���� ����");
				}
			}
		});
		signinBtn.setFont(new Font("���� ���", Font.BOLD, 16));
		signinBtn.setBounds(330, 244, 115, 40);
		signinItems.add(signinBtn);
		
		JButton signupBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		signupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameText.setText("");
				passwordText.setText("");
				mainCard.show(mainPanel,"signupPannel");
			}			
		});
		signupBtn.setFont(new Font("���� ���", Font.BOLD, 16));
		signupBtn.setBounds(193, 244, 115, 40);
		signinItems.add(signupBtn);

	}
	
	public static SigninPanel getInstance() {
		if(instance ==null) {
			instance  = new SigninPanel();
		}
		return instance;
	}

	public void setCardLayout(JPanel mainPanel, CardLayout mainCard) {
		this.mainPanel = mainPanel;
		this.mainCard = mainCard;
	}
	
}
