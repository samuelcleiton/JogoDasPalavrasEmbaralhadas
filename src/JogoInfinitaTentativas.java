import java.util.Objects;

public class JogoInfinitaTentativas extends Jogo {

	private boolean _fimDoJogo;
	
	public JogoInfinitaTentativas() {
		_fimDoJogo = false;
	}
	
	@Override
	public boolean fimDoJogo() {
		return _fimDoJogo;
	}

	@Override
	public void mensagemInicial() {
		System.out.println("\n>> JOGO DAS infinitas TENTATIVAS \n");
	}
	
	@Override
	public void mensagemFinal() {
		if (level == MecanicaDoJogo.levelParaConcluir) {
			System.out.println("\n-Parabens, voce concluiu o jogo");
		} else {
			System.out.println("\n-Voce perdeu, tente novamente");
		}
		System.out.printf("-Pontuacao final: %d | Tentativas: %d \n\n", pontos, tentativas);	
	}
	
	@Override
	public void exibirPalavra() {
		MecanicaDoJogo.dificuldade dificuldade;
		if (level < 10) dificuldade = MecanicaDoJogo.dificuldade.Facil;
		else if (level < 20) dificuldade = MecanicaDoJogo.dificuldade.Medio;
		else  dificuldade = MecanicaDoJogo.dificuldade.Dificil;
		
		palavraAtual = bancoDePalavras.retornaPalavra();
		palavraEmbaralhada = FabricaEmbaralhadores.getPalavraEmbaralhada(palavraAtual, dificuldade);
		
		System.out.printf("Voce está no level %d. Voce tem %d pontos. \n", level, pontos);
		System.out.printf("Desembaralhe a seguinte palavra: %s | ou digite (0) para SAIR \n", palavraEmbaralhada);
	}
	
	
	@Override
	public void responder(String palavra) {
		if (Objects.equals(palavra, "0")) {
			_fimDoJogo = true;
		} else if (Objects.equals(palavra, palavraAtual)) {
			System.out.println("- ACERTOU");
			pontos += multiplicadorPontos();
			level++;
		} else {
			System.out.println("- ERROU");
			tentativas++;
		}
	}
	


}
