package com.microservice.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

    private long id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String email;

}
