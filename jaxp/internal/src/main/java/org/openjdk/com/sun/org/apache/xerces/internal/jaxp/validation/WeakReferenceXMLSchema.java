/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/*
 * Copyright 2005 The Apache Software Foundation.
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

package org.openjdk.com.sun.org.apache.xerces.internal.jaxp.validation;

import org.openjdk.com.sun.org.apache.xerces.internal.xni.grammars.XMLGrammarPool;

import java.lang.ref.WeakReference;

/**
 * <p>An implementation of Schema for W3C XML Schemas
 * that keeps a weak reference to its grammar pool. If
 * no validators currently have a reference to the
 * grammar pool, the garbage collector is free to reclaim
 * its memory.</p>
 *
 * @author Michael Glavassevich, IBM
 */
final class WeakReferenceXMLSchema extends AbstractXMLSchema {

    /**
     * Weak reference to grammar pool.
     */
    private WeakReference fGrammarPool = new WeakReference(null);

    public WeakReferenceXMLSchema() {
    }

    /*
     * XSGrammarPoolContainer methods
     */

    public synchronized XMLGrammarPool getGrammarPool() {
        XMLGrammarPool grammarPool = (XMLGrammarPool) fGrammarPool.get();
        // If there's no grammar pool then either we haven't created one
        // yet or the garbage collector has already cleaned out the previous one.
        if (grammarPool == null) {
            grammarPool = new SoftReferenceGrammarPool();
            fGrammarPool = new WeakReference(grammarPool);
        }
        return grammarPool;
    }

    public boolean isFullyComposed() {
        return false;
    }

} // WeakReferenceXMLSchema
