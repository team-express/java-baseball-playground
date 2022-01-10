package baseball;

public class BallStatesInfo {
    //합해서 3을 넘어도 안넘어도 안된다는 것이, 여기서 해야할 일일까?
    private int ballCnt;
    private int strikeCnt;

    //필드 ball, strike를 올린다
    public void plusBallCount(){
        this.ballCnt++;
    }
    public void plusStrikeCount(){
        this.strikeCnt++;
    }

    //명세 반환
    @Override
    public String toString(){
        StringBuffer message = new StringBuffer("");

        int ballCnt = this.ballCnt;
        int strikeCnt = this.strikeCnt;

        if(ballCnt==0&&strikeCnt==0)
            return "Nothing";

        if(ballCnt>0)
            message.append(ballCnt+"볼 ");
        if(strikeCnt>0)
            message.append(strikeCnt+"스트라이크 ");

        return message.toString();
    }

    //삼진아웃
    public boolean check3Strike(){
        return this.strikeCnt==3;
    }
}
