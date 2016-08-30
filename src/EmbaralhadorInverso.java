
public class EmbaralhadorInverso implements Embaralhador {

	@Override
	public String palavraEmbaralhada(String str) {
		return new StringBuilder(str).reverse().toString();
	}

}
