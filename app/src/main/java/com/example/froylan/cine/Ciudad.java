package com.example.froylan.cine;

import com.google.gson.annotations.SerializedName;

/**
 * Created by froylan on 3/12/16.
 */
//[{"Estado":"Guerrero","Id":2,"IdEstado":13,"IdPais":1,"Latitud":16.866389,"Longitud":-99.8825,"Nombre":"Acapulco","Pais":"México","Uris":null},
public class Ciudad {
    @SerializedName("Estado")
    private String Estado;
    @SerializedName("Id")
    private int Id;
    @SerializedName("IdEstado")
    private int IdEsatdo;
    @SerializedName("IdPais")
    private int IdPais;
    @SerializedName("Latitud")
    private double Latitud;
    @SerializedName("Longitud")
    private double Longitud;
    @SerializedName("Nombre")
    private String Nombre;
    @SerializedName("Pais")
    private String Pais;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdEsatdo() {
        return IdEsatdo;
    }

    public void setIdEsatdo(int idEsatdo) {
        IdEsatdo = idEsatdo;
    }

    public int getIdPais() {
        return IdPais;
    }

    public void setIdPais(int idPais) {
        IdPais = idPais;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }
}
