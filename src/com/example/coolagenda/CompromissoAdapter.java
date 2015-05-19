package com.example.coolagenda;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CompromissoAdapter extends ArrayAdapter<Compromisso> {
	
	private List<Compromisso> lista;
	private Context context;
	
	public CompromissoAdapter(List<Compromisso> ls, Context ct)
	{
		super(ct, R.layout.listacompromisso_activity, ls);
		
		lista = ls;
		context = ct;
	}
	
	public View getView (int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listacompromisso_activity, parent, false);
		}
		
		//TextView txvID = (TextView)convertView.findViewById(R.id.txtID);
		TextView txvNome = (TextView)convertView.findViewById(R.id.txtNome);
		TextView txvDataInicial = (TextView)convertView.findViewById(R.id.txtDataInicial);
		TextView txvDataFinal = (TextView)convertView.findViewById(R.id.txtDataFinal);
		
		return convertView;
	}

}
