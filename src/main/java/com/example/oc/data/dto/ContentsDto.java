package com.example.oc.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ContentsDto {
    private Long id;

    private String title;
    private String language;
    private String overview;
    private String poster;
}
