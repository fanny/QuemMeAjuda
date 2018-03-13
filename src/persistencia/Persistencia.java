package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe utilizada para armazenar os dados cadastrados no 
 * sistema
 * @author fanny
 *
 */
public class Persistencia {
	
	
	private static final String DIR = "resources" + File.separator + "persistencia";
	
	private File rootPath = new File(DIR);
	
	private File arquivoAjudas;
	private File arquivoAlunos;
	private File arquivoTutores;
	

	public Persistencia(){
		
		this.arquivoAjudas = new File(rootPath + File.separator + "ajudas.txt");
		this.arquivoAlunos = new File(rootPath + File.separator + "alunos.txt");
		this.arquivoTutores = new File(rootPath + File.separator + "tutores.txt");
	
	}
	
	/**
	 * Método usado para salvar as ajudas cadastradas no sistema
	 * 
	 * @param texto
	 *            uma representação textual de todas as ajudas cadastradas no
	 *            sistema
	 * @throws IOException
	 *             caso ocorra algum erro na escrita do arquivo
	 */
	public void salvarAjudas(String texto) throws IOException{
		this.salvar(this.arquivoAjudas, texto);
	}
	
	/**
	 * Método usado para salvar os tutores cadastradas no sistema
	 * 
	 * @param texto
	 *            uma representação textual de todas os tutores cadastrados no
	 *            sistema
	 * @throws IOException
	 *             caso ocorra algum erro na escrita do arquivo
	 */
	public void salvarTutores(String texto) throws IOException{
		this.salvar(this.arquivoTutores, texto);
	}
	
	/**
	 * Método usado para salvar os alunos cadastrados no sistema
	 * 
	 * @param texto
	 *            uma representação textual de todas os alunos cadastradas no
	 *            sistema
	 * @throws IOException
	 *             caso ocorra algum erro na escrita do arquivo
	 */
	public void salvaAlunos(String texto) throws IOException{ 
		this.salvar(this.arquivoAlunos, texto);
	}
	
	/**
	 * Salva um arquivo no sistema
	 * 
	 * @param arquivo
	 *            o arquivo que será salvo
	 * @param texto
	 *            o texto que será escrito no arquivo
	 * @throws IOException
	 *             caso ocorra algum erro na escrita do arquivo
	 */
	private void salvar(File arquivo, String texto)throws IOException{
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(texto);
		
		bw.close();
		fw.close();
	}
	
	/**
	 * Método usado para apagar todos os arquivos cadastrados no sistema.
	 */
	public void limpar(){
		for(File file: this.rootPath.listFiles()) 
		    if (!file.isDirectory()) 
		        file.delete();
	}

}
