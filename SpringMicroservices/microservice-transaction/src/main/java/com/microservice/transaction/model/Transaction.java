package com.microservice.transaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tptransaction")
public class Transaction {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "id_cuenta_orig")
    private long idCuentaOrig;

    @Column(name = "id_cuenta_dest")
    private long idCuentaDest;

}
