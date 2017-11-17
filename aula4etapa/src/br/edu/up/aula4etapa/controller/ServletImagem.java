package br.edu.up.aula4etapa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.up.aula4etapa.dao.PlanoCompartilhadoDao;
import br.edu.up.aula4etapa.entity.PlanoComp;


@WebServlet("/ServletImagem")
public class ServletImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public ServletImagem() {
       super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || id.equals("")) {
			return;
		}
		PlanoComp plano = new PlanoCompartilhadoDao().buscar(Integer.parseInt(id));
		File f = new File(plano.getImgUrl());
		FileInputStream fis = new FileInputStream(f);
		byte[] arrayImagem = new byte[(int) f.length()];
		fis.read(arrayImagem);
		
		response.getOutputStream().write(arrayImagem);
		
	}

	

}
