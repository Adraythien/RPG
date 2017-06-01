import java.util.ArrayList;

public class Jogo {

	public static void main(String[] args) {

		Mapa mapa = new Mapa();
		int aparecerloja = Utilities.aleatorio(0, 5);
		Jogador player = new Jogador();
		
		player.criaPersonagem();
		player.playerStats();
		
		
		boolean done = false;
		String  resp;
		Monstros monstros1 = new Monstros();
		Loja loja = new Loja();
		while(!done){
			System.out.println(aparecerloja);
			mapa.mostraPosJogador();
			int escolha = 0;
			
			System.out.println("*******MENU PRINCIPAL**1********");
			System.out.println("1-Mover  2-Descansar  3-Ver Estado  4- Ver Inventario 5-Sair");
			
			escolha = Input.lerInts();
			switch(escolha){
			
			case 1:
				
				mapa.moveJogador();
				mapa.mostraPosJogador();
				if(mapa.getpXPos()==1 && mapa.getpYPos()==1){
					System.out.println("Encontrou uma loja, deseja entrar?[Y,N]");
					Input.lerStrings();
					resp=Input.lerStrings();
									
					switch(resp)
					{	
					case "Y":
						loja.Stock();
						loja.Mostra();
						System.out.println("Escreva o nome do item que deseja comprar");
						resp=Input.lerStrings();
						loja.Comprar(resp,player);
						break;
						default: break;
					}
				}
				else{
				monstros1 = mapa.encontrosImediatos();
				
				if(monstros1 != null ){
					
					while(true){
						player.mostrapDanos();
						monstros1.mostraMDanos();
						
						//jogador ataca primeiro
						boolean foge = player.atacar(monstros1);
						
						if(foge){
							break;
						}
						
						if(monstros1.mMorreu()){
							player.vitoria(monstros1.getmExperienciaOferecida(),monstros1.getmCoinsOferecidas());
							player.mudaNivel();
							break;
						}
						
						monstros1.ataque(player);
						
						if(player.morreu()){
							
							player.gameover();
							done = true;
							break;
						}
					}
				}
				}
				break;
				
			case 2:
				monstros1 = mapa.encontrosImediatos();
				if(monstros1 != null ){
					
					while(true){
						
						player.mostrapDanos();
						monstros1.mostraMDanos();
						
						//jogador ataca primeiro
						boolean foge = player.atacar(monstros1);
						
						if(foge){
							break;
						}
						
						if(monstros1.mMorreu()){
							player.vitoria(monstros1.getmExperienciaOferecida(),monstros1.getmCoinsOferecidas());
							player.mudaNivel();
							break;
						}
						
						monstros1.ataque(player);
						
						if(player.morreu()){
							
							player.gameover();
							done = true;
							break;
						}
					}
				
				}
				player.descansar();
				break;
				
			case 3:
				
				player.playerStats();
				break;
			case 4:
				player.inv();
				break;
			case 5:
				
				done = true;
				Input.fechaStream();
				break;
			}	
			
		}
	}
		
	}

		

