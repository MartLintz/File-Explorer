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
 * $Id: ChildIterator.java,v 1.2.4.2 2005/09/14 19:45:20 jeffsuttor Exp $
 */
package org.openjdk.com.sun.org.apache.xpath.internal.axes;

import org.openjdk.com.sun.org.apache.xml.internal.dtm.Axis;
import org.openjdk.com.sun.org.apache.xml.internal.dtm.DTM;
import org.openjdk.com.sun.org.apache.xml.internal.dtm.DTMFilter;
import org.openjdk.com.sun.org.apache.xpath.internal.XPathContext;
import org.openjdk.com.sun.org.apache.xpath.internal.compiler.Compiler;

/**
 * This class implements an optimized iterator for
 * "node()" patterns, that is, any children of the
 * context node.
 *
 * @xsl.usage advanced
 * @see LocPathIterator
 */
public class ChildIterator extends LocPathIterator {
    static final long serialVersionUID = -6935428015142993583L;

    /**
     * Create a ChildIterator object.
     *
     * @param compiler A reference to the Compiler that contains the op map.
     * @param opPos    The position within the op map, which contains the
     *                 location path expression for this itterator.
     * @param analysis Analysis bits of the entire pattern.
     * @throws org.openjdk.javax.xml.transform.TransformerException
     */
    ChildIterator(Compiler compiler, int opPos, int analysis)
            throws org.openjdk.javax.xml.transform.TransformerException {
        super(compiler, opPos, analysis, false);

        // This iterator matches all kinds of nodes
        initNodeTest(DTMFilter.SHOW_ALL);
    }

    /**
     * Return the first node out of the nodeset, if this expression is
     * a nodeset expression.  This is the default implementation for
     * nodesets.
     * <p>WARNING: Do not mutate this class from this function!</p>
     *
     * @param xctxt The XPath runtime context.
     * @return the first node out of the nodeset, or DTM.NULL.
     */
    public int asNode(XPathContext xctxt)
            throws org.openjdk.javax.xml.transform.TransformerException {
        int current = xctxt.getCurrentNode();

        DTM dtm = xctxt.getDTM(current);

        return dtm.getFirstChild(current);
    }

    /**
     * Returns the next node in the set and advances the position of the
     * iterator in the set. After a NodeIterator is created, the first call
     * to nextNode() returns the first node in the set.
     *
     * @return The next <code>Node</code> in the set being iterated over, or
     * <code>null</code> if there are no more members in that set.
     */
    public int nextNode() {
        if (m_foundLast)
            return DTM.NULL;

        int next;

        m_lastFetched = next = (DTM.NULL == m_lastFetched)
                ? m_cdtm.getFirstChild(m_context)
                : m_cdtm.getNextSibling(m_lastFetched);

        // m_lastFetched = next;
        if (DTM.NULL != next) {
            m_pos++;
            return next;
        } else {
            m_foundLast = true;

            return DTM.NULL;
        }
    }

    /**
     * Returns the axis being iterated, if it is known.
     *
     * @return Axis.CHILD, etc., or -1 if the axis is not known or is of multiple
     * types.
     */
    public int getAxis() {
        return Axis.CHILD;
    }


}
