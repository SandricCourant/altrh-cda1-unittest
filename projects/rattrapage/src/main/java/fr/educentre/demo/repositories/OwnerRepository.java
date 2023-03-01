package fr.educentre.demo.repositories;

import fr.educentre.demo.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    Owner findByLogin(String login);

}
