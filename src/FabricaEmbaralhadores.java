
public class FabricaEmbaralhadores  {

	static Embaralhador embaralhador;
	
	public static String getPalavraEmbaralhada(String palavra,  MecanicaDoJogo.dificuldade dificuldade) {
		switch (dificuldade) {
		case  Facil:
			embaralhador = new EmbaralhadorInverso();
			break;
		case Medio:
			embaralhador = new EmbaralhadorOrdemAlfabetica();
			break;
		case Dificil:
			embaralhador = new EmbaralhadorRandomico();
			break;
		default:
			embaralhador = new EmbaralhadorInverso();
			break;
		}
		return embaralhador.palavraEmbaralhada(palavra);
	}
	
	
}
