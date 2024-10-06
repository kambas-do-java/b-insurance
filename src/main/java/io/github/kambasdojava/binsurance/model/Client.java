package io.github.kambasdojava.binsurance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "client_sequence")
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, unique = true)
    private String bi;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Insurance> insurances;
}
