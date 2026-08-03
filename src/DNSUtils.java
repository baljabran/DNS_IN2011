import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class DNSUtils {

    public static void writeShort(ByteArrayOutputStream out, int value) {
        out.write((value >> 8) & 0xFF);
        out.write(value & 0xFF);
    }

    public static int readShort(ByteBuffer buffer) {
        return buffer.getShort() & 0xFFFF;
    }

}
