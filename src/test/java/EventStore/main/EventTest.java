package EventStore.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void testEvent() {
        Event event = new Event();
        event.setEmployeeId("123");
        event.setEventType("swipeIn");
        event.setTimestamp(1617918723L);

        assertEquals("123", event.getEmployeeId());
        assertEquals("swipeIn", event.getEventType());
        assertEquals(1617918723L, event.getTimestamp());
    }
}

