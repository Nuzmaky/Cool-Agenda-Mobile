package com.example.coolagenda;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_login);
        
		// Login btn evento Click
		Button btnLogin = (Button) findViewById(R.id.btnLogar);
		btnLogin.setOnClickListener(this); 	
                
    }
    
	// ===== LOGIN
	public void onClick(View v) {

		// Email, password editText
		EditText txtLogin, txtSenha; 
		
		//Email, Senha
		txtLogin = (EditText) findViewById(R.id.editLogin);
		txtSenha = (EditText) findViewById(R.id.editSenha);   

		// Get username, senha
		String login = txtLogin.getText().toString();
		String senha = txtSenha.getText().toString();

		DialogOkNo(ValidaLogin(login,senha));
		//if (ValidaLogin(login, senha))
			//Cadastro(v);

	}
	
	// Abre a tela de Cadastro	
	public void Cadastro (View view){
		startActivity(new Intent(this, ContatoActivity.class));				
	}
    
	
	// ==== VERIFICA SE LOGIN É VÁLIDO
	private boolean ValidaLogin(String login, String senha) {

		// Check se foi digitado              
		if(login.trim().length() > 0 && senha.trim().length() > 0)
		{									
			if (login.equals("admin") && senha.equals("senha"))
				return true;
			else {
				return false;
			}
		}
		else
			return false;
	}
               
	//Caixa de diálogo
	public AlertDialog dialogOK;
	public AlertDialog dialogNO;
	public void DialogOkNo(boolean i) {

		if (i == true)
		{
			//Abre tela de Compromissos
			startActivity(new Intent(this, CompromissoActivity.class));
			
			/*AlertDialog.Builder alertaOK = new AlertDialog.Builder(this);
			alertaOK.setTitle("Login");
			alertaOK.setMessage("Logado com sucesso!");
			dialogOK = alertaOK.create();
			// Abre a próxima tela				
			dialogOK.show();*/
			
		} 
		else
		{
			//startActivity(new Intent(this, ContatoActivity.class));
			
			AlertDialog.Builder alertaNO = new AlertDialog.Builder(this);
			alertaNO.setTitle("Login");
			alertaNO.setMessage("Usuário ou senha errados!");
			dialogNO = alertaNO.create();
			dialogNO.show();
		
		}
	}

}
