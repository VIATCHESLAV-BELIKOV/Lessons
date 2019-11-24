package com.ifmo.lesson15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    Реализуйте все методы с использованием потоков ввода-вывода.
 */
public class IOStreamTasks {
    public static void main(String[] args) throws IOException {

        File srcf = new File("C:\\Java\\resources\\wap.txt");

        File dstf = new File("C:\\Java\\resources\\wap_copy.txt");

        File fspl = new File("C:\\Java\\resources\\wap_split.txt");

        List<File> file_split;

        File fasb = new File("C:\\Java\\resources\\wap_assembly.txt");

        File fkey1 = new File("C:\\Java\\resources\\wap_encypt1.txt");

        File fkey2 = new File("C:\\Java\\resources\\wap_encypt2.txt");

        String string_key = "I'll never let you see\n" +
                "The way my broken heart is hurting me\n" +
                "I've got my pride and I know how to hide\n" +
                "All the sorrow and pain\n" +
                "I'll do my crying in the rain";

        File fkeyK = new File("C:\\Java\\resources\\wap_RobertBurns.txt");

        File fkey3 = new File("C:\\Java\\resources\\wap_encypt3.txt");

        File fkey4 = new File("C:\\Java\\resources\\wap_encypt4.txt");

        try ( InputStream inpS = new FileInputStream(srcf); OutputStream outS = new FileOutputStream(dstf) ) {
            copy(inpS, outS);
            outS.flush();
        }

        file_split = split( srcf, fspl, 40960 );

  //      file_split.forEach( item->System.out.println(item) );

        assembly(file_split, fasb);

        try ( InputStream inpS = new FileInputStream(srcf); OutputStream outS = new FileOutputStream(fkey1) ) {
            encrypt(inpS, outS, string_key);
            outS.flush();
        }

        try ( InputStream inpS = new FileInputStream(fkey1); OutputStream outS = new FileOutputStream(fkey2) ) {
            encrypt(inpS, outS, string_key);
            outS.flush();
        }

        encrypt(srcf, fkey3, fkeyK);

        encrypt(fkey3, fkey4, fkeyK);

    }

    /**
     * Полностью копирует один поток в другой.
     *
     * @param src Входящий поток.
     * @param dst Выходящий поток.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void copy(InputStream src, OutputStream dst) throws IOException {
        // TODO implement
        byte[] buf = new byte[1024];
        int len;
        while ((len = src.read(buf)) > 0)
            dst.write(buf, 0, len);
    }

    /**
     * Последовательно разбивает файл на несколько более мелких, равных
     * указанному размеру. Последний файл может быть меньше задданого
     * размера.
     *
     * @param file Файл, который будет разбит на несколько.
     * @param dstDir Директория, в которой будут созданы файлы меньшего размера.
     * @param size Размер каждого файла-части, который будет создан.
     * @return Список файлов-частей в том порядке, в котором они должны считываться.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static List<File> split(File file, File dstDir, int size) throws IOException {

        int iFileNo = 1;
        int iBuf = (size > 1024) ? 1024 : size;
        int iRead, iGot, iFrom;
        List<File> lf = new ArrayList<>();

        try(InputStream inS = new FileInputStream(file)){
            byte buf[] = new byte[iBuf];
            //  iInSz = inS.available();
            File f = new File(dstDir.getAbsolutePath() + /* file.getName() + */  ".part."+ String.format("%05d",iFileNo));
            OutputStream outS = new FileOutputStream(f);
            lf.add(f);
            iGot = 0;
            while ((iRead = inS.read(buf)) > 0) {

                if ((iGot + iRead) <= size ) {
                    outS.write(buf, 0, iRead);
                    iGot += iRead;
                }
                else {
                    iFrom = iGot + iRead - size;
                    outS.write( buf, 0, size - iGot );
                    outS.flush();
                    iFileNo++;
                    f = new File(dstDir.getAbsolutePath() + /*file.getName() + */ ".part."+ String.format("%05d",iFileNo));
                    lf.add(f);
                    outS = new FileOutputStream(f);
                    outS.write( buf, size - iGot, iGot + iRead - size );
                    iGot = iGot + iRead - size;
                }
            }
            outS.close();
            inS.close();
            return lf;
            /*  Files.find( dstDir.toPath(), 0, ( path, basicFileAttributes) -> {
                File f = path.toFile();
                return f.getName().matches(file.getName() + ".part.*");       } ).collect(Collectors.toList());*/
        }
    }

    /**
     * Собирает из частей один файл.
     *
     * @param files Список файлов в порядке чтения.
     * @param dst Файл, в который будут записаны все части.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void assembly(List<File> files, File dst) throws IOException {

        try(OutputStream outS = new FileOutputStream(dst)) {

           int iBuf = 1024;
           byte buf[] = new byte[iBuf];

           files.forEach( file->{
               int len;
               try {
                   InputStream inS = new FileInputStream(file);
                   while ((len = inS.read(buf)) > 0)
                       outS.write(buf, 0, len);
                   inS.close();
               }
               catch (IOException e) {
                   e.printStackTrace();
               }
           } );
           outS.flush();
        }
    }

    /**
     * Шифрует/дешифрует поток с помощью XOR. В качестве ключа используется пароль.
     *
     * @param src Входящий поток, данные которого будут зашифрованы/расшифрованы.
     * @param dst Выходящий поток, куда будут записаны зашифрованные/расшифрованные данные.
     * @param passphrase Пароль.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(InputStream src, OutputStream dst, String passphrase) throws IOException {

        byte[] buf = new byte[1024];
        int i, len;
        i = 0;

 //       System.out.println("length=" + passphrase.length());

        while ((len = src.read(buf)) > 0) {
            for (int j = 0; j < len; j++) {
                buf[j] ^= passphrase.charAt(i);
                i++;
                if (!(i < passphrase.length())) i = 0;
            }
            dst.write(buf, 0, len);
        }

    }

    /**
     * Шифрует/дешифрует файл с помощью файла-ключа.
     *
     * @param src Файл, который должен быть зашифрован/расшифрован.
     * @param dst Файл, куда будут записаны зашифрованные/расшифрованные данные.
     * @param key Файл-ключ.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(File src, File dst, File key) throws IOException {

        int iBuf = 1024;
        int iBufKey, len;
        int lenKey, iKeyFileSz, i;

        try( InputStream inS = new FileInputStream(src); OutputStream outS = new FileOutputStream(dst) ) {

            InputStream inKey = new FileInputStream(key);
            iKeyFileSz =  inKey.available();
            iBufKey = ( iKeyFileSz > 1024 ) ? 1024 : iKeyFileSz;
            byte bufKey[] = new byte[iBufKey];
            byte buf[] = new byte[iBuf];
            i = 0;
            lenKey = inKey.read(bufKey);
            while ((len = inS.read(buf)) > 0) {
                for (int j = 0; j < len; j++) {
                    buf[j] ^= bufKey[i];
                    i++;
                    if ( !(i < lenKey) ) {                   // end of key buffer reached
                        if ( lenKey == iKeyFileSz ) {         // key file is equal lenKey
                            i = 0;
                        }
                        else {                               // key buffer should be filled with next data portion
                            lenKey = inKey.read(bufKey);
                            if ( lenKey > 0 ) {              // key buffer is filled
                                i = 0;
                            }
                            else {                           // reopen key file
                                inKey.close();
                                inKey = new FileInputStream(key);
                                lenKey = inKey.read(bufKey);
                                i = 0;
                            }
                        }

                    } // end: !(i < lenKey)
                }
                outS.write(buf, 0, len);
            }
            inKey.close();
            outS.flush();
            inS.close();

            return;
        }
    }
}
