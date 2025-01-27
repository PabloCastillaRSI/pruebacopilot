package com.rsi.cosasDashboard.Dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Persona {

    Integer getId();

    BigDecimal getCosteHora();

    LocalDate getFechaIncorporacion();

    String getNombre();

    Area getArea();

    void setCosteHora(BigDecimal costeHora);

}
