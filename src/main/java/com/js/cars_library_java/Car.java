package com.js.cars_library_java;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Podaj markę!")
    private String brand;

    @NotEmpty(message = "Podaj model!")
    private String model;

    @NotNull(message = "Podaj rok produkcji!")
    private Integer productionYear;

    @NotNull(message = "Podaj moc!")
    private Integer powerHp;

    @NotNull(message = "Podaj pojemność silnika!")
    private Integer engineCapacity;

    @NotEmpty(message = "Podaj typ paliwa!")
    private String fuelType;

    @NotEmpty(message = "Podaj rodzaj napędu!")
    private String drive;

    @NotEmpty(message = "Podaj rodzaj skrzyni biegów!")
    private String transmission;

    @NotEmpty(message = "Podaj typ nadwozia!")
    private String type;

    @NotNull(message = "Podaj liczbę drzwi!")
    private Integer doorsNumber;

}
