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

package org.openjdk.com.sun.org.apache.xerces.internal.impl.xs.identity;

import org.openjdk.com.sun.org.apache.xerces.internal.xs.XSIDCDefinition;

/**
 * Schema key reference identity constraint.
 *
 * @author Andy Clark, IBM
 * @xerces.internal
 */
public class KeyRef
        extends IdentityConstraint {

    //
    // Data
    //

    /**
     * The key (or unique) being referred to.
     */
    protected UniqueOrKey fKey;

    //
    // Constructors
    //

    /**
     * Constructs a keyref with the specified name.
     */
    public KeyRef(String namespace, String identityConstraintName,
                  String elemName, UniqueOrKey key) {
        super(namespace, identityConstraintName, elemName);
        fKey = key;
        type = IC_KEYREF;
    } // <init>(String,String,String)

    //
    // Public methods
    //

    /**
     * Returns the key being referred to.
     */
    public UniqueOrKey getKey() {
        return fKey;
    } // getKey(): int

    /**
     * {referenced key} Required if {identity-constraint category} is keyref,
     * forbidden otherwise. An identity-constraint definition with
     * {identity-constraint category} equal to key or unique.
     */
    public XSIDCDefinition getRefKey() {
        return fKey;
    }

} // class KeyRef
