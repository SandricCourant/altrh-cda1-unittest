package fr.educentre.demo.repositories;

import fr.educentre.demo.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    Reservation findByReference(int reference);

}
