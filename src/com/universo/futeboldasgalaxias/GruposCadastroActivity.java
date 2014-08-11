package com.universo.futeboldasgalaxias;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.universo.dao.GrupoDAO;
import com.universo.entity.Grupo;

public class GruposCadastroActivity extends FragmentActivity {

    LinearLayout dfragbutton;
    //Button alertdfragbutton;
    FragmentManager fm = getSupportFragmentManager();
    
    GrupoDAO grupoDao = new GrupoDAO(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_grupos_cadastro);

        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        // Locate the button in activity_main.xml
        dfragbutton = (LinearLayout) findViewById(R.id.linearLayoutOpenDialogGolsPorPartida);
        //alertdfragbutton = (Button) findViewById(R.id.alertdfragbutton);

        // Capture button clicks
        dfragbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                DialogGrupoGolsPorPartida dFragment = new DialogGrupoGolsPorPartida();
                // Show DialogFragment
                dFragment.show(fm, null);
                
                /*NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
                np.setMaxValue(20);
                np.setMinValue(0);
                np.setFocusable(true);
                np.setFocusableInTouchMode(true);
                */
            }
        });

        // Capture button clicks
        /*alertdfragbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                AlertDFragment alertdFragment = new AlertDFragment();
                // Show Alert DialogFragment
                alertdFragment.show(fm, "Alert Dialog Fragment");
            }
        });*/
    }
    
    @Override
	protected void onStart() {
		super.onStart();
		Log.i("CICLO", "ON START");
	}
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.i("CICLO", "ON RESUME");
    }

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("CICLO", "ON RESTART");
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		Toast.makeText(GruposCadastroActivity.this, "value:asdfasd", Toast.LENGTH_SHORT).show();
		
		//EXCLUIR DEPOIS
        List<Grupo> todosGrupos = new ArrayList<Grupo>();
        todosGrupos = grupoDao.buscarTodosGrupos();

        for (Grupo grupoTeste : todosGrupos) {
            Log.i("GRUPO: ", grupoTeste.toString());
            Toast.makeText(GruposCadastroActivity.this, "value: "+grupoTeste.getConfigGols().toString(), Toast.LENGTH_SHORT).show();
        }
        //FIM EXCLUIR
        
		Log.i("CICLO", "ON PAUSE");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("CICLO", "ON STOP");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.i("CICLO", "ON DESTROY");
	}
}


