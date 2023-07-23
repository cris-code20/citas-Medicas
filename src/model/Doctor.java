package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends user {

//    creacion de atribustos del doctor

     String speciality;


    //    creando un construtor de la clase doctor

public Doctor(String name, String email){
    super(name,email);
    this.speciality = speciality;
}
// creacion de getter and setter
    public String getSpeciality() {
        return "la especialidad de la doctora: " + this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: cruz roja");
    }



//clase anidad
    ArrayList<AvalibleAppointment> avalibleAppointments = new ArrayList<>();
    public void addAvalibleAppointment(String date, String time) {
        avalibleAppointments.add(new Doctor.AvalibleAppointment(date, time));
    }

    public  ArrayList<AvalibleAppointment> getAvalibleAppointment(){
        return avalibleAppointments;
    }
// una sobrecarga de clases anidada
    public static class AvalibleAppointment{
    private int id;
    private Date date;
    private String time;
    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

// un costrutor de las clases anidadas
        public AvalibleAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public Date getDate(String DATE) {
            return date;
        }

    public String getDate() {
        return format.format(date);
    }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }




    }
}
