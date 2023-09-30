package FileUtils;

import AppUtil.ScannerUtil;
import ArrayWords.ArrayUtils;
import EngineApp.MainEngine;
import EngineApp.Testing_Engine;
import Word.TheWord;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FromFile {


    public static TheWord[] fillWordsToArray(File file)
    {
        TheWord[] words = ArrayUtils.createStrArray(file);

        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr))
        {

            for(int i =0;i<words.length;i++)
            {   words[i]= new TheWord();
               String[] word = br.readLine().split(":");
               words[i].setEng(word[0]);
               words[i].setAze(word[1]);

            }
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }

        return words;
    }

    public static void printResults()
    {

        try(Scanner input  = new Scanner(MainEngine.resultsFile))
        {
            while(input.hasNextLine())
            {
                System.out.println(input.nextLine());
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }


}
