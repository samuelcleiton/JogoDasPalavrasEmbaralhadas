import java.util.Objects;

public class JogoCincoTentativas extends Jogo {
	


	public JogoCincoTentativas() {
		tentativas = 5;
	}
	
	@Override
	public boolean fimDoJogo() {
		if (tentativas <= 0 || level >= MecanicaDoJogo.levelParaConcluir) return true;
		return false;
	}

	@Override
	public void mensagemInicial() {
		System.out.println("\n>> JOGO DAS 5 TENTATIVAS \n");
	}
	

	@Override
	public void responder(String palavra) {
		if (Objects.equals(palavra,palavraAtual)) {
			pontos += multiplicadorPontos();
			level++;
		} else {
			tentativas--;
		}
	}




	
}
