package com.example.Hospital_management_system1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    HashMap<Integer,Patient> patientDb = new HashMap<>();
    @PostMapping("/addviaParamaters")

    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,@RequestParam("age")Integer age,@RequestParam("disease")String disease){
        Patient patient = new Patient(patientId,name,disease,age);
        patientDb.put(patientId,patient);
        return "patient added successfully";


    }

    @PostMapping("/addViaRequestBody")

    public String addPatient(@RequestBody Patient patient){
         int key =patient.getPatientId();
         patientDb.put(key,patient);
         return "patient added via RequestBody";

    }

    @GetMapping("/getInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){
        Patient patient=patientDb.get(patientId);
        return patient;


    }

    @GetMapping("/getAllPatients")

    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();
        for(Patient p:patientDb.values()){
            patients.add(p);

        }
        return patients;

    }

    @GetMapping("/getInfoViaPathVariable/{patientId}")
     public Patient getPatientInfo(@PathVariable("patientId")Integer  patientId){
        Patient patient =patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getPatients/{age}/{disease}")
    public List<Patient> getPatients(@PathVariable ("age")Integer age,@PathVariable ("disease")String disease){
        List<Patient> patients = new ArrayList<>();

        for(Patient p:patientDb.values()){
            if(p.getAge()>age && p.getDisease().equals(disease)){
                patients.add(p);

            }
        }
        return patients;
    }

    @GetMapping("/getPatientByName")
      public Patient getPatientsByName(@RequestParam("name")String name){
        for(Patient p :patientDb.values()){
            if(p.getName().equals(name))return p;
        }
        return null;
    }
    @GetMapping("/getPatientsListGreaterThanAge")
    public List<Patient> getPatientsListGreaterThanAge(@RequestParam("age")Integer age){
        List<Patient> patients = new ArrayList<>();
        for(Patient p:patientDb.values()){
            if(p.getAge()>age){
                patients.add(p);
            }
        }
        return patients;

    }

    @PutMapping("/updatePatientsDetail")

    public String updatePatinetsDetails(@RequestBody Patient patient  ) {
        int key = patient.getPatientId();
        if (patientDb.containsKey(key)) {
            patientDb.put(key, patient);
            return "The patient has been successfully update ";

        }
        else return "Does not exist data";
    }

    @PutMapping("/updateDisease")

    public String updateDisease(@RequestParam ("patientId")Integer patientId,@RequestParam ("disease")String disease){

        if(patientDb.containsKey(patientId)){
            Patient patient =patientDb.get(patientId);
            patient.setDisease(disease);
            patientDb.put(patientId,patient);

            return "updated successfully";
        }
        else return "patient does not exist";

    }

    @DeleteMapping("/deletePatient")

    public String deletePatient(@RequestParam("patientId")Integer patientId){
        patientDb.remove(patientId);
        return "patient has been deleted successfully";

    }





}
