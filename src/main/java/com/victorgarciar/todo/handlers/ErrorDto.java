package com.victorgarciar.todo.handlers;

import com.victorgarciar.todo.exception.ErrorCodes;
import io.swagger.v3.oas.annotations.ApiModel;
import io.swagger.v3.oas.annotations.ApiModelProperty;
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

    @Schema(value = "The error code.", required = true)
    private Integer httpCode;

    @Schema(value = "The error code.", required = true)
    private ErrorCodes code;

    @Schema(value = "A detailed error message.")
    private String message;

    @Schema(value = "The input fields related to the error, if any.")
    List<String> errors = new ArrayList<>();


}
