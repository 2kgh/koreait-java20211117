package a24_윈도우빌더.swing.frame.panel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import a24_윈도우빌더.service.AccountService;
import a24_윈도우빌더.service.AuthService;
import a24_윈도우빌더.swing.dto.SignupDto;

public class SignupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private CardLayout mainCard;

	private static SignupPanel instance = new SignupPanel();
	private JTextField usernameText;
	private JTextField nameText;
	private JTextField emailText;
	private JPasswordField passwordText;
	
	private AuthService authService;
	private SigninPanel signinPanel;
	private boolean usernameCheckFlag = false;
	
	public boolean isEmpty(String str,String label) {
		if(str.length()==0) {
			JOptionPane.showMessageDialog(null, label + "은(는) 빈값일 수 없습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return true;
		}else {
			return false;
		}
	}

	private SignupPanel() {
		setLayout(null);
		setSize(1000,600);
	
		authService = new AuthService();
		signinPanel = SigninPanel.getInstance();
	JLabel signupTitle = new JLabel("\uD68C\uC6D0\uAC00\uC785");
	signupTitle.setHorizontalAlignment(SwingConstants.CENTER);
	signupTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	signupTitle.setBounds(431, 81, 117, 39);
	add(signupTitle);
	
	JLabel usernameLable = new JLabel("\uC0AC\uC6A9\uC790 \uC774\uB984");
	usernameLable.setHorizontalAlignment(SwingConstants.RIGHT);
	usernameLable.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	usernameLable.setBounds(259, 162, 132, 22);
	add(usernameLable);
	
	usernameText = new JTextField();
	usernameText.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			usernameCheckFlag = false;
		}
	});
	usernameText.setBounds(403, 161, 132, 31);
	add(usernameText);
	usernameText.setColumns(10);
	
	JLabel nameLable = new JLabel("\uC774\uB984");
	nameLable.setHorizontalAlignment(SwingConstants.RIGHT);
	nameLable.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	nameLable.setBounds(259, 270, 132, 22);
	add(nameLable);
	
	nameText = new JTextField();
	nameText.setColumns(10);
	nameText.setBounds(403, 269, 221, 31);
	add(nameText);
	
	JLabel emailLable = new JLabel("\uC774\uBA54\uC77C");
	emailLable.setHorizontalAlignment(SwingConstants.RIGHT);
	emailLable.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	emailLable.setBounds(259, 335, 132, 22);
	add(emailLable);
	
	emailText = new JTextField();
	emailText.setColumns(10);
	emailText.setBounds(403, 334, 221, 31);
	add(emailText);
	
	JLabel passwordLable = new JLabel("\uBE44\uBC00\uBC88\uD638");
	passwordLable.setHorizontalAlignment(SwingConstants.RIGHT);
	passwordLable.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	passwordLable.setBounds(259, 215, 132, 22);
	add(passwordLable);
	
	JButton btnNewButton = new JButton("\uAC00\uC785\uD558\uAE30");
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(isEmpty(usernameText.getText(),usernameLable.getText())) {
				return;
			}else if(isEmpty(passwordText.getText(),passwordLable.getText())){
				return;
			}else if(isEmpty(nameText.getText(),nameLable.getText())){
				return;
			}else if(isEmpty(emailText.getText(),emailLable.getText())){
				return;
			}else if(usernameCheckFlag == false) {
				JOptionPane.showMessageDialog(null,"중복확인을 해주세요.","중복확인 오류",JOptionPane.WARNING_MESSAGE);
			}else {
				SignupDto signupDto = new SignupDto();
				signupDto.setUsername(usernameText.getText());
				signupDto.setPassword(passwordText.getText());
				signupDto.setName(nameText.getText());
				signupDto.setEmail(emailText.getText());
				boolean result = authService.signup(signupDto);
				if(result == true) {
					JOptionPane.showMessageDialog(null,"회원이 되신 것을 축하드립니다.","회원가입 성공",JOptionPane.PLAIN_MESSAGE);
					signinPanel.getUsernameText().setText(usernameText.getText());
					mainCard.show(mainPanel,"signinPanel");
				}
			}
		}
	});
	btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	btnNewButton.setBounds(401, 403, 221, 31);
	add(btnNewButton);
	
	JButton backBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
	backBtn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			usernameText.setText("");
			passwordText.setText("");
			nameText.setText("");
			emailText.setText("");
			mainCard.show(mainPanel,"signinPanel");
		}
	});
	backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	backBtn.setBounds(23, 21, 97, 45);
	add(backBtn);
	
	passwordText = new JPasswordField();
	passwordText.setBounds(403, 219, 221, 31);
	add(passwordText);
	
	JButton usernameCheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
	usernameCheckBtn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// username 중복 체크
			boolean result = authService.usernameCheck(usernameText.getText());
			if(result == true) {
				usernameCheckFlag = true;
				JOptionPane.showMessageDialog(null,"가입가능한 사용자 이름입니다.","가입가능",JOptionPane.PLAIN_MESSAGE);
			}else {
				usernameCheckFlag = false;
				JOptionPane.showMessageDialog(null,"이미 사용중인 사용자 이름입니다.","가입불가능",JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	usernameCheckBtn.setBounds(543, 161, 81, 31);
	add(usernameCheckBtn);
	}

	public static SignupPanel getInstance() {
	if(instance ==null) {
		instance  = new SignupPanel();
	}
	return instance;
}

public void setCardLayout(JPanel mainPanel, CardLayout mainCard) {
	this.mainPanel = mainPanel;
	this.mainCard = mainCard;
}
}
