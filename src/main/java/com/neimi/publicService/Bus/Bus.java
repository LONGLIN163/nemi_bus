package com.neimi.publicService.Bus;
import javax.persistence.*;

@Entity
@Table
public class Bus {

    @Id
    @SequenceGenerator(
            name="bus_sequence",
            sequenceName = "bus_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bus_sequence"
    )
    private Long id;
    private String name;
    private String location;
    private String client;
    private Boolean active;

    public Bus() {
    }

    public Bus(String name, String location, String client, Boolean active) {
        this.name = name;
        this.location = location;
        this.client = client;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", client='" + client + '\'' +
                ", active=" + active +
                '}';
    }
}

