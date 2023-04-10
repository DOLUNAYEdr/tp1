package reseauQ2;

import java.io.*;
import java.net.*;
//////////////////////////////Q2/datainput///////////
public class server {


	  public static void main(String[] args) {
	    try {
	      ServerSocket server = new ServerSocket(10233); //num_port_du_serveur_pour_ecouter_accepter_lesappls

	      System.out.println("Serveur en attente");

	      while (true) {
	    	//retourne_une_nouvl_socket_pr_gerer_la_conexon //attendre_une cnx_client 
	        Socket socket = server.accept(); 
	        
	        //on_recuperer_la_donnee_envoyer_par_le_client
	        DataInputStream inserv = new DataInputStream(socket.getInputStream());
	        
	        //envoie_donnee_au_client
	        DataOutputStream tocli = new DataOutputStream(socket.getOutputStream());
	        
            //lire_les 2mots_recus
	        String line = inserv.readUTF();
	        String line2 = inserv.readUTF();
	        System.out.println(" message reçu du client est : "+line+ " et " +line2);
	  
            //verifier 
	        if (line.contains(line2)) {
	        	tocli.writeUTF(line + " contient " + line2);
	        } else {
	          tocli.writeUTF(line + " ne contient pas " + line2);
	        }
	      
            //fermer
	        socket.close();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}
