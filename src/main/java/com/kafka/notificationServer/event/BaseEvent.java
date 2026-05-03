package com.kafka.notificationServer.event;

import java.time.LocalDateTime;

public class BaseEvent {
    private String eventType;
    private String source;
    private LocalDateTime timestamp;
}
