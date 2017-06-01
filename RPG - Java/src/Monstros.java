import java.util.ArrayList;

public class Monstros {
	
	private StringBuilder mNome = new StringBuilder();
	private int mDanos;
	private int mHabilidade;
	private int mExperienciaOferecida;
	private int mEscudo;
	private int mCoinsOferecidas;
	private Armas mArma;
	
	Monstros(StringBuilder nome, int vidas, int habilidade, int experiencia, int escudo, String nomeArma, int danoInf, int danoSup, int coins){
		
		mNome.append(nome);
		mDanos = vidas;
		mHabilidade = habilidade;
		mExperienciaOferecida = experiencia;
		mEscudo = escudo;
		mCoinsOferecidas= coins;
		
		mArma = new Armas();
		mArma.setNome(nomeArma);
		mArma.intervaloDanos.setIntervaloInferior(danoInf);
		mArma.intervaloDanos.setIntervaloSuperior(danoSup);
	}
	private static ArrayList<Monstros>Monstros1;
	Monstros(){
		Monstros1 =new ArrayList<>();
		Monstros a = new Monstros(new StringBuilder("Lesma"), 2, 1, 10, 0, "Lentidao", 1, 3, Utilities.aleatorio(1, 10));
		Monstros b = new Monstros(new StringBuilder("Orc"), 10, 8, 200, 1, "Pequena Espada", 2, 7, Utilities.aleatorio(30, 70));
		Monstros c = new Monstros(new StringBuilder("Goblin"), 6, 6, 100, 0,"Punhal", 1, 5, Utilities.aleatorio(15, 75));
		Monstros d = new Monstros(new StringBuilder("Ogre"), 20, 12, 500, 2, "Machado", 3, 8, Utilities.aleatorio(65, 125));
		Monstros e = new Monstros(new StringBuilder("Lord Ocre"), 25, 15, 2000, 5, "Raio Laser", 5, 20, Utilities.aleatorio(120, 200));
		Monstros1.add(a);
		Monstros1.add(b);
		Monstros1.add(c);
		Monstros1.add(d);
		Monstros1.add(e);
	}

		
		
	
	/**retorna true se o monstro já morreu*/
	/**o monstro morre quando mDanos <= 0*/
	
	public boolean mMorreu(){
		
		return mDanos <= 0;
	}

	public StringBuilder getmNome() {
		return mNome;
	}
	
	public int getmCoinsOferecidas() {
		return mCoinsOferecidas;
	}

	public int getmExperienciaOferecida() {
		return mExperienciaOferecida;
	}

	public int getmEscudo() {
		return mEscudo;
	}
	
	public void ataque(Jogador jogador){
		
		StringBuilder texto = new StringBuilder();
		texto.append("Está a ser atacado por um " + mNome + " com um(a) " + mArma.getNome() );
		System.out.println(texto);
		texto.setLength(0);
		
		if(Utilities.aleatorio(0, 20) < mHabilidade){
			
			int danos = Utilities.aleatorio(mArma.intervaloDanos);
			
			int totalDanos = danos - jogador.getEscudo();
			
			if(totalDanos <= 0){
				
				texto.append("O ataque do monstro não penetrou no seu escudo!");
				System.out.println("texto");
			}
			
			else{
				
				texto.append("Foi atingido em " +totalDanos +" de dano!");
				System.out.println(texto);
				jogador.atingido(totalDanos);
			}
			
		}
		
		else{
			
			texto.append("O " + mNome + " falhou!");
			System.out.println(texto);
		}
	}
	
	public void atingido(int danos){
		
		mDanos -= danos;
	}
	
	/**Mostra para output os danos que o monstro ainda tem*/
	/**Será mostrado durante as batalhas*/
	
	public void mostraMDanos(){
		
		System.out.println(new StringBuilder(mNome + ": " + mDanos));
	}
}

