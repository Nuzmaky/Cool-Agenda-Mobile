package com.example.coolagenda;

public class Compromisso {
	
	//private int id;
	private String nome;
	private String dataInicial;
	private String dataFinal;
	
	public Compromisso() {}	
	
	public Compromisso (String nome, String dataInicial, String dataFinal)
	{
		super();
		//this.id = id;
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	//public int getId() { return id; }
	//public void setId(int id) {	this.id = id; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) {	this.nome = nome; }
	
	public String getDataInicial() { return dataInicial; }
	public void setDataInicial(String dataInicial) {	this.dataInicial= dataInicial; }
	
	public String getDataFinal() { return dataFinal; }
	public void setDataFinal(String dataFinal) {	this.dataFinal= dataFinal; }	
	

}
