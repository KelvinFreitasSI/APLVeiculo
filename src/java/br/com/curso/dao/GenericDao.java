/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.curso.dao;

import java.util.List;

/**
 *
 * @author kelvi
 */
public interface GenericDao {
      
    public Boolean cadastrar(Object objeto);
    public Boolean inserir(Object objeto);
    public Boolean alterar(Object objeto);
    public Boolean excluir(Object objeto);
    public Object carregar(int numero);
    public List<Object> listar();
    
}