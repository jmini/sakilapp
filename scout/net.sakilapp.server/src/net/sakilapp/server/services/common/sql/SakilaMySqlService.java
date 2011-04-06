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
package net.sakilapp.server.services.common.sql;

import org.eclipse.scout.rt.server.services.common.jdbc.AbstractSqlService;
import org.eclipse.scout.rt.server.services.common.jdbc.style.ISqlStyle;
import org.eclipse.scout.service.IService;

public class SakilaMySqlService extends AbstractSqlService implements IService {

  @Override
  protected Class<? extends ISqlStyle> getConfiguredSqlStyle() {
    return MysqlSqlStyle.class;
  }

  @Override
  protected String getConfiguredJdbcDriverName() {
    return "com.mysql.jdbc.Driver";
  }

  @Override
  protected String getConfiguredJdbcMappingName() {
    return "jdbc:mysql://localhost:3306/sakila";
  }

  @Override
  protected String getConfiguredUsername() {
    return "root";
  }

  @Override
  protected String getConfiguredPassword() {
    return "";
  }
}
