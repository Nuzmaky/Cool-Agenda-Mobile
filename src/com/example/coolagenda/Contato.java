package com.example.coolagenda;

public class Contato {
	
	//private int id;
	private String nomeContato;
	private String email;
	private String endereco;
	
	public Contato() {}
	
	public Contato(String nomeContato, String email, String endereco) 	
	{
		super();
		this.nomeContato = nomeContato;
		this.email = email;
		this.endereco = endereco;	
	}
	
	//public int getId() { return id; }
	//public void setId(int id) {	this.id = id; }
	
	public String getNomeContato() { return nomeContato; }
	public void setNomeContato(String nomeContato) { this.nomeContato = nomeContato; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) {	this.email= email; }
	
	public String getEndereco() { return endereco; }
	public void setEndereco(String endereco) {	this.endereco= endereco; }		

}
