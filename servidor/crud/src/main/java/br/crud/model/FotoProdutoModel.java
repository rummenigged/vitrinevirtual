package br.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fotoproduto")
public class FotoProdutoModel {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int idFotoProduto;

@Column(name="fotourl")
String fotoURL;

@Column(name="perfil")
String perfil;

@Column(name="produto_idproduto")
int produto_idproduto;

public int getIdFotoProduto() {
	return idFotoProduto;
}

public void setIdFotoProduto(int idFotoProduto) {
	this.idFotoProduto = idFotoProduto;
}

public String getFotoURL() {
	return fotoURL;
}

public void setFotoURL(String fotoURL) {
	this.fotoURL = fotoURL;
}

public String getPerfil() {
	return perfil;
}

public void setPerfil(String perfil) {
	this.perfil = perfil;
}

public int getProduto_idproduto() {
	return produto_idproduto;
}

public void setProduto_idproduto(int produto_idproduto) {
	this.produto_idproduto = produto_idproduto;
}



}
