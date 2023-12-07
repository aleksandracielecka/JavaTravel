package com.example.javatravel.entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate birthdate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "user_x_roles")
    private Set<RoleEntity> roles;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<PurchaseEntity> purchases;


}
