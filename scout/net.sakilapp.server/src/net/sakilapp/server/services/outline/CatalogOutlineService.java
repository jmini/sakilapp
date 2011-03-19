package net.sakilapp.server.services.outline;

import net.sakilapp.shared.formdata.FilmsSearchFormData;
import net.sakilapp.shared.services.outline.ICatalogOutlineService;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.server.services.common.jdbc.builder.FormDataStatementBuilder;
import org.eclipse.scout.rt.shared.data.model.DataModelConstants;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.service.AbstractService;

public class CatalogOutlineService extends AbstractService implements ICatalogOutlineService {

  public Object[][] loadFilms(SearchFilter filter) throws ProcessingException {
    //TODO: add security

    FormDataStatementBuilder filmsStatementBuilder = new FormDataStatementBuilder(SQL.getSqlStyle());
    filmsStatementBuilder.setValueDefinition(FilmsSearchFormData.FilmIdFrom.class, "film_id", DataModelConstants.OPERATOR_GE);
    filmsStatementBuilder.setValueDefinition(FilmsSearchFormData.FilmIdTo.class, "film_id", DataModelConstants.OPERATOR_LE);
    filmsStatementBuilder.setValueDefinition(FilmsSearchFormData.Title.class, "title", DataModelConstants.OPERATOR_CONTAINS);

    //TODO: use the search form, remove the limit
    Object[][] result = SQL.select(
        "select      film_id, " +
            "        title " +
            " from   film " +
            " where  1 = 1 " +
            filmsStatementBuilder.build(filter.getFormData()),
            filmsStatementBuilder.getBindMap());

    return result;
  }
}
