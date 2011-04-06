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
package net.sakilapp.client.ui.desktop.outlines;

import java.util.Collection;

import net.sakilapp.client.ui.desktop.outlines.pages.ActorsTablePage;
import net.sakilapp.client.ui.desktop.outlines.pages.CategoriesTablePage;
import net.sakilapp.client.ui.desktop.outlines.pages.FilmsTablePage;
import net.sakilapp.shared.Texts;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;

public class CatalogOutline extends AbstractOutline {

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Catalog");
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
    pageList.add(new FilmsTablePage());
    pageList.add(new CategoriesTablePage());
    pageList.add(new ActorsTablePage());
  }
}
