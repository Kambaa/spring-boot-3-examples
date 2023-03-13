package kambaa;

import org.springframework.data.repository.CrudRepository;

/**
 * A spring boot Repository for PERSON entity.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    /**
     * A custom find by surname operation, everything will be set up by Spring.
     *
     * @param surname Surname to search.
     * @return Person
     */
    Person findBySurname(String surname);
}