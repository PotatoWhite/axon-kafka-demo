package events;

import java.io.Serializable;

public class GreetingEvent implements Serializable {
    private String greeting;

    public GreetingEvent() {
    }

    public GreetingEvent(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    @Override
    public String toString() {
        return "SampleEvents{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
