/*******************************************************************************
 * Copyright 2011 Jérémie Bresson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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

    Object[][] result = SQL.select(
        "select      film_id, " +
            "        title, " +
            "        release_year, " +
            "        language_id, " +
            "        original_language_id, " +
            "        length, " +
            "        concat(convert(rental_rate, char), '$ / ', convert(rental_duration, char), ' Days'), " +
            "        replacement_cost, " +
            "        rating, " +
            "        special_features," +
            "        last_update" +
            " from   film " +
            " where  1 = 1 " +
            filmsStatementBuilder.build(filter.getFormData()),
            filmsStatementBuilder.getBindMap());

    return result;
  }
}
