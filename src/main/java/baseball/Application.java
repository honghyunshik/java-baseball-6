package baseball;

import baseball.common.controller.CommonController;
import baseball.common.service.RandomNumberService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CommonController commonController = new CommonController(new RandomNumberService());
        commonController.baseball();
    }


}


