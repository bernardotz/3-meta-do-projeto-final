package controllers;
import play.*;
import play.mvc.*;
import java.util.*;
import models.*;
/**
 * 	 Essa Classe é o home do projeto onde fica todas as musica postadas pelos usuarios
 * - Autor: Matheus Rodrigues
 * - Versão: 0.1
 *
 */
@With(Seguranca.class)
public class Musicas extends Controller {
	
	/**
 	Exibe todas as musicas que tem no banco de dados
     */
	
	public static void home() {
		String busca = params.get("busca");
		List<Musica> musicasDaComunidade;
		if (busca == null) {
			musicasDaComunidade = Musica.findAll();
		} else {
			musicasDaComunidade = Musica.find
					("LOWER (titulo) like ?1 or LOWER (autor) like ?1 or LOWER (album) like ?1", "%"
					+ busca.toLowerCase() + "%").fetch();
		}
        render(musicasDaComunidade);
    }
	
	public static void formulario() {
		List<Meses> meses = Arrays.asList(Meses.values());
        render(meses);
    }
	
    public static void salvar(Musica musica) {
        musica.save();
        home();
    }
    
    public static void editar(Long id) {
        Musica musica = Musica.findById(id);
        renderTemplate("musicas/formulario.html", musica);
    }
    
    public static void remover(Long id) {
        Musica musica = Musica.findById(id);
        musica.delete();
        home();
    }
    
}