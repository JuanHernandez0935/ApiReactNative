package com.apiNative.ApiReactNative.models;
import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String apeP;
    private String apeM;
    private String tel;
    private String correo;
    private String dir;

    // Metodos set y get id
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Metodos set y get nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Metodos set y get apeP
    public String getApeP() {
        return apeP;
    }
    public void setApeP(String apeP) {
        this.apeP = apeP;
    }

    // Metodos set y get apeM
    public String getApeM() {
        return apeM;
    }
    public void setApeM(String apeM) {
        this.apeM = apeM;
    }

    // Metodos set y get tel
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    // Metodos set y get correo
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Metodos set y get dir
    public String getDir() {
        return dir;
    }
    public void setDir(String dir) {
        this.dir = dir;
    }

}
