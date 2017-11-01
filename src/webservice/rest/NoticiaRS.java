package webservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import webservice.adapter.NoticiaAdapter;
import webservice.bo.NoticiaBO;
import webservice.vo.NoticiaVO;

@Path("/noticias")
public class NoticiaRS {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response selecionarNoticias(){
		
		Gson gson = new Gson();
		
		NoticiaBO bo = new NoticiaBO();
		List<NoticiaVO> noticias = null;
		
		try {
			noticias = bo.selecionarNoticias();
			
		} catch (Exception e) {
			Response.status(Status.BAD_REQUEST).entity("Erro dentro do serviço!").build();
		}
		
		return Response.status(Status.OK).entity(gson.toJson(noticias)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserirNoticia(String json){
		
		Gson gson = new Gson();
		NoticiaBO bo = new NoticiaBO();
		
		try {
			NoticiaAdapter adapter = gson.fromJson(json, NoticiaAdapter.class);
			
			bo.inserirNoticia(adapter.getAdapter());
			
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Erro dentro do serviço!").build();
		}
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response atualizarNoticia(String json){
		Gson gson = new Gson();
		NoticiaBO bo = new NoticiaBO();
		
		try {
			
			NoticiaVO noticia = gson.fromJson(json, NoticiaVO.class);
			
			bo.atualizarNoticia(noticia);
		
			return Response.status(Status.OK).build();	
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Erro dentro do serviço!").build();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deletarNoticia(@PathParam("id") Long idNoticia){
		Gson gson = new Gson();
		NoticiaBO bo = new NoticiaBO();
		
		try {
			if(!bo.deletarNoticia(idNoticia)){
				return Response.status(Status.NOT_FOUND).entity("Notícia inexistente!").build();
			}
			
			return Response.status(Status.OK).build();
		} catch(Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Erro dentro do serviço!").build();
		}
	}
}
