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
package net.sakilapp.shared.services.code;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class RatingCodeType extends AbstractCodeType<String> {
  private static final long serialVersionUID = 1L;
  public static final String ID = "Rating";

  public RatingCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("Rating");
  }

  @Override
  public String getId() {
    return ID;
  }

  @Order(10.0)
  public class PGCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "PG";

    @Override
    public String getId() {
      return KEY;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("PG");
    }
  }

  @Order(20.0)
  public class GCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "G";

    @Override
    public String getId() {
      return KEY;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("G");
    }
  }

  @Order(30.0)
  public class NC17Code extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "NC-17";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("NC17");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(40.0)
  public class PG13Code extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "PG-13";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("PG13");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(50.0)
  public class RCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "R";

    @Override
    public String getId() {
      return KEY;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("R");
    }
  }

}
