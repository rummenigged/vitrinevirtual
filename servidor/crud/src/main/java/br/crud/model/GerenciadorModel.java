package br.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gerenciador")
public class GerenciadorModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int idGerenciador;

@Column(name="gerenciadoremail")
String gerenciadorEmail;

@Column(name="gerenciadorsenha")
String gerenciadorSenha;

@Column(name="gerenciadorusuario")
String gerenciadorUsuario;

@Column(name="gerenciadorclienteson")
int gerenciadorClientesOn;

public int getIdGerenciador() {
	return idGerenciador;
}

public void setIdGerenciador(int idGerenciador) {
	this.idGerenciador = idGerenciador;
}

public String getGerenciadorEmail() {
	return gerenciadorEmail;
}

public void setGerenciadorEmail(String gerenciadorEmail) {
	this.gerenciadorEmail = gerenciadorEmail;
}

public String getGerenciadorSenha() {
	return gerenciadorSenha;
}

public void setGerenciadorSenha(String gerenciadorSenha) {
	this.gerenciadorSenha = gerenciadorSenha;
}

public String getGerenciadorUsuario() {
	return gerenciadorUsuario;
}

public void setGerenciadorUsuario(String gerenciadorUsuario) {
	this.gerenciadorUsuario = gerenciadorUsuario;
}

public int getGerenciadorClientesOn() {
	return gerenciadorClientesOn;
}

public void setGerenciadorClientesOn(int gerenciadorClientesOn) {
	this.gerenciadorClientesOn = gerenciadorClientesOn;
}





}
