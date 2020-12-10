import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by caozhen on 2020/12/10
 * 7、拉耗子
 * 几个人玩拉耗子（一种扑克游戏，每人随机发5张牌按牌型比大小，2最小，A最大）
 * 写一个简单发牌函数，要求发出10～A的概率要比2-9高出一倍
 */
public class LaHaozi {

    public static Boolean faPai() {

        Random r = new Random();
        int s = r.nextInt(99);
        if (s <= 66) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] bigger = {"A", "10"};
        String[] smaller = {"2", "9"};

        List<String> biggerList = Arrays.asList(bigger);
        List<String> smallerList = Arrays.asList(smaller);

        while (true) {
            Boolean fa = faPai();
            if (fa) {
                biggerList.get(0);
            } else {
                smallerList.get(0);
            }
        }


    }
}
