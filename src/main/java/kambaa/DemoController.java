package kambaa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * A demo REST controller.
 *
 * @author Kambaa
 */
@RestController
public class DemoController {

    DemoRepository demoRepository;

    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
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
    public Iterable<DemoEntity> getPeople() {
        return demoRepository.findAll();
    }

    /**
     * Get singular PERSON info by id.
     *
     * @param id Person id in db.
     * @return Person entity.
     */
    @GetMapping("/getPerson/{id}")
    public DemoEntity getPerson(@PathVariable Long id) {
        return demoRepository.findById(id).orElse(null);
    }

}
