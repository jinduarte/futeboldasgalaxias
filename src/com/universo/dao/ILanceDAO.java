package com.universo.dao;

import com.universo.entity.Lance;

public interface ILanceDAO {

    public long salvar(Lance lance);

    public long atualizar(Lance lance);

    public boolean excluir(Long id);

}
