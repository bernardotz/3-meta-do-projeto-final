package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	public String email;
	public String senha;
	public String username;
	public String dia;
	public Meses mes;
	public String ano;
	
}
