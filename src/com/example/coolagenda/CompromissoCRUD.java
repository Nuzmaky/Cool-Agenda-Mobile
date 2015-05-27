package com.example.coolagenda;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CompromissoCRUD {	

	//objeto helper
	private MyDatabaseHelper myDbHelper;

	//construtor, que recebe o contexto
	public CompromissoCRUD(Context context){

		myDbHelper = new MyDatabaseHelper(context);
	}

	// Adiciona um Compromisso
	public void addCompromisso(Compromisso compromisso) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("NOME", compromisso.getNome());
		values.put("DATAINICIAL", compromisso.getDataInicial());
		values.put("DATAFINAL", compromisso.getDataFinal());

		//insere registro
		db.insert("COMPROMISSO", null, values);
		db.close(); //fecha a base
	}

	// Recupera um Compromisso
	public Compromisso getCompromisso(int id) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		//o cursor recebe o resultado da consulta
		//aqui o metodo "query" recebe quatro parametros
		Cursor cursor = 
				db.query("COMPROMISSO", //o nome da tabela
						new String[] { "ID", "NOME", "DATAINICIAL", "FINAL" }, //uma lista com as colunas da tabela 
						"ID = ?",  //a cláusula WHERE com a variavel de substituicao "?"
						new String[] { String.valueOf(id) }, //a lista de valores que será utilizada para substituir a variavel de substituicao da clausula WHERE
						null, //cláusula GROUP BY
						null, //clausula HAVING
						null //clausula ORDER BY
						); 

		//se recuperou alguma coisa move cursor para a primeira posicao
		if (cursor != null)
			cursor.moveToFirst();

		Compromisso compromisso = 
				new Compromisso(cursor.getInt(0),
						cursor.getString(1), 
						cursor.getString(2),
						cursor.getString(3));		
		cursor.close();
		db.close();

		// returna o compromisso
		return compromisso;
	}

	// Recupera todos os contatos
	public List<Compromisso> getTodosCompromissos() {

		List<Compromisso> listaCompromisso = new ArrayList<Compromisso>();
		//select para a consulta
		String selectQuery = "SELECT * FROM COMPROMISSO ";

		SQLiteDatabase db = myDbHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// percorre todos os registros recuperados
		if (cursor.moveToFirst()) {
			do {
				Compromisso compromisso = 
						new Compromisso(cursor.getInt(0),
								cursor.getString(1),
								cursor.getString(2),
								cursor.getString(3));
				// adiciona registro atual na lista
				listaCompromisso.add(compromisso);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();

		// retorna a lista de contatos
		return listaCompromisso;
	}

	//Atualiza um Compromisso
	public int updateCompromisso(Compromisso compromisso) {
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("NOME", compromisso.getNome());
		values.put("DATAINICIAL", compromisso.getDataInicial());
		values.put("DATAFINAL", compromisso.getDataFinal());

		// atualiza registro
		int ret = db.update("COMPROMISSO", //o nome da tabela 
				values, //lista de valores a serem atualizados
				"ID = ?",  //a cláusula WHERE com a variavel de substituicao "?"
				new String[] { String.valueOf(compromisso.getId()) }); //a lista de valores que será utilizada para substituir a variavel de substituicao da clausula WHERE
		db.close();

		return ret;
	}	

	// Remove um contato
	public void deleteCompromisso(Compromisso compromisso)
	{
		SQLiteDatabase db = myDbHelper.getWritableDatabase();

		db.delete("COMPROMISSO", //o nome da tabela 
				"ID = ?",  //a cláusula WHERE com a variavel de substituicao "?"
				new String[] { String.valueOf(compromisso.getId()) }); //a lista de valores que será utilizada para substituir a variavel de substituicao da clausula WHERE
		db.close();
	}
}
