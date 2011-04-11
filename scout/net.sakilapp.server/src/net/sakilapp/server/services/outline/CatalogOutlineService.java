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

import net.sakilapp.shared.formdata.ActorsSearchFormData;
import net.sakilapp.shared.formdata.CategoriesSearchFormData;
import net.sakilapp.shared.formdata.FilmsSearchFormData;
import net.sakilapp.shared.services.outline.ICatalogOutlineService;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.holders.NVPair;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.server.services.common.jdbc.builder.FormDataStatementBuilder;
import org.eclipse.scout.rt.shared.data.model.DataModelConstants;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.service.AbstractService;

public class CatalogOutlineService extends AbstractService implements ICatalogOutlineService {

  public Object[][] loadActors(SearchFilter filter) throws ProcessingException {
    //TODO: add security

    FormDataStatementBuilder actorsStatementBuilder = new FormDataStatementBuilder(SQL.getSqlStyle());
    actorsStatementBuilder.setValueDefinition(ActorsSearchFormData.ActorIdFrom.class, "actor_id", DataModelConstants.OPERATOR_GE);
    actorsStatementBuilder.setValueDefinition(ActorsSearchFormData.ActorIdTo.class, "actor_id", DataModelConstants.OPERATOR_LE);
    actorsStatementBuilder.setValueDefinition(ActorsSearchFormData.FirstName.class, "first_name", DataModelConstants.OPERATOR_CONTAINS);
    actorsStatementBuilder.setValueDefinition(ActorsSearchFormData.LastName.class, "last_name", DataModelConstants.OPERATOR_CONTAINS);
    actorsStatementBuilder.setValueDefinition(ActorsSearchFormData.LastUpdateFrom.class, "last_update", DataModelConstants.OPERATOR_DATE_GE);
    actorsStatementBuilder.setValueDefinition(ActorsSearchFormData.LastUpdateTo.class, "last_update", DataModelConstants.OPERATOR_DATE_LE);

    Object[][] result = SQL.select(
        "select      actor_id, " +
            "        first_name, " +
            "        last_name, " +
            "        last_update" +
            " from   actor " +
            " where  1 = 1 " +
            actorsStatementBuilder.build(filter.getFormData()),
            actorsStatementBuilder.getBindMap());
    return result;
  }

  public Object[][] loadCategories(SearchFilter filter) throws ProcessingException {
    //TODO: add security

    FormDataStatementBuilder categoriesStatementBuilder = new FormDataStatementBuilder(SQL.getSqlStyle());
    categoriesStatementBuilder.setValueDefinition(CategoriesSearchFormData.CategoryIdFrom.class, "category_id", DataModelConstants.OPERATOR_GE);
    categoriesStatementBuilder.setValueDefinition(CategoriesSearchFormData.CategoryIdTo.class, "category_id", DataModelConstants.OPERATOR_LE);
    categoriesStatementBuilder.setValueDefinition(CategoriesSearchFormData.Name.class, "name", DataModelConstants.OPERATOR_CONTAINS);
    categoriesStatementBuilder.setValueDefinition(CategoriesSearchFormData.LastUpdateFrom.class, "last_update", DataModelConstants.OPERATOR_DATE_GE);
    categoriesStatementBuilder.setValueDefinition(CategoriesSearchFormData.LastUpdateTo.class, "last_update", DataModelConstants.OPERATOR_DATE_LE);

    Object[][] result = SQL.select(
        "select      category_id, " +
            "        name, " +
            "        last_update" +
            " from   category " +
            " where  1 = 1 " +
            categoriesStatementBuilder.build(filter.getFormData()),
            categoriesStatementBuilder.getBindMap());
    return result;
  }

  public Object[][] loadFilms(SearchFilter filter, Long categoryIdFilter, Long actorIdFilter) throws ProcessingException {
    //TODO: add security

    FormDataStatementBuilder filmsStatementBuilder = new FormDataStatementBuilder(SQL.getSqlStyle());
    filmsStatementBuilder.setValueDefinition(FilmsSearchFormData.FilmIdFrom.class, "film_id", DataModelConstants.OPERATOR_GE);
    filmsStatementBuilder.setValueDefinition(FilmsSearchFormData.FilmIdTo.class, "film_id", DataModelConstants.OPERATOR_LE);
    filmsStatementBuilder.setValueDefinition(FilmsSearchFormData.Title.class, "title", DataModelConstants.OPERATOR_CONTAINS);
    //TODO: complete the list

    //subselect in the where statement for categories
    String sqlWhereCategory;
    if (categoryIdFilter != null && categoryIdFilter.longValue() > 0) {
      sqlWhereCategory = " and film_id in (select film_id from film_category where category_id = :categoryId) ";
    }
    else {
      sqlWhereCategory = "";
    }

    //subselect in the where statement for actor
    String sqlWhereActor;
    if (actorIdFilter != null && actorIdFilter.longValue() > 0) {
      sqlWhereActor = " and film_id in (select film_id from film_actor where actor_id = :actorId) ";
    }
    else {
      sqlWhereActor = "";
    }

    Object[][] result = SQL.select(
        "select      f.film_id, " +
            "        f.title, " +
            "        f.release_year, " +
            "        f.language_id, " +
            "        f.original_language_id, " +
            "        f.length, " +
            "        concat(convert(f.rental_rate, char), '$ / ', convert(f.rental_duration, char), ' Days'), " +
            "        f.replacement_cost, " +
            "        f.rating, " +
            "        f.special_features," +
            "        f.last_update" +
            " from   film f " +
            " where  1 = 1 " +
            sqlWhereCategory +
            sqlWhereActor +
            filmsStatementBuilder.build(filter.getFormData()),
            filmsStatementBuilder.getBindMap(),
            new NVPair("categoryId", categoryIdFilter),
            new NVPair("actorId", actorIdFilter)
            );

    return result;
  }
}
