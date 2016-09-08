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

import br.crud.model.ProdutoModel;

@Path("/produto")
public class ProdutoService {

	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ProdutoModel> listar() {
		try {
			String query = "select c from ProdutoModel c";
			List<ProdutoModel> produto = objEM.createQuery(query,
					ProdutoModel.class).getResultList();
			objEM.close();
			return produto;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{idproduto}")
	@Produces("application/json")
	public ProdutoModel buscar(
			@PathParam("idproduto") int idproduto) {
		try {
			ProdutoModel produto = objEM.find(
					ProdutoModel.class, idproduto);
			objEM.close();
			return produto;
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	public Response Cadastrar(ProdutoModel objProduto) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objProduto);
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
	public Response Alterar(ProdutoModel objProduto) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objProduto);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("Alteração de produto realizada com Sucesso")
					.build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{idproduto}")
	@Produces("application/json")
	public Response Excluir(@PathParam("idproduto") int idProduto) {
		try {
			ProdutoModel objProduto = objEM.find(
					ProdutoModel.class, idProduto);
			objEM.getTransaction().begin();
			objEM.remove(objProduto);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200)
					.entity("produto Excluida com Sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
