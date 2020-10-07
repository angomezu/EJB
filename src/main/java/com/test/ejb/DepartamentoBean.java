/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.ejb;

import com.test.entidades.Departamento;
import com.test.servicio.DepartamentoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author GERSON
 */

@Named("departamentobean")
@RequestScoped
public class DepartamentoBean implements Serializable{
    

    @EJB
    private DepartamentoFacadeLocal departamentoFacade;
    private Departamento newdepartamento;

   
    public Departamento getNewdepartamento() {
        if(newdepartamento==null){
            
            newdepartamento = new Departamento();
        
        }
            return newdepartamento;
    }

        
    public void setNewproduct(Departamento newdepartamento) {
        this.newdepartamento = newdepartamento;
    }
    
       
    public DepartamentoBean(){
    
    }
               
    public List<Departamento>getDepartamento(){
    
        return this.departamentoFacade.findAll();
    
    }
    
    public void crear(){
    
        this.departamentoFacade.create(newdepartamento);
    
    }
    
    public void Eliminar(Departamento departamento){
    
        this.departamentoFacade.remove(departamento);
    }
    
    
    public void Actualizar(Departamento departamento){
    
        this.departamentoFacade.edit(departamento);
    
    }
    
    
    
    
}
