package fr.eni.encheres.messages;

import java.util.ResourceBundle;

/**
 * Cette classe permet de lire le contenu du fichier messages_erreur.properties
 * @author Administrator
 *
 */
public abstract class LecteurMessage {
	private static ResourceBundle rb; // déclaration statique du ResourceBundle pour lire le fichier messages_erreur.properties
	
	static
	{
		try
		{
			rb = ResourceBundle.getBundle("fr.eni.encheres.messages.messages_erreur"); // chemin vers le fichier et lecture
		}
		catch (Exception e) 
		{
			e.printStackTrace(); // capture d'une erreur liée à la l'inexistance du fichier messages_erreur.properties
		}
	}
	
	/**
	 * Méthode statique servant à retourner le message correspondant à l'erreur
	 * @param code d'erreur au format int
	 * @return le message d'erreur au format String
	 */
	public static  String getMessageErreur(int code)
	{
		String message="";
		try
		{
			if(rb!=null) // Recherche d'une erreur de lecture du fichier messages_erreur.properties
			{
				message = rb.getString(String.valueOf(code)); // lecture du message correspondant au code d'erreur remonté
			}
			else
			{
				message="Problème à la lecture du fichier contenant les messages"; // envoi d'un message générique si soucis de lecture de messages_erreur.properties 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Une erreur inconnue est survenue"; // interception d'une erreur inconnue à dertination de l'admin
		}
		return message;
	}
}
