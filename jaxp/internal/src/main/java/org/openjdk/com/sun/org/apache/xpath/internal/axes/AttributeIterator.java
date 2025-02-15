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
 * $Id: AttributeIterator.java,v 1.2.4.1 2005/09/14 19:45:22 jeffsuttor Exp $
 */
package org.openjdk.com.sun.org.apache.xpath.internal.axes;

import org.openjdk.com.sun.org.apache.xml.internal.dtm.Axis;
import org.openjdk.com.sun.org.apache.xml.internal.dtm.DTM;
import org.openjdk.com.sun.org.apache.xpath.internal.compiler.Compiler;

/**
 * This class implements an optimized iterator for
 * attribute axes patterns.
 *
 * @xsl.usage advanced
 * @see com.sun.org.apache.xpath.internal.axes#ChildTestIterator
 */
public class AttributeIterator extends ChildTestIterator {
    static final long serialVersionUID = -8417986700712229686L;

    /**
     * Create a AttributeIterator object.
     *
     * @param compiler A reference to the Compiler that contains the op map.
     * @param opPos    The position within the op map, which contains the
     *                 location path expression for this itterator.
     * @throws org.openjdk.javax.xml.transform.TransformerException
     */
    AttributeIterator(Compiler compiler, int opPos, int analysis)
            throws org.openjdk.javax.xml.transform.TransformerException {
        super(compiler, opPos, analysis);
    }

    /**
     * Get the next node via getFirstAttribute && getNextAttribute.
     */
    protected int getNextNode() {
        m_lastFetched = (DTM.NULL == m_lastFetched)
                ? m_cdtm.getFirstAttribute(m_context)
                : m_cdtm.getNextAttribute(m_lastFetched);
        return m_lastFetched;
    }

    /**
     * Returns the axis being iterated, if it is known.
     *
     * @return Axis.CHILD, etc., or -1 if the axis is not known or is of multiple
     * types.
     */
    public int getAxis() {
        return Axis.ATTRIBUTE;
    }


}
