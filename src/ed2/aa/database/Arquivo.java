package ed2.aa.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {

	public static void converter(String input, String output){
		try{
			RandomAccessFile leitura = new RandomAccessFile(input,"rw");
			RandomAccessFile escrita = new RandomAccessFile(output,"rw");
			
			String linha = new String();
			while((linha = leitura.readLine()) != null)
				escrita.writeUTF(linha+"\n");
			
			leitura.close();
			escrita.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void buscarLivros(String autor){
		try {
			RandomAccessFile autores = new RandomAccessFile("autor.dat","rw");
			RandomAccessFile livros = new RandomAccessFile("autor.dat","rw");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}