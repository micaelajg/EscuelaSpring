/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.escuela.serviceImpl;

import com.example.escuela.dao.EscuelaDao;
import com.example.escuela.model.Escuela;
import com.example.escuela.service.EscuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Micaela
 */
@Service
public class EscuelaServiceImpl implements EscuelaService{
    @Autowired
    private EscuelaDao escuelaDao;

    @Override
    public int create(Escuela escuela) {
        return escuelaDao.create(escuela);
    }

    @Override
    public int update(Escuela escuela) {
        return escuelaDao.update(escuela);
    }

    @Override
    public int delete(int id) {
         return escuelaDao.delete(id);
    }

    @Override
    public Escuela read(int id) {
        return escuelaDao.read(id);
    }

    @Override
    public List<Escuela> readAll() {
           return escuelaDao.readAll();
    }
    
    
}
