/**
 *     01.12.2015
 *     Dmitry Talankin
 *     Lessons #5 Task #22
 */

package com.dtalankin;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class Task6_22JUnit {

    private static Path pathFile = Paths.get("47.txt");
    private static Path pathDest = Paths.get("47_1.txt");
    private static Path pathDir = Paths.get("testdir");
    private static Path pathDir1 = Paths.get("testdir1");
    private static Path absolutePathFile = null;

    @BeforeClass
    public static void onceSetUp() {
        try {
            Files.createFile(pathFile);
            Files.createDirectory(pathDir);
            Files.createDirectory(pathDir1);
            absolutePathFile = pathFile.toAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void onceTearDown() {
        try {
            Files.deleteIfExists(pathFile);
            Files.deleteIfExists(pathDest);
            Files.deleteIfExists(pathDir);
            Files.deleteIfExists(pathDir1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFileName() {
        assertEquals("failure - filenames are not equal", pathFile.getFileName().toString(), "47.txt");
    }

    @Test
    public void testGetRoot() {
        assertEquals("failure - roots are not equal", absolutePathFile.getRoot().toString(), "/");
    }

    @Test
    public void testIsAbsolute() {
        assertTrue("failure - absolutePathFile is not absolute", absolutePathFile.isAbsolute());
    }

    @Test
    public void testCopy() {
        try {
            Files.copy(pathFile, pathDest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue("failure - pathDest is not exist", Files.exists(pathDest, LinkOption.NOFOLLOW_LINKS));
    }

    @Test
    public void testCreateDirectory() {
        assertTrue("failure - pathDir is not exist", Files.exists(pathDir));
    }

    @Test
    public void testIsDirectory() {
        assertTrue("failure - pathDir1 is not a directory or it is not exists", Files.isDirectory(pathDir1));
    }

}