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

import br.crud.model.PromocaoModel;

@Path("/promocao")
public class PromocaoService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<PromocaoModel> listar() {
		try {
			String query = "select c from PromocaoModel c";
			List<PromocaoModel> promocao = objEM.createQuery(query,
					PromocaoModel.class).getResultList();
			objEM.close();
			return promocao;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{idpromocao}")
	@Produces("application/json")
	public PromocaoModel buscar(
			@PathParam("idpromocao") int idpromocao) {
		try {
			PromocaoModel promocao = objEM.find(
					PromocaoModel.class, idpromocao);
			objEM.close();
			return promocao;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	public Response Cadastrar(PromocaoModel objPromocao) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objPromocao);
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
	public Response Alterar(PromocaoModel objPromocao) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objPromocao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("Alteração de promocao realizada com Sucesso")
					.build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{idpromocao}")
	@Produces("application/json")
	public Response Excluir(@PathParam("idpromocao") int idPromocao) {
		try {
			PromocaoModel objPromocao = objEM.find(
					PromocaoModel.class, idPromocao);
			objEM.getTransaction().begin();
			objEM.remove(objPromocao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("promocao Excluida com Sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
