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

package org.openjdk.com.sun.org.apache.xerces.internal.impl.dv.xs;

import org.openjdk.com.sun.org.apache.xerces.internal.impl.dv.InvalidDatatypeValueException;
import org.openjdk.com.sun.org.apache.xerces.internal.util.XMLChar;
import org.openjdk.com.sun.org.apache.xerces.internal.impl.dv.ValidationContext;

/**
 * Represent the schema type "ID"
 *
 * @author Neeraj Bajaj, Sun Microsystems, inc.
 * @author Sandy Gao, IBM
 * @xerces.internal
 */
public class IDDV extends TypeValidator {

    public short getAllowedFacets() {
        return (XSSimpleTypeDecl.FACET_LENGTH | XSSimpleTypeDecl.FACET_MINLENGTH | XSSimpleTypeDecl.FACET_MAXLENGTH | XSSimpleTypeDecl.FACET_PATTERN | XSSimpleTypeDecl.FACET_ENUMERATION | XSSimpleTypeDecl.FACET_WHITESPACE);
    }

    public Object getActualValue(String content, ValidationContext context) throws InvalidDatatypeValueException {
        if (!XMLChar.isValidNCName(content)) {
            throw new InvalidDatatypeValueException("cvc-datatype-valid.1.2.1", new Object[]{content, "NCName"});
        }
        return content;
    }

    public void checkExtraRules(Object value, ValidationContext context) throws InvalidDatatypeValueException {
        String content = (String) value;
        if (context.isIdDeclared(content))
            throw new InvalidDatatypeValueException("cvc-id.2", new Object[]{content});
        context.addId(content);
    }
} // class IDDV
