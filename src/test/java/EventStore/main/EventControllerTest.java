package EventStore.main;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EventControllerTest {
    @Mock
    private KafkaTemplate<String, Event> kafkaTemplate;

    @InjectMocks
    private EventController eventController;

    @Test
    public void testSwipeIn() {
        Event event = new Event();
        event.setEmployeeId("123");
        event.setTimestamp(1617918723L);

        eventController.swipeIn(event);

        verify(kafkaTemplate).send("events", event);
    }

    @Test
    public void testSwipeOut() {
        Event event = new Event();
        event.setEmployeeId("123");
        event.setTimestamp(1617918723L);

        eventController.swipeOut(event);

        verify(kafkaTemplate).send("events", event);
    }
}
