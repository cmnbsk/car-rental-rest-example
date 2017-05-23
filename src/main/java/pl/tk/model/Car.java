package pl.tk.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Tobiasz on 2017-05-22.
 */

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 150)
    private String brand;

    @NotNull
    @Size(min = 1, max = 150)
    private String model;

    @NotNull
    @Max(200)
    private int seats;

    @OneToMany(mappedBy = "car")
    private List<Rent> rentList;

    public Car() {
    }

    public Car(String brand, String model, int seats) {
        this.brand = brand;
        this.model = model;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
