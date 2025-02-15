/*
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

/*
 * Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 */

package org.openjdk.javax.xml.stream.events;

/**
 * This describes the interface to Characters events.
 * All text events get reported as Characters events.
 * Content, CData and whitespace are all reported as
 * Characters events.  IgnorableWhitespace, in most cases,
 * will be set to false unless an element declaration of element
 * content is present for the current element.
 *
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @version 1.0
 * @since 1.6
 */
public interface Characters extends XMLEvent {
    /**
     * Get the character data of this event
     */
    public String getData();

    /**
     * Returns true if this set of Characters
     * is all whitespace.  Whitespace inside a document
     * is reported as CHARACTERS.  This method allows
     * checking of CHARACTERS events to see if they
     * are composed of only whitespace characters
     */
    public boolean isWhiteSpace();

    /**
     * Returns true if this is a CData section.  If this
     * event is CData its event type will be CDATA
     * <p>
     * If javax.xml.stream.isCoalescing is set to true CDATA Sections
     * that are surrounded by non CDATA characters will be reported
     * as a single Characters event. This method will return false
     * in this case.
     */
    public boolean isCData();

    /**
     * Return true if this is ignorableWhiteSpace.  If
     * this event is ignorableWhiteSpace its event type will
     * be SPACE.
     */
    public boolean isIgnorableWhiteSpace();

}
