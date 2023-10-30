package pan.eduard.Practice1.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "event_place")
public class EventPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;

    public int getPlaceId() {
        return id;
    }

    public void setPlaceId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return name;
    }

    public void setPlaceName(String name) {
        this.name = name;
    }

    public String getPlaceCountry() {
        return country;
    }

    public void setPlaceCountry(String country) {
        this.country = country;
    }

    public String getPlaceCity() {
        return city;
    }

    public void setPlaceCity(String city) {
        this.city = city;
    }
}