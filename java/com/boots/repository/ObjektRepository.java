package com.boots.repository;

import com.boots.entity.Customer;
import com.boots.entity.Objekt;
import com.boots.entity.Podryadchik;
import com.boots.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ObjektRepository extends CrudRepository<Objekt, Long> {
    User findByNumberobjekt(String numberpodryadchik);

}

