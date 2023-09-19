package EventStore.main;

import lombok.Data;

@Data
public class Event {

    
    private String employeeId;

    
    private String eventType; // "swipeIn" or "swipeOut"

    
    private Long timestamp; // Unix timestamp

    // constructors, getters, setters, etc.
}

