public class EtLicence extends Etudiant {
    private String parcours;

    public EtLicence(int n, int tot, String parcours) {
        super(n, tot);
        this.set_Parcours(parcours);
    }

    public EtLicence(int numero) {
        super(numero, 0);
        this.parcours = "";
    }

    // getters setters
    public void set_Parcours(String new_parcours) {
        this.parcours = new_parcours;
    }

    public String get_Parcours() {
        return this.parcours;
    }

    public String toString() {
        return ("Etudiant numero " + super.get_Numero() + " Licence, parcours = " + this.get_Parcours());
    }

    public Boolean ajouterUE(UE ue) {
        if (ue.get_Niveau() == 1) {
            super.addUE(ue);
            return true;
        } else {
            System.out.println("etudiant n a pas le droit de s inscrire a ce UE");
            return false;
        }
    }

}