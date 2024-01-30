package com.example.Hospital_management_system1.Service;

import com.example.Hospital_management_system1.Models.Nurse;
import com.example.Hospital_management_system1.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.org.objectweb.asm.tree.Util.add;

@Service

public class NurseService {
    @Autowired
    NurseRepository nurseRepository;

    //NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse){
        if(nurse.getNurseId()<0)return "Enter a Valid NurseId";
        if(nurse.getName().equals(null))return "Name Should not Be Null";
        String ans =nurseRepository.addNurse(nurse);
        return ans;

    }
    public List<Nurse> getListGreaterThanAge(int age){
        List<Nurse> nurses =nurseRepository.getAllNurses();
        List<Nurse>finalList = new ArrayList<>();
        for(Nurse nurse :nurses){
            if(nurse.getAge()>age){
                finalList.add(nurse);
            }
        }
     return finalList;
    }
    public List<Nurse> getNursesWithQualification(String qualification){
        List<Nurse>nurseList =nurseRepository.getAllNurses();
        List<Nurse>nurses = new ArrayList<>();
        for(Nurse nurse:nurseList){
            if(nurse.getQualification().equals(qualification)){
                nurses.add(nurse);
            }
        }
        return nurses;
    }
}
