package com.abg.auth.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 12/14/2023
 */
@Data
@AllArgsConstructor
public class AuthRequest implements Serializable {
    private String name;
    private String pass;
}
