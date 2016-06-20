package ed2.aa.database;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.Random;

import ed2.aa.model.Autor;
import ed2.aa.model.Editora;
import ed2.aa.model.Livro;

public class Consulta{
	
	public static Map<String,Integer> buscarModelo(String tabela){
		// Modelos Disponíveis para Consulta
		switch(tabela){
			case "autor": return new Autor().getModelo();
			case "editora": return new Editora().getModelo();
			case "livro": return new Livro().getModelo();
			default:
				System.out.println("Tabela: "+tabela+"\tModelo não reconhecido.\nFinalizando execução do Programa.");
				System.exit(1);
			}
		return null;
	}
	
	// σ - sigma
	public static File selecao(String tabela, String coluna, String comparacao){
		try{
			String t = tabela.toLowerCase();
			int random = new Random().nextInt(3000);
			Map<String,Integer> modelo = null;
			File arquivoEscrita = new File("select_"+t+"_"+random+".dat");
			modelo = buscarModelo(t);
			
			// Ler ''tabela.dat'', onde tabela é informada pelo Usuário
			RandomAccessFile leitura = new RandomAccessFile(t+".dat","rw");
			// Criar e inserir dados em ''select_tabela_(random)'', onde tabela é informada pelo Usuário
			// e (random) é um inteiro aleatório gerado pelo sistema.
			RandomAccessFile escrita = new RandomAccessFile(arquivoEscrita,"rw");

			// Leitura do Arquivo Completo
			while(leitura.getFilePointer() < leitura.length()){
				// Ler uma linha inteira, em UTF
				String linha = leitura.readUTF();
				// Remover '/n' do final da String
				linha = linha.substring(0, linha.length()-1);
				
				// Separar Colunas do Arquivo
				String[] colunas = linha.split("\t");

				// Escrever no Arquivo todos os elementos da tabela
				if(coluna.compareTo("*") == 0){ escrita.writeUTF(linha); continue; }
				
				// Acessar coluna correta do modelo
				String valor = colunas[modelo.get(coluna)];

				// Escrever no Arquivo toda a Coluna, caso não seja informada a Comparacao.
				if(comparacao.isEmpty()){ escrita.writeUTF(valor); continue; }
				// Escrever no Arquivo elementos que na Coluna X, tenham valores iguais ao comparador.
				if(comparacao.compareTo(valor) == 0){ escrita.writeUTF(linha); continue; }
			}
			leitura.close();
			escrita.close();
			return arquivoEscrita;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	// π - pi
	public static RandomAccessFile projecao(){
		return null;
	}
	
	// ⋃
	public static RandomAccessFile uniao(){
		return null;
	}
	
	// −
	public static RandomAccessFile diferencaConjuntos(){
		return null;
	}
	
	// ×
	public static RandomAccessFile produtoCartesiano(){
		return null;
	}
	
	// ρ - ro
	public static RandomAccessFile renomeacao(){
		return null;
	}

}
