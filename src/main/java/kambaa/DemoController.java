package kambaa;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/**
 * A demo CRUD REST controller.
 *
 * @author Kambaa
 */
@RestController
public class DemoController {

    /**
     * Spring Person Entity Repository, this will automagically prepare the database interactions methods on itself.
     */
    PersonRepository personRepository;

    /**
     * Argument constructor, no need to @Autowire anymore.
     *
     * @param personRepository PersonRepository
     */
    public DemoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    record Greeting(long id, String content) {
    }

    /**
     * Basic greeting example for the main url
     *
     * @param name enter your name to have a personalized greeting
     * @return Greeting text
     */
    @GetMapping("/")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * Gets every person in PERSONs table in db.
     *
     * @return List of PERSON entity.
     */
    @GetMapping("/getPeople")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }

    /**
     * Get singular PERSON info by id.
     *
     * @param id Person id in db.
     * @return Person entity.
     */
    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).orElse(null);
    }

    /**
     * Get singular PERSON info by id.
     *
     * @param surname Person id in db.
     * @return Person entity.
     */
    @GetMapping("/getPersonByName/{surname}")
    public Person getPerson(@PathVariable String surname) {
        return personRepository.findBySurname(surname);
    }

    /**
     * Deletes the person given by the id
     *
     * @param id id to delete
     */
    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }


    /**
     * Adds some people into db and greets people.
     *
     * @return greeting message
     */
    @GetMapping("/addPeople")
    public String index() {
        for (int i = 1; i <= 10; i++) {
            Person person = new Person();
            person.setName("PersonName" + i);
            person.setSurname("PersonSurname" + i);
            personRepository.save(person);
        }
        return "Greetings from Spring Boot! Added some people in person table";
    }

    /**
     * Adds a person to database.
     *
     * @param person Person to add
     */
    @PostMapping("/addPerson")
    public void addNewPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    /**
     * Edits the Person info given by the id.
     *
     * @param id     id to edit
     * @param person new Person information
     * @throws Exception if no person by the given id found.
     */
    // fixme: if no person by the given id, return 404.
    @PatchMapping("/updatePerson/{id}")
    public void editPerson(@PathVariable Long id, @RequestBody Person person) throws Exception {
        Person existingPerson = personRepository.findById(id).orElseThrow(Exception::new);
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        personRepository.save(existingPerson);
    }

}
