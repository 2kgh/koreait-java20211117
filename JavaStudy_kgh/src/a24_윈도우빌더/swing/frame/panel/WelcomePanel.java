package a24_À©µµ¿ìºô´õ.swing.frame.panel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import a24_À©µµ¿ìºô´õ.swing.frame.MainController;


public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public WelcomePanel(JPanel mainPanel, CardLayout mainCard) {
		setLayout(null);
		setSize(1000,600);
		JLabel welcomeTitle = new JLabel("JAVA \uC2A4\uC719 \uC218\uC5C5");
		welcomeTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitle.setBounds(361, 141, 256, 57);
		add(welcomeTitle);
		
		JButton startBtn = new JButton("\uC2DC\uC791\uD558\uAE30");
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel,"signinPanel");
			}
		});
		startBtn.setBounds(436, 432, 97, 23);
		add(startBtn);

	}
}
