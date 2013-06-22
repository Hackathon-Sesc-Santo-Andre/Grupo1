package br.org.virtualtrainersesc;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.org.virtualtrainersesc.model.Treino;

public class Treinos extends RoboActivity{
	
	ListView lista;
	
	@SuppressLint("NewApi") 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treinos);
		
		lista = (ListView) findViewById(R.id.lsTreinos);
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> listView, View linha, int position, long idLinha) {
				
                Bundle param = new Bundle();
                param.putInt("idTreino", ((Treino)linha.getTag()).getId());
                param.putString("nomeTreino", ((Treino)linha.getTag()).getNome());
                
                Intent intent = new Intent(Treinos.this, Exercicios.class);
                intent.putExtras(param);
                
                startActivity(intent);
			}
		});
		
		
		popularListView();
		
	}
	
	private void popularListView() {
		List<Treino> TreinosFake = new ArrayList<Treino>();
		
		for (int i = 0; i <= 3; i++) {
			Treino treinoFake = new Treino();
			
			treinoFake.setId(200+i);
			treinoFake.setNome("Treino"+i);
			
			TreinosFake.add(treinoFake);
		}
		
		ListaTreinoAdapter adapter = new ListaTreinoAdapter(this, R.layout.linha_treino, TreinosFake);
		
		lista.setAdapter(adapter);
	}
	
	private class ListaTreinoAdapter extends ArrayAdapter<Treino>{

		List<Treino> treinos = null;
		
		public ListaTreinoAdapter(Context context, int textViewResourceId, List<Treino> treinos) {
			super(context, textViewResourceId);
			
			this.treinos = treinos;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View linha = convertView;
			
			if(linha == null){
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				linha = vi.inflate(R.layout.linha_treino, null);
			}
			
			TextView linhaTreino = (TextView) linha.findViewById(R.id.txTreino);
			
			Treino treino = treinos.get(position);
			
			linhaTreino.setText(treino.getNome());
			linha.setTag(treino);
			
			return linha;
		}
		
		@Override
		public int getCount() {
			return treinos.size(); 
		}
	}
}
