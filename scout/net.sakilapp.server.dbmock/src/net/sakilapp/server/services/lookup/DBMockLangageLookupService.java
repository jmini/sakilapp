/*******************************************************************************
 * Copyright (c) 2010 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package net.sakilapp.server.services.lookup;

import java.util.List;

import net.sakilapp.shared.services.lookup.ILanguageLookupService;

import org.eclipse.scout.commons.annotations.Priority;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;

/**
 *
 */
@Priority(100)
public class DBMockLangageLookupService extends LocalLookupService<Long> implements ILanguageLookupService {

  @Override
  protected List<ILookupRow<Long>> execCreateLookupRows(ILookupCall<Long> call) throws ProcessingException {
    Object[][] data = new Object[][]{
        new Object[]{1L, "English", null, null, null, null, null, 1, null, 1},
        new Object[]{2L, "Italian", null, null, null, null, null, 1, null, 1},
        new Object[]{3L, "Japanese", null, null, null, null, null, 1, null, 1},
        new Object[]{4L, "Mandarin", null, null, null, null, null, 1, null, 1},
        new Object[]{5L, "French", null, null, null, null, null, 1, null, 1},
        new Object[]{6L, "German", null, null, null, null, null, 1, null, 1}
    };

    return createLookupRowArray(data, call, Long.class);
  }
}
