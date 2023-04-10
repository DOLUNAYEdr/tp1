package reseau1;
import java.io.*;
import java.io.Serializable;
import java.net.*;
public class clientTr {
	public static void main(String[] args) 
	{
////////////////////////////Q1///////////
	try { 
		Socket soc = new Socket("localhost", 42010); // socket de_communication avec_le _serveur
		 BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));// pour lire_depuis le_clavier
		 
		 //
		 PrintWriter toserv = new PrintWriter(soc.getOutputStream()); // pour recevoir_du_serveur
		 
		 //client creer_un flux_de type_buffer_pr_pouvoire_lire_et afficher_reponse_serveur
		 BufferedReader inserv = new BufferedReader(new InputStreamReader(soc.getInputStream()));//pour envoyer_au _serveur
		 
		 //demander_au client d'envoyer 2mots
		  System.out.print("Entrer le 1er mot: ");
	        String mot = scan.readLine();//lecture_dune_chaine_carctr
	        
	        System.out.print("Entrer le 2eme mot: ");
	        String mot2 = scan.readLine();//lecture_dune_chaine_carctr
	        
	      //envoyer_au serveur_les 2 mot_lus  
	        toserv.println(mot);
	        toserv.println(mot2);
	        toserv.flush();
	        toserv.flush();
	       //recevoir_la reponse_du _serveur
	       String rep = inserv.readLine();
	     
		    System.out.println("Réponse du serveur : " + rep);
	       
	       //affichage_d'info sur_le client
	       System.out.println(" mon adresse client"+soc.getLocalAddress()+"."+soc.getLocalPort());
	       System.out.println(" mon serveur est:"+soc.getInetAddress()+"."+soc.getPort());
	       soc.close();}
	       catch (Exception e) {
	       System.err.println("Erreur: "+e);}}}

		 
	
		

	
