public class Etudiant {
    private int num;
    private int numCourrantUE = 0;
    private UE[] UEs;
    int total;

    public Etudiant(int numero, int tot) {
        total = tot;
        this.set_Numero(numero);
        this.UEs = new UE[total];
    }
    //getters setters
    public int get_Numero() {
        return this.num;
    }

    public int get_NumCourrantUE() {
        return this.numCourrantUE;
    }

    public UE[] get_UEs() {
        return this.UEs;
    }

    public void set_Numero(int n) {
        this.num = n;
    }

    public void set_NumCourrantUE(int new_num) {
        this.numCourrantUE = new_num;
    }

    public void set_UES(UE[] new_ues) {
        this.UEs = new_ues;
    }

    public String toString() {
        return ("Etudiant numero " + this.get_Numero());
    }

    public void afficheListeUEs() {
        for (UE ue : this.UEs) {
            if (ue != null)
                System.out.println("	" + ue);
        }
    }

    public void addUE(UE ue_to_add) {
        if (this.get_NumCourrantUE() < total) {
            this.UEs[get_NumCourrantUE()] = ue_to_add;
            set_NumCourrantUE(get_NumCourrantUE() + 1);
        } else
            System.out.println("etudiant a atteint le max de UEs");
    }

    public float get_AVG() {
        int counter = 0;
        float avg = 0;
        for (UE ue : this.get_UEs()) {
            if (ue != null) {
                for (int i : ue.get_Notes()) {
                    avg += i;
                    counter++;
                }
            }
        }
        return (avg / counter);
    }
}