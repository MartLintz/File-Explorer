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

import org.openjdk.com.sun.org.apache.xerces.internal.xni.XMLResourceIdentifier;
import org.openjdk.com.sun.org.apache.xerces.internal.xni.XNIException;

import java.io.IOException;

/**
 * This interface is used to resolve external parsed entities. The
 * application can register an object that implements this interface
 * with the parser configuration in order to intercept entities and
 * resolve them explicitly. If the registered entity resolver cannot
 * resolve the entity, it should return <code>null</code> so that the
 * parser will try to resolve the entity using a default mechanism.
 *
 * @author Andy Clark, IBM
 * @see XMLParserConfiguration
 */
public interface XMLEntityResolver {

    //
    // XMLEntityResolver methods
    //

    /**
     * Resolves an external parsed entity. If the entity cannot be
     * resolved, this method should return null.
     *
     * @param resourceIdentifier location of the XML resource to resolve
     * @throws XNIException Thrown on general error.
     * @throws IOException  Thrown if resolved entity stream cannot be
     *                      opened or some other i/o error occurs.
     * @see XMLResourceIdentifier
     */
    public XMLInputSource resolveEntity(XMLResourceIdentifier resourceIdentifier)
            throws XNIException, IOException;

} // interface XMLEntityResolver
