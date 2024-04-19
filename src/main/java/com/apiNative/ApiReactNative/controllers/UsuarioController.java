package com.apiNative.ApiReactNative.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiNative.ApiReactNative.models.UsuarioModel;
import com.apiNative.ApiReactNative.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://127.0.0.1:64201")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsu() {
        return usuarioService.obtenerUsu();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsu(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerId(id);
    }

    @GetMapping("/query")
    public List<UsuarioModel> searchDynamic(@RequestParam("term") String term) {
        return this.usuarioService.searchDynamic(term);
    }

    @GetMapping("/queryNombre")
    public ArrayList<UsuarioModel> ObtenerUsuarioPorNombre(@RequestParam("nombre") String nombre) {
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    @GetMapping("/queryApeP")
    public ArrayList<UsuarioModel> ObtenerUsuarioPorApeP(@RequestParam("apeP") String apeP) {
        return this.usuarioService.obtenerPorApeP(apeP);
    }

    @GetMapping("/queryApeM")
    public ArrayList<UsuarioModel> ObtenerUsuarioPorApeM(@RequestParam("apeM") String apeM) {
        return this.usuarioService.obtenerPorApeM(apeM);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se elimino el contacto con id: " + id;
        } else {
            return "No se pudo eliminar el contacto con id: " + id;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        try {
            UsuarioModel usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
