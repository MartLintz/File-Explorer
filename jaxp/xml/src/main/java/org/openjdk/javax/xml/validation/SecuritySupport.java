/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package org.openjdk.javax.xml.validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;

/**
 * This class is duplicated for each JAXP subpackage so keep it in sync.
 * It is package private and therefore is not exposed as part of the JAXP
 * API.
 * <p>
 * Security related methods that only work on J2SE 1.2 and newer.
 */
class SecuritySupport {


    ClassLoader getContextClassLoader() {
        return (ClassLoader)
                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        ClassLoader cl = null;
                        //try {
                        cl = Thread.currentThread().getContextClassLoader();
                        //} catch (SecurityException ex) { }
                        if (cl == null)
                            cl = ClassLoader.getSystemClassLoader();
                        return cl;
                    }
                });
    }

    String getSystemProperty(final String propName) {
        return (String)
                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        return System.getProperty(propName);
                    }
                });
    }

    FileInputStream getFileInputStream(final File file)
            throws FileNotFoundException {
        try {
            return (FileInputStream)
                    AccessController.doPrivileged(new PrivilegedExceptionAction() {
                        public Object run() throws FileNotFoundException {
                            return new FileInputStream(file);
                        }
                    });
        } catch (PrivilegedActionException e) {
            throw (FileNotFoundException) e.getException();
        }
    }

    InputStream getURLInputStream(final URL url)
            throws IOException {
        try {
            return (InputStream)
                    AccessController.doPrivileged(new PrivilegedExceptionAction() {
                        public Object run() throws IOException {
                            return url.openStream();
                        }
                    });
        } catch (PrivilegedActionException e) {
            throw (IOException) e.getException();
        }
    }

    URL getResourceAsURL(final ClassLoader cl,
                         final String name) {
        return (URL)
                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        URL url;
                        if (cl == null) {
                            url = Object.class.getResource(name);
                        } else {
                            url = cl.getResource(name);
                        }
                        return url;
                    }
                });
    }

    Enumeration getResources(final ClassLoader cl,
                             final String name) throws IOException {
        try {
            return (Enumeration)
                    AccessController.doPrivileged(new PrivilegedExceptionAction() {
                        public Object run() throws IOException {
                            Enumeration enumeration;
                            if (cl == null) {
                                enumeration = ClassLoader.getSystemResources(name);
                            } else {
                                enumeration = cl.getResources(name);
                            }
                            return enumeration;
                        }
                    });
        } catch (PrivilegedActionException e) {
            throw (IOException) e.getException();
        }
    }

    InputStream getResourceAsStream(final ClassLoader cl,
                                    final String name) {
        return (InputStream)
                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        InputStream ris;
                        if (cl == null) {
                            ris = Object.class.getResourceAsStream(name);
                        } else {
                            ris = cl.getResourceAsStream(name);
                        }
                        return ris;
                    }
                });
    }

    boolean doesFileExist(final File f) {
        return ((Boolean)
                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        return new Boolean(f.exists());
                    }
                })).booleanValue();
    }

}
