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
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file and, per its terms, should not be removed:
 *
 * Copyright (c) 2000 World Wide Web Consortium,
 * (Massachusetts Institute of Technology, Institut National de
 * Recherche en Informatique et en Automatique, Keio University). All
 * Rights Reserved. This program is distributed under the W3C's Software
 * Intellectual Property License. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See W3C License http://www.w3.org/Consortium/Legal/ for more
 * details.
 */

package org.w3c.dom.html;

/**
 * The HTML document body. This element is always present in the DOM API,
 * even if the tags are not present in the source document. See the  BODY
 * element definition in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLBodyElement extends HTMLElement {
    /**
     * Color of active links (after mouse-button down, but before
     * mouse-button up). See the  alink attribute definition in HTML 4.0.
     * This attribute is deprecated in HTML 4.0.
     */
    public String getALink();

    public void setALink(String aLink);

    /**
     * URI of the background texture tile image. See the  background
     * attribute definition in HTML 4.0. This attribute is deprecated in HTML
     * 4.0.
     */
    public String getBackground();

    public void setBackground(String background);

    /**
     * Document background color. See the  bgcolor attribute definition in
     * HTML 4.0. This attribute is deprecated in HTML 4.0.
     */
    public String getBgColor();

    public void setBgColor(String bgColor);

    /**
     * Color of links that are not active and unvisited. See the  link
     * attribute definition in HTML 4.0. This attribute is deprecated in HTML
     * 4.0.
     */
    public String getLink();

    public void setLink(String link);

    /**
     * Document text color. See the  text attribute definition in HTML 4.0.
     * This attribute is deprecated in HTML 4.0.
     */
    public String getText();

    public void setText(String text);

    /**
     * Color of links that have been visited by the user. See the  vlink
     * attribute definition in HTML 4.0. This attribute is deprecated in HTML
     * 4.0.
     */
    public String getVLink();

    public void setVLink(String vLink);

}
