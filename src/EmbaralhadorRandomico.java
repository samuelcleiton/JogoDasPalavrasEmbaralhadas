
public class EmbaralhadorRandomico implements Embaralhador {

	public String palavraEmbaralhada(String str) {
		
		char[] array = str.toCharArray();
		int n = array.length;
		for (int i = 0; i < array.length; i++) {
		    int random = i + (int) (Math.random() * (n - i));
		    int randomElement = array[random];
		    array[random] = array[i];
		    array[i] = (char) randomElement;
		}
		StringBuilder newStr = new StringBuilder("");
		for (char c : array) newStr.append(c);
		return newStr.toString();
		
	}


}
