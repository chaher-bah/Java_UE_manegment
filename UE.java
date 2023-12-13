public class UE {
    private int code;
    static int count = 1;
    private String description;
    private int niveau;
    private int[] notes = new int[3];

    public UE(String description, int niveau) {
        this.set_Description(description);
        this.set_Niveau(niveau);
        this.code = UE.count;
        UE.count++;
    }

    public int get_Code() {
        return this.code;
    }

    public int get_Niveau() {
        return this.niveau;
    }

    public int[] get_Notes() {
        return this.notes;
    }

    public String get_Description() {
        return this.description;
    }

    public void set_Niveau(int new_niveau) {
        this.niveau = new_niveau;
    }

    public void set_Description(String new_description) {
        this.description = new_description;
    }

    public void set_Notes(int n1, int n2, int n3) {
        this.notes[0] = n1;
        this.notes[1] = n2;
        this.notes[2] = n3;
    }

    public String toString() {
        String niv = "";
        if (this.get_Niveau() == 1)
            niv = "license";
        else if (this.get_Niveau() == 2)
            niv = "mastere";
        else
            niv = "doctorat";
        return ("Code UE = " + this.get_Code() + " Description UE = " + this.get_Description() + " Niveau = " + niv);
    }

    public float get_UEAVG() {
        float avg = 0;
        for (int i : this.get_Notes())
            avg += i;
        return avg / 3;
    }

}