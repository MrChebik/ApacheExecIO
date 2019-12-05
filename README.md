# Apache Exec IO Example

To send data to other Application:

1 . Create custom StreamHandler

```
public class ExtendedStreamHandler extends PumpStreamHandler {
    public OutputStream outputStream;

    ExtendedStreamHandler(OutputStream outAndErr) {
        super(outAndErr);
    }

    @Override
    public void setProcessInputStream(OutputStream os) {
        outputStream = os;
    }

    public boolean isOutputAvailable() {
        return outputStream != null;
    }
}
```

2 . When you want to send data to the process, execute
```
if (streamHandlet.isOutputAvailable() {
    Writer writer = new OutputStreamWriter(streamHandler.outputStream);
    
    // ...
}
```