package kambaa;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class DemoService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting greet(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    public Greeting greet(long id, String name) {
        return new Greeting(id, String.format(template, name));
    }


}
