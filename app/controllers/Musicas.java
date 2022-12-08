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
 	Exibe todas as musicas que tem no banco de dados e com filtro de pesquisa com o termo pesquisado
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
	
	/*
	 * Direciona para o formulario de músicas
	 */
	
	public static void formulario() {
		List<Meses> meses = Arrays.asList(Meses.values());
        render(meses);
    }
	
	/*
	 * Ao chamar esse método salva a música sendo direcionado para o home, onde é listado as músicas de todos os usuários
	 */
    public static void salvar(Musica musica) {
        musica.save();
        home();
    }
    
    /*
     * Reutiliza a página do formulário de música passando o id do usuário e deixando os campos preenchidos
     * caso o usuário queira editar algo.   
     */
    
    public static void editar(Long id) {
        Musica musica = Musica.findById(id);
        renderTemplate("musicas/formulario.html", musica);
    }
    
    /*
     * Remove a música que o usuário solicitou
     */
    
    public static void remover(Long id) {
        Musica musica = Musica.findById(id);
        musica.delete();
        home();
    }
    
}