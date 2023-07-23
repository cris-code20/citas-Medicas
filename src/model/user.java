package model;

public abstract class user {
    private String nombre;
    private String email;
    private String address;
    private String phoneNumber;

    public user(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getNombre() {
        return nombre +  " bienvenido";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
       if(phoneNumber.length() > 8){
           System.out.println("solo admite 8 digitos");
           return;
       }
       if (phoneNumber.length() == 8){
           this.phoneNumber = phoneNumber;
           return;
       }

    }

    public abstract void showDataUser();


}
