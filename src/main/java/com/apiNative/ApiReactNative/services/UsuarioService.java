package com.apiNative.ApiReactNative.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiNative.ApiReactNative.models.UsuarioModel;
import com.apiNative.ApiReactNative.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // Obtener contactos
    public ArrayList<UsuarioModel> obtenerUsu() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    // Guardar contactos
    public UsuarioModel guardarUsu(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener por id
    public Optional<UsuarioModel> obtenerId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Buscar por nombre
    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    // Buscar por apellido paterno
    public ArrayList<UsuarioModel> obtenerPorApeP(String apeP) {
        return usuarioRepository.findByApeP(apeP);
    }

    // Buscar por apellido materno
    public ArrayList<UsuarioModel> obtenerPorApeM(String apeM) {
        return usuarioRepository.findByApeM(apeM);
    }

    // Elimnar usuario
    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception err) {
            return false;
        }
        return false;
    }

    // Método para búsqueda dinámica por nombre, apellido paterno y apellido materno
    public List<UsuarioModel> searchDynamic(String term) {
        return usuarioRepository.searchDynamic(term);
    }

    // Actualizar usuario
    public UsuarioModel actualizarUsuario(Long id, UsuarioModel usuarioActualizado) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioModel usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApeP(usuarioActualizado.getApeP());
            usuarioExistente.setApeM(usuarioActualizado.getApeM());
            usuarioExistente.setTel(usuarioActualizado.getTel());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setDir(usuarioActualizado.getDir());

            return usuarioRepository.save(usuarioExistente);
        } else {
            throw new IllegalArgumentException("No se encontró el usuario con ID: " + id);
        }
    }
}
