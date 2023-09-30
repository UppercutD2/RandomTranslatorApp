package ArrayWords;


import FileUtils.FileOps;
import Word.TheWord;

import java.io.File;

public class ArrayUtils {


    public static TheWord[] createStrArray(File file)
    {


        return new TheWord[FileOps.getLinesNumber(file)];

    }



}
