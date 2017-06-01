import java.lang.reflect.Array;
import java.util.ArrayList;

public class Jogador {

	
	private String pNome;
	private String pClasse;
	private int pHabilidade;
	private int pDanos;
	private int pCoins;
	
	private int pMagicPoints;
	private int pMaxMagicPoints;
	private int pMaxDanos;
	private int pExperiencia;
	
	//n�mero de pontos necess�rios para passar ao pr�ximo n�vel
	private int pNextLevel;
	private int pLevel;
	
	private int pEscudo;
	private Armas pArma;
	ArrayList<Item> inventario;
	Racas raca = new Racas();
	Mapa map= new Mapa();
	
	Jogador(){
		
		pNome = "Desconhecido";
		pClasse = "Desconhecido";
		pHabilidade = 0;
		pDanos = 0;
		pMaxDanos = 0;
		pExperiencia = 0;
		pNextLevel = 0;
		pLevel = 0;
		pEscudo = 0;
		pCoins=0;
		inventario = new ArrayList<>();
		pArma = new Armas();
		pArma.setNome("Desconhecida");
		pArma.intervaloDanos.setIntervaloInferior(0);
		pArma.intervaloDanos.setIntervaloSuperior(0);
				
	}
	
	public boolean morreu(){
		
		return pDanos <= 0; 
	}
	
	
	public int getEscudo(){
		
		return pEscudo;
	}

	public void atingido(int totalDanos) {
		
		pDanos -= totalDanos;
	}
	
	public void criaPersonagem(){
		
		System.out.println("******************CRIA��O DA PERSONAGEM**************");
		System.out.println("*****************************************************");
		
		
		System.out.print("Insira o nome da sua personagem de jogo:");
		pNome = Input.lerStrings();	
		
		
		System.out.println("Escolha a ra�a: (1-An�o 2-Humano 3-Elfo 4-Troll 5-Ver Especifica��es)");
		int op = Input.lerInts();
		if(op==5){
			raca.Specs();
			System.out.println("Escolha a ra�a: (1-An�o 2-Humano 3-Elfo 4-Troll 5-Ver Especifica��es)");
			int op2 = Input.lerInts();
			raca.escolherRaca(op2);
		}
		else{
			raca.escolherRaca(op);
		}
	
		
		System.out.println("Escolha com quem quer jogar(1-Guerreiro  2-Feiticeiro  3-Padre  4-Ladr�o):");
		int personagem = Input.lerInts();
		
		switch(personagem){
		
		
		case 1:	
				
				pClasse = "Guerreiro";
				pHabilidade = 10;
				pDanos = 20;
				pMaxDanos = 20;
				pMagicPoints=10;
				pMaxMagicPoints=15;
				pExperiencia = 0;
				pNextLevel = 1000;
				pLevel = 1;
				pEscudo = 4;
				pArma.setNome("Espada Longa");
				pArma.intervaloDanos.setIntervaloInferior(1);
				pArma.intervaloDanos.setIntervaloSuperior(8);
				break;
			
		case 2:
			
			pClasse = "Feiticeiro";
			pHabilidade = 5;
			pDanos = 10;
			pMaxDanos = 10;
			pMagicPoints=20;
			pMaxMagicPoints=20;
			pExperiencia = 0;
			pNextLevel = 1000;
			pLevel = 1;
			pEscudo = 1;
			pArma.setNome("P� M�gico");
			pArma.intervaloDanos.setIntervaloInferior(1);
			pArma.intervaloDanos.setIntervaloSuperior(4);
			break;
			
		case 3:
			
			pClasse = "Padre";
			pHabilidade = 0;
			pDanos = 15;
			pMaxDanos = 15;
			pMagicPoints = 15;
			pMaxMagicPoints=15;
			pExperiencia = 0;
			pNextLevel = 1000;
			pLevel = 1;
			pEscudo = 3;
			pArma.setNome("Biblia");
			pArma.intervaloDanos.setIntervaloInferior(1);
			pArma.intervaloDanos.setIntervaloSuperior(6);
			break;
			
		case 4:
			
			pClasse = "Ladr�o";
			pHabilidade = 7;
			pDanos = 12;
			pMaxDanos = 12;
			pMagicPoints = 5;
			pMaxMagicPoints=5;
			pExperiencia = 0;
			pNextLevel = 1000;
			pLevel = 1;
			pEscudo = 2;
			pArma.setNome("Faca da Cozinha");
			pArma.intervaloDanos.setIntervaloInferior(1);
			pArma.intervaloDanos.setIntervaloSuperior(6);
			break;
			
		default:
			
			pClasse = "Ladr�o";
			pHabilidade = 7;
			pDanos = 12;
			pMaxDanos = 12;
			pMagicPoints = 5;
			pMaxMagicPoints=5;
			pExperiencia = 0;
			pNextLevel = 1000;
			pLevel = 1;
			pEscudo = 2;
			pArma.setNome("Faca da Cozinha");
			pArma.intervaloDanos.setIntervaloInferior(1);
			pArma.intervaloDanos.setIntervaloSuperior(6);
			break;
		}
		
		
		this.pHabilidade += raca.getrHabilidade();
		this.pDanos += raca.getrDanos();
		this.pMaxDanos += raca.getrMaxDanos();
		this.pEscudo += raca.getrEscudo();
		
		
	}
	
	public boolean atacar(Monstros monstro){
		
		int escolha = 1;
		int escolha2=1;
		int escolha3=1;
		
		Spell pSpell = null;
		
		System.out.print("1)Atacar   2)Fugir :");
		escolha = Input.lerInts();
		
		switch(escolha){
		
		case 1:
			System.out.println("Escolheu atacar um " + monstro.getmNome() + ", Escolha '1' para atacar com a arma " + pArma.getNome()+" ou '2' com o spell ");
			escolha2 = Input.lerInts();
			
			switch (escolha2){// switch(2)
			case 1:							//Escolheu atacar com arma
				System.out.println("Escolheu atacar um " + monstro.getmNome() + "com a "+pArma.getNome());
				if(Utilities.aleatorio(0, 20) < pHabilidade){
				
				int danos = Utilities.aleatorio(pArma.intervaloDanos);
				
				int danosTotais = danos - monstro.getmEscudo();
				
				if(danosTotais <= 0 ){
					
					System.out.println("O seu ataque n�o teve consequ�ncias!!!");
				}
				
				else {
					
					System.out.println("O ataque provocou " + danosTotais + " de dano!" + "ao " + monstro.getmNome() + ".");
					monstro.atingido(danosTotais);
					
				}
				
			}
			else{
				
				System.out.println("FALHOU!!!");
			}
				break;// switch(2)
			case 2:
										// Escolheu atacar com Spell
				System.out.println("Escolheu atacar um " + monstro.getmNome() + "com um spell"+"\n");
				if (pClasse=="Guerreiro"){
				pSpell = new Spell (new StringBuilder ("Spin"),5, 2, 2,0 );
				
				System.out.println("Escolha o Spell que pretende, 1-Spin 2-Espada M�gica");
				escolha3 = Input.lerInts();
				
				switch(escolha3){ // switch(3)
				case 1:
					pSpell = new Spell (new StringBuilder ("Spin"),2, 5, 2,0 );
					if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
						
						int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
						
						int danosTotais = danos - monstro.getmEscudo();
						
						if(danosTotais <= 0 ){
							
							System.out.println("O seu Spell n�o teve consequ�ncias!!!");
						}
						
						else {
							pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
							System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
							System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de Mana");
							System.out.print("Neste momento tem "+pMagicPoints);
							monstro.atingido(danosTotais);
						}
						
					}
					else{
						
						System.out.println("FALHOU!!!");
					}
						
						break;// switch(3)
				case 2:
					pSpell = new Spell (new StringBuilder ("Espada M�gica"),3, 6, 3,0);
					if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
						
						int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
						
						int danosTotais = danos - monstro.getmEscudo();
						
						if(danosTotais <= 0 ){
							
							System.out.println("O seu Spell n�o teve consequ�ncias!!!");
						}
						
						else {
							pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
							System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
							System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de Mana");
							System.out.print("Neste momento tem "+pMagicPoints);
							monstro.atingido(danosTotais);
						}
						
					}
					else{
						
						System.out.println("FALHOU!!!");
					}
					break;// switch(3)
					}
				
				return false;
				}
				else if(pClasse=="Feiticeiro") {
					
					System.out.println("Escolha o Spell que pretende, 1-Missil M�gico 2-Bola de Fogo");
					escolha3 = Input.lerInts();
					
					switch(escolha3){
					case 1:
						pSpell = new Spell (new StringBuilder ("M�ssil M�gico"),10, 15, 15,0 );
						if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
							
							int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
							
							int danosTotais = danos - monstro.getmEscudo();
							
							if(danosTotais <= 0 ){
								
								System.out.println("O seu Spell n�o teve consequ�ncias!!!");
							}
							
							else {
								pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
								System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
								System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de Mana");
								System.out.print("Neste momento tem "+pMagicPoints);
								monstro.atingido(danosTotais);
								
								
							}
							
						}
						else{
							
							System.out.println("FALHOU!!!");
						}
							
							break;// switch(3)
					case 2:
						pSpell = new Spell (new StringBuilder ("Bola de Fogo"),12, 18, 20,0 );
						if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
							
							int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
							
							int danosTotais = danos - monstro.getmEscudo();
							
							if(danosTotais <= 0 ){
								
								System.out.println("O seu Spell n�o teve consequ�ncias!!!");
							}
							
							else {
								pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
								System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
								System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de Mana.");
								System.out.print(" Neste momento tem "+pMagicPoints+" de mana");
								monstro.atingido(danosTotais);
								
								
							}
							
						}
						else{
							
							System.out.println("FALHOU!!!");
						}
						break;// switch(3)
						}
					
					return false;
				}
				else if(pClasse=="Padre") {
					System.out.println("Escolha o Spell que pretende, 1-Biblia Fant�stica 2-Curar");
					escolha3 = Input.lerInts();
					
					switch(escolha3){
					case 1:
						pSpell = new Spell (new StringBuilder ("Biblia Fant�stica"),12, 18, 20,0 );
						if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
							
							int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
							
							int danosTotais = danos - monstro.getmEscudo();
							
							if(danosTotais <= 0 ){
								
								System.out.println("O seu Spell n�o teve consequ�ncias!!!");
							}
							
							else {
								pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
								System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
								System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de mana.");
								System.out.print(" Neste momento tem "+pMagicPoints+" de mana");
								monstro.atingido(danosTotais);
							}
						}
						else{
							
							System.out.println("FALHOU!!!");
						}
							break;// switch(3)
					case 2:
						pSpell = new Spell (new StringBuilder ("Curar"),3, 5, 10,8 );
						if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
							
							int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
							int danosTotais = danos - monstro.getmEscudo();
							int curar=pSpell.getfVida();
							pDanos+=curar;
							if(danosTotais <= 0 ){
								
								System.out.println("O seu Spell n�o teve consequ�ncias!!!");
							}
							
							else {
								pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
								System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
								System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de mana.");
								System.out.print(" Neste momento tem "+pMagicPoints+" de mana.");
								System.out.print(" Neste momento tem "+pDanos+" de vida");
								monstro.atingido(danosTotais);
							}
							
						}
						else{
							
							System.out.println("FALHOU!!!");
						}
						break;// switch(3)
						}
					
					return false;
				}
				else if(pClasse=="Ladr�o") {
					System.out.println("Escolha o Spell que pretende, 1-Facalhao do Talho 2-Roubar");
					escolha3 = Input.lerInts();
					
					switch(escolha3){
					case 1:
						pSpell = new Spell (new StringBuilder ("Facalhao do Talho"),5, 10, 5,0 );
						if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
							
							int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
							
							int danosTotais = danos - monstro.getmEscudo();
							
							if(danosTotais <= 0 ){
								
								System.out.println("O seu Spell n�o teve consequ�ncias!!!");
							}
							
							else {
								pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
								System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
								System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de mana.");
								System.out.print(" Neste momento tem "+pMagicPoints+" de mana");
								monstro.atingido(danosTotais);

							}
							
						}
						else{
							
							System.out.println("FALHOU!!!");
						}
							
							break;// switch(3)
					case 2:
						pSpell = new Spell (new StringBuilder ("Ataque Critico"),10, 13, 10,0);
						if(Utilities.aleatorio(0, 20) < pSpell.getfPontosMagicosNecessarios() ){
							
							int danos = Utilities.aleatorio(pSpell.fDanos.getIntervaloInferior(),pSpell.fDanos.getIntervaloSuperior());
							
							int danosTotais = danos - monstro.getmEscudo();
							
							if(danosTotais <= 0 ){
								
								System.out.println("O seu Spell n�o teve consequ�ncias!!!");
							}
							
							else {
								pMagicPoints-=pSpell.getfPontosMagicosNecessarios();
								System.out.println("O ataque provocou " + danosTotais + " de dano!" + " Ao " + monstro.getmNome() + ".");
								System.out.print("Perdeu "+ pSpell.getfPontosMagicosNecessarios()+" de mana.");
								System.out.print(" Neste momento tem "+pMagicPoints+" de mana");
								monstro.atingido(danosTotais);
							}	
						}
						else{
							
							System.out.println("FALHOU!!!");
						}
						break;// switch(3)
						}
					
					return false;
				}
			}
			break;//switch(2)
			
		case 2:
			/*Se o jogador escolher fugir ir� ser gerado um aleat�rio baseado em 25% de possibilidades de fugir*/
			
			int fugir = Utilities.aleatorio(1, 4);
			
			if(fugir == 1){
				
				System.out.println("UFA! Conseguiu fugir.");
	
				return true;
			}
			
			else{
				
				System.out.println("N�o conseguiu fugir!");
				break;// switch(2)
			}
		}// switch(1)
		
		return false;
	}
	
	public void mudaNivel(){
		
		if(pExperiencia >= pNextLevel){
			
			System.out.println("PARAB�NS! Subiu um nivel...");
			pLevel++;
			pNextLevel = pLevel * pLevel * 1000;
			
			//Aumenta aleat�riamente as caracterirsticas
			pHabilidade += Utilities.aleatorio(1, 3);
			pMaxDanos += Utilities.aleatorio(2, 6);
			pEscudo += Utilities.aleatorio(1, 2);
			
			pDanos = pMaxDanos;
		}
		else if (pClasse=="Feiticeiro"){
			pHabilidade += Utilities.aleatorio(1, 3);
			pMaxDanos += Utilities.aleatorio(2, 6);
			pEscudo += Utilities.aleatorio(1, 2);
			pMaxMagicPoints += Utilities.aleatorio(5, 9);
			pDanos = pMaxDanos;
		}
		else if (pClasse=="Padre"){
			pHabilidade += Utilities.aleatorio(1, 3);
			pMaxDanos += Utilities.aleatorio(2, 6);
			pEscudo += Utilities.aleatorio(1, 2);
			pMaxMagicPoints += Utilities.aleatorio(4, 7);
			pDanos = pMaxDanos;
		}
		else if (pClasse=="Ladr�o"){
			pHabilidade += Utilities.aleatorio(1, 3);
			pMaxDanos += Utilities.aleatorio(2, 6);
			pEscudo += Utilities.aleatorio(1, 2);
			pMaxMagicPoints += Utilities.aleatorio(2,4);
			pDanos = pMaxDanos;
		}
	}
	
	public void descansar(){
		System.out.println("A descansar!! Diminuem os danos...");
		pDanos = pMaxDanos;
	}
	public void inv(){
		String resp;
		for(int i=0;i<inventario.size();i++){
			System.out.println("Nome: "+(inventario.get(i).getNome()+" Descricao: "+inventario.get(i).getDescricao()+"Ataque: "+inventario.get(i).getAtaque()+" Vida: +"+inventario.get(i).getVida()+" Escudo : "+inventario.get(i).getpEscudo()+" Pre�o: "+inventario.get(i).getCoins()));
		}
		System.out.println("Escreva o item que deseja equipar");
		Input.lerStrings();
		resp=Input.lerStrings();
		for(int i=0;i<inventario.size();i++)
        {   
           if(inventario.get(i).getNome().equals(resp))
           {
           	setpDanos(getpDanos()+inventario.get(i).getAtaque());
           	setpMaxDanos(getpMaxDanos()+inventario.get(i).getVida());
           	setpEscudo(getEscudo()+inventario.get(i).getpEscudo());
           	inventario.remove(i);
           }
        }		
	}
	public void playerStats(){
		
		System.out.println("***********************PLAYER STATS*********************");
		System.out.println("********************************************************");
		
		System.out.println("Nome: "+pNome);
		System.out.println("Ra�a: "+raca.getrNome());
		System.out.println("Classe: "+pClasse);
		System.out.println("Habilidade: "+pHabilidade);
		System.out.println("Mana: "+pMagicPoints);
		System.out.println("Danos: "+pDanos);
		System.out.println("Valor M�ximo de Danos: "+pMaxDanos);
		System.out.println("Experi�ncia: "+pExperiencia);
		System.out.println("Experi�ncia necess�ria para evoluir: "+pNextLevel);
		System.out.println("N�vel Actual: "+pLevel);
		System.out.println("Escudo: "+pEscudo);
		System.out.println("Nome: "+pNome);
		System.out.println("Arma: "+pArma.getNome());
		System.out.println("Range da arma: ["+pArma.intervaloDanos.getIntervaloInferior()+","+pArma.intervaloDanos.getIntervaloSuperior()+"]");
		System.out.println("Coins: "+pCoins);
		System.out.println("==========================================================");
	}
	
	
	/**Depois da vit�ria na batalha*/
	public void vitoria(int xp,int gold){
		
		System.out.println("Venceu a batalha");
		System.out.println("Ganhou " + xp + " pontos de experi�ncia.");
		System.out.println("Ganhou "+gold+" coins.");
		
		pCoins +=gold;
		pExperiencia += xp;
	}
	
	public int getpHabilidade() {
		return pHabilidade;
	}

	public void setpHabilidade(int pHabilidade) {
		this.pHabilidade = pHabilidade;
	}

	public int getpDanos() {
		return pDanos;
	}

	public void setpDanos(int pDanos) {
		this.pDanos = pDanos;
	}

	public int getpMagicPoints() {
		return pMagicPoints;
	}

	public void setpMagicPoints(int pMagicPoints) {
		this.pMagicPoints = pMagicPoints;
	}

	public int getpMaxMagicPoints() {
		return pMaxMagicPoints;
	}

	public void setpMaxMagicPoints(int pMaxMagicPoints) {
		this.pMaxMagicPoints = pMaxMagicPoints;
	}

	public int getpMaxDanos() {
		return pMaxDanos;
	}

	public void setpMaxDanos(int pMaxDanos) {
		this.pMaxDanos = pMaxDanos;
	}

	public int getpEscudo() {
		return pEscudo;
	}

	public void setpEscudo(int pEscudo) {
		this.pEscudo = pEscudo;
	}

	public Armas getpArma() {
		return pArma;
	}

	public void setpArma(Armas pArma) {
		this.pArma = pArma;
	}

	/**Jogador morre em batalha*/
	public void gameover(){
		
		System.out.println("MORREU NA BATALHA! IREMOS ENVIAR AS CONDOL�NCIAS � FAMILIA");
		System.out.println("******************GAME OVER*******************************");
		System.out.println("Pressione q");
		
	}
	
	public void mostrapDanos(){
		
		System.out.println("O " + pNome+" tem " + pDanos);
	}
	public int getpCoins() {
		return pCoins;
	}

	public void setpCoins(int pCoins) {
		this.pCoins = pCoins;
	}

}