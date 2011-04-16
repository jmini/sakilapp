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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.scout.rt.server.services.common.jdbc.style.AbstractSqlStyle;

/**
 * Scout SqlStyle for MySql.
 */
public class MysqlSqlStyle extends AbstractSqlStyle {
  private static final long serialVersionUID = 1L;

  public void testConnection(Connection conn) throws SQLException {
    Statement testStatement = null;
    try {
      testStatement = conn.createStatement();
      testStatement.execute("SELECT 1 FROM DUAL");
    }
    finally {
      if (testStatement != null) try {
        testStatement.close();
      }
      catch (Throwable t) {
      }
    }
  }

  public boolean isBlobEnabled() {
    return false;
  }

  public boolean isClobEnabled() {
    return false;
  }

  public boolean isLargeString(String s) {
    return (s.length() > 4000);
  }

  @Override
  protected int getMaxListSize() {
    return 1000;
  }

  @Override
  public String getNvlToken() {
    return "IFNULL";
  }

  //TODO add other create* functions.

  @Override
  public String createDateGE(String attribute, String bindName) {
    return attribute + ">=DATE(" + adaptBindName(bindName) + ")";
  }

  @Override
  public String createDateGT(String attribute, String bindName) {
    return attribute + ">DATE(" + adaptBindName(bindName) + ")";
  }

  @Override
  public String createDateLE(String attribute, String bindName) {
    return attribute + "<DATE(" + adaptBindName(bindName) + ") + INTERVAL 1 DAY";
  }

  @Override
  public String createDateLT(String attribute, String bindName) {
    return attribute + "<DATE(" + adaptBindName(bindName) + ")";
  }

  @Override
  public String createStartsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat(" + adaptBindName(bindName) + ",'%'))";
  }

  @Override
  public String createNotStartsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") not like upper(concat(" + adaptBindName(bindName) + ",'%'))";
  }

  @Override
  public String createEndsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat('%'," + adaptBindName(bindName) + "))";
  }

  @Override
  public String createNotEndsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") not like upper(concat('%'," + adaptBindName(bindName) + "))";
  }

  @Override
  public String createContains(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat('%'," + adaptBindName(bindName) + ",'%'))";
  }

  @Override
  public String createNotContains(String attribute, String bindName) {
    return "upper(" + attribute + ") not like upper(concat('%'," + adaptBindName(bindName) + ",'%'))";
  }
}
