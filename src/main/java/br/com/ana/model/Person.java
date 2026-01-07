package br.com.ana.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "PERSON")  // maiúscula, igual no Oracle
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 80)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 80)
    private String lastName;

    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;

    @Column(name = "GENDER", nullable = false, length = 10)
    private String gender;

    @Column(name = "BIRTH_DAY")
    private LocalDate birthDay;
}
