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
 * $Id: VoidType.java,v 1.2.4.1 2005/09/05 11:45:26 pvedula Exp $
 */

package org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util;

import org.openjdk.com.sun.org.apache.bcel.internal.generic.Instruction;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.InstructionList;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.PUSH;
import org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;

/**
 * @author Jacek Ambroziak
 * @author Santiago Pericas-Geertsen
 */
public final class VoidType extends Type {
    protected VoidType() {
    }

    public String toString() {
        return "void";
    }

    public boolean identicalTo(Type other) {
        return this == other;
    }

    public String toSignature() {
        return "V";
    }

    public org.openjdk.com.sun.org.apache.bcel.internal.generic.Type toJCType() {
        return null;    // should never be called
    }

    public Instruction POP() {
        return NOP;
    }

    /**
     * Translates a void into an object of internal type <code>type</code>.
     * This translation is needed when calling external functions
     * that return void.
     *
     * @see Type#translateTo
     */
    public void translateTo(ClassGenerator classGen, MethodGenerator methodGen,
                            Type type) {
        if (type == String) {
            translateTo(classGen, methodGen, (StringType) type);
        } else {
            ErrorMsg err = new ErrorMsg(ErrorMsg.DATA_CONVERSION_ERR,
                    toString(), type.toString());
            classGen.getParser().reportError(Constants.FATAL, err);
        }
    }

    /**
     * Translates a void into a string by pushing the empty string ''.
     *
     * @see Type#translateTo
     */
    public void translateTo(ClassGenerator classGen, MethodGenerator methodGen,
                            StringType type) {
        final InstructionList il = methodGen.getInstructionList();
        il.append(new PUSH(classGen.getConstantPool(), ""));
    }

    /**
     * Translates an external (primitive) Java type into a void.
     * Only an external "void" can be converted to this class.
     */
    public void translateFrom(ClassGenerator classGen, MethodGenerator methodGen,
                              Class clazz) {
        if (!clazz.getName().equals("void")) {
            ErrorMsg err = new ErrorMsg(ErrorMsg.DATA_CONVERSION_ERR,
                    toString(), clazz.getName());
            classGen.getParser().reportError(Constants.FATAL, err);
        }
    }
}
