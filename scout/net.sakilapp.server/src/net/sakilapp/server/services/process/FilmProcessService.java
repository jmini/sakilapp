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
package net.sakilapp.server.services.process;

import java.util.HashMap;

import net.sakilapp.shared.Texts;
import net.sakilapp.shared.formdata.FilmFormData;
import net.sakilapp.shared.formdata.FilmFormData.ActorsTable;
import net.sakilapp.shared.formdata.FilmFormData.CategoriesTable;
import net.sakilapp.shared.security.CreateFilmPermission;
import net.sakilapp.shared.security.DeleteFilmPermission;
import net.sakilapp.shared.security.ReadFilmPermission;
import net.sakilapp.shared.security.UpdateFilmPermission;
import net.sakilapp.shared.services.process.IFilmProcessService;

import org.eclipse.scout.commons.StringUtility;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.commons.holders.ITableHolder;
import org.eclipse.scout.commons.holders.NVPair;
import org.eclipse.scout.commons.holders.StringHolder;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.data.form.fields.tablefield.AbstractTableFieldData;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

public class FilmProcessService extends AbstractService implements IFilmProcessService {

  public FilmFormData prepareCreate(FilmFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateFilmPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    //Nothing to do for the preparation of the creation.
    return formData;
  }

  public FilmFormData create(FilmFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateFilmPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }

    //TODO: Add a Sync block?
    SQL.insert(
        " insert into   film( " +
            " title, " +
            " description, " +
            " release_year, " +
            " language_id, " +
            " original_language_id, " +
            " rental_duration, " +
            " rental_rate, " +
            " length, " +
            " replacement_cost, " +
            " rating, " +
            " special_features " +
            " ) values( " +
            " :Title, " +
            " :Description, " +
            " :ReleaseYear, " +
            " :Language, " +
            " :OriginalLanguage, " +
            " :RentalDuration, " +
            " :RentalRate, " +
            " :Length, " +
            " :ReplacementCost, " +
            " :Rating," +
            " :SpecialFeatureList " +
            " ) ",
        new NVPair("SpecialFeatureList", StringUtility.join(",", formData.getSpecialFeatures().getValue())),
        formData
        );
    SQL.selectInto(
        " select      film_id, " +
            "             last_update " +
            " from        film " +
            " where       film_id = LAST_INSERT_ID() " +
            " into        :id, " +
            "             :lastUpdate ",
        formData.getMetadataBox());

    storeFilmActor(formData);
    storeFilmCategory(formData);
    return formData;
  }

  public FilmFormData load(FilmFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadFilmPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }

    StringHolder SpecialFeatureList = new StringHolder();
    SQL.selectInto(
        "select      last_update, " +
            "            title, " +
            "            description, " +
            "            CONVERT(release_year, CHAR(4)), " +
            "            language_id, " +
            "            original_language_id, " +
            "            rental_duration, " +
            "            rental_rate, " +
            "            length, " +
            "            replacement_cost, " +
            "            rating, " +
            "            special_features " +
            " from       film " +
            " where      film_id = :id " +
            " into       :lastUpdate, " +
            "            :Title, " +
            "            :Description, " +
            "            :ReleaseYear, " +
            "            :Language, " +
            "            :OriginalLanguage, " +
            "            :RentalDuration, " +
            "            :RentalRate, " +
            "            :Length, " +
            "            :ReplacementCost, " +
            "            :Rating," +
            "            :SpecialFeatureList",
        formData.getMetadataBox(),
        new NVPair("SpecialFeatureList", SpecialFeatureList),
        formData
        );

    SQL.selectInto(
        "select      actor_id, " +
            "        first_name, " +
            "        last_name " +
            " from   actor " +
            " where  1 = 1 " +
            " and    actor_id in (select actor_id from film_actor where film_id = :id) " +
            " into   :ActorId, " +
            "        :FirstName," +
            "        :LastName ",
        formData.getMetadataBox(),
        formData.getActorsTable()
        );

    SQL.selectInto(
        "select      category_id, " +
            "        name " +
            " from   category " +
            " where  1 = 1 " +
            " and    category_id in (select category_id from film_category where film_id = :id) " +
            " into   :CategoryId, " +
            "        :Name ",
        formData.getMetadataBox(),
        formData.getCategoriesTable()
        );

    String specialFeatureList = SpecialFeatureList.getValue();
    if (specialFeatureList != null) {
      formData.getSpecialFeatures().setValue(specialFeatureList.split(","));
    }

    return formData;
  }

  public FilmFormData store(FilmFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateFilmPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }

    SQL.update(
        " update      film " +
            " set         title                = :Title, " +
            "             description          = :Description, " +
            "             release_year         = :ReleaseYear, " +
            "             language_id          = :Language, " +
            "             original_language_id = :OriginalLanguage, " +
            "             rental_duration      = :RentalDuration, " +
            "             rental_rate          = :RentalRate, " +
            "             length               = :Length, " +
            "             replacement_cost     = :ReplacementCost, " +
            "             rating               = :Rating," +
            "             special_features     = :SpecialFeatureList" +
            " where       film_id = :id ",
        formData.getMetadataBox(),
        new NVPair("SpecialFeatureList", StringUtility.join(",", formData.getSpecialFeatures().getValue())),
        formData
        );
    storeFilmActor(formData);
    storeFilmCategory(formData);
    return formData;
  }

  /**
   * @param formData
   * @throws ProcessingException
   */
  private void storeFilmActor(FilmFormData formData) throws ProcessingException {
    ActorsTable table = formData.getActorsTable();
    cleanupTable(table, 0); //TODO: 0 stands for ActorIdColumn, BUG: 356426
    for (int i = 0; i < table.getRowCount(); i++) {
      switch (table.getRowState(i)) {
        case ITableHolder.STATUS_INSERTED:
          SQL.insert(
              " insert into film_actor(" +
                  "    film_id, " +
                  "    actor_id " +
                  " ) values( " +
                  "    :id, " +
                  "    :ActorId " +
                  " ) ",
              formData.getMetadataBox(),
              new NVPair("ActorId", table.getActorId(i))
              );
          break;
        case ITableHolder.STATUS_DELETED:
          SQL.delete(
              " delete       from film_actor " +
                  " where    film_id = :id " +
                  " and      actor_id = :ActorId",
              formData.getMetadataBox(),
              new NVPair("ActorId", table.getActorId(i))
              );
          break;
        case ITableHolder.STATUS_NON_CHANGED:
        case ITableHolder.STATUS_UPDATED:
        default:
          //Do nothing
          break;
      }
    }
  }

  /**
   * @param formData
   * @throws ProcessingException
   */
  private void storeFilmCategory(FilmFormData formData) throws ProcessingException {
    CategoriesTable table = formData.getCategoriesTable();
    cleanupTable(table, 0); //TODO: 0 stands for CategoryIdColumn, BUG: 356426
    for (int i = 0; i < table.getRowCount(); i++) {
      switch (table.getRowState(i)) {
        case ITableHolder.STATUS_INSERTED:
          SQL.insert(
              " insert into film_category(" +
                  "    film_id, " +
                  "    category_id " +
                  " ) values( " +
                  "    :id, " +
                  "    :CategoryId " +
                  " ) ",
              formData.getMetadataBox(),
              new NVPair("CategoryId", table.getCategoryId(i))
              );
          break;
        case ITableHolder.STATUS_DELETED:
          SQL.delete(
              " delete       from film_category " +
                  " where    film_id = :id " +
                  " and      category_id = :CategoryId",
              formData.getMetadataBox(),
              new NVPair("CategoryId", table.getCategoryId(i))
              );
          break;
        case ITableHolder.STATUS_NON_CHANGED:
        case ITableHolder.STATUS_UPDATED:
        default:
          //Do nothing
          break;
      }
    }
  }

  /**
   * This function clean the status if a row was deleted and added
   * TODO: make the check client-side.
   * 
   * @param table
   *          the tableFieldData
   * @param valueColumn
   *          the index of the column that need to be compared.
   */
  private void cleanupTable(AbstractTableFieldData table, int valueColumn) {
    HashMap<Object, Integer> insertedMap = new HashMap<Object, Integer>();

    for (int i = 0; i < table.getRowCount(); i++) {
      if (ITableHolder.STATUS_INSERTED == table.getRowState(i)) {
        insertedMap.put(table.getValueAt(i, valueColumn), Integer.valueOf(i));
      }
    }

    for (int i = 0; i < table.getRowCount(); i++) {
      if (ITableHolder.STATUS_DELETED == table.getRowState(i) &&
          insertedMap.containsKey(table.getValueAt(i, valueColumn))) {
        Integer index = insertedMap.get(table.getValueAt(i, valueColumn));
        table.setRowState(index.intValue(), ITableHolder.STATUS_UPDATED);
        table.setRowState(i, ITableHolder.STATUS_UPDATED);
      }
    }
  }

  public boolean delete(Long[] filmIds) throws ProcessingException {
    if (!ACCESS.check(new DeleteFilmPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    int nbRows = SQL.delete(
        " delete       from film" +
            " where    film_id = :id",
        new NVPair("id", filmIds)
        );
    return nbRows > 0;
  }
}
