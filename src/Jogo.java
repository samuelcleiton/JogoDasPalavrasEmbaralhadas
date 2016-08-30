import java.util.Objects;

public abstract class Jogo implements MecanicaDoJogo {
	
	protected int pontos, tentativas, level;
	protected String palavraAtual, palavraEmbaralhada;
	protected BancoDePalavras bancoDePalavras;
	protected dificuldade dificuldade;
	
	public Jogo () {
		pontos = 0;
		level = 1;
		bancoDePalavras = new BancoDePalavras();
		dificuldade = MecanicaDoJogo.dificuldade.Facil;
	}
	
	@Override
	public abstract boolean fimDoJogo();

	@Override
	public abstract void mensagemInicial();

	@Override
	public void mensagemFinal() {
		if (level == MecanicaDoJogo.levelParaConcluir) {
			System.out.println("\n-Parabens, voce concluiu o jogo");
		} else {
			System.out.println("\n-Voce perdeu, tente novamente");
		}
		System.out.printf("-Pontuacao final: %d \n\n", pontos);	
	}

	@Override
	public void exibirPalavra() {
		MecanicaDoJogo.dificuldade dificuldade;
		if (level < 10) dificuldade = MecanicaDoJogo.dificuldade.Facil;
		else if (level < 20) dificuldade = MecanicaDoJogo.dificuldade.Medio;
		else  dificuldade = MecanicaDoJogo.dificuldade.Dificil;
		
		palavraAtual = bancoDePalavras.retornaPalavra();
		palavraEmbaralhada = FabricaEmbaralhadores.getPalavraEmbaralhada(palavraAtual, dificuldade);
		
		System.out.printf("Voce está no level %d, Restam %d tentativas. Voce tem %d pontos. \n", level, tentativas, pontos);
		System.out.printf("Desembaralhe a seguinte palavra: %s \n", palavraEmbaralhada);
	}


	@Override
	public void responder(String palavra) {
		if (Objects.equals(palavra,palavraAtual)) {
			System.out.println("- ACERTOU");
			pontos += multiplicadorPontos();
			level++;
		} else {
			System.out.println("- ERROU");
			tentativas--;
		}
	}

	@Override
	public int multiplicadorPontos() {
		int multiplicadorPontos = 0;
		if (dificuldade == MecanicaDoJogo.dificuldade.Facil) multiplicadorPontos = 10;
		else if (dificuldade == MecanicaDoJogo.dificuldade.Medio) multiplicadorPontos = 20;
		else if (dificuldade == MecanicaDoJogo.dificuldade.Dificil)multiplicadorPontos = 40;
		multiplicadorPontos += level;
		return multiplicadorPontos*10;
	}

}
