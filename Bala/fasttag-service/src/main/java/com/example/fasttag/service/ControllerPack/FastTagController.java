package com.example.fasttag.service.ControllerPack;

import com.example.fasttag.service.EntityPack.FastagEntity.VehiclesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.fasttag.service.EntityPack.ControllerInputEntity.UserVehicleInput;
import com.example.fasttag.service.EntityPack.FastagEntity.FastagDetails;
import com.example.fasttag.service.ServicePack.FastagService;

import java.util.List;


@Controller
public class FastTagController {

    @Autowired
    FastagService service;

    @GetMapping("/vehicle")
    public String getVehicleNumber(Model model) {
        try{
            model.addAttribute("userVehicleInput", new UserVehicleInput());
            return "vehicle";

        }catch(Exception e){
            System.out.println(e);
            String error=String.valueOf(e);
            return error;
        }
    }

    @PostMapping("/user")
    public String postMethodName(@ModelAttribute UserVehicleInput input,Model model) {

        model.addAttribute("VehiclesData",service.findUser(input));
        return "UserDetails";
    }


    @PostMapping("/sampleDetails")
    public ResponseEntity<String> detailsUpload(@RequestBody FastagDetails data){

        try {
            service.addDetails(data);
            return ResponseEntity.ok().body("data uploaded");
        } catch (Exception e) {
            return ResponseEntity.ok().body(String.valueOf(e));
        }
    }
    
    
    


}
