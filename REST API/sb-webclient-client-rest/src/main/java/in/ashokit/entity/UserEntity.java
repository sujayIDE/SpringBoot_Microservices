package in.ashokit.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserEntity {

    private Integer userId;

    private String name;

    private String email;

    private Long phno;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
