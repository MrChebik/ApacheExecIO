package project0.exec.extra;

import org.apache.commons.exec.LogOutputStream;

import java.util.LinkedList;
import java.util.List;

public class CollectingLogOutputStream extends LogOutputStream {
    private final List<String> lines = new LinkedList<String>();
    @Override protected void processLine(String line, int level) {
        lines.add(line);

        System.out.println("[M]: " + line);
    }
    public List<String> getLines() {
        return lines;
    }
}
