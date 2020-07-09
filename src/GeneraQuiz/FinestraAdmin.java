package GeneraQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class FinestraAdmin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel labelInserisciDomanda;
	private JLabel labelInserisciRisposte;
	private JTextField txtInsDomanda;
	private JTextField txtInsRisp1;
	private JTextField txtInsRisp2;
	private JTextField txtInsRisp3;
	private JButton buttonInserisci;
	private Quiz quiz;
	private JRadioButton radio0, radio1, radio2;
	
	public FinestraAdmin() {
		this.quiz = new Quiz("CD2345", 30);
		
		this.setContentPane(creaPanel());
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public JPanel creaPanel() {
		this.setTitle("Gestisci Archivio Quiz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		
		this.panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel.setLayout(null);
		
		this.labelInserisciDomanda = new JLabel();
		this.labelInserisciDomanda.setText("Inserire Nuova Domanda" );
		this.labelInserisciDomanda.setBounds(10, 11, 200, 30);
		
		this.txtInsDomanda = new JTextField();
		this.txtInsDomanda.setBounds(286, 11, 200, 30);
		
		this.labelInserisciRisposte = new JLabel();
		this.labelInserisciRisposte.setText("Inserire 1 risposta ESATTA e 2 risposte ERRATE" );
		this.labelInserisciRisposte.setBounds(10, 75, 270, 30);
		
		this.txtInsRisp1 = new JTextField();
		this.txtInsRisp1.setBounds(286, 75, 200, 30);
		
		this.txtInsRisp2 = new JTextField();
		this.txtInsRisp2.setBounds(286, 116, 200, 30);
		
		this.txtInsRisp3 = new JTextField();
		this.txtInsRisp3.setBounds(286, 157, 200, 30);
		
		this.radio0 = new JRadioButton();
		radio0.setBackground(SystemColor.activeCaption);
		this.radio0.setBounds(492, 83, 21, 15);

		this.radio1 = new JRadioButton();
		radio1.setBackground(SystemColor.activeCaption);
		this.radio1.setBounds(492, 125, 21, 15);

		this.radio2 = new JRadioButton();
		radio2.setBackground(SystemColor.activeCaption);
		this.radio2.setBounds(492, 165, 21, 15);
		
		this.buttonInserisci = new JButton("INSERISCI");
		this.buttonInserisci.setBounds(273, 234, 86, 20);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radio0);
		buttonGroup.add(radio1);
		buttonGroup.add(radio2);
		
		this.panel.add(labelInserisciDomanda);
		this.panel.add(txtInsDomanda);
		this.panel.add(labelInserisciRisposte);
		this.panel.add(txtInsRisp1);
		this.panel.add(txtInsRisp2);
		this.panel.add(txtInsRisp3);
		this.panel.add(radio0);
		this.panel.add(radio1);
		this.panel.add(radio2);
		this.panel.add(buttonInserisci);
		
		return this.panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
