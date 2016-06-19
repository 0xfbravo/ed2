package ed2.aa.struct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * <h1>Página</h1>
 * <ul>
 * <li>Cada página possui no máximo <i>Ordem</i>-1 chaves;</li>
 * <li>A <i>Raiz</i> possui no mínimo 2 Chaves e suas demais páginas contém no mínimo <i>Ordem</i>/2 chaves;</li>
 * <li>Cada <i>Folha</i> da árvore é uma <b>Página Externa</b>, "nós" são <b>Páginas Internas</b>;</li>
 * </ul>
 * @author Fellipe Pimentel
 * @see 
 * <ul>
 * <li><a href="http://www.ime.usp.br/~pf/estruturas-de-dados/aulas/B-trees.html">http://www.ime.usp.br/~pf/estruturas-de-dados/aulas/B-trees.html</a></li>
 * <li><a href="http://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BTree.java.html">http://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BTree.java.html</a></li>
 * <li><a href="http://www2.dcc.ufmg.br/livros/algoritmos-java/implementacoes-06.php">http://www2.dcc.ufmg.br/livros/algoritmos-java/implementacoes-06.php</a></li>
 * </ul>
 */

public class Pagina<Chave> {
	public static final int ordem = 2;
	
	public Pagina<Chave> pai;
	private ArrayList<Chave> valores;
	private ArrayList<Pagina<Chave>> filhos;
	
	@Override
	public String toString(){
		return super.toString();
	}
	
	/**
	 * <h1>Construtor</h1>
	 * Cria e abre uma página nova.
	 * <p>
	 * @param externa - Diz se a página é Externa ou não. 
	 */
	public Pagina(){
		this.valores = new ArrayList<Chave>();
		this.filhos = new ArrayList<Pagina<Chave>>();
	}
	
	/**
	 * <h1>Inserir Chave</h1>
	 * Insere uma chave nesta página
	 * <ol>
	 * <li>Caso a chave passada seja igual a uma chave encontrada, não será adicionada.</li>
	 * </ol>
	 * <p>
	 * @param chave - Chave a ser inserida na Página
	 */
	public Pagina<Chave> inserir(Chave chave){
		System.out.println("Inserindo - "+chave+" em "+this);
		
		if(this.externa()){ this.valores.add(chave); }
		else {
			for(Iterator<Chave> i = this.valores.iterator(); i.hasNext();){
				Chave aux = i.next();
				int index = this.valores.indexOf(aux);
				// Primeiro Elemento > Chave -> inserir no primeiro filho
				if(aux.toString().compareTo(chave.toString()) > 0){ this.filhos.get(index).inserir(chave); break; }
				else if(index == this.valores.size() -1){ this.filhos.get(index+1).inserir(chave); break; }
			}
		
		}
		
		this.valores.sort(ORDEM_ALFABETICA);
		
		/*for(Chave c: this.valores){
			if(this.raiz()) System.out.println("\t Raiz -> "+c+" - "+this);
			else System.out.println("\t"+c+" - "+this);
		}*/
		if(noLimite()){
			System.out.println("::: Executar o Split :::");
			split();
			return this.pai;
		}
		
		return this;
	}
	
	public Pagina<Chave> inserirRaiz(Pagina<Chave> raiz, Chave chave){
		raiz.valores.add(chave);
		raiz.valores.sort(ORDEM_ALFABETICA);
		if(raiz.noLimite()){
			System.out.println("::: Executar o Split :::");
			raiz.split();
		}
		return raiz;
	}
	
	public void visualizarArvore(){
		if(raiz()){
			System.out.println("Raiz - "+this);
			System.out.println("Valores - "+this);
			this.valores.forEach(v -> {
				System.out.print("\t"+v);
			});
			System.out.println("");
			System.out.println("Filhos da Raiz - "+this);
			this.filhos.forEach(f -> {
				System.out.println("\t"+f);
				
				f.valores.forEach(vf -> {
					System.out.print("\t\t"+vf);
				});
				System.out.println("");
				f.visualizarArvore();
			});
		}
	}
	
	public Chave buscar(String nome){
		for(Iterator<Chave> i = this.valores.iterator(); i.hasNext();){
			Chave aux = i.next();
			int index = this.valores.indexOf(aux);
			
			if(aux.toString().compareTo(nome) == 0) { return aux; }
			if(aux.toString().compareTo(nome) > 0 && !this.externa()){ return this.filhos.get(index).buscar(nome); }
			if(index == this.valores.size() - 1 && !this.externa()){ return this.filhos.get(index+1).buscar(nome); }
		}
		return null;
	}
	
	/**
	 * <h1>Ordem Alfabética</h1>
	 * Comparador para ordenação em Ordem Alfabética.
	 */
	public Comparator<Chave> ORDEM_ALFABETICA = new Comparator<Chave>(){
		public int compare(Chave a, Chave b){
			int res = String.CASE_INSENSITIVE_ORDER.compare(a.toString(), b.toString());
			if(res == 0){ res = a.toString().compareTo(b.toString()); }
			return res;
		}
	};
	
	/**
	 * <h1>Split (Cisão)</h1>
	 * <ol>
	 * <li>Cria uma nova Página vazia P</li>
	 * <li>"Mover" elemento PaginaAtual[(<i>Ordem</i>/2)+1] até elemento PaginaAtual[<i>Ordem</i>] para a nova Página P, removendo-os da PáginaAtual</li>
	 * <li>"Subir" elemento PaginaAtual[<i>Ordem</i>/2]</li>
	 * <li>Se Pai de PaginaAtual, não é raiz. Cria-se uma nova raiz.</li>
	 * </ol>
	 * <b>Observação: A cisão pode se propagar no pai de P até a Raiz, quando uma nova raiz é criada.</b>
	 * <p>
	 */
	public void split(){
		Pagina<Chave> nova = new Pagina<Chave>();	// Nova Página
		int m = this.valores.size()/2;				// Elemento do Meio da Página Atual
		int tamanho = this.valores.size()-1;
		
		// Passo 2
		System.out.println("\t :: Inserindo em Nova Página Valores > "+m);
		for(int i = tamanho; i > m; i--){
			Chave c = this.valores.get(i);	
			this.valores.remove(c);
			nova.inserir(c);
		}
		
		Chave valorMeio = this.valores.get(m);
		// Passo 4
		if(raiz()){
			System.out.println("\t :: Inserindo em Nova Raiz - "+valorMeio);
			Pagina<Chave> raiz = new Pagina<Chave>();	// Nova Raiz
			raiz = raiz.inserirRaiz(raiz,valorMeio);
			int index = raiz.valores.indexOf(valorMeio);
			raiz.filhos.add(index, this);
			raiz.filhos.add(index+1, nova);
			this.pai = raiz;
			nova.pai = raiz;
		}
		// Passo 3
		else {
			System.out.println("\t :: Inserindo no Pai Existente - "+valorMeio);
			this.pai = this.pai.inserirRaiz(this.pai,valorMeio);
			int index = this.pai.valores.indexOf(valorMeio);
			this.pai.filhos.add(index+1, nova);
			nova.pai = this.pai;
		}
		this.valores.remove(m);
		System.out.println("");
	}
	
	/**
	 * <h1>Raiz?</h1>
	 * Verifica se a página é raiz ou não (possui pai, ou não).<br>
	 * Se possui pai, retorna <b>true</b><br>
	 * Caso contrário, <b>false</b>
	 * <p>
	 */
	public boolean raiz(){ return this.pai == null; }
	
	/**
	 * <h1>Externa?</h1>
	 * Verifica se a página é externa ou não
	 * <p>
	 */
	public boolean externa(){ return this.filhos.size() == 0; }
	
	/**
	 * <h1>No Limite?</h1>
	 * Verifica se esta página já possui <i>Ordem</i> chaves
	 * <p>
	 */
	public boolean noLimite(){ return this.valores.size() > 2*ordem; } // 2D
}
