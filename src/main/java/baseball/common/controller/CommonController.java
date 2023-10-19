package baseball.common.controller;

import baseball.common.service.RandomNumberService;
import camp.nextstep.edu.missionutils.Console;

public class CommonController {


    public RandomNumberService randomNumberService;

    public CommonController(RandomNumberService randomNumberService){
        this.randomNumberService = randomNumberService;
    }


    public void baseball(){

        while(true){

            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true){

                System.out.print(randomNumberService.getCount() + "번째 시도입니다! 숫자를 입력해주세요 : ");
                String answer = randomNumberService.isCorrect(Console.readLine());
                System.out.println(answer);
                //3 스트라이크일 경우 break
                if(answer.equals("3스트라이크 ")){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            while(true){
                String input = Console.readLine();
                //1 입력 시 재시작
                if(input.equals("1")) break;
                else if(input.equals("2")) return;
                else System.out.println("1과 2 중에서 입력하세요");
            }

        }
    }


}
