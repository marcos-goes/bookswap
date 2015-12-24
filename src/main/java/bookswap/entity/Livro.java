package bookswap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Livro {

	private Integer id;
	private String titulo;
	
	@XmlElement(name="autor")
	private List<String> autores;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	
	public Livro(){
	}
	
	public Livro(Integer id, String titulo, String autor){
		this.id = id;
		this.titulo = titulo;
		this.autores = new ArrayList<String>();
		this.autores.add(autor);
	}
	
}
