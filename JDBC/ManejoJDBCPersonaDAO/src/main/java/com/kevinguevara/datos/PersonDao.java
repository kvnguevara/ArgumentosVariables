package com.kevinguevara.datos;

import com.kevinguevara.domain.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    public int insert(PersonaDTO persona) throws SQLException;

    public int update(PersonaDTO persona) throws SQLException;

    public int delete(PersonaDTO persona)throws SQLException;

    public List<PersonaDTO> select()throws SQLException;
}
