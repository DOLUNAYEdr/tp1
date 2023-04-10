package reseau1;

import java.io.*;
import java.net.*;
public class serverTr {
	public static void main(String[] args) 
	{
	try { int port=42010;  //num_port_du_serveur_pour_ecouter_accepter_lesappls
	
		// serveur_positionne sa_socket d'écoute
		ServerSocket ss = new ServerSocket(port);
		// se_met en_attente de_connexion de_la part d'un client
		System.out.println("Serveur en attente: ");
		Socket soc = ss.accept();//retourne_une_nouvl_socket_pr_gerer_la_conexon //attendre_une cnx_client
		
      //creer_flux de_donne en_sortie
		PrintWriter tocli = new PrintWriter ( soc . getOutputStream ());//pour_envoyer au_client
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));//recevoir_du client
        
        //lire_from client 2 chaines_et les_stocker dans_2 var_line et_line2
		String line = reader.readLine ();
		 String line2 = reader.readLine();
		 System.out.println(" message reçu du client est : "+line+ " et " +line2);
		 
		 //verifier si_la_1ere contient_la 2eme
		 String rep = "";
         if (line.contains(line2)) {
             rep = line + " contient " + line2;
         } else {
            rep = line + " ne contient pas " + line2;
         }
		 // envoyer_la reponse_au client 
         tocli.println(rep);
         tocli.flush();
         
         //fermer_les_scockets
         ss.close();
         soc.close();
	}
	catch (Exception e) {
		System.err.println("Erreur: "+e);}}


}	

   