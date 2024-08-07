package com.example.fasttag.service.ServicePack;

import com.example.fasttag.service.EntityPack.ControllerInputEntity.UserVehicleInput;
import com.example.fasttag.service.EntityPack.FastagEntity.Banks;
import com.example.fasttag.service.EntityPack.FastagEntity.VehiclesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fasttag.service.EntityPack.FastagEntity.FastagDetails;
import com.example.fasttag.service.RepositoryPack.FastagRepository;

import java.util.List;
import java.util.Objects;

@Service
public class FastagService {

    @Autowired
    FastagRepository repository;

    public void addDetails(FastagDetails data) {
        repository.save(data);
    }

    public VehiclesData findUser(UserVehicleInput input){
        List<FastagDetails> datas=repository.findAll();
        VehiclesData result = null;
        for(FastagDetails data:datas){
            for (Banks bank: data.getBanks()){
                if (Objects.equals(bank.getBankname(), input.getBank())){
                    for(VehiclesData vehicle:bank.getVehiclesdatas()){
                        if(Objects.equals(vehicle.getVehiclenumber(), input.getVehiclenumber())){
                            result=vehicle;
                        }
                    }
                }
            }
        }

        return result;
    }

}
