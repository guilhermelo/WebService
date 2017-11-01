package webservice.bo;

import java.sql.Connection;
import java.util.List;

import webservice.dao.Conexao;
import webservice.dao.NoticiaDAO;
import webservice.vo.NoticiaVO;

public class NoticiaBO {

	public void inserirNoticia(NoticiaVO noticia) throws Exception {

		try {

			Connection conn = Conexao.getConnection();

			NoticiaDAO dao = new NoticiaDAO();

			dao.inserirNoticia(conn, noticia);

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public void atualizarNoticia(NoticiaVO noticia) throws Exception {

		try {

			Connection conn = Conexao.getConnection();

			NoticiaDAO dao = new NoticiaDAO();

			dao.atualizarNoticia(conn, noticia);

		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public boolean deletarNoticia(Long idNoticia) throws Exception {

		try {

			Connection conn = Conexao.getConnection();

			NoticiaDAO dao = new NoticiaDAO();
			
			if(!validaNoticia(idNoticia)){
				return false;
			}

			dao.deletarNoticia(conn, idNoticia);
			
			return true;

		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	public List<NoticiaVO> selecionarNoticias() throws Exception {

		try {

			Connection conn = Conexao.getConnection();

			NoticiaDAO dao = new NoticiaDAO();

			return dao.selecionarNoticias(conn);

		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public boolean validaNoticia(Long idNoticia) throws Exception {
		
		try {
			Connection conn = Conexao.getConnection();
			
			NoticiaDAO dao = new NoticiaDAO();
			
			return dao.selecionarNoticia(conn, idNoticia) != null;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
