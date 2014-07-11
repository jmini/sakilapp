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

public class SpecialFeatureCodeType extends AbstractCodeType<String, String> {
  private static final long serialVersionUID = 1L;
  public static final String CODETYPE_ID = "SpecialFeature";

  public SpecialFeatureCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("SpecialFeature");
  }

  @Override
  public String getId() {
    return CODETYPE_ID;
  }

  @Order(10.0)
  public class TrailersCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Trailers";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Trailers");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(20.0)
  public class CommentariesCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Commentaries";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Commentaries");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(30.0)
  public class DeletedScenesCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Deleted Scenes";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("DeletedScenes");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(40.0)
  public class BehindTheScenesCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Behind the Scenes";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("BehindTheScenes");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }
}
