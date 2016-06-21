package ed2.aa.database;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
		if(tabela.isEmpty() || coluna.isEmpty()){
			System.out.println("Parâmetros de Seleção não preenchidos corretamente.");
			System.out.println("Utilização: selecao(tabela,coluna,comparacao).");
			System.out.println("Finalizando execução do Programa.");
			System.exit(1);
		}
		try{
			String t = tabela.toLowerCase();
			int random = new Random().nextInt(3000);
			Map<String,Integer> modelo = buscarModelo(t);
			File arquivoEscrita = new File("select_"+t+"_"+random+".dat");
			
			// Verifica se a Key existe no modelo, caso contrário encerra a execução.
			if(!modelo.containsKey(coluna) && coluna.compareTo("*") != 0){
				System.out.println("A Coluna informada não existe na Tabela.");
				System.out.println("Finalizando execução do Programa.");
				System.exit(1);
			}
			
			// Ler ''tabela.dat'', onde tabela é informada pelo Usuário
			RandomAccessFile leitura = new RandomAccessFile(t+".dat","r");
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

				// Escrever no Arquivo elementos que na Coluna X, tenham valores iguais ao comparador.
				if(comparacao.compareTo(valor) == 0){ escrita.writeUTF(linha); continue; }
			}
			
			// Caso atinja o final do arquivo, sem resultados
			if((leitura.getFilePointer() == leitura.length()) && escrita.length() < 1){
				System.out.println("O Registro não foi encontrado.");
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
	public static File projecao(String tabela, ArrayList<String> colunas){
		if(tabela.isEmpty() || colunas.size() < 1){
			System.out.println("Parâmetros de Projeção não preenchidos corretamente.");
			System.out.println("Utilização: projecao(tabela,coluna).");
			System.out.println("Finalizando execução do Programa.");
			System.exit(1);
		}
		try{
			String t = tabela.toLowerCase();
			int random = new Random().nextInt(3000);
			Map<String,Integer> modelo = null;
			if(t.contains("select") || t.contains("project")){
				String[] m = t.split("_");
				modelo = buscarModelo(m[1]);
			} else {
				modelo = buscarModelo(t);
			}
			
			File arquivoEscrita = new File("project_"+t+"_"+random+".dat");
			
			for(String c: colunas){
				// Verifica se a Key existe no modelo, caso contrário encerra a execução.
				if(!modelo.containsKey(c)){
					System.out.println("A Coluna informada não existe na Tabela.");
					System.out.println("Finalizando execução do Programa.");
					System.exit(1);
				}
			}
			
			// Ler ''tabela.dat'', onde tabela é informada pelo Usuário
			RandomAccessFile leitura = new RandomAccessFile(t+".dat","r");
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
				String[] colunasTabela = linha.split("\t");
				// Acessar coluna correta do modelo
				StringBuilder valores = new StringBuilder();
				for(String c: colunas){
					valores.append(colunasTabela[modelo.get(c)]);
					valores.append("\t");
				}
				String valoresTratados = valores.toString();
				valoresTratados = valoresTratados.substring(0, valoresTratados.length()-1);
				// Escrever no Arquivo elementos que na Coluna X, tenham valores iguais ao comparador.
				escrita.writeUTF(valoresTratados);
			}
			
			// TODO: Remover Duplicatas
			
			leitura.close();
			escrita.close();
			return arquivoEscrita;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static File NestedLoop(){
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
