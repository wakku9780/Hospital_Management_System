package com.example.Hospital_management_system1.Models;

import java.util.List;

public class Doctor {
   private int doctorId;
   private  String name;
   private String specialization;
   private int age;
   private String degree;
   private int experience;
   public List<String> schedule;

   public Doctor(int doctorId,String name, String specialization, int age, String degree,int experience,List<String> schedule) {
      this.name = name;
      this.specialization = specialization;
      this.age = age;
      this.degree = degree;
      this.doctorId=doctorId;
      this.experience=experience;
      this.schedule= schedule;
   }

   public List<String> getSchedule() {
      return schedule;
   }

   public void setSchedule(List<String> schedule) {
      this.schedule = schedule;
   }

   public int getExperience() {
      return experience;
   }

   public void setExperience(int experience) {
      this.experience = experience;
   }

   public int getDoctorId() {
      return doctorId;
   }

   public void setDoctorId(int doctorId) {
      this.doctorId = doctorId;
   }
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSpecialization() {
      return specialization;
   }

   public void setSpecialization(String specialization) {
      this.specialization = specialization;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getDegree() {
      return degree;
   }

   public void setDegree(String degree) {
      this.degree = degree;
   }
}
