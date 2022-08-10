package com.novaproduction.hellonerd.selenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * <p><b>Initialize the logger in the class BaseClass</b></p>
 * <code>private static Logger logger = MyLogger.getLogger(BaseClass.class);</code>
 * 
 * <p><b>Use the logger</b></p>
 * <li>logger.info("this is an info log message.");</li>
 * <li>logger.warning("this is a warning log message.");</li>
 * <li>logger.severe("this is a severe log message.");</li>
 * 
 * <p><b>Result Log</b></p>
 * <li>25/06/2022 10:05:48.729 - [com.novaproduction.hellonerd.selenium.BaseClass.startup] - [INFO] - this is an info log message.</li>
 * <li>25/06/2022 10:06:47.318 - [com.novaproduction.hellonerd.selenium.BaseClass.readfile] - [WARNING] - this is a warning log message.</li>
 * <li>25/06/2022 10:08:43.281 - [com.novaproduction.hellonerd.selenium.TabManager.changetab] - [SEVERE] - this is a severe log message.</li>
 * 
 * @author hir
 *
 */
public class MyLogger {
	public static Logger getLogger(Class className) {
		if(className == null) {
			return null;
		}
		Logger logger = Logger.getLogger(className.getName());
        logger.setUseParentHandlers(false);
        MyFormatter formatter = new MyFormatter();
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(formatter);
        logger.addHandler(handler);
        return logger;
	}
}

class MyFormatter extends Formatter {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

    public String format(LogRecord record) {
        Date date = new Date(record.getMillis());
        String formattedDate = null;
        if(date != null) {
        	formattedDate = DATE_FORMAT.format(date);
        }
        String className = record.getSourceClassName();
        String methodeName = record.getSourceMethodName();
        Level logLevel = record.getLevel();
        String formattedText = null;
        if(record != null) {
        	formattedText = formatMessage(record);        	
        }
        String logMessage = null;
        if(formattedDate != null && className != null && methodeName != null && logLevel != null && formattedText != null) {
        	logMessage = getFormattedLogMessage(formattedDate, className, methodeName, logLevel, formattedText);        	
        }else {
        	System.out.println("format args not valid.");
        }
        return logMessage;
    }
    
    private static final String CHAR_HYPHEN = " - ";
    private static final String CHAR_BRACKET_OPENED = "[";
    private static final String CHAR_BRACKET_CLOSED = "]";
    private static final String CHAR_DOT = ".";
    private static final String NEW_LINE = "\n";
    
	private String getFormattedLogMessage(String formattedDate, String className, String methodeName, Level logLevel, String formattedText) {
		StringBuilder sb = new StringBuilder();
		sb.append(formattedDate);
		sb.append(CHAR_HYPHEN);
		sb.append(CHAR_BRACKET_OPENED);
		sb.append(className);
		sb.append(CHAR_DOT);
		sb.append(methodeName);
		sb.append(CHAR_BRACKET_CLOSED);
		sb.append(CHAR_HYPHEN);
		sb.append(CHAR_BRACKET_OPENED);
		sb.append(logLevel);
		sb.append(CHAR_BRACKET_CLOSED);
		sb.append(CHAR_HYPHEN);
		sb.append(formattedText);
		sb.append(NEW_LINE);
	    return sb.toString();
	}
}

