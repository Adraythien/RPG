import java.util.Random;

public final class Utilities {
	
	private static Random gerador = new Random();
	
	
	public static int aleatorio(int inf, int sup){
		
		return  inf + gerador.nextInt((sup+1) - inf);
	}
	
	public static int aleatorio(Intervalo i){
		
		return i.getIntervaloInferior() +  gerador.nextInt((i.getIntervaloSuperior() + 1) - i.getIntervaloInferior());
	}
}

