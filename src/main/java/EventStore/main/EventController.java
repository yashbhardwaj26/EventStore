package EventStore.main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private final KafkaTemplate<String, Event> kafkaTemplate;
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Value("${kafka.topic}")
    private String topic;

    public EventController(KafkaTemplate<String, Event> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/api/v1/events/swipeIn")
    public void swipeIn(@RequestBody Event event) {
        event.setEventType("swipeIn");
        kafkaTemplate.send(topic, event);
        logger.info("Swipe in event published for employee: {}", event.getEmployeeId());
    }

    @PostMapping("/api/v1/events/swipeOut")
    public void swipeOut(@RequestBody Event event) {
        event.setEventType("swipeOut");
        kafkaTemplate.send(topic, event);
        logger.info("Swipe out event published for employee: {}", event.getEmployeeId());
    }
}
