package com.server.abm.entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_images")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image implements Serializable {

    @Id
    private String id;
    private String name;
    private String imageUrl;
}
