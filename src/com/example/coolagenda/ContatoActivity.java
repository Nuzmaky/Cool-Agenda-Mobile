package com.example.coolagenda;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ContatoActivity extends Activity {
	
	private List<Contato> lista;
		
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contatos_activity);
		
		CarregaLista();
	}
	
	void CarregaLista()
	{
		lista = new ArrayList<Contato>();
		
		ContatoCRUD crud = new ContatoCRUD(this);
		List<Contato> contatos = crud.getTodosContatos();
			
		for (Contato cn : contatos) 
		{
			lista.add(new Contato(cn.getId(), cn.getNomeContato(), cn.getEmail(), cn.getEndereco()));
		}

		ArrayAdapter<Contato> adapter = new ContatoAdapter(lista, this);
		ListView listaContato = (ListView)findViewById(R.id.listaContatoActivity);
		listaContato.setAdapter(adapter);
		
		
		
		// Clicar em um contato
    	listaContato.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) 
			{
				Toast toast = Toast.makeText(getApplicationContext(), "Clicou no item: " + position ,Toast.LENGTH_LONG);
				toast.show();
			}		
    	});		
	}
	

}
