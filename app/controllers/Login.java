package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
  Essa Classe gerencia o sistema de Login
   - Autor: Matheus Rodrigues
   - Versãoe: 0.1 
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
	
	/*
	 * Direciona para página de login
	 */
	
	public static void entrar() {
        render();
    }
	
	/*
	 * Ao chamar esse método o usuário é direcionado para o formulário de cadastro
	 */
	
	public static void cadastrar() {
		List<Meses> meses = Arrays.asList(Meses.values());
        render(meses);
    }
	
	/*
	 * Ao chamar esse método cria um novo usuário no banco de dados
	 */
	
	public static void salvar(Usuario usuario) {
        usuario.save();
        entrar();
    }
	
	/*
	 * Sistema de login onde tem uma verificação para validar o acesso ao usuário
	 * verificando se seu email e senha existe no sistema, caso exista o usuário é direcionado para o home onde
	 * tem todas as músicas dos usuários
	 */
	
	public static void logar(String email, String senha) {
		Usuario usuario = Usuario.find("email = ?1 and senha = ?2", email, senha).first();
		if (usuario == null) {
			entrar();
		} else {
			session.put("usuario.email", usuario.email);
			Musicas.home();
		}
    }
	
	/*
	 * Ao chamar esse método a sessão do usuário é encessada e é direcionado para a tela de login
	 */
	
	public static void sair() {
        session.clear();
        entrar();
    }
	
}