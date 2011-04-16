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
import net.sakilapp.shared.formdata.ActorFormData;
import net.sakilapp.shared.security.CreateActorPermission;
import net.sakilapp.shared.security.DeleteActorPermission;
import net.sakilapp.shared.security.ReadActorPermission;
import net.sakilapp.shared.security.UpdateActorPermission;
import net.sakilapp.shared.services.process.IActorProcessService;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.commons.holders.NVPair;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

public class ActorProcessService extends AbstractService implements IActorProcessService {

  public ActorFormData prepareCreate(ActorFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateActorPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    //Nothing to do for the preparation of the creation.
    return formData;
  }

  public ActorFormData create(ActorFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateActorPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    //TODO: Add a Sync block?
    SQL.insert(
        " insert into      actor(first_name, last_name) " +
            " values (:firstName, :lastName) ",
        formData
        );
    SQL.selectInto(
        " select      actor_id, " +
            "             last_update " +
            " from        actor " +
            " where       actor_id = LAST_INSERT_ID() " +
            " into        :id, " +
            "             :lastUpdate ",
        formData.getMetadataBox());
    return formData;
  }

  public ActorFormData load(ActorFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadActorPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    SQL.selectInto(
        "select      last_update, " +
            "            first_name," +
            "            last_name " +
            " from       actor " +
            " where      actor_id = :id " +
            " into       :lastUpdate, " +
            "            :firstName," +
            "            :lastName ",
        formData.getMetadataBox(),
        formData
        );

    return formData;
  }

  public ActorFormData store(ActorFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateActorPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    SQL.update(
        " update      actor " +
            " set         first_name = :firstName," +
            "             last_name = :lastName " +
            " where       actor_id = :id ",
        formData.getMetadataBox(),
        formData
        );
    return formData;
  }

  public boolean delete(Long[] actorIds) throws ProcessingException {
    if (!ACCESS.check(new DeleteActorPermission())) {
      throw new VetoException(Texts.get("AuthorizationFailed"));
    }
    int nbRows = SQL.delete(
        " delete       from actor" +
            " where    actor_id = :id",
        new NVPair("id", actorIds)
        );
    return nbRows > 0;
  }
}
