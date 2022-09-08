package com.wutreg.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private String category;
    private String problem;
    private String solution;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee engineer;

    private String status;
}
