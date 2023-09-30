package EngineApp;

import AppStr.NavigationEnum;
import AppUtil.ScannerUtil;
import Exceptions.AppException;
import FileUtils.FromFile;
import FileUtils.ToFile;

import java.io.File;
import java.util.Scanner;

public class MainEngine {
    public static NavigationEnum[] navigation = {NavigationEnum.START,
                                       NavigationEnum.ADD_WORD,
                                       NavigationEnum.SEE_HISTORY,
                                       NavigationEnum.EXIT};

        public static  File resultsFile;
    public void mainMenu()
    {

            System.out.println("================Translator App=====================");
            for (NavigationEnum en : navigation) {
                System.out.println(en.getNaviMsg());
            }
            System.out.println("==================================================");
        System.out.print("Choose option: ");
        String option =  ScannerUtil.requiredString("");

            switch(option)
            {
                case "0":
                    System.out.println("Program stopped");
                        System.exit(0);
                case "1":
                    startGame();
                    break;
                case "2":
                    addWord();
                    break;
                case "3":
                    seeHistory();
                    break;
                default:
                    System.err.println("Wrong operation selected");

            }

    }

    public void startGame()
    {
        Testing_Engine testingEngine = new Testing_Engine();

        try{
            testingEngine.startTesting();
        }catch(AppException ex)
        { }
    }
    public void addWord()
    {
        ToFile.addWord();
    }

    public void seeHistory()
    {
        FromFile.printResults();
    }

    //will exit on Exit



}
