/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.escuela.dao;

import com.example.escuela.model.Escuela;
import java.util.List;

/**
 *
 * @author Micaela
 */
public interface EscuelaDao {
    int create(Escuela escuela);
    int update(Escuela escuela);
    int delete(int id);
    Escuela read(int id);
    List<Escuela> readAll();
}
