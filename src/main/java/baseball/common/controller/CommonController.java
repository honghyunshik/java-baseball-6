package baseball.common.controller;

import baseball.common.service.RandomNumberService;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class CommonController {

    public RandomNumberService randomNumberService;
    private HashMap<Integer,String> modeMap;


    public CommonController(RandomNumberService randomNumberService){
        this.randomNumberService = randomNumberService;
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
        randomNumberService.createRandomNumber();   //정답 생성
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

        if(mode==1) BeginnerModeInGameInRecursion();
        if(mode==2) NormalModeInGameInRecursion();

    }

    //초보 모드 인게임 재귀 함수
    private void BeginnerModeInGameInRecursion(){
        beforeInGame();
        System.out.println();
    }

    //노말 모드 인게임 재귀 함수
    private void NormalModeInGameInRecursion(){
        beforeInGame();
        if(!afterInGame()) NormalModeInGameInRecursion();
        return;
    }

    //인게임 before
    private void beforeInGame(){
        System.out.print(randomNumberService.getCount() + "번째 시도입니다! 숫자를 입력해주세요 : ");
    }

    //인게임 after
    private boolean afterInGame(){
        String answer = randomNumberService.isCorrect(Console.readLine());
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

        System.out.println("모드를 설정해주세요.\n1. 초보 모드 -> 히트가 제공됩니다!\n" +
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

    //모드 해시맵 초기 설정
    private void modeMapInit(){
        modeMap = new HashMap<>();
        modeMap.put(1,"초보 모드");
        modeMap.put(2,"노말 모드");
        modeMap.put(3,"하드 모드");
    }


}
