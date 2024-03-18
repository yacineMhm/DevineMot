package trouve;

public class Trouve {

	public static void main(String[] args) {
		
		// < >
		
		// Variables :
		String MatriceUtilisateur[];
		String MatriceJoueur[];
		String MatriceAffichage[];
		String mot;
		String motJoueur;
		String Rejouer;
		String SOL = "";
		int TailleUtilisateur;
		int TailleJoueur;
		int nombreEssai;
		int tour;
		
		// Début du programme, boucle de jeu :
		
		Rejouer = "oui";
		while(Rejouer.equalsIgnoreCase("oui") && (!SOL.equalsIgnoreCase("non"))) { 
		SOL = "";
		//Explication du jeu :
		
		System.out.println("Explication du jeu : ");
		System.out.println();
		System.out.println("Ce jeu se joue à deux et consiste à trouver un mot donné par le premier joueur. Le nombre d'essai dépend de la taille du mot -2.");
		System.out.println();
		
		// Saisie du mot par l'utilisateur 
		
		mot = Saisie.lire_String("[Joueur 1] : Veuillez entrer un mot à faire deviner au joueur 2 avec au minimum 5 lettres.");
		// Contrôle de saisie :
		TailleUtilisateur = mot.length();
		while(TailleUtilisateur < 5){
			mot = Saisie.lire_String("[Joueur 1] : Recommencez avec un mot comportant au minimum 5 lettres.");
			TailleUtilisateur = mot.length();
		}
		
		// Calcul du nombre d'essai
		
		nombreEssai = TailleUtilisateur - 2;
		

		// Instanciation de la variables indicée utilisateur
		
		//MatriceUtilisateur = new String [TailleUtilisateur];
		
		MatriceUtilisateur = extraireLettres(mot);
		
		
		// instanciation matrice affichage et remplir 
		MatriceAffichage = new String [TailleUtilisateur];
		
		for(int i = 0; i < TailleUtilisateur; i++) {
			MatriceAffichage[i] = "_";
		}
		
		
		
		// boucle essai du joueur : 
		
		tour = 0;
		// initialisation mot joueur 
		motJoueur = "";
		
		while((tour != nombreEssai && ((!SOL.equalsIgnoreCase("oui")))) && (!SOL.equalsIgnoreCase("non"))) {			
		motJoueur = Saisie.lire_String("[Joueur 2] : Essayez de déviner le mot, entrer un mot de " + (TailleUtilisateur) +  " lettres.");
		if (motJoueur.equalsIgnoreCase("SOL")) {
		    SOL = Saisie.lire_String("[Joueur 2] : Vous avez perdu, voulez-vous rejouer oui/non ?");
		} else {
		    TailleJoueur = motJoueur.length();

			// Contrôle de saisie du joueur
			while((TailleJoueur != TailleUtilisateur)) {
				motJoueur = Saisie.lire_String("[Joueur 2] : Recommencez entrer un mot à deviner de " + (TailleUtilisateur) +  " lettres.");
				 TailleJoueur = motJoueur.length();
				 }
			
			
			tour++;
			System.out.println("Nombre de tour restant : " + (nombreEssai-tour));
			// Instanciation de la variables indicée joueur
			MatriceJoueur = extraireLettres(motJoueur);
			
			
			// Comparer les mots
			
			for (int i = 0; i < TailleUtilisateur; i++) {
			    if (MatriceJoueur[i].equalsIgnoreCase(MatriceUtilisateur[i])) {
			        MatriceAffichage[i] = MatriceUtilisateur[i];
			    } 
			}

			
			
			System.out.println("Voici les lettres communes et bien placées : ");
			for(int i = 0; i < TailleUtilisateur; i++) {
				System.out.print(MatriceAffichage[i]+ " ");

			}
			System.out.println();
		    
			
			if(mot.equalsIgnoreCase(motJoueur)) {
				Rejouer = Saisie.lire_String("[Joueur 2] : Vous avez gagné en "+ tour + " tour" + ", voulez-vous rejouer oui/non ?");
				tour = nombreEssai;
			} else if (tour == nombreEssai) {
				Rejouer = Saisie.lire_String("[Joueur 2] : Vous avez perdu, voulez-vous rejouer oui/non ?");
			}
			
			
			}
		}
	}
}

//Fonction pour extraire les lettres d'un mot et les placer dans un vecteur
public static String[] extraireLettres(String mot) {
    String[] matrice = new String[mot.length()];

    for (int i = 0; i < mot.length(); i++) {
        matrice[i] = mot.substring(i, i + 1);
    }

    return matrice;
}



}

