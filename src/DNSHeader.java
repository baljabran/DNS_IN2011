import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class DNSHeader {

    public int id;

    public boolean qr;
    public int opcode;
    public boolean aa;
    public boolean tc;
    public boolean rd;
    public boolean ra;
    public int rcode;

    public int qdCount;
    public int anCount;
    public int nsCount;
    public int arCount;

    public DNSHeader() {

    }

    public byte[] toBytes() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        DNSUtils.writeShort(out, id);

        int flags = 0;
        if (qr) flags |= 0x8000;
        flags |= (opcode & 0xF) << 11;
        if (aa) flags |= 0x0400;
        if (tc) flags |= 0x0200;
        if (rd) flags |= 0x0100;
        if (ra) flags |= 0x0080;
        flags |= (rcode & 0xF);

        DNSUtils.writeShort(out, flags);

        DNSUtils.writeShort(out, qdCount);
        DNSUtils.writeShort(out, anCount);
        DNSUtils.writeShort(out, nsCount);
        DNSUtils.writeShort(out, arCount);

        return out.toByteArray();
    }

    public static DNSHeader fromBytes(ByteBuffer buffer) {

        DNSHeader header = new DNSHeader();

        header.id = DNSUtils.readShort(buffer);

        int flags = DNSUtils.readShort(buffer);

        header.qr = (flags & 0x8000) != 0;
        header.opcode = (flags >> 11) & 0xF;
        header.aa = (flags & 0x0400) != 0;
        header.tc = (flags & 0x0200) != 0;
        header.rd = (flags & 0x0100) != 0;
        header.ra = (flags & 0x0080) != 0;
        header.rcode = flags & 0xF;

        header.qdCount = DNSUtils.readShort(buffer);
        header.anCount = DNSUtils.readShort(buffer);
        header.nsCount = DNSUtils.readShort(buffer);
        header.arCount = DNSUtils.readShort(buffer);

        return header;
    }
}
