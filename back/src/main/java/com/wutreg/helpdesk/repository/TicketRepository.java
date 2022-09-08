package com.wutreg.helpdesk.repository;

import com.wutreg.helpdesk.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select t from Ticket t join fetch t.employee join fetch t.engineer")
    List<Ticket> getAll();
}
