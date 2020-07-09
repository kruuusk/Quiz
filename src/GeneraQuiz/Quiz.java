package GeneraQuiz;

import java.util.ArrayList;

public class Quiz {
	private ArrayList<Domanda> domande;
	private String codQuiz;
	private int tempoMax;

	public Quiz(String codQuiz, int tempoMax) {
		this.codQuiz = codQuiz;
		this.tempoMax = tempoMax;
		domande = new ArrayList<Domanda>();
	}

	public int addDomanda(Domanda d) {
		for (Domanda domandaEsistente : this.getDomande()) {
			if (domandaEsistente.equals(d))
				return 1;
		}

		this.getDomande().add(d);
		return 0;
	}
	
	public int removeDomanda(Domanda d) {
		for (Domanda domandaEsistente : this.getDomande()) {
			if (domandaEsistente.equals(d)) {
				this.getDomande().remove(this.getDomande().indexOf(domandaEsistente));
				return 0;
			}
		}

		return 1;
	}

	public void upDateQuiz() {

	}

	public void deleteQuiz() {

	}
	
	public Quiz getQuiz() {
		return new Quiz(codQuiz, tempoMax);
	}

	public ArrayList<Domanda> getDomande() {
		return domande;
	}

	public void setDomande(ArrayList<Domanda> domande) {
		this.domande = domande;
	}

	public String getCodQuiz() {
		return codQuiz;
	}

	public void setCodQuiz(String codQuiz) {
		this.codQuiz = codQuiz;
	}

	public int getTempoMax() {
		return tempoMax;
	}

	public void setTempoMax(int tempoMax) {
		this.tempoMax = tempoMax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codQuiz == null) ? 0 : codQuiz.hashCode());
		result = prime * result + ((domande == null) ? 0 : domande.hashCode());
		result = prime * result + tempoMax;
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
		Quiz other = (Quiz) obj;
		if (codQuiz == null) {
			if (other.codQuiz != null)
				return false;
		} else if (!codQuiz.equals(other.codQuiz))
			return false;
		if (domande == null) {
			if (other.domande != null)
				return false;
		} else if (!domande.equals(other.domande))
			return false;
		if (tempoMax != other.tempoMax)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quiz [domande=").append(domande).append(", codQuiz=").append(codQuiz).append(", tempoMax=")
				.append(tempoMax).append("]");
		return builder.toString();
	}

}
