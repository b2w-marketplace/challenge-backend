package br.com.munieri.boot.database;


import br.com.munieri.infrastructure.repository.dimension.DimensionEntity;
import br.com.munieri.infrastructure.repository.dimension.DimensionRepository;
import br.com.munieri.infrastructure.repository.item.ItemEntity;
import br.com.munieri.infrastructure.repository.item.ItemRepository;
import br.com.munieri.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Profile("staging")
public class DatabaseInitializer {

    @Autowired
    private Environment env;

    @Autowired
    private DimensionRepository dimensionRepository;

    @PostConstruct
    public void init() throws ParseException {

        DimensionEntity dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Celular", 1L, DateUtil.parse("2016-10-01", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Xbox", 2L, DateUtil.parse("2016-10-02", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Televisao", 3L, DateUtil.parse("2016-10-03", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Caixa de Som", 4L, DateUtil.parse("2016-10-04", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Impressora", 5L, DateUtil.parse("2016-10-05", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Fifa2017", 6L, DateUtil.parse("2016-10-06", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Notebook", 7L, DateUtil.parse("2016-10-07", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Tablet", 8L, DateUtil.parse("2016-10-08", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Computador", 9L, DateUtil.parse("2016-10-09", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Guarda-Roupa", 10L, DateUtil.parse("2016-10-10", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Fogao", 11L, DateUtil.parse("2016-10-11", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Freezer", 12L, DateUtil.parse("2016-10-12", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

        dimensionEntity = new DimensionEntity(10.5, 10.5, 10.5, 10.5,
                new ItemEntity("Forno", 13L, DateUtil.parse("2016-10-13", DateUtil.CREATION_PATTERN)));
        dimensionRepository.save(dimensionEntity);

    }
}
