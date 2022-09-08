package com.wutreg.helpdesk.service;

import com.wutreg.helpdesk.model.Ticket;
import com.wutreg.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record TicketService(TicketRepository ticketRepository) {

    public List<Ticket> getAll() {
        return ticketRepository.getAll();
    }
}
