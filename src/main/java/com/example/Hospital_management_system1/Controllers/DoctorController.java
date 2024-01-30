package com.example.Hospital_management_system1.Controllers;

import com.example.Hospital_management_system1.Models.Doctor;
import com.example.Hospital_management_system1.Models.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    HashMap<Integer, Doctor> doctorDb = new HashMap<>();


    public Doctor getDoctorById(Integer doctorId) {
        return doctorDb.get(doctorId);
    }

    public HashMap<Integer, Doctor> getDoctorDb() {
        return doctorDb;
    }

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        int doctorId=doctor.getDoctorId();
        doctorDb.put(doctorId,doctor);
        return "Doctor has been added successfully";
    }


    @GetMapping("/get/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) {
        Doctor doctor = doctorDb.get(doctorId);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>(doctorDb.values());
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/getByName/{doctorName}")
    public ResponseEntity<List<Doctor>> getDoctorsByName(@PathVariable String doctorName){
        List<Doctor>matchingDoctors = new ArrayList<>();
        for(Doctor doctor :doctorDb.values()){
            if(doctor.getName().equalsIgnoreCase(doctorName)){
                matchingDoctors.add(doctor);
            }
        }

        if(!matchingDoctors.isEmpty()){
            return ResponseEntity.ok(matchingDoctors);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/getbyExperience/{experience}")
    public ResponseEntity<List<Doctor>> getDoctorsByExperience(@PathVariable int experience){
        List<Doctor> matchingDoctors = new ArrayList<>();

        for(Doctor doctor :doctorDb.values()){
            if(doctor.getExperience()>=experience){
                matchingDoctors.add(doctor);
            }
        }
        if(!matchingDoctors.isEmpty()){
            return ResponseEntity.ok(matchingDoctors);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getSchedule/{doctorId}")
    public ResponseEntity<List<String>> getDoctorSchedule(@PathVariable int doctorId) {
        Doctor doctor = doctorDb.get(doctorId);

        if (doctor != null) {
            List<String> schedule = doctor.getSchedule();
            if (!schedule.isEmpty()) {
                return ResponseEntity.ok(schedule);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update/{doctorId}")
    public ResponseEntity<String> updateDoctor(@PathVariable int doctorId, @RequestBody Doctor updatedDoctor) {
        if (doctorDb.containsKey(doctorId)) {
            doctorDb.put(doctorId, updatedDoctor);
            return new ResponseEntity<>("Doctor information updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int doctorId) {
        if (doctorDb.containsKey(doctorId)) {
            doctorDb.remove(doctorId);
            return new ResponseEntity<>("Doctor deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getBySpecialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
        List<Doctor> matchingDoctors = new ArrayList<>();

        for (Doctor doctor : doctorDb.values()) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                matchingDoctors.add(doctor);
            }
        }

        if (!matchingDoctors.isEmpty()) {
            return ResponseEntity.ok(matchingDoctors);
        } else {
            return ResponseEntity.notFound().build();
        }
    }







}
