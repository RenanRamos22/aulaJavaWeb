package br.edu.up.aula4etapa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.up.aula4etapa.dao.DedicadoDao;
import br.edu.up.aula4etapa.dao.PlanoCompartilhadoDao;
import br.edu.up.aula4etapa.entity.Dedicado;
import br.edu.up.aula4etapa.entity.PlanoComp;


@WebServlet("/ServletImagemDedicado")
public class ServletImagemDedicado extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public ServletImagemDedicado() {
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
		Dedicado dedic = new DedicadoDao().buscar(Integer.parseInt(id));
		File f = new File(dedic.getImgUrl());
		FileInputStream fis = new FileInputStream(f);
		byte[] arrayImagem = new byte[(int) f.length()];
		fis.read(arrayImagem);
		
		response.getOutputStream().write(arrayImagem);
		
	}

	

}
