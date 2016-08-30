

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); 
		String escolha;
		
		do {
			System.out.println("\nEscolha o tipo de jogo:");
			System.out.println("(1) Jogo com 5 tentativas");
			System.out.println("(2) Jogo com Morte Subita");
			System.out.println("(3) Jogo com infintas tentativas");
			escolha = scan.nextLine();
			
			MecanicaDoJogo jogo = FabricaMecanicaDoJogo.criarJogo(Integer.parseInt(escolha));
			
			jogo.mensagemInicial();
			while (!jogo.fimDoJogo()) {
				jogo.exibirPalavra();
				String palavra = scan.nextLine();
				jogo.responder(palavra);
			}
			jogo.mensagemFinal();
			
			 System.out.println("Continue?[S/N]");
			
		} while (scan.hasNext() && (scan.nextLine().equalsIgnoreCase("s")));
		
		scan.close();
		
		System.out.println("\nFIM\n");
	}

}
