package baseball;

import lombok.Getter;

@Getter
public class Ball {
    private int num;

    public Ball(int num){
        this.num=num;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Ball)
            return ((Ball) object).getNum()==this.getNum();
        return false;
    }
}
