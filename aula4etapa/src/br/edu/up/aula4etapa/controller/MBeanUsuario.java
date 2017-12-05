package br.edu.up.aula4etapa.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.up.aula4etapa.dao.UsuarioDao;
import br.edu.up.aula4etapa.entity.Usuario;

@ManagedBean
public class MBeanUsuario {
	private Integer id;
	private String email;
	private String senha;
	
	public String login() {
		
		Usuario usuario = new UsuarioDao().buscar(email, senha);
		
		if(usuario == null) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login ou senha incorretos!",""));
			
			 
			return"";
		}
		
		HttpServletRequest req = (HttpServletRequest)
				FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		req.getSession().setAttribute("usuario", usuario);
		
		
		
		return""+req.getSession().getAttribute("pagina");
	}
	
	public String cadastraUsuario() {
		
		Usuario u = new Usuario();
		
		
		
		u.setId(this.id);
		u.setEmail(email);
		u.setSenha(senha);
		
		HttpServletRequest req = (HttpServletRequest)
				FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		req.getSession().setAttribute("usuario", u);
		
		
		new UsuarioDao().inserir(u);
		
		
		return"carrinho.jsf";
		
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
