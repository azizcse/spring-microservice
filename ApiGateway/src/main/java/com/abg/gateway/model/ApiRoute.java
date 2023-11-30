package com.abg.gateway.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "API_ROUTE")
public class ApiRoute {

    @Id
    @Column(value = "ID")
    private Long id;

    private String path;
    private String method;
    private String uri;

}

