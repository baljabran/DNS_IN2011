public class DNSConstants {

    // DNS record types
    public static final short TYPE_A = 1;
    public static final short TYPE_NS = 2;
    public static final short TYPE_CNAME = 5;
    public static final short TYPE_MX = 15;
    public static final short TYPE_TXT = 16;

    // DNS class
    public static final short CLASS_IN = 1;

    // Standard DNS port
    public static final int DNS_PORT = 53;

    // Response codes
    public static final int RCODE_NOERROR = 0;
    public static final int RCODE_FORMERR = 1;
    public static final int RCODE_SERVFAIL = 2;
    public static final int RCODE_NXDOMAIN = 3;
}
