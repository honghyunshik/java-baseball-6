package baseball.common.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberService {

    private List<Integer> computer;

    public RandomNumberService(){
        computer = createRandomNumber();
    }

    //임의의 3자리 숫자 생성 로직
    private ArrayList<Integer> createRandomNumber(){

        ArrayList<Integer> list = new ArrayList<>();

        while(list.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }
        return list;
    }

    //사용자 입력 유효성 검사
    public boolean isValid(String number){

        //사용자 입력에는 0이 포함되어서는 안된다
        if(number.contains("0")) throw new IllegalArgumentException("정답에는 0이 포함될 수 없습니다");

        //사용자 입력은 3자리여야 한다
        if(number.length()!=3) throw new IllegalArgumentException("정답은 3자리 숫자입니다");

        //사용자 입력은 숫자이어야 한다
        try{
            int numberToInt = Integer.parseInt(number);
        }catch(Exception e){
            throw new IllegalArgumentException("정답은 숫자로 입력해야 합니다");
        }

        return true;

    }

    //정답 캡슐화
    public List<Integer> getComputer(){
        return computer;
    }


}
