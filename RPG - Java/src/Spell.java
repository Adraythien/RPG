
public class Spell {
	
	private StringBuilder fNome;
	public Intervalo fDanos = new Intervalo(); //o intervalo de dano que o feiti�o vai infligir no inimigo
	private int fVida=0;
	
	private int fPontosMagicosNecessarios; //pontos m�gicos minimos para executar
	
	
	public int getfPontosMagicosNecessarios() {
		return fPontosMagicosNecessarios;
	}
	
	public StringBuilder getfNome() {
		return fNome;
	}
	
	public void setfNome(StringBuilder fNome) {
		this.fNome = fNome;
	}
	
	public void setfPontosMagicosNecessarios(int fPontosMagicosNecessarios) {
		this.fPontosMagicosNecessarios = fPontosMagicosNecessarios;
	}
	
	public void setfVida(int fVida) {
		this.fVida = fVida;
	}
	
	public int getfVida() {
		return fVida;
	}
	//Construtor 
	Spell(StringBuilder nome,int danosinf, int danossup,int pontosmagicosnecessarios,int vida){
		
		setfNome(nome);;
		fDanos.setIntervaloInferior(danosinf);
		fDanos.setIntervaloSuperior(danossup);
		fPontosMagicosNecessarios=pontosmagicosnecessarios;
		fVida=vida;
		
	}

}
