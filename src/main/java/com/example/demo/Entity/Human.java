package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Builder
@Table(name = "Peoples")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    @Column(nullable = false)
    private String telephoneNumber;

    @Column(nullable = false)
    private String email;

    public Human(String name, String telephoneNumber, String email) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Human() {



    }

}
