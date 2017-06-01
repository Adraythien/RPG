import java.util.ArrayList;
import java.util.Random;

public class Mapa {
	
	private int pXPos;
	private int pYPos;
	
	Mapa(){
		
		pXPos = 0;
		pYPos = 0;	
	}

	public int getpXPos() {
		return pXPos;
	}

	public int getpYPos() {
		return pYPos;
	}
	
	public void moveJogador(){
		
		int escolha = 1;
		
		
		System.out.println("1-Norte   2-Este   3-Sul   4-Oeste");
		escolha = Input.lerInts();
		
		switch(escolha){
		
		case 1:
			pYPos++;
			break;
		
		case 2:
			pXPos++;
			break;
			
		case 3:
			pYPos--;
			break;
			
		default:
			pXPos--;
			break;
		}
	}
	
	/**Encontros imediatos*/
	
	public Monstros encontrosImediatos(){
		int roll = Utilities.aleatorio(0, 20);
		
		
		Monstros monstro = null;
		
		
		
		//se roll for 5 não apareceu nenhum monstro logo monstro continua null
		if(roll >=6 && roll <=15){
			monstro = new Monstros(new StringBuilder("Lesma"), 2, 1, 10, 0, "Lentidao", 1, 3, Utilities.aleatorio(1, 10));
			System.out.println("Encontrou uma Lesma, prepare-se para a batalha!!!");
		}
		if(roll >= 6 && roll <= 10){
			monstro = new Monstros(new StringBuilder("Orc"), 10, 8, 200, 1, "Pequena Espada", 2, 7, Utilities.aleatorio(30, 70));
			System.out.println("Encontrou um ORC, prepare-se para a batalha!!!");
		}
		
		else if(roll >= 11 && roll <= 15){
			
			monstro = new Monstros(new StringBuilder("Goblin"), 6, 6, 100, 0,"Punhal", 1, 5, Utilities.aleatorio(15, 75));
			System.out.println("Encontrou um GOBLIN, prepare-se para a batalha!!!");
		}
		
		else if(roll >= 16 && roll <= 19){
			
			monstro = new Monstros(new StringBuilder("Ogre"), 20, 12, 500, 2, "Machado", 3, 8, Utilities.aleatorio(65, 125));
			System.out.println("Encontrou um OGRE, prepare-se para a batalha!!!");
		}
		
		else if(roll == 20){
			
			monstro = new Monstros(new StringBuilder("Lord Ocre"), 25, 15, 2000, 5, "Raio Laser", 5, 20, Utilities.aleatorio(120, 200));
			System.out.println("Encontrou um LORD OCRE, prepare-se para a batalha!!!");
		}
		
			
		return monstro;
	}
	

	
public Monstros encontrosImediatosD(){
		
		int roll = Utilities.aleatorio(0, 20);
		
		
		Monstros monstro = null;
		
		//se roll for 5 não apareceu nenhum monstro logo monstro continua null
		
		if(roll >= 1 && roll <= 5){
			
			monstro = new Monstros(new StringBuilder("Orc"), 10, 8, 200, 1, "Pequena Espada", 2, 7, Utilities.aleatorio(30, 70));
			System.out.println("Encontrou um ORC, prepare-se para a batalha!!!");
		}
		
		else if(roll >= 6 && roll <= 10){
			
			monstro = new Monstros(new StringBuilder("Goblin"), 6, 6, 100, 0,"Punhal", 1, 5, Utilities.aleatorio(15, 75));
			System.out.println("Encontrou um GOBLIN, prepare-se para a batalha!!!");
		}
		
		return monstro;
	}
	
	public void mostraPosJogador(){
		
		System.out.println("Posição actual do jogador: [" + pXPos + "," + pYPos + "]");
	}

}
