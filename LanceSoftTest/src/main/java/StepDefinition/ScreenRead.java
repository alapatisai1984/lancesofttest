package StepDefinition;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class ScreenRead
{
    public static String getText(String filepath, int index){
        File imageFile = null;
        ITesseract instance = null;
        try
        {
            imageFile = new File(filepath);
            System.out.println("Read From Image :" + imageFile.toString());
            instance = new Tesseract();
//            File tessDataFolder = LoadLibs.extractTessResources("tessdata");
//            System.out.println(tessDataFolder.getAbsolutePath());
            instance.setDatapath("/Users/gouthami/Downloads/tesseract/3.05.01/share/tessdata/");
            instance.setLanguage("eng");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String text = null;
        String result = null;
        try
        {
            text = instance.doOCR(imageFile);
            System.out.println("=======================================");
            System.out.println(text);
            System.out.println("=======================================");
            String[] array = text.split("\n");
            result = array[index];


            for(int i=0;i<array.length;i++)
            {
                System.out.println("Index : "+i);
                System.out.println("Value = "+array[i]);
            }


        } catch (TesseractException e)
        {
            e.printStackTrace();
        }


        return result;
    }
}
