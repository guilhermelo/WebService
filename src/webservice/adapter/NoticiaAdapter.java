package webservice.adapter;

import webservice.util.DateUtil;
import webservice.vo.NoticiaVO;

public class NoticiaAdapter {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String dtUpdate;
	
	public NoticiaAdapter(NoticiaVO noticia) throws Exception{
		
		this.setId(noticia.getId());
		this.setTitulo(noticia.getTitulo());
		this.setDescricao(noticia.getDescricao());
		this.setDtUpdate(DateUtil.formatDateTime(noticia.getDtUpdate()));
	}

	
	public NoticiaVO getAdapter() throws Exception{
		NoticiaVO vo = new NoticiaVO();
		
		vo.setId(this.id);
		vo.setTitulo(this.titulo);
		vo.setDescricao(this.descricao);
		
		if(this.dtUpdate != null && !"".equals(this.dtUpdate)){
			vo.setDtUpdate(DateUtil.formatToDateTime(this.getDtUpdate()));
		}
		
		return vo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(String dtUpdate) {
		this.dtUpdate = dtUpdate;
	}
}
