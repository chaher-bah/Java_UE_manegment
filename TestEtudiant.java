import java.util.Random;

public class TestEtudiant {
	public static UE[] initTabUEd(int nbUE) {
		Random r = new Random();
		UE[] ues = new UE[nbUE];
		for (int i = 0; i < nbUE; i++) {
			String description = "UE " + r.nextInt(2001);
			int random_lvl = r.nextInt(3) + 1;
			ues[i] = new UE(description, random_lvl);
		}
		return ues;
	}

	public static Etudiant[] initTabEtud(int nbEtudiants) {
		Random r = new Random();
		Etudiant[] etds = new Etudiant[nbEtudiants];
		int nb_lic = (nbEtudiants * 50 / 100);
		int nb_mas = (nbEtudiants * 30 / 100);
		int nb_doc = nbEtudiants - (nb_lic + nb_mas);
		String[] par = { "Math", "Physique", "Info", "Chimie", "Biologie" };
		String[] sp = { "E1", "E2", "E3", "E4", "E5", "E6" };
		String[] dir = { "LeBrand", "Stion", "Ficher", "Bonen" };
		int i = 0;
		while (i < nbEtudiants) {
			for (int j = 0; j < nb_lic; j++) {
				int n = r.nextInt(100001);
				int p = r.nextInt(5);
				etds[i] = new EtLicence(n, 10, par[p]);
				i++;
			}

			for (int j = 0; j < nb_mas; j++) {
				int nm = r.nextInt(100001);
				int s = r.nextInt(6);
				etds[i] = new EtMaster(nm, 6, sp[s]);
				i++;
			}

			for (int j = 0; j < nb_doc; j++) {
				int nd = r.nextInt(100001);
				int d = r.nextInt(4);
				etds[i] = new EtDoctorat(nd, 3, dir[d]);
				i++;
			}
		}
		return etds;
	}

	public static Etudiant[] inscription(Etudiant[] etds, UE[] ues) {
		Random random = new Random();
		for (int i = 0; i < etds.length; i++) {
			Boolean rg = false;
			while (rg == false) {
				UE random_ue = ues[random.nextInt(ues.length)];
				if (etds[i] instanceof EtLicence) {
					EtLicence et_lic = (EtLicence) etds[i];
					while (random_ue.get_Niveau() != 1) {
						random_ue = ues[random.nextInt(ues.length)];
					}
					et_lic.ajouterUE(random_ue);
					etds[i] = et_lic;
					rg = true;
				}
				if (etds[i] instanceof EtMaster) {
					EtMaster et_mas = (EtMaster) etds[i];
					while (random_ue.get_Niveau() != 2) {
						random_ue = ues[random.nextInt(ues.length)];
					}
					et_mas.ajouterUE(random_ue);
					etds[i] = et_mas;
					rg = true;
				}
				if (etds[i] instanceof EtDoctorat) {
					EtDoctorat et_doc = (EtDoctorat) etds[i];
					while (random_ue.get_Niveau() != 3) {
						random_ue = ues[random.nextInt(ues.length)];
					}
					et_doc.ajouterUE(random_ue);
					etds[i] = et_doc;
					rg = true;
				}
			}
		}
		return etds;
	}

	public static void afficherInscription(Etudiant[] etds) {
		for (Etudiant et : etds) {
			System.out.println(et + " est inscrit a ");
			et.afficheListeUEs();
		}
	}

	public static Etudiant[] setNotes(Etudiant[] etds) {
		Random random = new Random();
		for (Etudiant et : etds) {
			for (UE ue : et.get_UEs()) {
				if (ue != null) {
					ue.set_Notes(random.nextInt(20), random.nextInt(20), random.nextInt(20));
				}
			}
		}
		return etds;
	}

	public static void afficherNotes(Etudiant[] etds) {
		for (Etudiant et : etds) {
			if (et instanceof EtLicence) {
				System.out.println("Etudiant " + et.get_Numero() + "notes =");
				for (UE ue : et.get_UEs()) {
					if (ue != null) {
						System.out.println("pour UE numero " + ue.get_Code() + " : ");
						for (int i : ue.get_Notes())
							System.out.println(" " + i);
						System.out.println("moyenne de l UE: " + ue.get_UEAVG());
					}
				}
				System.out.println("moyenne generale = " + et.get_AVG());
			}
		}
	}

	public static void main(String[] args) {
		UE[] ues = initTabUEd(30);
		Etudiant[] etds = initTabEtud(10);
		etds = inscription(etds, ues);
		etds = inscription(etds, ues);
		afficherInscription(etds);
		etds = setNotes(etds);
		afficherNotes(etds);
	}

}