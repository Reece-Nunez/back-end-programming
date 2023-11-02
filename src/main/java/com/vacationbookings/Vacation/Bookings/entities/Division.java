package com.vacationbookings.Vacation.Bookings.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "country_id", insertable = false, updatable = false)
    private Long countryID;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers;

    public void setCountry(Country country) {
        this.country = country;
        this.countryID = (country != null) ? country.getId() : null;
    }
}
