package Uebungsblatt06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFiles {

    public static void main(String[] args) throws IOException {

        List<String> _p = Arrays.asList("test1.txt", "test2.txt");
        FileOutputStream fos = new FileOutputStream("src/programming/ue/dcs/zip/ZipFiles/multiCompressed.zip");
        String _u = "src/programming/ue/dcs/zip/ZipFiles/multiCompressed.zip";
        String dy = "src/programming/ue/dcs/zip/ZipFiles/UnzipTest";

        //Zip(_p, fos);

        UnzipFile(_u, dy);

    }

    private static void Zip(List<String> zip, FileOutputStream dir) throws IOException {

        List<String> _p = zip;
        FileOutputStream fos = dir;

        ZipOutputStream zipOut = new ZipOutputStream(dir);

        for (String srcFile : zip) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        dir.close();
    }

    private static void UnzipFile(String unzip, String directory) throws IOException {

        List fileList;
        byte[] buffer = new byte[1024];
        try{
            //create output directory if not exist
            File folder = new File(directory);
            if(!folder.exists()){
                folder.mkdir();
            }
            //get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(unzip + "/"));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();
            while(ze!=null){
                String fileName = ze.getName();
                File newFile = new File(directory + File.separator + fileName);
                System.out.println("file unzip : "+ newFile.getAbsoluteFile());
                //create all non existing folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            System.out.println("Done");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
