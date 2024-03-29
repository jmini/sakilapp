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
package net.sakilapp.shared.services.process;

import net.sakilapp.shared.formdata.CategoryFormData;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.service.IService;

public interface ICategoryProcessService extends IService {

  CategoryFormData prepareCreate(CategoryFormData formData) throws ProcessingException;

  CategoryFormData create(CategoryFormData formData) throws ProcessingException;

  CategoryFormData load(CategoryFormData formData) throws ProcessingException;

  CategoryFormData store(CategoryFormData formData) throws ProcessingException;

  boolean delete(Long[] categoryIds) throws ProcessingException;

}
