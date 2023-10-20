package baseball.hard.service;

import baseball.common.service.CommonNumberService;

public class HardService extends CommonNumberService {

    private static final int COUNT_LIMIT = 1;
    private static final int TIME_LIMIT = 10;

    //카운트 제한을 넘었는지 체크
    public boolean isCountOver(int count){
        if(count>COUNT_LIMIT) return true;
        return false;
    }

    //카운트 캡슐화
    public int getCountLimit(){return COUNT_LIMIT;}

    public int getTimeLimit(){return TIME_LIMIT;}
}
