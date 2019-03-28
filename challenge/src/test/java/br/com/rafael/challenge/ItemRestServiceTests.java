package br.com.rafael.challenge;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static br.com.rafael.challenge.util.ParseDateUtil.parseDateFromRequest;

@RunWith(SpringRunner.class)
public class ItemRestServiceTests {

    @Test
    public void givenWellFormedString_ThenParseToLocalDateTime() {
        String date = "24-09-1994";
        LocalDateTime localDt = parseDateFromRequest(date, LocalTime.MIN);
        Assertions.assertThat(localDt.getDayOfMonth() == 24
                && localDt.getMonth().equals(Month.SEPTEMBER)
                && localDt.getYear() == 1994);
    }
}
