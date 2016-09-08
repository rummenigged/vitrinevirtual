package br.crud.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="promocao")
public class PromocaoModel {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int idpromocao;

@Column(name="promocaourlbanner")
String promocaoURLBanner;

@Column(name="promocaoduracao")
@Temporal(TemporalType.TIMESTAMP)
Date promocaoDuracao;

@Column(name="promocaoview")
int promocaoView;

public int getIdpromocao() {
	return idpromocao;
}

public void setIdpromocao(int idpromocao) {
	this.idpromocao = idpromocao;
}

public String getPromocaoURLBanner() {
	return promocaoURLBanner;
}

public void setPromocaoURLBanner(String promocaoURLBanner) {
	this.promocaoURLBanner = promocaoURLBanner;
}

public Date getPromocaoDuracao() {
	return promocaoDuracao;
}

public void setPromocaoDuracao(Date promocaoDuracao) {
	this.promocaoDuracao = promocaoDuracao;
}

public int getPromocaoView() {
	return promocaoView;
}

public void setPromocaoView(int promocaoView) {
	this.promocaoView = promocaoView;
}








}
