package br.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="produto")
public class ProdutoModel {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idproduto;
	
	@Column(name="produtonome")
	String produtoNome;
	
	@Column(name="produtodescricao")
	String produtoDescricao;
	@Column(name="produtopreco")
	Float produtoPreco;
	
	@Column(name="produtotamanho")
	String produtoTamanho;
	
	@Column(name="categoria_idcategoria")
	int categoria_idCategoria;
	
	@Column(name="produtoviews")
	int produtoViews;
	
	@Column(name="produtofavorito")
	int produtoFavorito;

	public int getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public Float getProdutoPreco() {
		return produtoPreco;
	}

	public void setProdutoPreco(Float produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	public String getProdutoTamanho() {
		return produtoTamanho;
	}

	public void setProdutoTamanho(String produtoTamanho) {
		this.produtoTamanho = produtoTamanho;
	}

	public int getCategoria_idCategoria() {
		return categoria_idCategoria;
	}

	public void setCategoria_idCategoria(int categoria_idCategoria) {
		this.categoria_idCategoria = categoria_idCategoria;
	}

	public int getProdutoViews() {
		return produtoViews;
	}

	public void setProdutoViews(int produtoViews) {
		this.produtoViews = produtoViews;
	}

	public int getProdutoFavorito() {
		return produtoFavorito;
	}

	public void setProdutoFavorito(int produtoFavorito) {
		this.produtoFavorito = produtoFavorito;
	}	
	
	
}
