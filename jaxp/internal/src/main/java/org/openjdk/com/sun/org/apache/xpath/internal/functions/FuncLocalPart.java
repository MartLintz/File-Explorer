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
 * $Id: FuncLocalPart.java,v 1.2.4.1 2005/09/14 20:18:44 jeffsuttor Exp $
 */
package org.openjdk.com.sun.org.apache.xpath.internal.functions;

import org.openjdk.com.sun.org.apache.xml.internal.dtm.DTM;
import org.openjdk.com.sun.org.apache.xpath.internal.XPathContext;
import org.openjdk.com.sun.org.apache.xpath.internal.objects.XObject;
import org.openjdk.com.sun.org.apache.xpath.internal.objects.XString;

/**
 * Execute the LocalPart() function.
 *
 * @xsl.usage advanced
 */
public class FuncLocalPart extends FunctionDef1Arg {
    static final long serialVersionUID = 7591798770325814746L;

    /**
     * Execute the function.  The function must return
     * a valid object.
     *
     * @param xctxt The current execution context.
     * @return A valid XObject.
     * @throws org.openjdk.javax.xml.transform.TransformerException
     */
    public XObject execute(XPathContext xctxt) throws org.openjdk.javax.xml.transform.TransformerException {

        int context = getArg0AsNode(xctxt);
        if (DTM.NULL == context)
            return XString.EMPTYSTRING;
        DTM dtm = xctxt.getDTM(context);
        String s = (context != DTM.NULL) ? dtm.getLocalName(context) : "";
        if (s.startsWith("#") || s.equals("xmlns"))
            return XString.EMPTYSTRING;

        return new XString(s);
    }
}
