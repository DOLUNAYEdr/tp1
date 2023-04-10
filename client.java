package reseauQ2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("localhost", 10233);
	    Scanner scan = new Scanner(System.in);//lire
	    DataOutputStream toserv = new DataOutputStream(socket.getOutputStream());//_envoyer donnes_au_serveur
	    
	  //on_recuperer_la_donnee_envoyer_par_le_serveur
	    DataInputStream inserv = new DataInputStream(socket.getInputStream());//_recevoir 
	    
	    //lire_les 2mots
	    System.out.println("Entrer le 1er mot : ");
	    String line = scan.nextLine();
	    System.out.println("Entrer le 2eme mot : ");
	    String line2 = scan.nextLine();
	    
	    
	    //les_envoyer au_serveur
	    toserv.writeUTF(line);
	    toserv.writeUTF(line2);
	    
	    //lire_la rep_du server
	    String rep = inserv.readUTF();
	    
	    //_affichage
	    System.out.println("Réponse du serveur : " + rep);
        System.out.println("mon Adresse client : " + socket.getLocalAddress() + " : " + socket.getLocalPort());//local_port_retourne_numport
	    System.out.println("mon serveur : " + socket.getInetAddress() + " : " + socket.getPort());
	 
	    //_fermer
	    socket.close();
	    
	  }
	}      
