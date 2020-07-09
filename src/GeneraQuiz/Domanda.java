package GeneraQuiz;

import java.util.ArrayList;

public class Domanda {
	private String domanda;
	private ArrayList<Risposta> risposte;

	public Domanda(String domanda) {
		this.domanda = domanda;
		risposte = new ArrayList<Risposta>();
	}

	public int addRisposta(Risposta r) {
		int conteggioFalse = 0;
		
		for (Risposta rispostaEsistente : this.getRisposte()) {
			if (rispostaEsistente.equals(r))
				return 1;
			
			if (rispostaEsistente.isEsatta() && r.isEsatta())
				return 2;
			
            if (!rispostaEsistente.isEsatta())
                conteggioFalse++;
        }
        
        if (conteggioFalse == 2 && !r.isEsatta())
            return 3;
		
		this.getRisposte().add(r);
		return 0;
	}
	
	public int removeRisposta(Risposta r) {
		for (Risposta rispostaEsistente : this.getRisposte()) {
			if (rispostaEsistente.equals(r)) {
				this.getRisposte().remove(this.getRisposte().indexOf(rispostaEsistente));
				return 0;
			}
		}

		return 1;
	}

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public ArrayList<Risposta> getRisposte() {
		return risposte;
	}

	public void setRisposte(ArrayList<Risposta> risposte) {
		this.risposte = risposte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domanda == null) ? 0 : domanda.hashCode());
		result = prime * result + ((risposte == null) ? 0 : risposte.hashCode());
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
		Domanda other = (Domanda) obj;
		if (domanda == null) {
			if (other.domanda != null)
				return false;
		} else if (!domanda.equals(other.domanda))
			return false;
		if (risposte == null) {
			if (other.risposte != null)
				return false;
		} else if (!risposte.equals(other.risposte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Domanda [domanda=").append(domanda).append(", risposte=").append(risposte).append("]");
		return builder.toString();
	}
}
