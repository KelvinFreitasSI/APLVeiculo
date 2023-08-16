/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.veiculo;

import br.com.curso.dao.GenericDao;
import br.com.curso.dao.VeiculoDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kelvi
 */
@WebServlet(name = "VeiculoListar", urlPatterns = {"/VeiculoListar"})
public class VeiculoListar extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        try {
            GenericDao dao = new VeiculoDao();
            request.setAttribute("veiculos", dao.listar());
            request.getRequestDispatcher("/cadastros/veiculo/veiculo.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao listar" + " Veiculos! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

    

