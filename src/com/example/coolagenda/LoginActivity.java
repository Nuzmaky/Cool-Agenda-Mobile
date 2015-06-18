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

		Button btnLogin = (Button) findViewById(R.id.btnLogar);
		btnLogin.setOnClickListener(this); 	
                
    }
    
	// ===== LOGIN
	public void onClick(View v) {

		EditText editLogin, editSenha; 
		
		editLogin = (EditText) findViewById(R.id.editLogin);
		editSenha = (EditText) findViewById(R.id.editSenha);   

		
		String login = editLogin.getText().toString();
		String senha = editSenha.getText().toString();

		DialogOkNo(ValidaLogin(login,senha));
	}
    
	private boolean ValidaLogin(String login, String senha) {
             
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
          
	public AlertDialog dialogOK;
	public AlertDialog dialogNO;
	public void DialogOkNo(boolean i) {

		if (i == true)
		{
			startActivity(new Intent(this, MainActivity.class));
			
		} 
		else
		{
			
			AlertDialog.Builder alertaNO = new AlertDialog.Builder(this);
			alertaNO.setTitle("Login");
			alertaNO.setMessage("Usuário ou senha errados!");
			dialogNO = alertaNO.create();
			dialogNO.show();
			
		
		}
	}

}
