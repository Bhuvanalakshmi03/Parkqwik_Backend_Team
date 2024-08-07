package com.example.fasttag.service.EntityPack.FastagEntity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VehiclesData {

    private String userid;
    private String username;
    private String vehiclenumber;
    private String balance;
    private List<PaymentHistory> paymenthistory;

}
