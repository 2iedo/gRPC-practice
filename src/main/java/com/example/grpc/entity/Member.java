package com.example.grpc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private LocalDate birthday;

    @NotNull
    private LocalDate registerDate;

    @NotNull
    private String gender;

    public Member(){}

    public int getAge(){
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public Member(String email, LocalDate birthday, LocalDate registerDate, String gender){
        this.email = email;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.gender = gender;
    }
}
