package net.sakilapp.server.services.outline;

import net.sakilapp.shared.services.outline.ICatalogOutlineService;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.service.AbstractService;

public class CatalogOutlineService extends AbstractService implements ICatalogOutlineService {

  public Object[][] loadFilms() throws ProcessingException {
    //TODO: add security

    //TODO: use the search form, remove the limit
    Object[][] result = SQL.select(
        "select      film_id, " +
            "        title " +
            " from   film limit 10 ");

    return result;
  }

}
