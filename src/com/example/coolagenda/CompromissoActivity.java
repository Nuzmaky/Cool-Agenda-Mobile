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

public class CompromissoActivity extends Activity{
	
	private List<Compromisso> lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compromisso_activity);
		
		CarregaLista();		
	}
	
	void CarregaLista()
	{
		lista = new ArrayList<Compromisso>();
		
		CompromissoCRUD crud = new CompromissoCRUD(this);
		List<Compromisso> compromissos = crud.getTodosCompromissos();		
		
		for (Compromisso cp : compromissos)
		{
			lista.add(new Compromisso(cp.getId(), cp.getNome(), cp.getDataInicial(), cp.getDataFinal()));
		}
		
		ArrayAdapter<Compromisso> adapter = new CompromissoAdapter(lista, this);
		ListView listaCompromisso = (ListView)findViewById(R.id.listaCompromissoActivity);
		listaCompromisso.setAdapter(adapter);
		
		
		// Clicar em um Compromisso
    	listaCompromisso.setOnItemClickListener(new OnItemClickListener() {

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

