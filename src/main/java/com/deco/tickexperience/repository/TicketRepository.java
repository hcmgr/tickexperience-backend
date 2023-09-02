package com.deco.tickexperience.repository;

import com.deco.tickexperience.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
