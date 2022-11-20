package server.part2;


public class PositiveNumber {

    /**
     * PositiveNumber 는 value Object 이다
     */
    private final int value;

    public PositiveNumber(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNagativeNumber(value)) {
            throw new IllegalArgumentException("0 또는 음수를 입력할 수 없습니다.");
        }
    }

    private boolean isNagativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }

}
