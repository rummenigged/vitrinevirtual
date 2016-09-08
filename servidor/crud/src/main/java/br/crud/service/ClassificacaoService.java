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

import br.crud.model.ClassificacaoModel;

@Path("/classificacao")
public class ClassificacaoService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ClassificacaoModel> listar() {
		try {
			String query = "select c from ClassificacaoModel c";
			List<ClassificacaoModel> classificacao = objEM.createQuery(query,
					ClassificacaoModel.class).getResultList();
			objEM.close();
			return classificacao;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{idclassificacao}")
	@Produces("application/json")
	public ClassificacaoModel buscar(
			@PathParam("idclassificacao") int idclassificacao) {
		try {
			ClassificacaoModel classificacao = objEM.find(
					ClassificacaoModel.class, idclassificacao);
			objEM.close();
			return classificacao;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	public Response Cadastrar(ClassificacaoModel objClassificacao) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objClassificacao);
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
	public Response Alterar(ClassificacaoModel objClassificacao) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objClassificacao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("Alteração de classificacao realizada com Sucesso")
					.build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{idclassificacao}")
	@Produces("application/json")
	public Response Excluir(@PathParam("idclassificacao") int idClassificacao) {
		try {
			ClassificacaoModel objClassificacao = objEM.find(
					ClassificacaoModel.class, idClassificacao);
			objEM.getTransaction().begin();
			objEM.remove(objClassificacao);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("classificacao Excluida com Sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
