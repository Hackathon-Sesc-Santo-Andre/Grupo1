package br.org.virtualtrainersesc;

import static br.org.virtualtrainersesc.util.Constantes.IP_ADMIN;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import roboguice.activity.RoboActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.org.virtualtrainersesc.model.Exercicio;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

public class Exercicios extends RoboActivity{
	
ListView lista;
	
	AQuery a;
	
	@SuppressLint("NewApi") 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercicios);
		
		a = new AQuery(this);
		
		lista = (ListView) findViewById(R.id.lsExercicios);
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View linha, int position, long idLinha) {
				
	            Bundle param = new Bundle();
	            param.putInt("idExercicio", ((Exercicio)linha.getTag()).getId());
	            param.putString("nomeExercicio", ((Exercicio)linha.getTag()).getNome());
	            
	            
	            //Intent intent = new Intent(Exercicios.this, Exercicios.class);
	            //intent.putExtras(param);
	            
	            //startActivity(intent);
			}
			});
		
		
		popularListView();
		
		ImageView imgCheckin = (ImageView) findViewById(R.id.imgCheckin);
		
		imgCheckin.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				if(event.getAction() ==  event.ACTION_DOWN){
					Bundle param = getIntent().getExtras();
					
					String url = "http://"+IP_ADMIN+"/gym/pages/mobile/exercicios/" + param.getInt("idTreino") + "/checkin";
					System.out.println(" A URL é [" + url + "]");
					
					a.ajax(url, JSONObject.class, this, "retorno");
					
					return mudarPagina();
				}
				
				return false;
			}

			private boolean mudarPagina() {
				Bundle param = getIntent().getExtras();
				System.out.println("cliquei ["+param.getInt("matricula")+"]");
				
                param.putInt("matricula", param.getInt("matricula"));
                
                Intent intent = new Intent(Exercicios.this, Treinos.class);
                intent.putExtras(param);
                
                startActivity(intent);
                /*finish();*/
                
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                v.vibrate(500);
                
				return true;
			}
			
			public void retorno(String url, JSONObject json, AjaxStatus status) throws JSONException {
				if(json != null){
					String retorno = json.getString("data");
					if(retorno != null){
						System.out.println(retorno);
						
						if(retorno.toString().equalsIgnoreCase("OK")){
							Toast.makeText(Exercicios.this, "Checkin realizado com sucesso" , Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(Exercicios.this, retorno.toString() , Toast.LENGTH_SHORT).show();
						}
					}
				} else {
					Toast.makeText(Exercicios.this, 
							"Não foi possivel realizar o checkin, verifique sua conexão com a internet e tente novamente", 
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	private void popularListView() {
		
        if(getIntent().getExtras() != null){
        	Bundle param = getIntent().getExtras();
        	
        	if(param != null){
        		//String url = "http://192.168.1.104:8080/gym/pages/mobile/treinos/"+param.getInt("matricula");
        		//String url = "http://192.168.1.104:8080/gym/pages/mobile/exercicios/2";
        		String url = "http://"+IP_ADMIN+"/gym/pages/mobile/exercicios/"+param.getInt("idTreino");
        		/*String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";*/
        		
        		System.out.println(" A URL é [" + url + "]");
        		
        		a.ajax(url, JSONObject.class, this, "retorno");
        	}
        }
		
		
/*		for (int i = 0; i <= 3; i++) {
			Treino treinoFake = new Treino();
			
			treinoFake.setId(200+i);
			treinoFake.setNome("Treino"+i);
			
			TreinosFake.add(treinoFake);
		}*/
		
/*		ListaTreinoAdapter adapter = new ListaTreinoAdapter(this, R.layout.linha_treino, TreinosFake);
		
		lista.setAdapter(adapter);*/
	}
	
	public void retorno(String url, JSONObject json, AjaxStatus status) throws JSONException {
		if(json != null && json.getJSONArray("listData") != null){ 
			JSONArray jsonArray = json.getJSONArray("listData");

			if(jsonArray.length() == 0){
				TextView linhaExercicio = (TextView) findViewById(R.id.txTreino);
				linhaExercicio.setText("Não existem exercícios, procure o seu professor!");

				return;
			}
			
			List<Exercicio> exercicios = new ArrayList<Exercicio>();
			for (int i = 0; i < jsonArray.length() ; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				Exercicio exercicio = new Exercicio();

				exercicio.setId(jsonObject.getInt("id"));
				//exercicio.setNome(jsonObject.getString("nome"));
				exercicio.setNome(jsonObject.getString("equipamento"));
				
				exercicios.add(exercicio);
			}
			

			ListaExercicioAdapter adapter = new ListaExercicioAdapter(this, R.layout.linha_exercicio, exercicios);

			lista.setAdapter(adapter);
		} 
	}
	
	private class ListaExercicioAdapter extends ArrayAdapter<Exercicio>{

		List<Exercicio> exercicios = null;
		
		public ListaExercicioAdapter(Context context, int textViewResourceId, List<Exercicio> exercicios) {
			super(context, textViewResourceId);
			
			this.exercicios = exercicios;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View linha = convertView;
			
			if(linha == null){
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				linha = vi.inflate(R.layout.linha_exercicio, null);
			}
			
			TextView linhaexercicio = (TextView) linha.findViewById(R.id.txExercicio);
			
			System.out.println("size = ["+exercicios.size()+"]");
			System.out.println("obj = ["+exercicios.get(position)+"]");
			
			Exercicio exercicio = exercicios.get(position);
			
			linhaexercicio.setText(exercicio.getNome());
			linha.setTag(exercicio);
			
			return linha;
		}
		
		@Override
		public int getCount() {
			return exercicios.size(); 
		}
	}
	
}