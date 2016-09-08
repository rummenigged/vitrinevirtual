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

import br.crud.model.FotoProdutoModel;

@Path("/fotoproduto")
public class FotoProdutoService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<FotoProdutoModel> listar() {
		try {
			String query = "select c from FotoProdutoModel c";
			List<FotoProdutoModel> fotoproduto = objEM.createQuery(query,
					FotoProdutoModel.class).getResultList();
			objEM.close();
			return fotoproduto;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{idfotoproduto}")
	@Produces("application/json")
	public FotoProdutoModel buscar(
			@PathParam("idfotoproduto") int idfotoproduto) {
		try {
			FotoProdutoModel fotoproduto = objEM.find(
					FotoProdutoModel.class, idfotoproduto);
			objEM.close();
			return fotoproduto;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	public Response Cadastrar(FotoProdutoModel objFotoProduto) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objFotoProduto);
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
	public Response Alterar(FotoProdutoModel objFotoProduto) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objFotoProduto);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("Alteração de fotoproduto realizada com Sucesso")
					.build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{idfotoproduto}")
	@Produces("application/json")
	public Response Excluir(@PathParam("idfotoproduto") int idFotoProduto) {
		try {
			FotoProdutoModel objFotoProduto = objEM.find(
					FotoProdutoModel.class, idFotoProduto);
			objEM.getTransaction().begin();
			objEM.remove(objFotoProduto);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("fotoproduto Excluida com Sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
