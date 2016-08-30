

public interface MecanicaDoJogo {
	
	final static int levelParaConcluir = 20;
	
	enum dificuldade {Facil, Medio, Dificil};

	public boolean fimDoJogo();
	
	public void mensagemInicial();
	public void mensagemFinal();
	
	public void exibirPalavra();
	
	public void responder(String palavra);
	
	int multiplicadorPontos();
	
}
