package vip.creeper.mcserverplugins.creeperserverfilesizer;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by July_ on 2017/7/21.
 */
public class Util {

    public static boolean copy(final String sourceFilePath, final String destFilePath) throws IOException{
        File srcFile = new File(sourceFilePath);

        if (srcFile.isDirectory()) {
            File[] srcFiles = srcFile.listFiles();

            for (int i = 0; i < srcFiles.length; i++) {
                String newPath = sourceFilePath + File.separator + srcFiles[i].getName();
                String newCopyPath = destFilePath + File.separator + srcFiles[i].getName();
                File newFile = new File(destFilePath);

                if(!newFile.exists()) {
                    newFile.mkdirs();
                }

                copy(newPath, newCopyPath);
            }

        } else if (srcFile.isFile()) {

            FileChannel inputChannel = new FileInputStream(sourceFilePath).getChannel();
            FileChannel outputChannel = new FileOutputStream(destFilePath).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } else {
            return false;
        }

        return true;
    }
}
