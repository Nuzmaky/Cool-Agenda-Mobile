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
		
		lista.add(new Contato("Mateus Q.", "mateusq1@hotmail.com","Rua Vereador Horácio Arantes Silva, 148"));
		lista.add(new Contato("Frederico V.", "frcolantonio@gmail.com","Rua do Planalto Verde, 171"));
		lista.add(new Contato("Leandro Y.", "lele_yoshi@gmail.com","Av do Contra Sushi, 2525"));
		
		ArrayAdapter<Contato> adapter = new ContatoAdapter(lista, this);
		ListView listaContato = (ListView)findViewById(R.id.listaContatoActivity);
		listaContato.setAdapter(adapter);
		
		
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
