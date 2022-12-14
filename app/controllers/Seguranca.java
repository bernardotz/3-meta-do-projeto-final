package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
/**
 *   Essa Classe é responsável pela segurança no login
 * - Autor: Matheus Rodrigues
 * - Versão: 0.1 
 */


/*
 * Verifica se existe um usuário na sessão, exceto na página home, se não houver o usuário é direcionado para a página de login
 * 
 */
public class Seguranca extends Controller {
	@Before(unless="Musicas.home")
	static void verificar() {
        if (session.contains("usuario.email") == false) {
        	Login.entrar();
        }
     }	
}