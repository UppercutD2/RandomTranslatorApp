package AppUtil;

import Exceptions.AppException;
import Exceptions.TranslatorException;

import java.util.Scanner;

public class ScannerUtil {
    public static Scanner console = new Scanner(System.in);

    public static  String requiredString(String s)
    {
        String word;
        while(true) {
            try {
            Thread.sleep(50);
            System.out.print(s);
            word = console.nextLine();
                if (word.matches("(\\w+|[abcçdeəfgğhxıijkqlmnoöprsştuüvyz]+|[0-9])")) {
                        break;

                } else {

                    throw new AppException(TranslatorException.ILLEGAL_CHARACTER_EXCEPTION);

                }

            } catch (AppException ex) {

            }
            catch(InterruptedException ex)
            {

            }
        }

        return word;
    }
}
