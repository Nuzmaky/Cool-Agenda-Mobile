package com.example.coolagenda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditaContatoActivity extends Activity {
	/*
	Contato contato;
	int posicao;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editacontato_activity);

		final Bundle extras = getIntent().getExtras();
		if (extras == null)
			return;

		contato = (Contato) extras.getSerializable("contato");
		posicao = extras.getInt("posicao");

		carregaPagina(posicao, contato);
	}


	void carregaPagina(int posicao, final Contato contato) {

		final EditText etxtNome = (EditText) findViewById(R.id.editEditaNomeContato);
		final EditText etxtEmail = (EditText) findViewById(R.id.editEditaEmailContato);
		final EditText etxtEndereco = (EditText) findViewById(R.id.editEditaEnderecoContato);

		etxtNome.setText(contato.getNomeContato());
		etxtEmail.setText(contato.getEmail());
		etxtEndereco.setText(contato.getEndereco());

		Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {										

				String mensagem = "Registro Salvo";

				contato.setNomeContato(etxtNome.getText().toString());				
				contato.setEmail(etxtEmail.getText().toString());
				contato.setEndereco(etxtEndereco.getText().toString());

				Toast.makeText(EditaContatoActivity.this, mensagem,
						Toast.LENGTH_SHORT).show();

				EditaContatoActivity.this.finish();
			}
		});

		Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
		btnCancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				EditaContatoActivity.this.finish();
			}
		});

	}
*/


}