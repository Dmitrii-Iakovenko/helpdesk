package com.wutreg.helpdesk.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString(of = {"id", "firsName", "lastName"})
@EqualsAndHashCode(of = {"id"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

//    @ManyToOne
    private Long department;

    private String jobPosition;  // TODO: отдельная таблица по факту
    private String workLocation; // TODO: отдельная таблица по факту
    private String email;

    /*
        Телефоны бывают городские, мобильные и внутренние.
        Внутренние при этом делятся на стационарные и трубку
    private List<Phone> phones; //
     */
    private String cityPhone;
    private String mobilePhone;
    private String localPhone;



//    /** @var DateReceipt  Дата принятия на работу */
//    private $dateReceipt;
//    /** @var DateDismissal  Дата увольнения */
//    private $dateDismissal;
//    /** @var DateOfBirth  Дата рождения */
//    private $DoB;

}
