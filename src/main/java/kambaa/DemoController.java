package kambaa;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/**
 * A demo REST controller.
 *
 * @author Kambaa
 */
@RestController
public class DemoController {

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

}
