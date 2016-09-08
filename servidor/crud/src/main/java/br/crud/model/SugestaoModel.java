package br.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sugestao")
public class SugestaoModel {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idsugestao;
	
	@Column(name="sugestaoduvida")
	String sugestaoduvida;
	
	@Column(name="produto_idproduto")
	int produto_idProduto;

	public int getIdsugestao() {
		return idsugestao;
	}

	public void setIdsugestao(int idsugestao) {
		this.idsugestao = idsugestao;
	}

	public String getSugestaoduvida() {
		return sugestaoduvida;
	}

	public void setSugestaoduvida(String sugestaoduvida) {
		this.sugestaoduvida = sugestaoduvida;
	}

	public int getProduto_idProduto() {
		return produto_idProduto;
	}

	public void setProduto_idProduto(int produto_idProduto) {
		this.produto_idProduto = produto_idProduto;
	}
	
	
}
