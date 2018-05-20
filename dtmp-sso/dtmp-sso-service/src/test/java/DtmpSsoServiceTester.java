import org.springframework.util.DigestUtils;

public class DtmpSsoServiceTester {

    public static void main(String[] args) {
        testMD5();
    }

    private static void testMD5() {
        String str = "123456";
        String md5Str = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println("before md5 :" + str);
        System.out.println("after md5 :" + md5Str);
    }
}