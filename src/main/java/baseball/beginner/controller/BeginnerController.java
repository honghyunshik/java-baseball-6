package baseball.beginner.controller;

import baseball.beginner.service.BeginnerService;
import baseball.common.controller.CommonController;
import camp.nextstep.edu.missionutils.Console;

public class BeginnerController extends CommonController {

    //초보 모드 인게임 재귀 함수
    public void beginnerModeInGameInRecursion(BeginnerService beginnerService){

        if(yesNoInReqursion(beginnerService).equals("y")) {
            System.out.println((beginnerService.getHintCount() + 1) + "번째 숫자는" +
                    beginnerService.hintWithPossibleNumber() + "입니다!");
            beginnerService.plusHintCount();
        }

        beforeInGame(beginnerService);
        if(!afterInGame(beginnerService)) beginnerModeInGameInRecursion(beginnerService);

        //힌트 카운트 초기화
        beginnerService.resetHintCount();
        return;
    }

    //yes no 재귀함수
    private String yesNoInReqursion(BeginnerService beginnerService){

        //
        if(beginnerService.getHintCount()==beginnerService.getNumberLength()){
            System.out.println("더 이상의 힌트를 받으실 수 없습니다!");
            return "n";
        }
        System.out.println((beginnerService.getHintCount()+1) + "번째 힌트를 제공해드릴까요?" +
                "\ny:n으로 대답해주세요!");
        String input = Console.readLine();

        if(!input.equals("y")&&!input.equals("n")) return yesNoInReqursion(beginnerService);
        return input;
    }
}
