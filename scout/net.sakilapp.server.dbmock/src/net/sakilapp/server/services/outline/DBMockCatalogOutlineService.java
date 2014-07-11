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

import net.sakilapp.shared.services.outline.ICatalogOutlineService;

import org.eclipse.scout.commons.DateUtility;
import org.eclipse.scout.commons.annotations.Priority;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.service.AbstractService;

@Priority(100)
public class DBMockCatalogOutlineService extends AbstractService implements ICatalogOutlineService {

  @Override
  public Object[][] loadActors(SearchFilter filter) throws ProcessingException {

    Object[][] result = new Object[][]{
        new Object[]{18, "DAN", "TORN", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{26, "RIP", "CRAWFORD", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{47, "JULIA", "BARRYMORE", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{94, "KENNETH", "TORN", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{102, "WALTER", "TORN", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{114, "MORGAN", "MCDORMAND", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{129, "DARYL", "CRAWFORD", DateUtility.parse("2006-02-15", "yyy-MM-dd")}
    };
    return result;
  }

  @Override
  public Object[][] loadCategories(SearchFilter filter) throws ProcessingException {

    Object[][] result = new Object[][]{
        new Object[]{1, "Action", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{2, "Animation", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{4, "Classics", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{6, "Documentary", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{7, "Drama", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{8, "Family", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{10, "Games", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
        new Object[]{16, "Travel", DateUtility.parse("2006-02-15", "yyy-MM-dd")}
    };

    return result;
  }

  @Override
  public Object[][] loadFilms(SearchFilter filter, Long categoryIdFilter, Long actorIdFilter) throws ProcessingException {

    Object[][] result = new Object[][]{
        new Object[]{1, "(dbmock) ACADEMY DINOSAUR", DateUtility.parse("2006", "yyyy"), 1, null, "20", null, null, "PG", "Deleted Scenes,Behind the Scenes", DateUtility.parse("2006-02-15", "yyy-MM-dd")},
    };
    return result;
  }
}
