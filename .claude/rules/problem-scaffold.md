# 문제 파일 생성 규칙

사용자가 알고리즘 문제를 붙여 넣으면 아래 형식으로 `.md`와 `.java` 파일 두 개를 만든다.

## 위치와 이름

- 폴더: `src/algorithmStudy/<사이트>/<문제>/` (예: `programmers/kakao2025/cactus/`, `programmers/kakao2025/yellowSignal/`)
- 사이트나 폴더를 붙여 넣은 내용으로 알 수 없을 때만 사용자에게 묻는다.
- 두 파일은 같은 폴더에 같은 이름으로 둔다: `<이름>.md`, `<이름>.java`

## `<이름>.md`

- 붙여 넣은 문제 원문을 그대로 넣는다. 요약하거나 고치지 않는다.

## `<이름>.java`

- `package algorithmStudy.<사이트>.<폴더>;`
- `solution` 메서드는 문제에 나온 시그니처대로 만들고, 본문은 기본값 `answer`만 반환한다. **풀이는 작성하지 않는다** (사용자가 직접 푼다).
- 입출력 예마다 JUnit 4 `@Test public void exampleN()`을 하나씩 만든다.
- 결과 확인은 private `check(expected, result)` 메서드로 한다. 결과를 출력한 뒤 비교한다.
  - 값이 하나면 `assertEquals`, 배열이면 `assertArrayEquals` (`static org.junit.Assert.*`)

```java
package algorithmStudy.programmers.kakao2025.yellowSignal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class yellowSignal {
    public int solution(int[][] signals) {
        int answer = 0;
        return answer;
    }

    @Test
    public void example1() {
        int[][] signals = {{2, 1, 2}, {5, 1, 1}};
        check(13, solution(signals));
    }

    private void check(int expected, int result) {
        System.out.println("result = " + result + ", expected = " + expected);
        assertEquals(expected, result);
    }
}
```

배열을 반환하는 문제는 `programmers/kakao2025/cactus/cactus.java`의 `check(int[] expected, int[] result)` 형식을 따른다.

## 확인

- 파일을 만든 뒤 컴파일되는지 확인한다:
  `./gradlew test --tests 'algorithmStudy.<사이트>.<폴더>.<이름>' --offline`
- `solution()`이 비어 있으므로 테스트가 실패하는 것은 정상이다. 컴파일 오류만 없으면 된다.
