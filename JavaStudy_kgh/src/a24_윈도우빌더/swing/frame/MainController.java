package a24_윈도우빌더.swing.frame;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import a24_윈도우빌더.swing.frame.panel.AccountsPanel;
import a24_윈도우빌더.swing.frame.panel.IndexPanel;
import a24_윈도우빌더.swing.frame.panel.SigninPanel;
import a24_윈도우빌더.swing.frame.panel.SignupPanel;
import a24_윈도우빌더.swing.frame.panel.WelcomePanel;

public class MainController extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private CardLayout mainCard;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MainController frame = new MainController();
					frame.setVisible(true);//false로 바꾸면 창을 숨길수 있음
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainController() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 529);//창을 실현시키는 위치
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCard = new CardLayout(0,0);
		mainPanel.setLayout(mainCard);
		mainPanel.setSize(1000,600);
		setContentPane(mainPanel);
		
		JPanel welcomePanel = new WelcomePanel(mainPanel, mainCard);
		mainPanel.add(welcomePanel, "welcomePanel");
		
		JPanel signinPanel = new SigninPanel(mainPanel, mainCard);
		mainPanel.add(signinPanel, "signinPanel");
		
		JPanel signupPanel = new SignupPanel(mainPanel, mainCard);
		mainPanel.add(signupPanel, "signupPanel");
		
		JPanel indexPanel = new IndexPanel(mainPanel, mainCard);
		mainPanel.add(indexPanel, "indexPanel");
		
		JPanel accountPanel = new AccountsPanel(mainPanel, mainCard);
		mainPanel.add(accountPanel, "accountPanel");
		
		JPanel panel = new JPanel();
		mainPanel.add(panel, "name_9281028289600");
		
		
	}
}
