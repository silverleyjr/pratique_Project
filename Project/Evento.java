public class Evento {
	String nomeDeEvento;
	String dataEvento;
	String horarioDoEvento;
	String cidadeDoEvento;
	String descricaoEvento;

	public Evento(String nome, String data, String horario, String cidade, String descricao) {
		nomeDeEvento = nome;
		dataEvento = data;
		horarioDoEvento = horario;
		cidadeDoEvento = cidade;
		descricaoEvento = descricao;
	}

	@Override
	public String toString() {
		return String.format(
				"\n%s | %s | %s | %s | %s", nomeDeEvento, dataEvento, horarioDoEvento, cidadeDoEvento,
				descricaoEvento);
	}

	public String getNomeDeEvento() {
		return nomeDeEvento;
	}

}
