package in.ashokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime localDateTime;
    private String message;
    private Integer status;
    private String path;
}
