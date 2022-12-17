package com.firstweb.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstweb.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{

}
