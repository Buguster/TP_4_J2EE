package metier;

import java.util.List;

public class TestMetier {
	public static void main(String[] args) {
		MetierImpl metier = new MetierImpl();
		List<Produit> prods = metier.getProduitsParMC("HP");
		System.out.println("Liste des produits dans la Table");
		for (Produit P: prods) {
			System.out.println(P.getNomProduit());
		}
	}
}
