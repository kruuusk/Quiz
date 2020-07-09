package GeneraQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class FinestraQuiz extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel labelNumeroDomanda;
	private JLabel labelTestoDomanda;
	private JButton buttonTermina;
	private JButton buttonAvanti;
	private JButton buttonIndietro;
	private QuizUtente quizUtente;
	private int i;
	private JRadioButton radio0, radio1, radio2;

	public FinestraQuiz(QuizUtente quizUtente) {

		this.quizUtente = quizUtente;

		this.setContentPane(creaPanel(this.i));

		this.setResizable(false);
		this.setVisible(true);
	}

	public JPanel creaPanel(int i) {

		this.setTitle(this.quizUtente.getQuiz().getCodQuiz());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);

		this.panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel.setLayout(null);

		this.labelNumeroDomanda = new JLabel();
		this.labelNumeroDomanda.setText("Domanda " + (this.i + 1) + "/" + this.quizUtente.getQuiz().getDomande().size());
		this.labelNumeroDomanda.setBounds(5, 5, 200, 30);

		this.labelTestoDomanda = new JLabel();
		this.labelTestoDomanda.setText(this.quizUtente.getQuiz().getDomande().get(this.i).getDomanda());
		this.labelTestoDomanda.setBounds(5, 25, 400, 50);

		this.buttonTermina = new JButton("TERMINA");
		buttonTermina.setBackground(SystemColor.activeCaption);
		this.buttonTermina.setBounds(675, 535, 100, 20);
		this.buttonTermina.addActionListener(this);

		this.buttonIndietro = new JButton("INDIETRO");
		this.buttonIndietro.setBounds(5, 535, 100, 20);
		this.buttonIndietro.addActionListener(this);

		this.buttonAvanti = new JButton("AVANTI");
		this.buttonAvanti.setBounds(120, 535, 100, 20);
		this.buttonAvanti.addActionListener(this);

		this.radio0 = new JRadioButton(this.quizUtente.getQuiz().getDomande().get(this.i).getRisposte().get(0).getRisposta());
		radio0.setBackground(SystemColor.activeCaption);
		this.radio0.setBounds(5, 85, 200, 15);

		this.radio1 = new JRadioButton(this.quizUtente.getQuiz().getDomande().get(this.i).getRisposte().get(1).getRisposta());
		radio1.setBackground(SystemColor.activeCaption);
		this.radio1.setBounds(5, 105, 200, 15);

		this.radio2 = new JRadioButton(this.quizUtente.getQuiz().getDomande().get(this.i).getRisposte().get(2).getRisposta());
		radio2.setBackground(SystemColor.activeCaption);
		this.radio2.setBounds(5, 125, 200, 15);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radio0);
		buttonGroup.add(radio1);
		buttonGroup.add(radio2);

		this.radio0.addItemListener(this);
		this.radio1.addItemListener(this);
		this.radio2.addItemListener(this);

		this.panel.add(labelNumeroDomanda);
		this.panel.add(labelTestoDomanda);
		this.panel.add(buttonAvanti);
		this.panel.add(buttonIndietro);
		this.panel.add(buttonTermina);
		this.panel.add(radio0);
		this.panel.add(radio1);
		this.panel.add(radio2);

		return this.panel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (radio0.isSelected()) {
			this.quizUtente.aggiungiRispostaMappa(this.quizUtente.getQuiz().getDomande().get(this.i),this.quizUtente.getQuiz().getDomande().get(this.i).getRisposte().get(0));
			// System.out.println(this.quizUtente.getRisposteDate().get(this.quizUtente.getQuiz().getDomande().get(this.i)));
		}

		if (radio1.isSelected()) {
			this.quizUtente.aggiungiRispostaMappa(this.quizUtente.getQuiz().getDomande().get(this.i),this.quizUtente.getQuiz().getDomande().get(this.i).getRisposte().get(1));
			// System.out.println(this.quizUtente.getRisposteDate().get(this.quizUtente.getQuiz().getDomande().get(this.i)));
		}

		if (radio2.isSelected()) {
			this.quizUtente.aggiungiRispostaMappa(this.quizUtente.getQuiz().getDomande().get(this.i),this.quizUtente.getQuiz().getDomande().get(this.i).getRisposte().get(2));
			// System.out.println(this.quizUtente.getRisposteDate().get(this.quizUtente.getQuiz().getDomande().get(this.i)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();
		if (this.i != this.quizUtente.getQuiz().getDomande().size() - 1) {
			if (src == this.buttonAvanti) {
				if (this.i != 2)
					this.setI(this.i + 1);
				else
					this.setI(0);

				this.setContentPane(creaPanel(this.i));
				this.invalidate();
				this.validate();
			}
		}

		if (this.i != 0) {
			if (src == this.buttonIndietro) {
				if (this.i != 0)
					this.setI(this.i - 1);
				else
					this.setI(this.quizUtente.getQuiz().getDomande().size() - 1);

				this.setContentPane(creaPanel(this.i));
				this.invalidate();
				this.validate();
			}
		}
		if (src == this.buttonTermina) {

			this.setVisible(false);

			this.quizUtente.risultatoQuiz();
			String messaggio = "";

			if (quizUtente.isSuperato())
				messaggio = "TEST SUPERATO!!! (Punteggio: " + quizUtente.getPunteggio() + ")";
			else
				messaggio = "TEST FALLITO!!! (Punteggio: " + quizUtente.getPunteggio() + ")";

			messaggio = messaggio + "\n\nRISPOSTE ESATTE:\n";

			for (Domanda domanda : this.quizUtente.getQuiz().getDomande()) {
				for (Risposta risposta : domanda.getRisposte()) {
					if (risposta.isEsatta()) {
						messaggio = messaggio + "DOMANDA: " + domanda.getDomanda() + "\nRISPOSTA: "
								+ risposta.getRisposta() + "\n";
						break;
					}
				}
			}

			messaggio = messaggio + "\nRISPOSTE DATE:\n";

			for (Domanda domanda : quizUtente.getQuiz().getDomande()) {
				if (this.quizUtente.getRisposteUtente().get(domanda) == null)
					messaggio = messaggio + "DOMANDA: " + domanda.getDomanda() + "\nRISPOSTA: Nessuna risposta data\n";
				else
					messaggio = messaggio + "DOMANDA: " + domanda.getDomanda() + "\nRISPOSTA: "
							+ this.quizUtente.getRisposteUtente().get(domanda) + "\n";
			}

			int result = JOptionPane.showConfirmDialog(this, messaggio, "Risultato Quiz", JOptionPane.DEFAULT_OPTION);
			if (result == JOptionPane.OK_OPTION)
				System.exit(0);

		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLabelNumeroDomanda() {
		return labelNumeroDomanda;
	}

	public void setLabelNumeroDomanda(JLabel labelNumeroDomanda) {
		this.labelNumeroDomanda = labelNumeroDomanda;
	}

	public JLabel getLabelTestoDomanda() {
		return labelTestoDomanda;
	}

	public void setLabelTestoDomanda(JLabel labelTestoDomanda) {
		this.labelTestoDomanda = labelTestoDomanda;
	}

	public JButton getButtonTermina() {
		return buttonTermina;
	}

	public void setButtonTermina(JButton buttonTermina) {
		this.buttonTermina = buttonTermina;
	}

	public JButton getButtonAvanti() {
		return buttonAvanti;
	}

	public void setButtonAvanti(JButton buttonAvanti) {
		this.buttonAvanti = buttonAvanti;
	}

	public JButton getButtonIndietro() {
		return buttonIndietro;
	}

	public void setButtonIndietro(JButton buttonIndietro) {
		this.buttonIndietro = buttonIndietro;
	}

	public QuizUtente getQuizUtente() {
		return quizUtente;
	}

	public void setQuizUtente(QuizUtente quizUtente) {
		this.quizUtente = quizUtente;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}