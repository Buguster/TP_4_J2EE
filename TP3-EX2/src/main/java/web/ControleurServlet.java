package web;

import metier.Produit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IMetierCatalogue;
import metier.MetierImpl;

@WebServlet("/traitement")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IMetierCatalogue metier;
    
    public ControleurServlet() {
        super();
    }
    
    public void init() throws ServletException{
    	metier = new MetierImpl();
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mc = request.getParameter("motCle");
    	ProduitModele mod = new ProduitModele();
    	mod.setMotCle(mc);
    	List<Produit> prods = metier.getProduitsParMC(mc);
    	mod.setProduits(prods);
    	
    	request.setAttribute("modele", mod);
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
