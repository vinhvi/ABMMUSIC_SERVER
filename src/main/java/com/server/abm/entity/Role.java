package com.server.abm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_roles")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
