package com.deco.tickexperience.repository;

import com.deco.tickexperience.model.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
