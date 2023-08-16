/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;
import br.com.curso.model.Veiculo;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelvi
 */
public class VeiculoDao implements GenericDao {
    
    private Connection conexao;
    
    public VeiculoDao() throws Exception{
        conexao= SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        Boolean retorno = false;
        if(oVeiculo.getIdVeiculo()== 0){
            retorno = this.inserir(oVeiculo);
        }else{
            retorno = this.alterar(oVeiculo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
         Veiculo oVeiculo = (Veiculo) objeto;
            PreparedStatement stmt = null;
            String sql = "insert into veiculo (idveiculo, marca, modelo) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarca());
            stmt.setString(2, oVeiculo.getModelo());
            stmt.execute();
            conexao.commit();
            return true;
            
        } catch (Exception ex) {
            try {
                    System.out.println("Problemas ao cadastrar a Veiculo! Erro: "+ex.getMessage());
                    ex.printStackTrace();
                    conexao.rollback();
                   } catch (SQLException e) {
                        System.out.println ("Erro: "+e.getMessage()) ;
                        e.printStackTrace ();
                   }
                    return false;
    }
    }

    @Override
    public Boolean alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean excluir(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       String sql = "Select * from veiculo order by idveiculo";
       try {
           stmt = conexao.prepareStatement (sql);
           rs=stmt.executeQuery();
           while (rs.next()){
               Veiculo oVeiculo = new Veiculo();
               oVeiculo.setIdVeiculo(rs.getInt("idVeiculo"));
               oVeiculo.setMarca(rs.getString("marca"));
               oVeiculo.setModelo(rs.getString("modelo"));
               resultado.add(oVeiculo);
           }
       } catch (SQLException ex) { 
           System.out.println("Problemas ao listar Veiculo! Erro:"
                   + ex.getMessage());
        } 
      return resultado;
    }
    }
    

