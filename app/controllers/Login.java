package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
  Essa Classe gerencia o sistema de Login
   - Autor: Matheus Rodrigues
   - Versão: 0.1 
*/
public class Login extends Controller {
/**
 Esse metodo cria um administrador para ter acesso algumas funções assim que iniciar o banco de dados
 */
	public static void admin() {
		Usuario usuario = new Usuario();
		usuario.email = "admin";
		usuario.senha = "admin";
		usuario.save();
		entrar();
	}
	
	public static void entrar() {
        render();
    }
	
	public static void cadastrar() {
		List<Meses> meses = Arrays.asList(Meses.values());
        render(meses);
    }
	
	public static void salvar(Usuario usuario) {
        usuario.save();
        entrar();
    }
	
	public static void logar(String email, String senha) {
		Usuario usuario = Usuario.find("email = ?1 and senha = ?2", email, senha).first();
		if (usuario == null) {
			entrar();
		} else {
			session.put("usuario.email", usuario.email);
			Musicas.home();
		}
    }
	
	public static void sair() {
        session.clear();
        entrar();
    }
	
}