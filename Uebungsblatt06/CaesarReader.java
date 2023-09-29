package Uebungsblatt06;

import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends Reader {

    private final Reader _base;

    public CaesarReader(Reader base) {
        _base = base;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int readLen = _base.read(cbuf, off, len);
        for (int i = 0; i < readLen; i++) {
            cbuf[off + i] = (char)(cbuf[off + i] - 3);
        }
        return readLen;
    }

    @Override
    public void close() throws IOException {
        _base.close();
    }
}
