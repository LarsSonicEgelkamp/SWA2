package de.hsw.iban.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.iban.beans.IbanResponse;

@Repository
public interface IbanRepository extends CrudRepository<IbanResponse, Long> {
    
}
