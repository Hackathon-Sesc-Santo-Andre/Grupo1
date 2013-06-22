package br.org.virtualtrainersesc;

import br.org.virtualtrainersesc.model.Treino;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// "chamando" os objetos
		final EditText matricula = (EditText) findViewById(R.id.txMatricula);
		final EditText senha = (EditText) findViewById(R.id.txSenha);
		Button entrar = (Button) findViewById(R.id.btnEntrar);
		Button limpar = (Button) findViewById(R.id.btnLimpar);
		
		
		entrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				String vrMatricula = "123";
				String vrSenha = "123";
				
				String strMatricula = matricula.getText().toString();
				String strSenha = senha.getText().toString();
				
				if(strMatricula.trim().length() == 0){
					matricula.setError("Favor informar Matricula!");
					
					return;
				}
				if(strSenha.trim().length() == 0){
					matricula.setError("Favor informar Senha!");
					
					return;
				} 
				if (strMatricula.equals(vrMatricula)){
					logar(Integer.parseInt(vrMatricula));
				} else {
					Toast.makeText(LoginActivity.this, "Favor confirmar dados digitados!" , Toast.LENGTH_SHORT).show();
				}
			}

			private void logar(int matricula) {
                Bundle param = new Bundle();
                param.putInt("matricula", matricula);
                
                Intent intent = new Intent(LoginActivity.this, Treinos.class);
                intent.putExtras(param);
                
                startActivity(intent);
				
			}
		});
		
		limpar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				matricula.setText("");
				senha.setText("");
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
