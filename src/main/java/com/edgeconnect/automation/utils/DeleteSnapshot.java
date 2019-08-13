package com.edgeconnect.automation.utils;

import java.io.File;

public class DeleteSnapshot {

    public static void deleteSnapShotDir() {
        File screenshotDir = new File("snapshot");
        if (screenshotDir.exists()) {
            String[] files = screenshotDir.list();
            for (String file : files) {
                File currentFile = new File(screenshotDir.getPath(), file);
                currentFile.delete();
            }
            screenshotDir.delete();
            System.out.println("Screenshots directory is deleted");
        } else
            System.out.println("Screenshots directory is not present");
    }
}
