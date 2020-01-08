package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author diego
 * @since 08/01/2020
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
