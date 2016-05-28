package ed2.aa.struct;

import java.util.ArrayList;

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
	
	private ArrayList<Chave> valores;
	private ArrayList<Pagina<Chave>> filhos;
	
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
	 * <p>
	 * @param chave - Chave a ser inserida na Página
	 */
	public void inserir(Chave chave){
		System.out.println("Inserindo - "+chave);
		this.valores.add(chave);
		if(noLimite()){
			System.out.println("Executar o Split");
			split();
		}
	}
	
	/**
	 * <h1>Inserir Chave</h1>
	 * Insere uma chave nesta página
	 * <p>
	 * @param chave - Chave a ser inserida na Página
	 */
	public Pagina<Chave> split(){
		return null;
	}
	
	/**
	 * <h1>Externa?</h1>
	 * Verifica se a página é externa ou não
	 * <p>
	 */
	public boolean externa(){
		return this.filhos.size() == 0;
	}
	
	/**
	 * <h1>Possui a Chave?</h1>
	 * Verifica se a página possui a chave.
	 * <p>
	 * @param chave - Chave a buscar na página
	 */
	public boolean possui(Chave chave){
		return this.valores.contains(chave);
	}
	
	/**
	 * <h1>No Limite?</h1>
	 * Verifica se esta página já possui <i>Ordem</i> chaves
	 * <p>
	 */
	public boolean noLimite(){
		return this.valores.size() > 2*ordem; // 2D
	}
}
