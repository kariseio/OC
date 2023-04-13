package com.example.oc.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contents {
    @Id
    private Long id;

    private String title;
    private String language;
    private String overview;
    private String poster;
}
