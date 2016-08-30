import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BancoDePalavras {
	
	private List<String> listaDePalavras ;
	private List<String> listaDePalavrasUsadas;
	
	public BancoDePalavras () {
		listaDePalavras = new ArrayList<String>();
		listaDePalavrasUsadas = new ArrayList<String>();
		abrirListaDePalavras();
	}
	
	
	
	private void abrirListaDePalavras() {
		try {
			FileReader file = new FileReader("Palavras.txt");
			BufferedReader lerArq = new BufferedReader(file);
			String linha = lerArq.readLine(); 
			while (linha != null) {
			  	if (linha.length()>0) {
			  		listaDePalavras.add(linha);
			  	}
				linha = lerArq.readLine();
			}
			file.close();
	    } catch (IOException e) {
	    	System.err.printf("Erro na abertura do arquivo: %s.\n",
	        e.getMessage());
	    	System.out.println("...............");
	    }
	}
	
	public String retornaPalavra () {
		int randomNum;
		Stream<String> filter;
		int r;
		do {
			randomNum = (int)(Math.random() * listaDePalavras.size());
			String palavra = listaDePalavras.get(randomNum);
			filter = listaDePalavrasUsadas.stream().filter(p -> p.equals(palavra));
			r = (int) filter.count();
		} while (r > 0);
		
		return listaDePalavras.get(randomNum);
	}
	
}
