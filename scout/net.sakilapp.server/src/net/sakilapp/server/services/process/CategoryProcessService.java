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
import net.sakilapp.shared.formdata.CategoryFormData;
import net.sakilapp.shared.security.CreateCategoryPermission;
import net.sakilapp.shared.security.DeleteCategoryPermission;
import net.sakilapp.shared.security.ReadCategoryPermission;
import net.sakilapp.shared.security.UpdateCategoryPermission;
import net.sakilapp.shared.services.process.ICategoryProcessService;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

public class CategoryProcessService extends AbstractService implements ICategoryProcessService {

  public CategoryFormData prepareCreate(CategoryFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateCategoryPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    //TODO  business logic here
    return formData;
  }

  public CategoryFormData create(CategoryFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateCategoryPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }

    //TODO: Add a Sync block?
    SQL.insert(
        " insert into      category(name) " +
            " values (:categoryName) ",
        formData
        );
    SQL.selectInto(
        " select      category_id, " +
            "             last_update " +
            " from        category " +
            " where       category_id = LAST_INSERT_ID() " +
            " into        :id, " +
            "             :lastUpdate ",
        formData.getMetadataBox());
    return formData;
  }

  public CategoryFormData load(CategoryFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadCategoryPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    SQL.selectInto(
            "select      last_update, " +
                "            name " +
                " from       category " +
                " where      category_id = :id " +
                " into       :lastUpdate, " +
                "            :categoryName ",
            formData.getMetadataBox(),
        formData
        );

    return formData;
  }

  public CategoryFormData store(CategoryFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateCategoryPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    SQL.update(
        " update      category " +
            " set         name = :categoryName " +
            " where       category_id = :id ",
        formData.getMetadataBox(),
        formData
        );
    return formData;
  }

  public boolean delete(Long categoryId) throws ProcessingException {
    if (!ACCESS.check(new DeleteCategoryPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    //TODO: add delete operation + Permission
    return false;
  }
}
