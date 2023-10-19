package baseball;

import baseball.common.Service.RandomNumberService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberService randomNumberService = new RandomNumberService();
        randomNumberService.isValid("000");
    }
}
