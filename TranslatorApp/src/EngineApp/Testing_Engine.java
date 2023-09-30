package EngineApp;

import AppStr.NavigationStr;
import AppUtil.ScannerUtil;
import Date_Time_Ops.DateTimeFormat_Ops;
import Exceptions.AppException;
import FileUtils.FileOps;
import FileUtils.FromFile;
import FileUtils.ToFile;
import Word.TheWord;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Testing_Engine {

    private int correctPoints=0;
    private int incorrectPoints=0;
    private LocalTime start;
    private LocalDateTime date;



    public void startTesting()throws AppException
    {

        File file = getResultsFile();
        MainEngine.resultsFile = file;

        testing_Loop();//Main tesing loop
        LocalTime end = LocalTime.now();
        String gameTime = DateTimeFormat_Ops.getDuration(start,end);
        int score = resultPoint_Calculation();
        String result = "**************************************************\n"+
                "New Game Started at ->Time " +DateTimeFormat_Ops.getNowDate(date)+ "\n" +
                "Earned Points - " +score +"\n" +
                     gameTime +"\n" +
                    resultEnglishLevel(score) + "\n"+
                "**************************************************";

        System.out.println(result);
        ToFile.writeLineToFile(file,result);

    }//proccess of testing and getting logda to Files

    public  void testing_Loop()
    {
        TheWord[] words = FromFile.fillWordsToArray(new File(NavigationStr.words_TXT_Path));

        start = LocalTime.now();//Startin game time
        date = LocalDateTime.now();
        for(int i =0;i<10;i++)
        {
            int rnd = new Random().nextInt(words.length);
            if(!words[rnd].isShown())
            { words[rnd].setShown(true);
                System.out.println(words[rnd].getEng());
                String answer = ScannerUtil.requiredString("");
                if(words[rnd].getAze().equals(answer))
                {
                    correctPoints++;
                }
                else
                {
                   incorrectPoints++;

                }

            }
            else {
                i--;
            }


        }
        System.out.println("correct points"+correctPoints);
        System.out.println("incorrect points"+incorrectPoints );
        System.out.println("That is it for now!!!!");

    }

    public File getResultsFile() // to be handled in main menu engine
    {
        String resultsName = ScannerUtil.requiredString("Enter Challengers Name: ");
        return  FileOps.selectFile(NavigationStr.results_TXT_Path + resultsName+".txt");
    }//gets results file

    public String resultEnglishLevel(int points)
    {  String level = "English level is: ";
        switch(points)
        {
            case 0:
            case 1:
            case 2:
                level+="A0";
                break;
            case 3:
            case 4:
                level+="A1";
            case 5:
            case 6:
                level+="A2";
            case 7:
            case 8:
                level+="C1";
            case 9:
            case 10:
                level+="C2";
            default:
                level+=" Sherlock Holmes";

        }
        return level;
    } //Returns String for level of English
    public int resultPoint_Calculation()
    {
        int endPoint=correctPoints;
        while(incorrectPoints>2 && endPoint>0)
        {
            if(incorrectPoints>2)
            {
                endPoint--;
                incorrectPoints-=3;
            }
        }
        correctPoints=endPoint;

        return endPoint;
    }
}
