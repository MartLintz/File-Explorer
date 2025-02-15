/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/*
 * Copyright 2001-2004 The Apache Software Foundation.
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
 * $Id: RtMethodGenerator.java,v 1.2.4.1 2005/09/05 11:30:49 pvedula Exp $
 */

package org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util;

import org.openjdk.com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.ASTORE;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.Instruction;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.InstructionList;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.Type;

/**
 * This class is used for result trees implemented as methods. These
 * methods take a reference to the DOM and to the handler only.
 *
 * @author Jacek Ambroziak
 * @author Santiago Pericas-Geertsen
 */
public final class RtMethodGenerator extends MethodGenerator {
    private static final int HANDLER_INDEX = 2;
    private final Instruction _astoreHandler;
    private final Instruction _aloadHandler;

    public RtMethodGenerator(int access_flags, Type return_type,
                             Type[] arg_types, String[] arg_names,
                             String method_name, String class_name,
                             InstructionList il, ConstantPoolGen cp) {
        super(access_flags, return_type, arg_types, arg_names, method_name,
                class_name, il, cp);

        _astoreHandler = new ASTORE(HANDLER_INDEX);
        _aloadHandler = new ALOAD(HANDLER_INDEX);
    }

    public int getIteratorIndex() {
        return INVALID_INDEX;           // not available
    }

    public final Instruction storeHandler() {
        return _astoreHandler;
    }

    public final Instruction loadHandler() {
        return _aloadHandler;
    }

    public int getLocalIndex(String name) {
        return INVALID_INDEX;           // not available
    }
}
