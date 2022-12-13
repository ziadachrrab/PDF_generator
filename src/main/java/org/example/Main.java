

/* Project by: ACHRRAB Ziad,
               FELLAH Hamza

          GI Students S3.
 */


package org.example;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        try
        {
            Scanner lire = new Scanner(System.in);

            String path,nameFile;

            System.out.println("Enter le chemin d'enregistrement de votre ficher excel et son nom (fichier.csv): ");

            nameFile = lire.nextLine(); //scanner pour lire le chemin d'enregistrement donner par l'utilisateur.

            System.out.println("Entrer le chemin de votre fichier pdf (liste d'etudiants): ");

            path = lire.nextLine();//scanner pour lire le chemin du fichier PDF donner par l'utilisateur.

            PrintWriter GiFile = new PrintWriter(nameFile);// le nom de fichier CSV aprés la convertion.

            PDDocument doc = PDDocument.load(new File(path));// le nom de fichier PDF que nous voulons lire.
            doc.getClass();
            if (!doc.isEncrypted()) //pour tester si le fichier est crypté ou non. Si oui, il va rien faire, sinon, il va executer le traitement suivant.
            {


                PDFTextStripperByArea stripper = new PDFTextStripperByArea();//Cela extraira le texte d'une région spécifiée dans le PDF.

                stripper.setSortByPosition(true); //Pour trier le texte de gauche à droite et de haut en bas.

                PDFTextStripper Tstripper = new PDFTextStripper(); //Cette classe prendra un document pdf et supprimera tout le texte et ignorera le formatage et autres.
                String str = Tstripper.getText(doc);

                Scanner scnLine = new Scanner(str); //lire les lignes de document PDF.

                //création des trois colonnes CNE, NOM, Prenom.

                String CNE = "";

                String NOM = "";

                String PRENOM = "";


                while (scnLine.hasNextLine()) //en tant qu'il exist des lignes, le code suivant va étre executer.
                {

                    String line = scnLine.nextLine();

                    Scanner scnWord = new Scanner(line); // read words from lines....

                    CNE = scnWord.next();

                    NOM = scnWord.next();

                    PRENOM = scnWord.next();


                    GiFile.println(CNE+","+NOM+","+PRENOM);


                }
            }
            doc.close(); //fermer le document.

            GiFile.close(); //fermer le fichier CSV.




        }
        catch (Exception e)
        {
            e.printStackTrace(); //pour afficher des exception par exemple(plus que 3 colonnes).

        }


    }

}