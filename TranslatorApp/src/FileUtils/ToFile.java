package FileUtils;

import AppStr.NavigationStr;
import AppUtil.ScannerUtil;
import Exceptions.AppException;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToFile {





    public static void writeLineToFile(File file,String s)
    {


        try(FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fileWriter))
        {
            bw.newLine();
            bw.write(s);
            bw.flush();
            System.out.println("Data have been added to File.");
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void addNewWord(String english, String azeri)
    {
        try(FileWriter fw = new FileWriter(NavigationStr.words_TXT_Path,true);
            BufferedWriter bw = new BufferedWriter(fw);
        )
        {
            String newWord = english + ":"+ azeri;
            bw.write(newWord);
            bw.newLine();
            bw.flush();
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void addWord()
    {
        try{
            String englishW = getEngWord();
            String azeriW = getAzeWord();
            addNewWord(englishW,azeriW);
            System.out.println("New word has been added to Vocabulary");
        }catch (AppException ex)
        {
            System.err.println("Failed to add New Word");
        }




    }


    public static String getEngWord() throws  AppException
    {
            return  ScannerUtil.requiredString("Input English word: ");
    }
    public static String getAzeWord() throws AppException
    {
            return ScannerUtil.requiredString("Input Azerbaijani word: ");
    }

}
