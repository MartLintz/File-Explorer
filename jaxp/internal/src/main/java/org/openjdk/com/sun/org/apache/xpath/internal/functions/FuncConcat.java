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
 * $Id: FuncConcat.java,v 1.2.4.1 2005/09/14 19:53:44 jeffsuttor Exp $
 */
package org.openjdk.com.sun.org.apache.xpath.internal.functions;

import org.openjdk.com.sun.org.apache.xalan.internal.res.XSLMessages;
import org.openjdk.com.sun.org.apache.xpath.internal.XPathContext;
import org.openjdk.com.sun.org.apache.xpath.internal.objects.XObject;
import org.openjdk.com.sun.org.apache.xpath.internal.objects.XString;

/**
 * Execute the Concat() function.
 *
 * @xsl.usage advanced
 */
public class FuncConcat extends FunctionMultiArgs {
    static final long serialVersionUID = 1737228885202314413L;

    /**
     * Execute the function.  The function must return
     * a valid object.
     *
     * @param xctxt The current execution context.
     * @return A valid XObject.
     * @throws org.openjdk.javax.xml.transform.TransformerException
     */
    public XObject execute(XPathContext xctxt) throws org.openjdk.javax.xml.transform.TransformerException {

        StringBuffer sb = new StringBuffer();

        // Compiler says we must have at least two arguments.
        sb.append(m_arg0.execute(xctxt).str());
        sb.append(m_arg1.execute(xctxt).str());

        if (null != m_arg2)
            sb.append(m_arg2.execute(xctxt).str());

        if (null != m_args) {
            for (int i = 0; i < m_args.length; i++) {
                sb.append(m_args[i].execute(xctxt).str());
            }
        }

        return new XString(sb.toString());
    }

    /**
     * Check that the number of arguments passed to this function is correct.
     *
     * @param argNum The number of arguments that is being passed to the function.
     * @throws WrongNumberArgsException
     */
    public void checkNumberArgs(int argNum) throws WrongNumberArgsException {
        if (argNum < 2)
            reportWrongNumberArgs();
    }

    /**
     * Constructs and throws a WrongNumberArgException with the appropriate
     * message for this function object.
     *
     * @throws WrongNumberArgsException
     */
    protected void reportWrongNumberArgs() throws WrongNumberArgsException {
        throw new WrongNumberArgsException(XSLMessages.createXPATHMessage("gtone", null));
    }
}
