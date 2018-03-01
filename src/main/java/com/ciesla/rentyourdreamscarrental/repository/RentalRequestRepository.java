package com.ciesla.rentyourdreamscarrental.repository;

import com.ciesla.rentyourdreamscarrental.entity.RentalRequest;
import org.springframework.data.repository.CrudRepository;

public interface RentalRequestRepository extends CrudRepository<RentalRequest, Integer> {
    void deleteRentalRequestsByAccountId(Integer id);
    long count();
}
