import org.json.simple.JSONObject;
import utils.HttpUtil;


public class Main {
    static HttpUtil httpUtil;
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            httpUtil = new HttpUtil(i);
            long now = httpUtil.start();
            while (true) {
                if (now == -1) {
                    break;
                }
                if (now != 0) {
                    httpUtil.UserInfo();
                }
                if (now == 595) {
                    httpUtil.GameResult();
                    httpUtil.Match(now);
                    break;
                }
                httpUtil.waiting(now);
                now = httpUtil.Match(now);
                httpUtil.GameResult();
            }
            JSONObject result = httpUtil.Score();
        }
    }
}
