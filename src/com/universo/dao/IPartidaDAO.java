package com.universo.dao;

import java.util.List;

import com.universo.entity.Partida;

public interface IPartidaDAO {

    public long salvar(Partida partida);

    public long atualizar(Partida partida);

    public boolean excluir(Long id);

    public List<Partida> buscarTodasPartidas();

    public Partida buscarPartidaPorId(Long id);
}
