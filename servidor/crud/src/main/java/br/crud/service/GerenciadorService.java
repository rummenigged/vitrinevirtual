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

import br.crud.model.GerenciadorModel;

@Path("/gerenciador")
public class GerenciadorService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<GerenciadorModel> listar() {
		try {
			String query = "select c from GerenciadorModel c";
			List<GerenciadorModel> gerenciador = objEM.createQuery(query,
					GerenciadorModel.class).getResultList();
			objEM.close();
			return gerenciador;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{idgerenciador}")
	@Produces("application/json")
	public GerenciadorModel buscar(
			@PathParam("idgerenciador") int idgerenciador) {
		try {
			GerenciadorModel gerenciador = objEM.find(
					GerenciadorModel.class, idgerenciador);
			objEM.close();
			return gerenciador;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	public Response Cadastrar(GerenciadorModel objGerenciador) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objGerenciador);
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
	public Response Alterar(GerenciadorModel objGerenciador) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objGerenciador);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("Alteração de gerenciador realizada com Sucesso")
					.build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{idgerenciador}")
	@Produces("application/json")
	public Response Excluir(@PathParam("idgerenciador") int idGerenciador) {
		try {
			GerenciadorModel objGerenciador = objEM.find(
					GerenciadorModel.class, idGerenciador);
			objEM.getTransaction().begin();
			objEM.remove(objGerenciador);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("gerenciador Excluida com Sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
