import java.util.Arrays;

public class EmbaralhadorOrdemAlfabetica implements Embaralhador {

	@Override
	public String palavraEmbaralhada(String str) {
		char newStr[] = str.toCharArray();
		Arrays.sort(newStr);
		return newStr.toString();
	}

}
