package com.universo.futeboldasgalaxias;

import java.util.ArrayList;
import java.util.List;

import com.universo.dao.GrupoDAO;
import com.universo.entity.Grupo;

import net.simonvt.numberpicker.NumberPicker;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DialogGrupoGolsPorPartida extends DialogFragment {
	
	Grupo grupo = new Grupo();
	GrupoDAO grupoDao = new GrupoDAO(getActivity());
    
	/*//DIALOG SIMPLES UTILIZANDO LAYOUT PERSONALIZADO
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_grupo_gols, container,
                false);
        getDialog().setTitle("Gols por Partida");
        // Do something else
        return rootView;
    }*/
    
	/*//DIALOG MAIS SIMPLES, SEM LAYOUT, CONSTRUIDO EM TEMPO DE EXECUCAO (NORMALMENTE PARA CONFIRMAR ACAO)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("ISTO EH UM DIALOG?")
               .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                   }
               })
               .setNegativeButton("NAO", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }*/

	// DIALOG COM LAYOUT PERSONALIZADO COM BOTOES DE ACAO CRIADOS EM TEMPO DE
	// EXECUCAO
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// Get the layout inflater
		LayoutInflater inflater = getActivity().getLayoutInflater();

		View DialogView = inflater.inflate(R.layout.dialog_grupo_gols, null);

		final NumberPicker np = (NumberPicker) DialogView.findViewById(R.id.numberPickerGrupoGols);
		np.setMinValue(1);
		np.setMaxValue(999);
		np.setWrapSelectorWheel(true);
		np.setValue(2);
		
		
		/**
         * VALORES DEFAULT
         */
        grupo.setConfigGols(2);
        grupo.setConfigMinutos(10);
        
        /**
         * SELECIONAR QTD DE GOLS
         */
        np.setValue(grupo.getConfigGols());
        
        /**
         * SELECIONAR TEMPO
         */
        //seekBarTempo.setOnSeekBarChangeListener(this);
        //-textProgressTempo = (TextView) findViewById(R.id.textViewProgressTempo);
        //seekBarTempo.setProgress(grupo.getConfigMinutos());
        //textProgressTempo.setText("Tempo selecionado:  "+ seekBarTempo.getProgress() + "min");

        
        

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		builder.setView(DialogView)
				// Add action buttons
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						
						/**
				         * SETAR NA ENTIDADE GRUPO
				         */
				        // Gol
				        grupo.setConfigGols(np.getValue());
				        // Tempo de Jogo
				        //grupo.setConfigMinutos(np.getValue());
				        //grupo.setId(1);

						//np.setValue(grupo.getConfigGols());
						
						Toast.makeText(getActivity(), "value:"+np.getValue(), Toast.LENGTH_SHORT).show();
						//makeText(DialogGrupoGolsPorPartida.this, "OKKKKK", Toast.LENGTH_SHORT).show();
					}
				})
				.setNegativeButton("Cancelar",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								DialogGrupoGolsPorPartida.this.getDialog()
										.cancel();
							}
						});
		builder.setTitle("Gol(s) por Partida");
		return builder.create();
	}
}

