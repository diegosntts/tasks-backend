package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

public class DateUtilsTest {

	public void deveRetornarTrueParaDatasFuturas(){
        LocalDate  date = LocalDate.of(2030, 01, 01);
        DateUtils.isEqualOrFutureDate(date);
}
}
