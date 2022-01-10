package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> list;

    public Balls(Ball ball1,Ball ball2,Ball ball3){
        list = new ArrayList<>();
        list.add(ball1);
        list.add(ball2);
        list.add(ball3);
    }
    public Balls(List<Ball> balls){
        this.list = balls;
    }

    @Override
    public String toString(){
        String result = "["+list.get(0);

        for(int i=1;i<list.size();i++)
            result+=","+list.get(i);
        result+="]";

        return result;
    }

    public Ball get(int index) {
        return list.get(index);
    }
}
