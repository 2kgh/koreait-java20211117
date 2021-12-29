package a24_À©µµ¿ìºô´õ.swing.frame.panel;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class SignupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private CardLayout mainCard;


	private static SignupPanel instance = new SignupPanel();

	private SignupPanel() {
	setLayout(null);
	setSize(1000,600);
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
