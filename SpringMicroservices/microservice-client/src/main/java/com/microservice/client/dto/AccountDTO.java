package com.microservice.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private long id;
    private String nroCuenta;
    private double saldo;
    private int tipoCuenta;
    private long idCliente;
    private int status;

}
