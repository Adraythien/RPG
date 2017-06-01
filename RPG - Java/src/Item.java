public class Item {
	private String nome;
    private String descricao;
    private int ataque;
    private int vida;
    private int pEscudo;
    private int coins;
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getpEscudo() {
		return pEscudo;
	}
	public void setpEscudo(int pEscudo) {
		this.pEscudo = pEscudo;
	}
	Item(){
    	nome="";
    	descricao="";
    	ataque=0;
    	vida=0;
    	pEscudo=0;
    	coins=0;
    	
    }
    public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	Item(String nome,String descricao,int ataque,int vida,int pEscudo,int coins){
    	this.nome=nome;
    	this.descricao=descricao;
    	this.ataque=ataque;
    	this.vida=vida;
    	this.pEscudo=pEscudo;
    	this.coins=coins;
    }
    
}