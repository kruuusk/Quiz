package GeneraQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class FinestraLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JButton buttonLogin;
	private JTextField textField;
	private JLabel label;

	public FinestraLogin() {

		this.setTitle("Log-In");
		this.setBounds(100, 100, 200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel.setLayout(null);

		this.label = new JLabel("Benvenuto in QuizOnline");
		this.label.setBounds(30, 11, 124, 16);

		this.textField = new JTextField();
		this.textField.setBounds(46, 45, 86, 20);

		this.buttonLogin = new JButton("ACCEDI");
		buttonLogin.setBackground(SystemColor.activeCaption);
		this.buttonLogin.setBounds(46, 76, 86, 20);

		this.panel.add(this.label);
		this.panel.add(this.textField);
		this.panel.add(this.buttonLogin);

		this.buttonLogin.addActionListener(this);

		this.setContentPane(panel);

		this.setResizable(false);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String codUtente = this.getTextField().getText();
		this.dispose();

		if ("456".equals(codUtente)) {

			Risposta risp1 = new Risposta("Un intero", true);
			Risposta risp2 = new Risposta("Una stringa", false);
			Risposta risp3 = new Risposta("Un booleano", false);

			Risposta risp4 = new Risposta("Un intero", false);
			Risposta risp5 = new Risposta("Una stringa", false);
			Risposta risp6 = new Risposta("Un booleano", true);

			Risposta risp7 = new Risposta("Un intero", false);
			Risposta risp8 = new Risposta("Una stringa", true);
			Risposta risp9 = new Risposta("Un booleano", false);

			Domanda dom1 = new Domanda("Cosa rappresenta 'int'?");
			dom1.addRisposta(risp1);
			dom1.addRisposta(risp2);
			dom1.addRisposta(risp3);

			Domanda dom2 = new Domanda("Cosa rappresenta 'boolean'?");
			dom2.addRisposta(risp4);
			dom2.addRisposta(risp5);
			dom2.addRisposta(risp6);

			Domanda dom3 = new Domanda("Cosa rappresenta 'String'?");
			dom3.addRisposta(risp7);
			dom3.addRisposta(risp8);
			dom3.addRisposta(risp9);

			// System.out.println(dom1);

			Quiz quiz1 = new Quiz("AE3245", 30);
			quiz1.addDomanda(dom1);
			quiz1.addDomanda(dom2);
			quiz1.addDomanda(dom3);

			Utente ut1 = new Utente("", "", "");
			// System.out.println(quiz1);
			QuizUtente quizU1 = new QuizUtente(quiz1, ut1);

			FinestraQuiz finestraQuiz = new FinestraQuiz(quizU1);
		} else if("123".equals(codUtente)) {
			FinestraAdmin finestraAdmin = new FinestraAdmin();
		}

	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(JButton buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
}
