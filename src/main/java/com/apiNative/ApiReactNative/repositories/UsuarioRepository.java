package com.apiNative.ApiReactNative.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apiNative.ApiReactNative.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    // Buscar por nombre
    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);

    // Buscar por apeP
    public abstract ArrayList<UsuarioModel> findByApeP(String apeP);

    // Buscar por apeP
    public abstract ArrayList<UsuarioModel> findByApeM(String apeM);

    @Query("SELECT u FROM UsuarioModel u WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :term, '%')) " +
            "OR LOWER(u.apeP) LIKE LOWER(CONCAT('%', :term, '%')) " +
            "OR LOWER(u.apeM) LIKE LOWER(CONCAT('%', :term, '%'))")
    public List<UsuarioModel> searchDynamic(String term);
}
