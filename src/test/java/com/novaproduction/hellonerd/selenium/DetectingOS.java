package com.novaproduction.hellonerd.selenium;

import java.util.logging.Logger;

/**
 * Recognize the operating system of the current system.<br />
 * There are 2 used OS constants to use.<br />
 * <li>OS_WINDOWS</li>
 * <li>OS_LINUX</li>
 * @author hir
 */
public class DetectingOS {
	public static final String OS_WINDOWS = "windows";
	public static final String OS_LINUX = "linux";
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private static boolean isWindows() {
        return OS.contains("win");
    }
 
	private static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }
	
	/**
	 * Recognize the operating system of the current system.<br />
	 * There are 2 used OS constants to use.<br />
	 * <li>OS_WINDOWS</li>
	 * <li>OS_LINUX</li>
	 * @author hir
	 */
    public static String getOS(){
        if (isWindows()) {
            return "windows";
        } else if (isUnix()) {
            return "linux";
        } else {
            return "err";
        }
    }
}
