package baseball.common.controller;

import baseball.beginner.service.BeginnerService;
import baseball.common.service.CommonNumberService;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class CommonController {

    private HashMap<Integer,String> modeMap;
    private BeginnerService beginnerService;


    public CommonController(){
        modeMapInit();  //모드맵 초기설정
    }

    //야구 시작 -> 모드 설정 -> 모드별 야구 진행 -> 종료 or 재시작
    public void baseball(){

        //야구 시작
        baseballStart();

        //모드 설정
        int mode = modeSelectInRecursion();

        //모드 별 야구 진행
        baseballInGame(mode);

        //종료 or 재시작
        //1이면 재시작, 2면 종료
        if(baseballEnd()==1) baseball();
    }

    //야구 시작 -> 정답 생성
    private void baseballStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //야구 종료 -> 재시작 or 종료
    private int baseballEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        //1,2번이 입력될 때까지 재귀
        if(!input.equals("1")&&!input.equals("2")) return baseballEnd();

        return Integer.parseInt(input);
    }

    //모드 별 야구 진행
    private void baseballInGame(int mode){

        if(mode==1) {
            //singleton 패턴
            if(beginnerService==null) beginnerService = new BeginnerService();
            //정답 생성
            beginnerService.createRandomNumber();
            beginnerModeInGameInRecursion();
        }
        if(mode==2) {

            normalModeInGameInRecursion();
        }

    }

    //초보 모드 인게임 재귀 함수
    private void beginnerModeInGameInRecursion(){

        if(yesNoInReqursion().equals("y")) {
            System.out.println((beginnerService.getHintCount() + 1) + "번째 숫자는" +
                    beginnerService.hintWithPossibleNumber() + "입니다!");
            beginnerService.plusHintCount();
        }

        beforeInGame(beginnerService);
        if(!afterInGame(beginnerService)) beginnerModeInGameInRecursion();

        //힌트 카운트 초기화
        beginnerService.resetHintCount();
        return;
    }

    //노말 모드 인게임 재귀 함수
    private void normalModeInGameInRecursion(){
        /*
        beforeInGame();
        if(!afterInGame()) normalModeInGameInRecursion();
        */

        return;
    }

    //인게임 before
    private void beforeInGame(CommonNumberService commonNumberService){
        System.out.print(commonNumberService.getCount() + "번째 시도입니다! 숫자를 입력해주세요 : ");
    }

    //인게임 after
    private boolean afterInGame(CommonNumberService commonNumberService){
        String answer = commonNumberService.isCorrect(Console.readLine());
        System.out.println(answer);
        //3 스트라이크일 경우 break
        if(answer.equals("3스트라이크")){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    //모드 설정 재귀 함수
    private int modeSelectInRecursion(){

        System.out.println("모드를 설정해주세요.\n1. 초보 모드 -> 힌트가 제공됩니다!\n" +
                "2. 노말 모드 -> 기본 모드입니다!\n" +
                "3. 하드 모드 -> 제약 조건이 주어집니다!\n");
        System.out.print("1~3의 숫자를 입력해주세요 : ");

        String input = Console.readLine();

        //1~3의 숫자를 선택할 때까지 재귀
        if(!input.equals("1")&&!input.equals("2")&&!input.equals("3")) return modeSelectInRecursion();

        int mode = Integer.parseInt(input);
        System.out.println(mode + "번 " + modeMap.get(mode) + "가 시작됩니다!");
        return Integer.parseInt(input);
    }

    //yes no 재귀함수
    private String yesNoInReqursion(){

        //
        if(beginnerService.getHintCount()==beginnerService.getNumberLength()){
            System.out.println("더 이상의 힌트를 받으실 수 없습니다!");
            return "n";
        }
        System.out.println((beginnerService.getHintCount()+1) + "번째 힌트를 제공해드릴까요?" +
                "\ny:n으로 대답해주세요!");
        String input = Console.readLine();

        if(!input.equals("y")&&!input.equals("n")) return yesNoInReqursion();
        return input;
    }

    //모드 해시맵 초기 설정
    private void modeMapInit(){
        modeMap = new HashMap<>();
        modeMap.put(1,"초보 모드");
        modeMap.put(2,"노말 모드");
        modeMap.put(3,"하드 모드");
    }


}
