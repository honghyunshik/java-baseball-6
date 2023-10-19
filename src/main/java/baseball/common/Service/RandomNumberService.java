package baseball.common.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberService {

    private List<Integer> computer;

    RandomNumberService(){
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

    //정답 캡슐화
    public List<Integer> getComputer(){
        return computer;
    }


}
