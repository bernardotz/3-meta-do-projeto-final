package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.jpa.Model;

@Entity
public class Musica extends Model{
	
	public String titulo;
	public String album;
	public String autor;
	public String duracao;
	public String dia;
	public Meses mes;
	public String ano;
	
	public int cont = 0;
}
