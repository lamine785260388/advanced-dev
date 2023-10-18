package com.uadb.advancedev.dto;
import com.uadb.advancedev.entities.enums.RateValue;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RateDTO {

    private long id;

    private RateValue rating;
}
