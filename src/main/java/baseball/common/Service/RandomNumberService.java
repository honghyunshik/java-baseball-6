package baseball.common.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RandomNumberService {

    private List<Integer> computer;
    private Map<String,String> cache;

    public RandomNumberService(){
        computer = createRandomNumber();
        cache = new LinkedHashMap<>();
        System.out.println(computer);
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

    //사용자 입력과 정답 비교
    public String isCorrect(String input){

        int strike = 0;
        int ball = 0;

        //물어본 적이 있는 질문이라면 캐시에서 반환
        if(cache.containsKey(input)) return cache.get(input);

        //유효한 입력에 대해서만 결과 반환
        if(isValid(input)){

            for(int index=0;index<3;index++){

                int nowNum = input.charAt(index)-48;
                if(nowNum==computer.get(index)) strike++;
                else if(computer.contains(nowNum)) ball++;
            }
            if(strike==0&&ball==0) return "낫싱";
            StringBuilder sb = new StringBuilder();
            if(strike>0) sb.append(strike + "스트라이크 ");
            if(ball>0) sb.append(ball + "볼");
            return sb.toString();
        }

        return null;
    }

    //사용자 입력 유효성 검사
    private boolean isValid(String number){

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
