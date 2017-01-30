package br.com.munieri.domain.item;

import br.com.munieri.domain.dimension.Dimension;

import java.time.LocalDateTime;
import java.util.Date;

public interface Item {

    Long id();

    String name();

    Long code();

    Date date();

    Dimension dimension();

}
