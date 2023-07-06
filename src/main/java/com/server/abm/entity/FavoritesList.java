package com.server.abm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_favoritesList")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoritesList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dateAdd;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "favoritesList_id")
    private List<Music> musicList;

}
