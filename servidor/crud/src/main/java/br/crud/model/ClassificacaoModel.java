package br.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="classificacao")
public class ClassificacaoModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int idClassificacao;
  
@Column(name="classificacaoestrelas")
int classificacaoestrelas;
  
@Column(name="produto_idproduto")
int produto_idproduto;

public int getIdClassificacao() {
	return idClassificacao;
}

public void setIdClassificao(int idClassificacao) {
	this.idClassificacao = idClassificacao;
}

public int getClassificacaoestrelas() {
	return classificacaoestrelas;
}

public void setClassificacaoestrelas(int classificacaoestrelas) {
	this.classificacaoestrelas = classificacaoestrelas;
}

public int getProduto_idproduto() {
	return produto_idproduto;
}

public void setProduto_idproduto(int produto_idproduto) {
	this.produto_idproduto = produto_idproduto;
}


 
	
}
