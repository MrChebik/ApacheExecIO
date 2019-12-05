package project0.exec;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import project0.exec.extra.CollectingLogOutputStream;
import project0.exec.extra.ExtendedStreamHandler;

import java.io.*;
import java.nio.file.Paths;

public class ApacheExec {
    private static CommandLine cmdLine;
    private static DefaultExecutor executor;
    private static ExtendedStreamHandler streamHandler;

    static {
        cmdLine = CommandLine.parse("java -jar " + System.getProperty("user.dir") + File.separator + Paths.get("target", "apache-exec-io-example-1.0-SNAPSHOT.jar").toString());

        executor = new DefaultExecutor();

        streamHandler = new ExtendedStreamHandler(new CollectingLogOutputStream());
        executor.setStreamHandler(streamHandler);
    }

    public static void startExec() {
        try {
            executor.execute(cmdLine, new DefaultExecuteResultHandler());
        } catch (IOException ignored) { }
    }

    public static void stopExec() {
        if (streamHandler.isOutputAvailable()) {
            Writer writer = new OutputStreamWriter(streamHandler.outputStream);

            System.out.println("[MAIN]: Call STOP execution");
            try {
                writer.write("exit\n");
                writer.flush();
            } catch (IOException ignored) {
            }
        } else {
            System.out.println("[MAIN]: Child programm is not running!");
        }
    }
}
 
