public class EtDoctorat extends Etudiant {
	private String directeurThese;

	public EtDoctorat(int n, int tot, String dir) {
		super(n, tot);
		this.set_Directeur(dir);
	}

	public EtDoctorat(int numero) {
		super(numero, 0);
		this.directeurThese = "";
	}
    //getters setters
	public void set_Directeur(String new_directeur) {
		this.directeurThese = new_directeur;
	}

	public String get_Directeur() {
		return this.directeurThese;
	}

	public String toString() {
		return ("Etudiant numero " + super.get_Numero() + " Doctorat, directeur de These = " + this.get_Directeur());
	}

	public Boolean ajouterUE(UE ue) {
		if (ue.get_Niveau() == 3) {
			super.addUE(ue);
			return true;
		} else {
			System.out.println("etudiant n a pas le droit de s inscrire a ce UE");
			return false;
		}
	}

}