package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImp;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImp();

    /**
     * Default constructor. 
     */
    public ServletPersonne() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récuperation des infos
		int Id= Integer.parseInt(request.getParameter("Id")); 
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		int age= Integer.parseInt(request.getParameter("age"));
		// envoyer à la couche service
		Personne p = new Personne();
		p.setId(Id);
		p.setAge(age);
		p.setNom(nom);// set=écrire
		p.setPrenom(prenom);
		String message = service.CreerPersonne(p);//appeler la couche service
		//preparation à l'envoi
		request.setAttribute("message", message);
		//appel de la JSP
		request.getRequestDispatcher("resultat.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
