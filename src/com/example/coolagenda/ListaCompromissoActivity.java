package com.example.coolagenda;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListaCompromissoActivity extends BaseAdapter{
	
	private LayoutInflater mInflater; 	
	private List<CompromissoActivity> compromissos; 	
	
	public AdapterListView(Context context, List<CompromissoActivity> compromissos) 
	{ 					
		//Itens do listview 
		this.compromissos = compromissos; 

		//Objeto responsável por pegar o Layout do item. 
		mInflater = LayoutInflater.from(context); 
	}

	public int getCount() 
	{ 
		return compromissos.size(); 
	} 

	public CompromissoActivity getItem(int position) 
	{ 
		return compromissos.get(position); 
	} 

	public long getItemId(int position) 
	{ 
		return position;
	}


	public View getView(int position, View view, ViewGroup parent) 	
	{ 
		
		ItemSuporte itemHolder; 
		//se a view estiver nula (nunca criada), inflamos o layout nela. 
		
		if (view == null) 
		{ 
			//infla o layout para podermos pegar as views 
			view = mInflater.inflate(R.layout.listacompromisso_activity, null); 
			
			//cria um item de suporte para não precisarmos sempre /
			//inflar as mesmas informacoes 
			itemHolder = new ItemSuporte(); 
			//itemHolder.txtTitle = ((TextView) view.findViewById(R.id.text));
			//itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.imagemview)); 
			
			//define os itens na view; 
			view.setTag(itemHolder); 
		} 
		else 
		{ 
			//se a view já existe pega os itens. 
			itemHolder = (ItemSuporte) view.getTag(); 
		}
		
		//pega os dados da lista 
		//e define os valores nos itens. 
		CompromissoActivity compromisso = compromissos.get(position); 
		//itemHolder.txtTitle.setText(item.getTexto()); 
		//itemHolder.imgIcon.setImageResource(item.getIconeRid()); 
		
		//retorna a view com as informações 
		return view; 
		
	} 
	
	/**
	 * Classe de suporte para os itens do layout.
	 */ 	
	private class ItemSuporte
	{ 
		//ImageView imgIcon; 
		//TextView txtTitle;
	}
}
		