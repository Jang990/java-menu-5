package menu.io.retry;

import menu.io.coach.CoachData;
import menu.io.coach.CoachDataReader;

import java.util.List;

public class CoachDataReaderErrorLoggingAspect extends CoachDataReader {
    private final CoachDataReader reader;

    public CoachDataReaderErrorLoggingAspect(CoachDataReader coachDataReader) {
        super(null, null);
        this.reader = coachDataReader;
    }

    @Override
    public List<CoachData> read() {
        try {
            return reader.read();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] %s".formatted(e.getMessage()));
            throw e;
        }
    }
}
