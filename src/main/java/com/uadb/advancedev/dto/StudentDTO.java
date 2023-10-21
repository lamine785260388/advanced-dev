package com.uadb.advancedev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class StudentDTO {

    private long id;
    private String name;
    @JsonIgnoreProperties("studentDTOs")
    private Set<CourseDTO> courseDTOs;
}
