package a24_���������.swing.frame.panel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import a24_���������.service.AccountService;
import a24_���������.session.Principal;
import a24_���������.swing.dto.AccountsDto;
import lombok.Data;

@Data
public class AccountsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static AccountsPanel instance = new AccountsPanel();
	
	private AccountService accountsService;
	private Principal principal;
	
	private JPanel mainPanel;
	private CardLayout mainCard;
	private JTextField nameText;
	private JPasswordField passwordText;
	private JPasswordField rePasswordText;
	private JTextField emailText;
	
	public boolean isEmpty(String str,String label) {
		if(str.length()==0) {
			JOptionPane.showMessageDialog(null, label + "��(��) ���� �� �����ϴ�.","���",JOptionPane.WARNING_MESSAGE);
			return true;
		}else {
			return false;
		}
	}
		
	private AccountsPanel() {
		accountsService = new AccountService();
		principal = Principal.getInstance();
		
		setLayout(null);
		setSize(1000,600);
		
		JLabel accountsTitle = new JLabel("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815 \uD398\uC774\uC9C0");
		accountsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		accountsTitle.setFont(new Font("���� ���", Font.BOLD, 20));
		accountsTitle.setBounds(314, 73, 292, 27);
		add(accountsTitle);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setFont(new Font("���� ���", Font.BOLD, 16));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(33, 162, 115, 27);
		add(nameLabel);
		
		nameText = new JPasswordField();
		nameText.setBounds(186, 168, 168, 21);
		add(nameText);
		nameText.setColumns(10);
		
		JLabel passwordLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("���� ���", Font.BOLD, 16));
		passwordLabel.setBounds(474, 162, 115, 27);
		add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setColumns(10);
		passwordText.setBounds(632, 168, 168, 21);
		add(passwordText);
		
		JLabel rePasswordLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		rePasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rePasswordLabel.setFont(new Font("���� ���", Font.BOLD, 16));
		rePasswordLabel.setBounds(491, 213, 115, 27);
		add(rePasswordLabel);
		
		rePasswordText = new JPasswordField();
		rePasswordText.setColumns(10);
		rePasswordText.setBounds(632, 219, 168, 21);
		add(rePasswordText);
		
		JLabel emailLabel = new JLabel("\uC774\uBA54\uC77C");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("���� ���", Font.BOLD, 16));
		emailLabel.setBounds(33, 213, 115, 27);
		add(emailLabel);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(166, 265, 244, 33);
		add(emailText);
		
		JButton updateBtn = new JButton("\uC218\uC815\uD558\uAE30");
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(isEmpty(nameText.getText(),nameLabel.getText())) {
					return;
				}else if(isEmpty(emailText.getText(),emailLabel.getText())) {
					return;
				}else {
					AccountsDto accountsDto = new AccountsDto();
					accountsDto.setName(nameText.getText());
					accountsDto.setEmail(emailText.getText());
					if(accountsService.updateProfile(accountsDto)) {
						JOptionPane.showMessageDialog(null, "ȸ�� ���� ���� ����.","�Ϸ�",JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		updateBtn.setBounds(166, 328, 191, 44);
		add(updateBtn);
		
		JButton backBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameText.setText("");
				emailText.setText("");
				passwordText.setText("");
				rePasswordText.setText("");
				mainCard.show(mainPanel,"indexPanel");
			}
		});
		backBtn.setBounds(30, 22, 88, 33);
		add(backBtn);
		
		JButton updatePasswordBtn = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		updatePasswordBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String originPassword = JOptionPane.showInputDialog(null,"������ ��й�ȣ�� �Է��� �ּ���.","��й�ȣ ����",JOptionPane.INFORMATION_MESSAGE);
				if(!originPassword.equals(principal.getUser().getPassword())) {
					JOptionPane.showMessageDialog(null, "��й�ȣ ��������","��й�ȣ ����",JOptionPane.ERROR_MESSAGE);
					return;
				}else if(!passwordText.getText().equals(rePasswordText.getText())) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.","��й�ȣ ����",JOptionPane.ERROR_MESSAGE);
					return;
				}else {
					boolean result = accountsService.updatePassword(passwordText.getText());
					if(result == true) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� ���������� ����Ǿ����ϴ�.","��й�ȣ ���� �Ϸ�",JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "��й�ȣ ���� �� ������ �߻��Ǿ����ϴ�.","��й�ȣ ���� ����",JOptionPane.ERROR_MESSAGE);
					}
					passwordText.setText("");
					rePasswordText.setText("");
					mainCard.show(mainPanel,"indexPanel");
				}
			}
		});
		updatePasswordBtn.setBounds(666, 328, 191, 44);
		add(updatePasswordBtn);
		
		JButton deleteUserBtn = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		deleteUserBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String originPassword = JOptionPane.showInputDialog(null,"������ ��й�ȣ�� �Է��� �ּ���.","��й�ȣ ����",JOptionPane.INFORMATION_MESSAGE);
				if(!originPassword.equals(principal.getUser().getPassword())) {
					JOptionPane.showMessageDialog(null, "��й�ȣ ��������","��й�ȣ ����",JOptionPane.ERROR_MESSAGE);
					return;
				}else {
				boolean result = accountsService.deleteUser();
				if(result == true) {
					JOptionPane.showMessageDialog(null,"���������� ȸ��Ż�� �̷�������ϴ�.","ȸ�� Ż�� ����",JOptionPane.PLAIN_MESSAGE);
					principal.setUser(null);
					mainCard.show(mainPanel,"signinPanel");
					}
				}
			}
		});
		deleteUserBtn.setBounds(689, 513, 168, 44);
		add(deleteUserBtn);
	}
	
	public static AccountsPanel getInstance() {
		if(instance ==null) {
			instance  = new AccountsPanel();
		}
		return instance;
	}
	
	public void setCardLayout(JPanel mainPanel, CardLayout mainCard) {
		this.mainPanel = mainPanel;
		this.mainCard = mainCard;
	}
}
