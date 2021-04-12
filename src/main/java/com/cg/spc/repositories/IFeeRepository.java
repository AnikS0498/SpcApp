package com.cg.spc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Fee;

public interface IFeeRepository extends JpaRepository<Fee, Integer>{

}
