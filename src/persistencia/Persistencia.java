package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

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
	public void salvaAjudas(String texto) throws IOException{
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
	public void salvaTutores(String texto) throws IOException{
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
	 * Faz a letura do arquivo de ajudas do sistema
	 * @throws IOException caso ocorra algum problema na leitura
	 */
	public String carregaAjudas() throws IOException{
		return this.carregar(this.arquivoAjudas);
	}
	
	/**
	 * Faz a letura do arquivo de tutores do sistema
	 * @throws IOException caso ocorra algum problema na leitura
	 */
	public String carregaTutores() throws IOException{
		return this.carregar(this.arquivoTutores);
	}
	
	/**
	 * Faz a letura do arquivo de alunos do sistema
	 * @throws IOException caso ocorra algum problema na leitura
	 */
	public String carregaAlunos() throws IOException{ 
		return this.carregar(this.arquivoAlunos);
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
	 * Faz a leitura do arquivo passado como parametro
	 * 
	 * @param arquivo
	 *            o arquvo a ser lido
	 * @return string uma string representando o conteúdo do arquivo
	 * @throws IOException
	 *             caso ocorra algum problema na leitura
	 */
	private String carregar(File arquivo) throws IOException{
		
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		
		StringJoiner joiner = new StringJoiner(System.lineSeparator());
		
		String line = br.readLine();
		while(line != null){
			joiner.add(line);
			line = br.readLine();
		}
		
		br.close();
		fr.close();
		
		return joiner.toString();
		
	}
	
	public void limparAjudas(){
		this.arquivoAjudas.delete();
	}
	
	public void limparTutores(){
		this.arquivoTutores.delete();
	}
	
	public void limparAlunos(){
		this.arquivoAlunos.delete();
	}

}
