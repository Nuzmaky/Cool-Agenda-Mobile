package com.example.coolagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	
	// Versão do banco de dados
	private static final int DATABASE_VERSION = 1;

	// Nome do banco de dados
	private static final String DATABASE_NAME = "dbCoolAgenda";

	// Tabela de contatos
	private static final String TABLE_COMPROMISSO = "CREATE TABLE COMPROMISSO(ID INTEGER, NOME TEXT, DATAINICIAL TEXT, DATAFINAL TEXT, PRIMARY KEY(ID))";
	private static final String TABLE_CONTATO = "CREATE TABLE CONTATO(ID INTEGER, NOME TEXT, EMAIL TEXT, ENDERECO TEXT, PRIMARY KEY(ID))";	

	public MyDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Criação das tabelas
	@Override
	public void onCreate(SQLiteDatabase db) {				
		
		db.execSQL("DROP TABLE IF EXISTS COMPROMISSO");				
		db.execSQL(TABLE_COMPROMISSO);	
		
		db.execSQL("DROP TABLE IF EXISTS CONTATO");		
		db.execSQL(TABLE_CONTATO);		
	}

	// Se existir alteração na base alteramos a versão e realizamos as alterações a seguir
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{

		db.execSQL("DROP TABLE IF EXISTS COMPROMISSO");		
		onCreate(db);
		 
		db.execSQL("DROP TABLE IF EXISTS CONTATO"); 
		onCreate(db);		
	}	

}
