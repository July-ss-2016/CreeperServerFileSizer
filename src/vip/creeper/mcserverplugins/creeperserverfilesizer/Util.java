package vip.creeper.mcserverplugins.creeperserverfilesizer;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by July_ on 2017/7/21.
 */
public class Util {

    public static boolean copy(final String SOURCE_FILE_PATH, final String DEST_FILE_PATH) throws IOException{
        File srcFile = new File(SOURCE_FILE_PATH);

        if (srcFile.isDirectory()) {
            File[] srcFiles = srcFile.listFiles();

            for (int i = 0; i < srcFiles.length; i++) {
                String newPath = SOURCE_FILE_PATH + File.separator + srcFiles[i].getName();
                String newCopyPath = DEST_FILE_PATH + File.separator + srcFiles[i].getName();
                File newFile = new File(DEST_FILE_PATH);

                if(!newFile.exists()) {
                    newFile.mkdirs();
                }

                copy(newPath, newCopyPath);
            }

        } else if (srcFile.isFile()) {

            FileChannel inputChannel = new FileInputStream(SOURCE_FILE_PATH).getChannel();
            FileChannel outputChannel = new FileOutputStream(DEST_FILE_PATH).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

            /*
            DataInputStream readStream= new DataInputStream(new BufferedInputStream(new FileInputStream(SOURCE_FILE_PATH)));
            DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(DEST_FILE_PATH)));
            byte [] buf = new byte[1024];
            int len;

            while ((len = readStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }

            readStream.close();
            outputStream.close();
            */
        } else {
            return false;
        }

        return true;
    }
}
