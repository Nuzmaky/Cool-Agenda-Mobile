package com.example.coolagenda;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		// Login btn evento Click
		Button btnTestarBase = (Button) findViewById(R.id.btnTestarBase);
		btnTestarBase.setOnClickListener(this); 	
                
    }
    
	// ===== LOGIN
	public void onClick(View v) {

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
