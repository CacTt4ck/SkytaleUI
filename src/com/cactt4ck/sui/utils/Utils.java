package com.cactt4ck.sui.utils;

import com.cactt4ck.sui.Main;

import java.io.File;

public class Utils {

    public static void restartApp() {
        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");
            String mainClass = Main.class.getName();

            String[] command = {javaBin, "-cp", classpath, mainClass};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        System.exit(0);
    }

}
