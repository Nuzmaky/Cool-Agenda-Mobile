package com.example.coolagenda;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		//testSharedPreferences();
		//writeFile();
		//readFile();
		testeBase();
	}		
	
	
	

	public void testeBase(){

		//nosso objeto para manipular dados
		ContatoCRUD crud = new ContatoCRUD(this);

		//inserindo registros
		Log.d("Insert: ", "Inserting ..");
		crud.addContato(new Contato(1, "ERNESTO", "9100000000",""));
		crud.addContato(new Contato(2, "ADAMASTOR", "9100000001",""));
		crud.addContato(new Contato(3, "PLINIA", "9100000002",""));

		//recuperando todos os registros
		Log.d("Recuperando: ", "Reading all contacts..");
		List<Contato> contatos = crud.getTodosContatos();      
		for (Contato cn : contatos) {
			String log = "Id: "+cn.getId()+" ,Nome: " + cn.getNomeContato() + " ,E-mail: " + cn.getEmail() + " ,Endereço: " + cn.getEndereco();
			// mostra resultado no log
			Log.d("Resultado: ", log);
		}		
	}

}
