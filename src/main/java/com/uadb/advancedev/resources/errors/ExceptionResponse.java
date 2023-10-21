package com.uadb.advancedev.resources.errors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {

    private HttpStatus status;
    private Map<String, String> message;
}
