/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.escuela.daoImpl;

import com.example.escuela.dao.EscuelaDao;
import com.example.escuela.model.Escuela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Micaela
 */
@Repository
public class EscuelaDaoImpl  implements EscuelaDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int create(Escuela escuela) {
        String SQL ="INSERT INTO escuela(nombre) VALUES(?)";
        return jdbcTemplate.update(SQL,new Object[]{escuela.getNombre()});
    }

    @Override
    public int update(Escuela escuela) {
        String SQL ="UPDATE escuela SET nombre=? WHERE idescuela=?";                 
        return jdbcTemplate.update(SQL,new Object[]{escuela.getNombre(), escuela.getIdescuela()});
    }

    @Override
    public int delete(int id) {
       String SQL ="DELETE FROM escuela WHERE idescuela=?"; 
        return jdbcTemplate.update(SQL,id);
    }

    @Override
    public Escuela read(int id) {
            String SQL ="SELECT * FROM escuela WHERE idescuela=?";
        try {
            Escuela escuela = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Escuela.class),id);
            return escuela;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Escuela> readAll() {
        String SQL ="SELECT idescuela, nombre FROM escuela ORDER BY idescuela ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Escuela.class));
    }

}
