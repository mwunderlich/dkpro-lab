/**
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

 * The original file does not contain a license statement. The license file in the projects
 * top-level directory states the files are under the Apache License 2.0:
 * 
 *   http://resteasy.svn.sourceforge.net/viewvc/resteasy/tags/RESTEASY_JAXRS_2_2_3_GA/
 *   License.html?revision=1542&content-type=text%2Fplain
 * 
 * Original location: 
 * 
 *   http://resteasy.svn.sourceforge.net/viewvc/resteasy/tags/RESTEASY_JAXRS_2_2_3_GA/
 *   resteasy-jaxrs/src/main/java/org/jboss/resteasy/specimpl/MultivaluedMapImpl.java
 *   ?revision=1542&content-type=text%2Fplain
 */
package de.tudarmstadt.ukp.dkpro.lab.resteasy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@SuppressWarnings("serial")
public class MultivaluedMapImpl<K, V> extends HashMap<K, List<V>> implements MultivaluedMap<K, V>
{
   @Override
public void putSingle(K key, V value)
   {
      List<V> list = new ArrayList<V>();
      list.add(value);
      put(key, list);
   }

   @Override
public final void add(K key, V value)
   {
      getList(key).add(value);
   }


   public final void addMultiple(K key, Collection<V> values)
   {
      getList(key).addAll(values);
   }

   @Override
public V getFirst(K key)
   {
      List<V> list = get(key);
      return list == null ? null : list.get(0);
   }

   public final List<V> getList(K key)
   {
      List<V> list = get(key);
      if (list == null)
         put(key, list = new ArrayList<V>());
      return list;
   }

   public void addAll(MultivaluedMapImpl<K, V> other)
   {
      for (Map.Entry<K, List<V>> entry : other.entrySet())
      {
         getList(entry.getKey()).addAll(entry.getValue());
      }
   }
}