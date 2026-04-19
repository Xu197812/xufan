package com.xufan.learn.File;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author XuFan
 * @create 2025-03-24-17:12
 */
public class DirectoryOperations {
//    public static void listFiles(String dirPath) {
//        Path path = Paths.get(dirPath);
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
//            for (Path file: stream) {
//                System.out.println(file.getFileName());
//            }
//        } catch (IOException | DirectoryIteratorException x) {
//            System.err.println(x);
//        }
//    }

//    public static void main(String[] args) {
//        String dir = "/E:/tmp_data/";// [√]      // "file:///E:/tmp_data/"; [x]
//
//        Collection<File> files = FileUtils.listFiles(
//                new File(dir), new RegexFileFilter(".*\\.enable.xmind"), TrueFileFilter.TRUE
//        );
//
//        int xmindFileSize = files.size();
//        if(xmindFileSize != 1) {
//            throw new RuntimeException(String.format("Enabled xmind files not only one file, please check file(`*.enable.xmind`) of directory(`%s`)!size:%d", xmindFileBaseDir, xmindFileSize));
//        }
//
//        Iterator<File> iterator = files.iterator();
//        while (iterator.hasNext()) {
//            File xmindFile = iterator.next();
//            logger.debug("xmindFile:{}", xmindFile.getAbsoluteFile());
//            xmindFilePath = xmindFile.getAbsolutePath();
//        }
//
//        logger.info("xmindFilePath:{}", xmindFilePath);
//    }
}
