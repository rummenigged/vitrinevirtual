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
import br.crud.model.CategoriaModel;

@Path("/categoria")
public class CategoriaService {

	private JpaEntityManager  JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();
	
	

	
@GET
@Path("/listar")
@Produces("application/json")
public List<CategoriaModel> listar(){
	try {
		String query = "select c from CategoriaModel c";
		List<CategoriaModel> categorias = objEM.createQuery(query, CategoriaModel.class).getResultList();
		objEM.close();
		return categorias;
	} catch (Exception e) {
		// TODO: handle exception
		throw new WebApplicationException(500);
	}
}

@GET
@Path("/buscar/{idcategoria}")
@Produces("application/json")
public CategoriaModel buscar(@PathParam("idcategoria") int idCategoria){
	try {
		CategoriaModel categoria = objEM.find(CategoriaModel.class, idCategoria);
		objEM.close();
		return categoria;
	} catch (Exception e) {
		// TODO: handle exception
		throw new WebApplicationException(500);
	}
}
	
@POST
@Path("/cadastrar")
@Produces("application/json")
public Response Cadastrar(CategoriaModel objCategoria){
	try{
		objEM.getTransaction().begin();
		objEM.persist(objCategoria);
		objEM.getTransaction().commit();
		objEM.close();
		return Response.status(200).entity("cadastro de categoria realizado com sucesso").build();
	}catch(Exception e){
	  throw new WebApplicationException(500);
	}
}

@PUT
@Path("/alterar")
@Produces("application/json")
public Response Alterar(CategoriaModel objCategoria){
	try {
		objEM.getTransaction().begin();
		objEM.merge(objCategoria);
		objEM.getTransaction().commit();
		objEM.close();
		return Response.status(200).entity("Alteração de categoria realizada com Sucesso").build();
	} catch (Exception e) {
	 throw new WebApplicationException(500);
	}
}

@DELETE
@Path("/excluir/{idcategoria}")
@Produces("application/json")
public Response Excluir(@PathParam("idcategoria") int idcategoria){
	try {
		CategoriaModel objCategoria = objEM.find(CategoriaModel.class, idcategoria);
		objEM.getTransaction().begin();
		objEM.remove(objCategoria);
		objEM.getTransaction().commit();
		objEM.close();
		return Response.status(200).entity("categoria Excluida com Sucesso").build();
	} catch (Exception e) {
	 throw new WebApplicationException(500);
	}
}

	
}
