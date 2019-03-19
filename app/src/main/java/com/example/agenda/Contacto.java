package com.example.agenda;

import java.io.Serializable;
import java.util.ArrayList;

public class Contacto implements Serializable {

        private String Nombre;
        private String telefono;
        private String email;
        private ArrayList<Contacto> itemList = new ArrayList<Contacto>();

        public String getNombre() {
            return Nombre;
        }
        public void setNombre(String Nombre){
            this.Nombre = Nombre;
        }
        public String getTelefono(){
            return telefono;
        }
        public void setTelefono(String telefono){
            this.telefono = telefono;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public ArrayList<Contacto> getArrayList(){
            return itemList;
        }
        public int getSize(){
            return itemList.size();
        }
        public void addNewItem(Contacto item){
            this.itemList.add(item);
        }

}
