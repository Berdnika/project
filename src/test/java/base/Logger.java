package test.java.base;

import org.apache.commons.lang3.StringEscapeUtils;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class Logger extends TestListenerAdapter {
    private static int m_count = 0;

    public static final void debug(String message)
    {
        log(" DEBUG: ", message);
    }

    public static final void htmlOutput(String message)
    {
        log(" SCREENSHOT: ",message);
    }

    public static final void error(String message)
    {
        log(" ERROR: ",message);
    }

    private static void log(String prefix, String message) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String newMessage = dt.format(date) + prefix + message;
        System.out.print(newMessage);
        System.out.println("");

    }
}
