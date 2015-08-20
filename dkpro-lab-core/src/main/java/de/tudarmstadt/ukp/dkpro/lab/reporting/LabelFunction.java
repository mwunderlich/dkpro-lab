/*******************************************************************************
 * Copyright 2011
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
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
package de.tudarmstadt.ukp.dkpro.lab.reporting;

import java.util.Map;

/**
 * Generate a salient label for a parameter configuration. This can be used to make 
 * {@link Report reports} more readable.
 * 
 * @see Report#TASK_LABEL_FUNC_PROP
 */
public interface LabelFunction
{
	public static final String PROP_TASK_CONTEXT_ID = "__TASK_CONTEXT_ID__";

	/**
	 * 
	 * @param aProperties a parameter configuration.
	 * @return a label.
	 */
	String makeLabel(Map<String, String> aProperties);
}
