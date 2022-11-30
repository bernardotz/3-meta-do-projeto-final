package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
 /**
  *   Essa Classe é o gerenciamento do perfil do usuario
  * - Autor: Carlos Bernardo
  * - Versão: 0.1
  *
  */
@With(Seguranca.class)
public class Usuarios extends Controller {
	
	public static void perfil() {
		List<Musica> lista = Musica.findAll();
        render(lista);
    }
	/**
 	Editar musicas do perfil do usuario
     */
    public static void editar(Long id) {
    	Usuario usuario = Usuario.findById(id);
		List<Meses> meses = Arrays.asList(Meses.values());
        renderTemplate("usuarios/formulario.html", usuario,  meses);
    }
    /**
 	Remover musicas do perfil do usuario
     */
    public static void remover(Long id) {
    	Usuario usuario = Usuario.findById(id);
    	usuario.delete();
        perfil();
    }
   
}