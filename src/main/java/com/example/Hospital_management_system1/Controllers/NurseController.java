package com.example.Hospital_management_system1.Controllers;

import com.example.Hospital_management_system1.Models.Nurse;
import com.example.Hospital_management_system1.Service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    NurseService nurseService;
    //NurseService nurseService = new NurseService();
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){

          String ans = nurseService.addNurse(nurse);
          return ans;
    }
    @GetMapping("/getList")
    public List<Nurse> getNursesGreaterThanAge(@RequestParam("age")Integer age){
        List<Nurse> nurseList = nurseService.getListGreaterThanAge(age);
        return nurseList;

    }
    @GetMapping("/getByQualification")

    public List<Nurse>getNursesByQualification(@RequestParam("qualification")String qualification){
        List<Nurse> nurses = nurseService.getNursesWithQualification(qualification);

        return nurses;
    }
}
