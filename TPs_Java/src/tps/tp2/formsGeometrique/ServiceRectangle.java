package tps.tp2.formsGeometrique;

public class ServiceRectangle {
	
	public static double surface(Rectangle r) {
		double surface = r.surface();
		return surface;
	}
	
	public static double perimetre(Rectangle r) {
		double perimetre = r.perimetre();
		return perimetre;
	}
	
	public static boolean estCarrée(Rectangle r) {
		return r.estCarrée();
	}

}
