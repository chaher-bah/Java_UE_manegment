public class EtMaster extends Etudiant {
    private String specialite;

    public EtMaster(int n, int tot, String specialite) {
        super(n, tot);
        this.set_Specialite(specialite);
    }

    public EtMaster(int numero) {
        super(numero, 0);
        this.specialite = "";
    }

    // getters setters
    public String get_Specialite() {
        return this.specialite;
    }

    public void set_Specialite(String new_specialite) {
        this.specialite = new_specialite;
    }

    public String toString() {
        return ("Etudiant numero " + super.get_Numero() + " Master, specialite = " + this.get_Specialite());
    }

    public Boolean ajouterUE(UE ue) {
        if (ue.get_Niveau() == 2) {
            super.addUE(ue);
            return true;
        } else {
            System.out.println("etudiant n a pas le droit de s inscrire a ce UE");
            return false;
        }
    }

}