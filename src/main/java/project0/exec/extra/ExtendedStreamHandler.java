package project0.exec.extra;

import org.apache.commons.exec.PumpStreamHandler;

import java.io.OutputStream;

public class ExtendedStreamHandler extends PumpStreamHandler {
    public OutputStream outputStream;

    public ExtendedStreamHandler(OutputStream outAndErr) {
        super(outAndErr);
    }

    @Override
    public void setProcessInputStream(OutputStream os) {
        outputStream = os;

        //super.setProcessInputStream(os);
    }

    public boolean isOutputAvailable() {
        return outputStream != null;
    }
}
