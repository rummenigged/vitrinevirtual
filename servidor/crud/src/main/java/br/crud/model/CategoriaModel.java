package br.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="categoria")
public class CategoriaModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int idcategoria;
  
@Column(name="categorianome")
String categoriaNome;
 
@Column(name="categoriaFoto")
String categoriaFoto;	

@Column(name="categoriaView")
int categoriaView;

public int getIdcategoria() {
	return idcategoria;
}

public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}

public String getCategoriaNome() {
	return categoriaNome;
}

public void setCategoriaNome(String categoriaNome) {
	this.categoriaNome = categoriaNome;
}

public String getCategoriaFoto() {
	return categoriaFoto;
}

public void setCategoriaFoto(String categoriaFoto) {
	this.categoriaFoto = categoriaFoto;
}

public int getCategoriaView() {
	return categoriaView;
}

public void setCategoriaView(int categoriaView) {
	this.categoriaView = categoriaView;
}



}



