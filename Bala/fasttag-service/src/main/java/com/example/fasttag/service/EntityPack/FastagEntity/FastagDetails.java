package com.example.fasttag.service.EntityPack.FastagEntity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Fastag")
public class FastagDetails {

    @Id
    String id;
    List<Banks> banks;
   

}


