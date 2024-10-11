package com.microservice.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "nro_cuenta")
    private String nroCuenta;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "tipo_cuenta")//1: ahorros, 2: corriente
    private int tipoCuenta;

    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "status")//0: inactiva, 1: activa
    private int status;
}
