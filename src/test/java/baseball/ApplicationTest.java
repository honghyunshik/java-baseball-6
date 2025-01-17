package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 이지모드_게임종료_후_재시작(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("1","y","246","y", "135", "1","1", "y","597", "y","589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );

    }

    @Test
    void 노말모드_게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("2","246", "135", "1","2", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 하드모드_7번이상_실패시_게임종료(){

        assertRandomNumberInRangeTest(
                () -> {
                    run("3","123","123","123","123","123","123","123","2");
                    assertThat(output()).contains("게임 종료");
                },
                1, 3, 5
        );
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2","1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
