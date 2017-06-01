import java.util.Scanner;

public final class Input {

	private static Scanner entrada = new Scanner(System.in);
	
	public static String lerStrings(){
		
		return entrada.nextLine();
	}
	
	public static int lerInts(){
		
		return entrada.nextInt();
	}
	
	public static void fechaStream(){
		
		entrada.close();
	}
}
