package com.italomlaino.backendchallenge.stub;

import com.italomlaino.backendchallenge.dto.DimensionDto;
import com.italomlaino.backendchallenge.dto.ItemDto;
import com.italomlaino.backendchallenge.service.MockyClient;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class MockyStubClient implements MockyClient {

    private static final DimensionDto DIMENSION = DimensionDto
            .builder()
            .weight(10.5)
            .height(10.5)
            .width(10.5)
            .length(10.50)
            .build();
    public static final ItemDto CELL_PHONE = ItemDto
            .builder()
            .name("CellPhone")
            .code("1")
            .date(ZonedDateTime.parse("2016-10-01T14:30:37.040Z"))
            .dimension(DIMENSION)
            .build();
    public static final ItemDto XBOX = ItemDto
            .builder()
            .name("Xbox")
            .code("2")
            .date(ZonedDateTime.parse("2016-10-02T14:30:37.040Z"))
            .dimension(DIMENSION)
            .build();
    public static final ItemDto TV = ItemDto
            .builder()
            .name("Tv")
            .code("3")
            .date(ZonedDateTime.parse("2016-10-03T14:30:37.040Z"))
            .dimension(DIMENSION)
            .build();
    public static final ItemDto SOUND_SYSTEM = ItemDto
            .builder()
            .name("Sound System")
            .code("4")
            .date(ZonedDateTime.parse("2016-10-04T14:30:37.040Z"))
            .dimension(DIMENSION)
            .build();
    public static final ItemDto TABLE = ItemDto
            .builder()
            .name("Table")
            .code("5")
            .date(null)
            .dimension(DIMENSION)
            .build();

    @Override
    public List<ItemDto> fetch() {
        return Arrays.asList(
                CELL_PHONE,
                XBOX,
                TV,
                SOUND_SYSTEM,
                TABLE
        );
    }
}
