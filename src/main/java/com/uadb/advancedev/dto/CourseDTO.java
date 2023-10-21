package com.uadb.advancedev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private long id;
    private String name;
    @JsonIgnoreProperties("courseDTOs")
    private Set<StudentDTO> studentDTOs;
}
