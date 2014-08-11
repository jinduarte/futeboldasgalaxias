package com.universo.service;

import java.util.List;

import android.content.Context;

import com.universo.dao.IJogadorDAO;
import com.universo.dao.JogadorDAO;
import com.universo.entity.Jogador;

public class JogadorService {


    private IJogadorDAO jogadorDao;

    public JogadorService(Context context) {
        this.jogadorDao = new JogadorDAO(context);
    }

    public String[] arrayDeJogadores() {

        List<Jogador> listaJogadores = jogadorDao.buscarTodosJogadores();

        String[] jogadores = new String[listaJogadores.size()];
        for (int i = 0; i < listaJogadores.size(); i++) {
            jogadores[i] = listaJogadores.get(i).getNome();
        }

        return jogadores;

    }

    public List<Jogador> listaDeJogadores() {

        List<Jogador> listaJogadores = jogadorDao.buscarTodosJogadores();

        return listaJogadores;

    }


}
