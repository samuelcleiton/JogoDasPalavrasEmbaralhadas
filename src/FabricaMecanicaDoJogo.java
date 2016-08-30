
public class FabricaMecanicaDoJogo {
	public static MecanicaDoJogo criarJogo(int escolha) {
		MecanicaDoJogo jogo;
		switch (escolha) {
		case 1:
			jogo = new JogoCincoTentativas();
			break;
		case 2:
			jogo = new JogoMorteSubita();
			break;
		case 3:
			jogo = new JogoInfinitaTentativas();
			break;
		default:
			jogo = new JogoCincoTentativas();
			break;
		}
		return jogo;
	}
}
