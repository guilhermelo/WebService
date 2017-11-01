package webservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import webservice.vo.NoticiaVO;

public class NoticiaDAO {

	public void inserirNoticia(Connection conn, NoticiaVO noticia) throws SQLException {

		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();

		query.append(" INSERT INTO noticias (ID, TITULO, DESCRICAO, DT_UPDATE) ");
		query.append(" VALUES (?, ?, ?, ?) ");

		try {
			stmt = conn.prepareStatement(query.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			stmt.setLong(1, noticia.getId());
			stmt.setString(2, noticia.getTitulo());
			stmt.setString(3, noticia.getDescricao());
			stmt.setTimestamp(4, new Timestamp(noticia.getDtUpdate().getTime()));

			stmt.execute();

		} catch (Exception e) {
			throw new SQLException("Erro: " + e.getMessage());
		}
	}

	public void atualizarNoticia(Connection conn, NoticiaVO noticia) throws SQLException {

		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();

		query.append(" UPDATE noticias SET TITULO = ?, DESCRICAO = ?, DT_UPDATE = ? ");
		query.append(" WHERE ID = ? ");

		try {
			stmt = conn.prepareStatement(query.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			stmt.setString(1, noticia.getTitulo());
			stmt.setString(2, noticia.getDescricao());
			stmt.setTimestamp(3, new Timestamp(noticia.getDtUpdate().getTime()));
			stmt.setLong(4, noticia.getId());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw new SQLException("Erro: " + e.getMessage());
		}
	}

	public void deletarNoticia(Connection conn, Long idNoticia) throws SQLException {

		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();

		query.append(" DELETE FROM noticias ");
		query.append(" WHERE ID = ? ");

		try {
			stmt = conn.prepareStatement(query.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			stmt.setLong(1, idNoticia);

			stmt.executeUpdate();

		} catch (Exception e) {
			throw new SQLException("Erro: " + e.getMessage());
		}
	}
	
	public List<NoticiaVO> selecionarNoticias(Connection conn) throws SQLException {

		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		List<NoticiaVO> noticias = new ArrayList<NoticiaVO>();
		NoticiaVO noticia = null;
		ResultSet rs = null;

		query.append(" SELECT ID, TITULO, DESCRICAO, DT_UPDATE FROM noticias ");

		try {
			stmt = conn.prepareStatement(query.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				noticia = new NoticiaVO();
				
				noticia.setId(rs.getLong("ID"));
				noticia.setTitulo(rs.getString("TITULO"));
				noticia.setDescricao(rs.getString("DESCRICAO"));
				noticia.setDtUpdate(rs.getTimestamp("DT_UPDATE"));
				
				noticias.add(noticia);
			}
			
			return noticias;

		} catch (Exception e) {
			throw new SQLException("Erro: " + e.getMessage());
		}
	}
	
	public NoticiaVO selecionarNoticia(Connection conn, Long idNoticia) throws SQLException {
		
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		NoticiaVO noticia = null;
		ResultSet rs = null;

		query.append(" SELECT ID, TITULO, DESCRICAO, DT_UPDATE FROM noticias where id = ? ");

		try {
			stmt = conn.prepareStatement(query.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			
			stmt.setLong(1, idNoticia);

			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				noticia = new NoticiaVO();
				
				noticia.setId(rs.getLong("ID"));
				noticia.setTitulo(rs.getString("TITULO"));
				noticia.setDescricao(rs.getString("DESCRICAO"));
				noticia.setDtUpdate(rs.getTimestamp("DT_UPDATE"));
				
			}
			
			return noticia;

		} catch (Exception e) {
			throw new SQLException("Erro: " + e.getMessage());
		}
	}
}
