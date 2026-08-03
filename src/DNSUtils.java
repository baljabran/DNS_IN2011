import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class DNSUtils {

    // Write a 16-bit unsigned value
    public static void writeShort(ByteArrayOutputStream out, int value) {
        out.write((value >> 8) & 0xFF);
        out.write(value & 0xFF);
    }

    // Read a 16-bit unsigned value
    public static int readShort(ByteBuffer buffer) {
        return buffer.getShort() & 0xFFFF;
    }

    // Write a 32-bit unsigned value
    public static void writeInt(ByteArrayOutputStream out, long value) {
        out.write((int) ((value >> 24) & 0xFF));
        out.write((int) ((value >> 16) & 0xFF));
        out.write((int) ((value >> 8) & 0xFF));
        out.write((int) (value & 0xFF));
    }

    // Read a 32-bit unsigned value
    public static long readInt(ByteBuffer buffer) {
        return buffer.getInt() & 0xFFFFFFFFL;
    }
}
