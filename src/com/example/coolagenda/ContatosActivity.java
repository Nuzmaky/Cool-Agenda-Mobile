package com.example.coolagenda;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ContatosActivity extends Activity implements OnItemClickListener {

	private String texto;
	private ListView listView;
	private AdapterListContatos adapterListView;
	private ArrayList<ContatosActivity> itens;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//carrega o layout onde contem o ListView
		setContentView(R.layout.listacontatos_activity);

		//Pega a referencia do ListView
		listView = (ListView) findViewById(R.id.listContatos);
		//Define o Listener quando alguem clicar no item.
		listView.setOnItemClickListener(this);

		createListView();
	}

	private void createListView()
	{
		//Criamos nossa lista que preenchera o ListView
		itens = new ArrayList<ContatosActivity>();
		ContatosActivity item1 = new ContatosActivity("Evento tal");
		ContatosActivity item2 = new ContatosActivity("Entao 2");
		ContatosActivity item3 = new ContatosActivity("Festa ");
		ContatosActivity item4 = new ContatosActivity("trabalo");

		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		itens.add(item4);

		//Cria o adapter
		adapterListView = new AdapterListContatos(this, itens);

		//Define o Adapter
		listView.setAdapter(adapterListView);
		
		//Cor quando a lista é selecionada para ralagem.
		listView.setCacheColorHint(Color.TRANSPARENT);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		//Pega o item que foi selecionado.
		ContatosActivity item = adapterListView.getItem(arg2);
		//Demostração
		Toast.makeText(this, "Você Clicou em: " + item.getTexto(), Toast.LENGTH_LONG).show();
	}

	public ContatosActivity()
	{
	}

	public ContatosActivity(String texto)
	{
		this.texto = texto;
	}

	public String getTexto()
	{
		return texto;
	}

	public void setTexto(String texto)
	{
		this.texto = texto;
	}

}
