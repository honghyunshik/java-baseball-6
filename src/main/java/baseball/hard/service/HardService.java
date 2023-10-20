package baseball.hard.service;

import baseball.common.service.CommonNumberService;

public class HardService extends CommonNumberService {

    private static final int COUNT_LIMIT = 7;

    //카운트 제한을 넘었는지 체크
    public boolean isCountOver(int count){
        if(count>COUNT_LIMIT) return false;
        return true;
    }

    //카운트 캡슐화
    public int getCountLimit(){return COUNT_LIMIT;}
}
