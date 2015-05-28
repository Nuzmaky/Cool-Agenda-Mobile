package com.example.coolagenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// POPULA A BASE
		populaBanco();

				                
	}
	
	// Abre tela de Contatos
	public void AbreContatos(View v) {
		startActivity(new Intent(this, ContatoActivity.class));
	}		
	
	// Abre tela de Compromissos
	public void onClick(View v) {
		startActivity(new Intent(this, CompromissoActivity.class));
	}			
		

	private void populaBanco() 
	{
		// ===== > CONTATOS
		// ===== > CONTATOS
		//nosso objeto para manipular dados
		ContatoCRUD crudContato = new ContatoCRUD(this);
		crudContato.addContato(new Contato(1, "Empresa Lima","empresalima@coldmail.com","Rua Anões 567"));
		crudContato.addContato(new Contato(2, "Teresa Cristina","tcristina@coldmail.com","Rua Napoli 2520"));
		crudContato.addContato(new Contato(3, "Hester Souza","hestersouza@fmail.com","Rua Domingos 89 apto 55"));
		crudContato.addContato(new Contato(4, "Mateus Q.", "mateusq1@hotmail.com","Rua Vereador Horácio Arantes Silva, 148"));
		crudContato.addContato(new Contato(5, "Flavio da Costa","flaviocosta@fmail.com","Rua Kennedy 500"));
		crudContato.addContato(new Contato(6, "Jessica Silva","jessicasilvaa@email.com","Rua Limões 20"));
		crudContato.addContato(new Contato(7, "Gustavo Henrique","gustavoh@zapmail.com","Av. Goiás 225"));
		crudContato.addContato(new Contato(8, "Empresa Legal","empresalegal@coldmail.com","Rua Gigantes 777"));
		crudContato.addContato(new Contato(9, "Carlos Rebes","carlosrebes@coldmail.com","Rua Rio de Janeiro 20"));
		crudContato.addContato(new Contato(10, "Abilio Silveiro","abiliosilveiro@fmail.com","Rua Cerqueira César 899 apto 20"));
		crudContato.addContato(new Contato(11, "Fabrícia de Melo","fafamelo@fmail.com","Rua Bingo Legal 55"));
		crudContato.addContato(new Contato(12, "Maria Jose","mariajose@email.com","Rua Batatas 200"));
		crudContato.addContato(new Contato(13, "Monique Maria","moniquemaria@zapmail.com","Av. Franca 2225"));  
				
		// ===== > COMPROMISSOS
		// ===== > COMPROMISSOS
		//nosso objeto para manipular dados		
		CompromissoCRUD crudCompromisso = new CompromissoCRUD(this);		
		crudCompromisso.addCompromisso(new Compromisso(1, "Evento tal", "20/05/2015", "20/05/2015"));
		crudCompromisso.addCompromisso(new Compromisso(2, "Evento X", "20/05/2015", "17/02/2015"));
		crudCompromisso.addCompromisso(new Compromisso(3, "Evento Y", "20/05/2015", "14/11/2015"));
		crudCompromisso.addCompromisso(new Compromisso(4, "Evento da Galera", "20/05/2015", "01/12/2015"));
		crudCompromisso.addCompromisso(new Compromisso(5, "Evento Ugul", "20/05/2015", "10/01/2016"));
		crudCompromisso.addCompromisso(new Compromisso(6, "Evento da Facul", "30/07/2015", "31/7/2015"));
	}
}
