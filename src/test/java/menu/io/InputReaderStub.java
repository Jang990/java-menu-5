package menu.io;

public class InputReaderStub extends InputReader {
    private String testValue;

    public InputReaderStub() {

    }

    public InputReaderStub(String testValue) {
        this.testValue = testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public String readLine() {
        return testValue;
    }
}