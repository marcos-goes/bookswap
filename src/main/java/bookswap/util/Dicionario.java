package bookswap.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import bookswap.entity.Livro;

@Singleton
public class Dicionario {

	private Map<Integer, Livro> livros;
	
	@PostConstruct
	private void init(){
		System.out.println("Iniciando o dicion�rio...");
		
		Livro livro1 = new Livro(1, "Livro do Marcos", "Marcos");
		Livro livro2 = new Livro(2, "Embaixador", "Luis");
		Livro livro3 = new Livro(3, "War Room", "Maria");
		Livro livro4 = new Livro(4, "Historia do Dell", "Jurema");
		Livro livro5 = new Livro(5, "Efective Recognized", "Ana");
		
		this.livros = new HashMap<Integer, Livro>();
		livros.put(livro1.getId(), livro1);
		livros.put(livro2.getId(), livro2);
		livros.put(livro3.getId(), livro3);
		livros.put(livro4.getId(), livro4);
		livros.put(livro5.getId(), livro5);
	}
	
	
	public Livro adicionaLivro(Livro livro){
		return livros.putIfAbsent(livro.getId(), livro);
	}
	
	public Livro buscaLivro(Integer id){
		return livros.get(id);
	}
	
	public List<Livro> buscaTodos(){
		List<Livro> lista = new ArrayList<Livro>(livros.values());
		return lista;
	}
	
	public Livro excluiLivro(Integer id){
		return livros.remove(id);
	}
}
