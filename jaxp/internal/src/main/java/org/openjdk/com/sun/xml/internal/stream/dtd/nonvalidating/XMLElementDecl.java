/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package org.openjdk.com.sun.xml.internal.stream.dtd.nonvalidating;

import org.openjdk.com.sun.org.apache.xerces.internal.xni.QName;

/**
 *
 */
public class XMLElementDecl {

    /**
     * TYPE_ANY
     */
    public static final short TYPE_ANY = 0;

    /**
     * TYPE_EMPTY
     */
    public static final short TYPE_EMPTY = 1;

    /**
     * TYPE_MIXED
     */
    public static final short TYPE_MIXED = 2;

    /**
     * TYPE_CHILDREN
     */
    public static final short TYPE_CHILDREN = 3;

    /**
     * TYPE_SIMPLE
     */
    public static final short TYPE_SIMPLE = 4;


    /**
     * name
     */
    public final QName name = new QName();

    /**
     * scope
     */
    public int scope = -1;

    /**
     * type
     */
    public short type = -1;


    /**
     * simpleType
     */
    public final XMLSimpleType simpleType = new XMLSimpleType();

    /**
     * setValues
     *
     * @param name
     * @param scope
     * @param type
     * @param contentModelValidator
     * @param simpleType
     */
    public void setValues(QName name, int scope, short type, XMLSimpleType simpleType) {
        this.name.setValues(name);
        this.scope = scope;
        this.type = type;
        this.simpleType.setValues(simpleType);
    } // setValues

    /**
     * clear
     */
    public void clear() {
        this.name.clear();
        this.type = -1;
        this.scope = -1;
        this.simpleType.clear();
    } // clear

} // class XMLElementDecl
