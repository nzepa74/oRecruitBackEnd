package com.spring.boot.development.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Setter
@Getter
@Entity
@Table(name = "token")
public class Token {
    //region private variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "access_token")
    private String access_token;

    @Column(name = "scope")
    private String scope;

    @Column(name = "token_type")
    private String token_type;

    @Column(name = "expires_in")
    private Integer expires_in;

    @Column(name = "created_on")
    private BigInteger created_on;
    //endregion

}