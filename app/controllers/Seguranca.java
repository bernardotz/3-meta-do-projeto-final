package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
/**
 *   Essa Classe é responsável pela segurança no login
 * - Autor: Carlos Bernardo
 * - Versão: 0.1 
 */
public class Seguranca extends Controller {
	@Before(unless="Musicas.home")
	static void verificar() {
        if (session.contains("usuario.email") == false) {
        	Login.entrar();
        }
     }	
}