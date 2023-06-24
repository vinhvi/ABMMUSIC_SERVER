package com.server.abm.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "image_id")
    private Image avatar;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id")
    private Account account;

    private String firstName;
    private String lastName;
    private int sex;
    private Date dateOfBirth;
    private String email;
    private String phone;
    private String address;
    private boolean access;


}
