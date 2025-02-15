/*
 * Copyright (c) 2003, 2005, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.openjdk.javax.xml.xpath;

import org.openjdk.javax.xml.namespace.QName;

/**
 * <p><code>XPathVariableResolver</code> provides access to the set of user defined XPath variables.</p>
 *
 * <p>The <code>XPathVariableResolver</code> and the XPath evaluator must adhere to a contract that
 * cannot be directly enforced by the API.  Although variables may be mutable,
 * that is, an application may wish to evaluate the same XPath expression more
 * than once with different variable values, in the course of evaluating any
 * single XPath expression, a variable's value <strong><em>must</em></strong>
 * not change.</p>
 *
 * @author <a href="mailto:Norman.Walsh@Sun.com">Norman Walsh</a>
 * @author <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @since 1.5
 */
public interface XPathVariableResolver {
    /**
     * <p>Find a variable in the set of available variables.</p>
     *
     * <p>If <code>variableName</code> is <code>null</code>, then a <code>NullPointerException</code> is thrown.</p>
     *
     * @param variableName The <code>QName</code> of the variable name.
     * @return The variables value, or <code>null</code> if no variable named <code>variableName</code>
     * exists.  The value returned must be of a type appropriate for the underlying object model.
     * @throws NullPointerException If <code>variableName</code> is <code>null</code>.
     */
    public Object resolveVariable(QName variableName);
}
