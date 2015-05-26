package com.example.coolagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{

	// Vers�o do banco de dados
	private static final int DATABASE_VERSION = 1;

	// Nome do banco de dados
	private static final String DATABASE_NAME = "dbCoolAgenda";

	// Tabela de contatos
	private static final String TABLE_CONTATO = 
			"CREATE TABLE CONTATO(ID INTEGER, NOME TEXT, EMAIL TEXT, ENDERECO TEXT PRIMARY KEY(ID))";

	public MyDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Cria��o das tabelas
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CONTATO);

	}

	// Se existir altera��o na base alteramos a vers�o e realizamos as altera��es a seguir
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// apaga tabelas antigas
		db.execSQL("DROP TABLE IF EXISTS CONTATO");

		// cria as tabelas novamente
		onCreate(db);
	}	

}
