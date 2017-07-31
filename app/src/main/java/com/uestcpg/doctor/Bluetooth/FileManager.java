package com.uestcpg.doctor.Bluetooth;


import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by John on 2017/7/11.
 */

public class FileManager {
    private static final String LOG_TAG = "error";
    private String display_content = "";
    public File file;
    private File tmp;

    public FileManager(Context context)
    {
        tmp = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    public File createFile(String albumName){
        // Get the directory for the app's private pictures directory.
        file = new File(tmp, albumName);
//        if(!file.mkdirs()){
//            Log.e(LOG_TAG,"Directory not created");
//            return null;
//        }
        return file;
    }

//    /* Checks if external storage is available for read and write */
//    public boolean isExternalStorageWritable(){
//        String state =Environment.getExternalStorageState();
//        if(Environment.MEDIA_MOUNTED.equals(state)){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 保存到SD卡
//     * @param filename
//     * @param filecontent
//     * @throws Exception
//     */
//    public void saveToSDCard(String filename, String filecontent) throws Exception{
////        file = new File(Environment.getExternalStorageDirectory(),filename);
//        FileOutputStream outStream = new FileOutputStream(file);
//        outStream.write(filecontent.getBytes());
//        outStream.close();
//    }
//
//    public void saveToSDCard2(Context context, String filename, String filecontent) throws Exception
//    {
////        File file = getAlbumStorageDir(context, filename);
//
//    }

    public void writeToFile() throws Exception
    {
        FileOutputStream outStream = new FileOutputStream(file);
        outStream.write(display_content.getBytes());
        outStream.close();
    }

    public void writeToFile(File file, String display_content) throws Exception
    {
        FileOutputStream outStream = new FileOutputStream(file);
        outStream.write(display_content.getBytes());
        outStream.close();
    }

    public void addOneLine(String line)
    {
        display_content += line;
        display_content += "\n";
    }

}
