package baseball;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class Ball {
    private int num;
    @Setter private int position;

    public Ball(int num){
        this.num=num;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Ball)
            return ((Ball) object).getNum()==this.getNum() && ((Ball) object).getPosition()==this.getPosition();
        return false;
    }
    @Override
    public  String toString(){
        return "("+num+","+position+")";
    }
}
