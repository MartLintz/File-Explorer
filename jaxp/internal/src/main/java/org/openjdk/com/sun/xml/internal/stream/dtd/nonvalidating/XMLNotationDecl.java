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

/**
 *
 */
public class XMLNotationDecl {

    //
    // Data
    //

    /**
     * name
     */
    public String name;

    /**
     * publicId
     */
    public String publicId;

    /**
     * systemId
     */
    public String systemId;

    /**
     * base systemId
     */
    public String baseSystemId;

    //
    // Methods
    //

    /**
     * setValues
     *
     * @param name
     * @param publicId
     * @param systemId
     */
    public void setValues(String name, String publicId, String systemId, String baseSystemId) {
        this.name = name;
        this.publicId = publicId;
        this.systemId = systemId;
        this.baseSystemId = baseSystemId;
    } // setValues

    /**
     * clear
     */
    public void clear() {
        this.name = null;
        this.publicId = null;
        this.systemId = null;
        this.baseSystemId = null;
    } // clear

} // class XMLNotationDecl
