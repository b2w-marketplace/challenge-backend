package com.italomlaino.backendchallenge.service;

import com.italomlaino.backendchallenge.exception.InvalidDateRangeException;
import com.italomlaino.backendchallenge.stub.MockyStubClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.italomlaino.backendchallenge.stub.MockyStubClient.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ItemServiceTest {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Spy
    private final MockyClient mockyClient = new MockyStubClient();

    @InjectMocks
    private ItemServiceImpl service;

    @Test
    public void returnsAllList() {
        var items = service.fetch(null, null);

        assertThat(items, contains(CELL_PHONE, XBOX, TV, SOUND_SYSTEM, TABLE));
    }

    @Test
    public void returnsFilteredListBeginDateIsNull() {
        var items = service.fetch(null, parse("03-10-2016"));

        assertThat(items, contains(CELL_PHONE, XBOX, TV));
    }

    @Test
    public void returnsFilteredListFinalDateIsNull() {
        var items = service.fetch(parse("03-10-2016"), null);

        assertThat(items, contains(TV, SOUND_SYSTEM));
    }

    @Test
    public void returnsFilteredList() {
        var items = service.fetch(
                parse("02-10-2016"),
                parse("03-10-2016"));

        assertThat(items, containsInAnyOrder(XBOX, TV));
    }

    @Test
    public void throwsInvalidDateRangeException() {
        Executable fetch = () -> service.fetch(
                parse("10-10-2016"),
                parse("05-10-2016")
        );

        var exception = assertThrows(InvalidDateRangeException.class, fetch);

        assertThat(exception.getMessage(), equalTo(InvalidDateRangeException.MESSAGE));
    }

    private LocalDate parse(String value) {
        return LocalDate.parse(value, DATE_FORMATTER);
    }
}
