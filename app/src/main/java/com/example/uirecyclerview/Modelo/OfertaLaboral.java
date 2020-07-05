package com.example.uirecyclerview.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OfertaLaboral {

    private String OfertaLaboral;
    private String Empresa;
    private String Cargo;
    private String Correo;
    private String Descripcion;
    private String Imagen;

    public OfertaLaboral(){

    }

    public OfertaLaboral(String ofertaLaboral, String empresa, String cargo, String correo, String descripcion, String imagen) {
        OfertaLaboral = ofertaLaboral;
        Empresa = empresa;
        Cargo = cargo;
        Correo = correo;
        Descripcion = descripcion;
        Imagen = imagen;
    }

    public String getOfertaLaboral() {
        return OfertaLaboral;
    }

    public void setOfertaLaboral(String ofertaLaboral) {
        OfertaLaboral = ofertaLaboral;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public OfertaLaboral(JSONObject a) throws JSONException {
        OfertaLaboral =  a.getString("OfertaLaboral").toString() ;
        Empresa =  a.getString("Empresa").toString() ;
        Cargo =  a.getString("Cargo").toString() ;
        Correo =  a.getString("Correo").toString() ;
        //Descripcion = a.getString("Descripcion").toString() ;
        Imagen = a.getString("Imagen").toString() ;
    }

    public static ArrayList<com.example.uirecyclerview.Modelo.OfertaLaboral> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<com.example.uirecyclerview.Modelo.OfertaLaboral> ofertas = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            ofertas.add(new OfertaLaboral(datos.getJSONObject(i)));
        }
        return ofertas;
    }
}
