import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class DNSQuestion {

    public String name;
    public short type;
    public short dnsClass;

    public DNSQuestion() {

    }

    public DNSQuestion(String name, short type) {
        this.name = name;
        this.type = type;
        this.dnsClass = DNSConstants.CLASS_IN;
    }

    public byte[] toBytes() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        DNSUtils.writeDomainName(out, name);
        DNSUtils.writeShort(out, type);
        DNSUtils.writeShort(out, dnsClass);

        return out.toByteArray();
    }

    public static DNSQuestion fromBytes(ByteBuffer buffer, byte[] packet) {

        DNSQuestion question = new DNSQuestion();

        question.name = DNSUtils.readDomainName(buffer, packet);
        question.type = (short) DNSUtils.readShort(buffer);
        question.dnsClass = (short) DNSUtils.readShort(buffer);

        return question;
    }
}
