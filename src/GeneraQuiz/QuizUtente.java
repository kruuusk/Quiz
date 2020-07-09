package GeneraQuiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class QuizUtente {
	private HashMap<Domanda, Risposta> risposteUtente;
	private Quiz quiz;
	private Utente utente;
	private boolean superato;
	private int punteggio;
	private int tempo;

	public QuizUtente(Quiz quiz, Utente utente) {
		this.quiz = quiz;
		this.utente = utente;
		this.superato = false;
		this.punteggio = 0;
		this.risposteUtente = new HashMap<Domanda, Risposta>();
		for (Domanda domanda : quiz.getDomande()) {
			risposteUtente.put(domanda, null);
		}
	}

	public void scorriDomande(Quiz quiz) {

	}
	public void aggiungiRispostaMappa(Domanda d, Risposta r) {
    	this.risposteUtente.put(d, r);
    }
	public void iniziaQuiz() {
		Scanner scanner = new Scanner(System.in);
		Risposta risposta = null;
		for (int i = 0; i < quiz.getDomande().size(); i++) {
			System.out.println(quiz.getDomande().get(i).getDomanda());
			System.out.println("1." + quiz.getDomande().get(i).getRisposte().get(0).getRisposta());
			System.out.println("2." + quiz.getDomande().get(i).getRisposte().get(1).getRisposta());
			System.out.println("3." + quiz.getDomande().get(i).getRisposte().get(2).getRisposta());
			System.out.print("Digita 1, 2 o 3: ");
			String rispostaUtente = scanner.nextLine();
			if ("1".equals(rispostaUtente)) {
				risposta = quiz.getDomande().get(i).getRisposte().get(0);
			} else if ("2".equals(rispostaUtente)) {
				risposta = quiz.getDomande().get(i).getRisposte().get(1);
			} else if ("3".equals(rispostaUtente)) {
				risposta = quiz.getDomande().get(i).getRisposte().get(2);
			}
			risposteUtente.put(quiz.getDomande().get(i), risposta);
		}
		scanner.close();
		this.risultatoQuiz();
	}
		
	public void risultatoQuiz() {
		boolean esatto = false;
		Properties properties = new Properties();
    	
		FileInputStream ip = null;
		
		try {
			ip = new FileInputStream("C:\\Users\\andre\\Desktop\\andrea caretto\\workspace\\Quiz\\src\\GeneraQuiz\\properties.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			properties.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String punteggioMinimo = properties.getProperty("PUNTEGGIO_MINIMO");
		
    	for (Domanda domanda : quiz.getDomande()) {
			
			if (risposteUtente.get(domanda) == null) {
				esatto = false;
			} else {
				esatto = risposteUtente.get(domanda).isEsatta();
			} 
			if (esatto == true) {
				punteggio++;
			}
		}
		//System.out.println("Punteggio: " + punteggio);
		if (punteggio >= 18) {
			//System.out.println("Test Superato!!!");
			superato = true;
		} else {
			//System.out.println("Test Fallito!!!");
		}
	}

	public void terminaQuiz() {

	}

	public HashMap<Domanda, Risposta> getRisposteUtente() {
		return risposteUtente;
	}

	public void setRisposteUtente(HashMap<Domanda, Risposta> risposteUtente) {
		this.risposteUtente = risposteUtente;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public boolean isSuperato() {
		return superato;
	}

	public void setSuperato(boolean superato) {
		this.superato = superato;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + punteggio;
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result + ((risposteUtente == null) ? 0 : risposteUtente.hashCode());
		result = prime * result + (superato ? 1231 : 1237);
		result = prime * result + tempo;
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizUtente other = (QuizUtente) obj;
		if (punteggio != other.punteggio)
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (risposteUtente == null) {
			if (other.risposteUtente != null)
				return false;
		} else if (!risposteUtente.equals(other.risposteUtente))
			return false;
		if (superato != other.superato)
			return false;
		if (tempo != other.tempo)
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuizUtente [risposteUtente=").append(risposteUtente).append(", quiz=").append(quiz)
				.append(", utente=").append(utente).append(", superato=").append(superato).append(", punteggio=")
				.append(punteggio).append(", tempo=").append(tempo).append("]");
		return builder.toString();
	}
}
