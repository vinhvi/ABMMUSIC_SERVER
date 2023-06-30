package com.server.abm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_music")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Music implements Serializable {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "image_id")
    private Image image;
    private String audio;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id")
    private Type type;
    private Date date;
    private String lyric;
}
