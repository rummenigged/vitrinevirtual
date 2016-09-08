package br.crud.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.crud.entitymanager.JpaEntityManager;

import br.crud.model.SugestaoModel;

@Path("/sugestao")
public class SugestaoService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<SugestaoModel> listar() {
		try {
			String query = "select c from SugestaoModel c";
			List<SugestaoModel> sugestao = objEM.createQuery(query,
					SugestaoModel.class).getResultList();
			objEM.close();
			return sugestao;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{idsugestao}")
	@Produces("application/json")
	public SugestaoModel buscar(
			@PathParam("idsugestao") int idsugestao) {
		try {
			SugestaoModel sugestao = objEM.find(
					SugestaoModel.class, idsugestao);
			objEM.close();
			return sugestao;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	public Response Cadastrar(SugestaoModel objSugestao) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objSugestao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("cadastro realizado com sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Path("/alterar")
	@Produces("application/json")
	public Response Alterar(SugestaoModel objSugestao) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objSugestao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("Alteração de sugestao realizada com Sucesso")
					.build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{idsugestao}")
	@Produces("application/json")
	public Response Excluir(@PathParam("idsugestao") int idSugestao) {
		try {
			SugestaoModel objSugestao = objEM.find(
					SugestaoModel.class, idSugestao);
			objEM.getTransaction().begin();
			objEM.remove(objSugestao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("sugestao Excluida com Sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
