package com.example.fasttag.service.RepositoryPack;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.fasttag.service.EntityPack.FastagEntity.FastagDetails;

@Repository
public interface FastagRepository extends MongoRepository<FastagDetails,String> {

}
