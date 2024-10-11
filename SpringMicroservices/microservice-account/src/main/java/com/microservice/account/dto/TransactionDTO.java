package com.microservice.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {

    private long id;
    private String tipo;
    private double monto;
    private String fecha;
    private long idCuentaOrig;
    private long idCuentaDest;

}
