/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/*
 * Copyright 1999-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: Quo.java,v 1.2.4.2 2005/09/14 21:31:44 jeffsuttor Exp $
 */
package org.openjdk.com.sun.org.apache.xpath.internal.operations;

import org.openjdk.com.sun.org.apache.xpath.internal.objects.XNumber;
import org.openjdk.com.sun.org.apache.xpath.internal.objects.XObject;

/**
 * The 'quo' operation expression executer. (no longer supported by XPath).
 *
 * @deprecated
 */
public class Quo extends Operation {
    static final long serialVersionUID = 693765299196169905L;

    // Actually, this is no longer supported by xpath...

    /**
     * Apply the operation to two operands, and return the result.
     *
     * @param left  non-null reference to the evaluated left operand.
     * @param right non-null reference to the evaluated right operand.
     * @return non-null reference to the XObject that represents the result of the operation.
     * @throws org.openjdk.javax.xml.transform.TransformerException
     */
    public XObject operate(XObject left, XObject right)
            throws org.openjdk.javax.xml.transform.TransformerException {
        return new XNumber((int) (left.num() / right.num()));
    }
}
