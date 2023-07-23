package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends user {
   private String birthday;
   private double weight;
   private double heighy;
   private String blood;


   private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
   private  ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor );
        appointmentDoctor.shedulable(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    // construtor de la clase patient
  public   Patient(String name, String email){
        super(name,email);

    }

    @Override
    public void showDataUser() {
        System.out.println("paciente");
        System.out.println("hitorial Completo");

    }
//    getters and setteres

//    set es el metodo que usamos para poder obtener los datos
    public void setWeight(double weight) {
        this.weight = weight;
    }
// el get es el metodo que usamos para prencentar los datos
    public String getWeight() {
        return this.weight + " KG";
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeighy() {
        return this.heighy + " mts";
    }

    public void setHeighy(double heighy) {
        this.heighy = heighy;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }



}


