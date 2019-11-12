import com.myMall.util.MD5Util;

public class MD5Test {
    public static void main(String[] args) {
        String md5Password = MD5Util.MD5EncodeUtf8("admin");
        System.out.println(md5Password);
    }
}
