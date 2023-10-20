package baseball.beginner.service;

import baseball.common.service.RandomNumberService;


import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeginnerService extends RandomNumberService {

    private int count = 0;

    //정답 1개 제공하기
    public Integer hintWithPossibleNumber(){
        return super.getComputer().get(count++);
    }

    public int getCount(){
        return count;
    }


}
