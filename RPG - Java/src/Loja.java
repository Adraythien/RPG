import java.util.ArrayList;

public class Loja {
	private static ArrayList<Item>Loja;
	String nome;
	String descricao;
	int num;
	int vida;int pEscudo;
	
	Loja(){
		Loja =new ArrayList<>();
	}
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public void Stock(){
		Loja.removeAll(Loja);
		Item a=new Item("Arma","aeasd",3,5,7,50);
		Item ar=new Item("Armadura","aeasd",0,5,7,350);
		
		
		Loja.add(ar);
		Loja.add(a);
	}
	public void Mostra(){
		for(int i=0;i<Loja.size();i++){
			System.out.println("Nome: "+(Loja.get(i).getNome()+" Descricao: "+Loja.get(i).getDescricao()+"Ataque: "+Loja.get(i).getAtaque()+" Vida: +"+Loja.get(i).getVida()+" Escudo : "+Loja.get(i).getpEscudo()+" Preço: "+Loja.get(i).getCoins()));
		}
	}
	public void Comprar(String resp, Jogador j){
		for(int i=0;i<Loja.size();i++)
         {   
            if(Loja.get(i).getNome().equals(resp) && j.getpCoins()>=Loja.get(i).getCoins())
            {
            	System.out.println("Acabou de comprar "+(Loja.get(i).getNome()).toString());
            	j.inventario.add(Loja.get(i));
            }
            else{
            	System.out.println("Não tem coins suficientes");
            }
         }
	}
}
