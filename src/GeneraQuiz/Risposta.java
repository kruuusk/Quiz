package GeneraQuiz;

public class Risposta {
	private String risposta;
	private boolean esatta;

	public Risposta(String risposta, boolean esatta) {
		this.risposta = risposta;
		this.esatta = esatta;
	}

	public void upDateRisposta(Risposta vecchiaRisposta, String nuovaRisposta, boolean nuovaEsatta) {
		
	}

	public void deleteRisposta() {

	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public boolean isEsatta() {
		return esatta;
	}
	public void setEsatta(boolean esatta) {
		this.esatta = esatta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (esatta ? 1231 : 1237);
		result = prime * result + ((risposta == null) ? 0 : risposta.hashCode());
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
		Risposta other = (Risposta) obj;
		if (esatta != other.esatta)
			return false;
		if (risposta == null) {
			if (other.risposta != null)
				return false;
		} else if (!risposta.equals(other.risposta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Risposta [risposta=").append(risposta).append(", esatta=").append(esatta).append("]");
		return builder.toString();
	}
}
