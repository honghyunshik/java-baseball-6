package baseball.hard.controller;

import baseball.common.controller.CommonController;
import baseball.hard.service.HardService;

public class HardController extends CommonController {

    //하드 모드 인게임 재귀 함수
    public void hardModeInGameRecursion(HardService hardService){

        //카운트 오버 시 실패
        if(hardService.isCountOver(hardService.getCount())){
            System.out.println("남은 기회를 모두 소진하셨습니다! 게임 종료");
            return;
        }

        System.out.println("하드모드에는 2가지 규칙이 추가 적용됩니다!\n" +
                "1. " + hardService.getCountLimit() + "번 이내에 정답을 맞춰야 합니다! 현재 " +
                (hardService.getCountLimit()-hardService.getCount()+1) + "번의 기회가 남아있습니다!");

        for(int timeLeft=hardService.getTimeLimit();timeLeft>0;timeLeft--){
            System.out.print("\r" + "2. " + hardService.getTimeLimit() + "초 이내에 정답을 맞춰야 합니다! 현재 남은시간은 + " +
                    timeLeft + "초 입니다!");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }

        beforeInGame(hardService);
        if(!afterInGame(hardService)) hardModeInGameRecursion(hardService);

        return;

    }
}
