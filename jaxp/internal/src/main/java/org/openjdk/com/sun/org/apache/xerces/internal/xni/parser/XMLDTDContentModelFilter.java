/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/*
 * Copyright 2001, 2002,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openjdk.com.sun.org.apache.xerces.internal.xni.parser;

import org.openjdk.com.sun.org.apache.xerces.internal.xni.XMLDTDContentModelHandler;

/**
 * Defines a DTD content model filter that acts as both a receiver and
 * an emitter of DTD content model events.
 *
 * @author Andy Clark, IBM
 */
public interface XMLDTDContentModelFilter
        extends XMLDTDContentModelHandler, XMLDTDContentModelSource {

} // interface XMLDTDContentModelFilter
