package vip.creeper.mcserverplugins.creeperserverfilesizer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by July_ on 2017/7/20.
 */
public class Main {
    public static final String SERVER_FOLDER_PATH = "D:\\vip.creeper.julyss\\test_servers\\RpgSurvival_0"; //服务器文件夹
    public static final String DEST_FOLDER_PATH = "F:\\vip.creeper\\server_updater"; //输出文件夹

    //子目录
    public static final List<String> SUBFILE_PATHS = Arrays.asList("w_instance_0",
            "plugins\\BossShop",
            "plugins\\CreeperRpgSystem\\configs",
            "plugins\\MythicMobs",
            "plugins\\AAC",
            "plugins\\Shopkeepers",
            "plugins\\CreeperRpgItemAttributeDisplayer",
            "plugins\\CreeperRpgItem",
            "plugins\\CreeperRpgSystem",
            "plugins\\CreeperRpgItemAttributeDisplayer");

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String currentTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        for (String subFilePath : SUBFILE_PATHS) {
            String completeSrcFilePath = SERVER_FOLDER_PATH + File.separator + subFilePath;
            String completeDestFilePath = DEST_FOLDER_PATH + File.separator + "update_" + currentTimeStr + File.separator + subFilePath;

            try {
                System.out.println("源目录: " + completeSrcFilePath);
                System.out.println("输出目录: " + completeDestFilePath);
                if (!Util.copy(completeSrcFilePath, completeDestFilePath)) {
                    System.out.println("目录或文件不存在!");
                }
            } catch (IOException e) {
                System.out.println("复制失败!");
                e.printStackTrace();
            }

        }

        System.out.println();
        System.out.println("任务完成!耗时" + (System.currentTimeMillis() - startTime) + "ms");

    }

}
