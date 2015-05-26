package com.example.coolagenda;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ContatoCRUD {
	

	//objeto helper
	private MyDatabaseHelper myDbHelper;

	//construtor, que recebe o contexto
	public ContatoCRUD(Context context){

		myDbHelper = new MyDatabaseHelper(context);
	}

	// Adiciona um contato
	public void addContato(Contato contato) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("NOME", contato.getNomeContato());
		values.put("EMAIL", contato.getEmail());
		values.put("ENDERECO", contato.getEndereco());

		//insere registro
		db.insert("CONTATO", null, values);
		db.close(); //fecha a base
	}

	// Recupera um contato
	public Contato getContato(int id) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		//o cursor recebe o resultado da consulta
		//aqui o metodo "query" recebe quatro parametros
		Cursor cursor = 
				db.query("CONTATO", //o nome da tabela
						new String[] { "ID", "NOME", "EMAIL", "ENDERECO" }, //uma lista com as colunas da tabela 
						"ID = ?",  //a cláusula WHERE com a variavel de substituicao "?"
						new String[] { String.valueOf(id) }, //a lista de valores que será utilizada para substituir a variavel de substituicao da clausula WHERE
						null, //cláusula GROUP BY
						null, //clausula HAVING
						null //clausula ORDER BY
						); 
		
		//se recuperou alguma coisa move cursor para a primeira posicao
		if (cursor != null)
			cursor.moveToFirst();
		
		Contato contato = 
				new Contato(cursor.getInt(0),
							cursor.getString(1), 
							cursor.getString(2),
							cursor.getString(3));		
		cursor.close();
		db.close();
		
		// returna o contato
		return contato;
	}
	
	// Recupera todos os contatos
	public List<Contato> getTodosContatos() {
		
		List<Contato> listaContato = new ArrayList<Contato>();
		//select para a consulta
		String selectQuery = "SELECT * FROM CONTATOS ";

		SQLiteDatabase db = myDbHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// percorre todos os registros recuperados
		if (cursor.moveToFirst()) {
			do {
				Contato contato = 
						new Contato(cursor.getInt(0),
								    cursor.getString(1),
								    cursor.getString(2),
								    cursor.getString(3));
				// adiciona registro atual na lista
				listaContato.add(contato);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		
		// retorna a lista de contatos
		return listaContato;
	}
	
	//Atualiza um contato
	public int updateContato(Contato contato) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("NOME", contato.getNomeContato());
		values.put("EMAIL", contato.getEmail());
		values.put("ENDERECO", contato.getEndereco());

		// atualiza registro
		int ret = db.update("CONTATOS", //o nome da tabela 
						 values, //lista de valores a serem atualizados
						 "ID = ?",  //a cláusula WHERE com a variavel de substituicao "?"
						 new String[] { String.valueOf(contato.getId()) }); //a lista de valores que será utilizada para substituir a variavel de substituicao da clausula WHERE
		db.close();
		
		return ret;
	}	
	
	// Remove um contato
	public void deleteContato(Contato contato) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();
		
		db.delete("CONTATOS", //o nome da tabela 
				  "ID = ?",  //a cláusula WHERE com a variavel de substituicao "?"
				  new String[] { String.valueOf(contato.getId()) }); //a lista de valores que será utilizada para substituir a variavel de substituicao da clausula WHERE
		db.close();
	}	
	

}
