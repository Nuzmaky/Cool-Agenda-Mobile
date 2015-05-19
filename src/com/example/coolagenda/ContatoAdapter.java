package com.example.coolagenda;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContatoAdapter extends ArrayAdapter<Contato>{
	
	private List<Contato> lista;
	private Context context;
	
	public ContatoAdapter (List<Contato> ls, Context ct)
	{
		super (ct, R.layout.listacontatos_activity, ls);
		
		lista = ls;
		context = ct;
	}
	
	
	public View getView (int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listacontatos_activity, parent, false);
		}
		
		TextView txvNomeContato = (TextView)convertView.findViewById(R.id.txtNomeContato);
		TextView txvEmail = (TextView)convertView.findViewById(R.id.txtEmail);
		TextView txvEndereco = (TextView)convertView.findViewById(R.id.txtEndereco);
			
		Contato c = lista.get(position);
		txvNomeContato.setText(c.getNomeContato());
		txvEmail.setText(c.getEmail());
		txvEndereco.setText(c.getEndereco());		
		
		return convertView;		
		
	}

}
