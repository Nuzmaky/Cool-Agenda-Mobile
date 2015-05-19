
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
		
		lista.add(new Compromisso("Evento tal", "20/05/2015", "20/05/2015"));
		lista.add(new Compromisso("Evento X", "20/05/2015", "17/02/2015"));
		lista.add(new Compromisso("Evento Y", "20/05/2015", "14/11/2015"));
		lista.add(new Compromisso("Evento da Galera", "20/05/2015", "01/12/2015"));
		lista.add(new Compromisso("Evento Ugul", "20/05/2015", "10/01/2016"));
		
		
		ArrayAdapter<Compromisso> adapter = new CompromissoAdapter(lista, this);
		ListView listaCompromisso = (ListView)findViewById(R.id.listaCompromissoActivity);
		listaCompromisso.setAdapter(adapter);
		
		
    	listaCompromisso.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) 
			{
				Toast toast = Toast.makeText(getApplicationContext(), "Clicou no item: " + position ,Toast.LENGTH_LONG);
				toast.show();
				//mostraDialogCustomizado(position, lista);
			}		
    	});
	}
}

