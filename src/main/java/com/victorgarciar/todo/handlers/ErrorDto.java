package com.victorgarciar.todo.handlers;

import com.victorgarciar.todo.exception.ErrorCodes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Holds error code, error message and related error messages of an error")
public class ErrorDto {

    @Schema(name = "The error code.", required = true)
    private Integer httpCode;

    @Schema(name = "The error code.", required = true)
    private ErrorCodes code;

    @Schema(name = "A detailed error message.")
    private String message;

    @Schema(name = "The input fields related to the error, if any.")
    List<String> errors = new ArrayList<>();


}
