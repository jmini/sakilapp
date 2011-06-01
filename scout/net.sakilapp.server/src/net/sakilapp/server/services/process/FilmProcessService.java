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

import net.sakilapp.shared.Texts;
import net.sakilapp.shared.formdata.FilmFormData;
import net.sakilapp.shared.security.CreateFilmPermission;
import net.sakilapp.shared.security.DeleteFilmPermission;
import net.sakilapp.shared.security.ReadFilmPermission;
import net.sakilapp.shared.security.UpdateFilmPermission;
import net.sakilapp.shared.services.process.IFilmProcessService;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.commons.holders.NVPair;
import org.eclipse.scout.commons.holders.StringHolder;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
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
//TODO: insert film values
//    SQL.insert(
//        " insert into      category(name) " +
//            " values (:categoryName) ",
//        formData
//        );
//    SQL.selectInto(
//        " select      film_id, " +
//            "             last_update " +
//            " from        film " +
//            " where       film_id = LAST_INSERT_ID() " +
//            " into        :id, " +
//            "             :lastUpdate ",
//        formData.getMetadataBox());
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
    //TODO: update
//    SQL.update(
//        " update      film " +
//            " set         name = :categoryName " +
//            " where       category_id = :id ",
//        formData.getMetadataBox(),
//        formData
//        );
    return formData;
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
