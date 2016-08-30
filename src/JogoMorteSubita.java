
public class JogoMorteSubita extends Jogo {
	

	
	public JogoMorteSubita() {
		tentativas = 1;
	}
	
	@Override
	public boolean fimDoJogo() {
		if (tentativas <= 0 || level >= MecanicaDoJogo.levelParaConcluir) return true;
		return false;
	}

	@Override
	public void mensagemInicial() {
		System.out.println("\n>> JOGO MORTE SUBITA. Errou 1, perdeu. \n");
	}

}
