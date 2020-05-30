/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.model;

import autorizacao.model.PapelUtilizador;
import lapr.controller.AppPOE;
import lapr.utils.Constants;

/**
 *
 * @author Universidade
 */
public class Colaborator extends User {

    private String name;
    private String email;
    private String password;

    public Colaborator (String name, String email, String password, PapelUtilizador[] papeis){
        super(name, email, password, papeis);
    }

    public Colaborator (String name, String email, String password){
        this(name, email, password, new PapelUtilizador[]{AppPOE.getInstance().getRole(Constants.ROLE_COLABORATOR)});
    }

    public String getNome()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
}
