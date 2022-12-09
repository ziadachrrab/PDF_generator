

/* Project by: ACHRRAB Ziad,
               FELLAH Hamza

          GI Students S3.
 */


package org.example;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        try
        {

            String path,nameFile;

            System.out.println("enter the name of your new file excel with path : ");

            Scanner lire = new Scanner(System.in);

            nameFile = lire.nextLine();

            System.out.println("enter the path of the pdf file : ");

            path = lire.nextLine();

            PrintWriter GiFile = new PrintWriter(nameFile);// this is the name of csv file after being converted...


            PDDocument doc = PDDocument.load(new File(path));// here is the name of pdf file that we want to read .
            doc.getClass();
            if (!doc.isEncrypted())
            {


                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper Tstripper = new PDFTextStripper();
                String str = Tstripper.getText(doc);

                //

                Scanner scnLine = null;

                scnLine = new Scanner(str);//read lines from pdf file...


                String CNE = "";

                String NOM = "";

                String PRENOM = "";


                while (scnLine.hasNextLine())
                {

                    String line = scnLine.nextLine();

                    Scanner scnWord = new Scanner(line); // read words from lines....

                    CNE = scnWord.next();

                    NOM = scnWord.next();

                    PRENOM = scnWord.next();


                    GiFile.println(CNE+","+NOM+","+PRENOM);


                }
            }
            doc.close();
            GiFile.close();




        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }

}