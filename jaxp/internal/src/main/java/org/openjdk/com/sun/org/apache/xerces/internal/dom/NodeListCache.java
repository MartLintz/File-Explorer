/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/*
 * Copyright 2001,2002,2004,2005 The Apache Software Foundation.
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

package org.openjdk.com.sun.org.apache.xerces.internal.dom;

import java.io.Serializable;

/**
 * This class is used, via a pool managed on CoreDocumentImpl, in ParentNode to
 * improve performance of the NodeList accessors, getLength() and item(i).
 *
 * @author Arnaud  Le Hors, IBM
 * @version $Id: NodeListCache.java,v 1.6 2010/07/20 20:25:25 joehw Exp $
 * @xerces.internal
 */
class NodeListCache implements Serializable {

    /**
     * Serialization version.
     */
    private static final long serialVersionUID = -7927529254918631002L;

    /**
     * Cached node list length.
     */
    int fLength = -1;

    /**
     * Last requested node index.
     */
    int fChildIndex = -1;

    /**
     * Last requested node.
     */
    ChildNode fChild;

    /**
     * Owner of this cache
     */
    ParentNode fOwner;

    /**
     * Pointer to the next object on the list,
     * only meaningful when actully stored in the free list.
     */
    NodeListCache next;

    NodeListCache(ParentNode owner) {
        fOwner = owner;
    }
}
