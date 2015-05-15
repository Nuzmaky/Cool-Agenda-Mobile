package com.example.coolagenda;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterListContatos extends BaseAdapter{
	
	 private LayoutInflater mInflater;
	    private ArrayList<ContatosActivity> itens;
	 
	    public AdapterListContatos(Context context, ArrayList<ContatosActivity> itens)
	    {
	        //Itens que preencheram o listview
	        this.itens = itens;
	        //responsavel por pegar o Layout do item.
	        mInflater = LayoutInflater.from(context);
	    }
	 
	    /**
	     * Retorna a quantidade de itens
	     *
	     * @return
	     */
	    public int getCount()
	    {
	        return itens.size();
	    }
	 
	    /**
	     * Retorna o item de acordo com a posicao dele na tela.
	     *
	     * @param position
	     * @return
	     */
	    public ContatosActivity getItem(int position)
	    {
	        return itens.get(position);
	    }
	 
	    /**
	     * Sem implementação
	     *
	     * @param position
	     * @return
	     */
	    public long getItemId(int position)
	    {
	        return position;
	    }
	 
	    public View getView(int position, View view, ViewGroup parent)
	    {
	        //Pega o item de acordo com a posção.
	        ContatosActivity item = itens.get(position);
	        
	        //infla o layout para podermos preencher os dados
	        view = mInflater.inflate(R.layout.listacontatos_activity, null);
	 
	        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
	        //ao item e definimos as informações.
	        ((TextView) view.findViewById(R.id.text)).setText(item.getTexto());	        
	 
	        return view;
	    }	

}
