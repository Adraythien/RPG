public class Racas {
	
	private String rNome;
	private int rRaça;
	private int rHabilidade;
	private int rDanos;
	private int rMaxDanos;
	private int rEscudo;
	
	Racas(){
		
		rNome = "Desconhecido";		
		rHabilidade = 0;
		rDanos = 0;
		rMaxDanos = 0;		
		rEscudo = 0;
			
	}
	
	public int escolherRaca(int n)
	{
	
		switch(n)
		{
		
		case 1:
			Anao();
			
			break;
		case 2:
			Humano();
			
			break;
		case 3:
			Elfo();
			
			break;
		case 4:
			Troll();
			
			break;
	
		default : Humano(); break;
		}
	
	
		return rRaça;
	}
	
	
	
	
	public void Anao()
	{
		
		rNome = "Anão";
		rHabilidade = 3;
		rDanos = 5;
		rMaxDanos = 3;
		rEscudo = 20;
	}
	
	public void Humano()
	{
		rNome = "Humano";
		rHabilidade = 7;
		rDanos = 7;
		rMaxDanos = 7;		
		rEscudo = 7;
	}
	
	public void Elfo()
	{
		rNome = "Elfo";
		rHabilidade = 12;
		rDanos = 12;
		rMaxDanos = 15;			
		rEscudo = 3;
	}
	
	public void Troll()
	{
		rNome="Troll";
		rHabilidade=10;
		rDanos=16;
		rMaxDanos=25;
		rEscudo=0;
	}
	public void Specs()
	{
		System.out.println("---------------");
		System.out.println("Anão");
		System.out.println("Habilidade:3");
		System.out.println("Danos:5");
		System.out.println("MaxDanos:3");
		System.out.println("Escudo:3");
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("Humano");
		System.out.println("Habilidade:7");
		System.out.println("Danos:7");
		System.out.println("MaxDanos:7");
		System.out.println("Escudo:7");
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("Elfo");
		System.out.println("Habilidade:12");
		System.out.println("Danos:12");
		System.out.println("MaxDanos:15");
		System.out.println("Escudo:3");
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("Troll");
		System.out.println("Habilidade:10");
		System.out.println("Danos:16");
		System.out.println("MaxDanos:25");
		System.out.println("Escudo:0");
		System.out.println("---------------");
	}
	
		public String getrNome() {
		return rNome;
	}


	public int getrRaça() {
		return rRaça;
	}


	public int getrHabilidade() {
		return rHabilidade;
	}


	public int getrDanos() {
		return rDanos;
	}


	public int getrMaxDanos() {
		return rMaxDanos;
	}

	public int getrEscudo() {
			return rEscudo;
		}

	public void setrNome(String rNome) {
		this.rNome = rNome;
	}

	public void setrRaça(int rRaça) {
		
		this.rRaça = rRaça;
		
	}

	public void setrHabilidade(int rHabilidade) {
		this.rHabilidade = rHabilidade;
	}

	public void setrDanos(int rDanos) {
		this.rDanos = rDanos;
	}

	public void setrMaxDanos(int rMaxDanos) {
		this.rMaxDanos = rMaxDanos;
	}

	public void setrEscudo(int rEscudo) {
		this.rEscudo = rEscudo;
	}
	

}
