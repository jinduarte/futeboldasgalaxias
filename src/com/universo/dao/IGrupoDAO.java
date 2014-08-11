package com.universo.dao;

import com.universo.entity.Grupo;


public interface IGrupoDAO {

    public Grupo buscarGrupo(Grupo grupo);

    public long salvar(Grupo grupo);
}

