package ed2.aa.struct;

import java.util.ArrayList;

/**
 * <h1>P�gina</h1>
 * <ul>
 * <li>Cada p�gina possui no m�ximo <i>Ordem</i>-1 chaves;</li>
 * <li>A <i>Raiz</i> possui no m�nimo 2 Chaves e suas demais p�ginas cont�m no m�nimo <i>Ordem</i>/2 chaves;</li>
 * <li>Cada <i>Folha</i> da �rvore � uma <b>P�gina Externa</b>, "n�s" s�o <b>P�ginas Internas</b>;</li>
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
	 * Cria e abre uma p�gina nova.
	 * <p>
	 * @param externa - Diz se a p�gina � Externa ou n�o. 
	 */
	public Pagina(){
		this.valores = new ArrayList<Chave>();
		this.filhos = new ArrayList<Pagina<Chave>>();
	}
	
	/**
	 * <h1>Inserir Chave</h1>
	 * Insere uma chave nesta p�gina
	 * <p>
	 * @param chave - Chave a ser inserida na P�gina
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
	 * Insere uma chave nesta p�gina
	 * <p>
	 * @param chave - Chave a ser inserida na P�gina
	 */
	public Pagina<Chave> split(){
		return null;
	}
	
	/**
	 * <h1>Externa?</h1>
	 * Verifica se a p�gina � externa ou n�o
	 * <p>
	 */
	public boolean externa(){
		return this.filhos.size() == 0;
	}
	
	/**
	 * <h1>Possui a Chave?</h1>
	 * Verifica se a p�gina possui a chave.
	 * <p>
	 * @param chave - Chave a buscar na p�gina
	 */
	public boolean possui(Chave chave){
		return this.valores.contains(chave);
	}
	
	/**
	 * <h1>No Limite?</h1>
	 * Verifica se esta p�gina j� possui <i>Ordem</i> chaves
	 * <p>
	 */
	public boolean noLimite(){
		return this.valores.size() > 2*ordem; // 2D
	}
}
