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
package net.sakilapp.server.services.lookup;

import net.sakilapp.shared.services.lookup.ILanguageLookupService;

import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

public class LanguageLookupService extends AbstractSqlLookupService<Long> implements ILanguageLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "select language_id, name, null, null, null, null, null, 1, null, 1 from language " +
        "<key>where language_id = :key</key>" +
        "<text>where name like concat('%',:text,'%')</text>";
  }

}
