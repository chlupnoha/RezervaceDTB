/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import java.util.List;
import model.Rezervation;

/**
 * Data Acces Object
 */
public interface RezervationDAO {

    Rezervation getRezervationByID(Integer rezervationId);

    Rezervation addRezervation(Rezervation rezervation);

    Rezervation updateRezervation(Rezervation rezervation);

    boolean deleteRezervation(int rezervationId);

    List<Rezervation> getAllRezervations();

}
