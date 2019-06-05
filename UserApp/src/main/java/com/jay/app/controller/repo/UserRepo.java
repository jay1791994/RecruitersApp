package com.jay.app.controller.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jay.app.model.User;


@Repository
public interface UserRepo extends MongoRepository< User, String>, PagingAndSortingRepository<User, String> {

}
