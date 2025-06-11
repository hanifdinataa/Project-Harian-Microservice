package com.teknologiinformasi.restapi.order.config;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AxonConfig {


   @Bean
   public EventStorageEngine storageEngine(Serializer serializer) {
       return new InMemoryEventStorageEngine();
   }


   @Bean
   public EmbeddedEventStore eventStore(EventStorageEngine storageEngine) {
       return EmbeddedEventStore.builder()
               .storageEngine(storageEngine)
               .build();
   }
}
