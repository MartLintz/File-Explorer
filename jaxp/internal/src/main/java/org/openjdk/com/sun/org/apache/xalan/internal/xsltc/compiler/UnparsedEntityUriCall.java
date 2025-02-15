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
 * $Id: UnparsedEntityUriCall.java,v 1.2.4.1 2005/09/05 09:22:36 pvedula Exp $
 */

package org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler;

import java.util.Vector;

import org.openjdk.com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.INVOKEINTERFACE;
import org.openjdk.com.sun.org.apache.bcel.internal.generic.InstructionList;
import org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util.ClassGenerator;
import org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodGenerator;
import org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringType;
import org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import org.openjdk.com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;

/**
 * @author Jacek Ambroziak
 * @author Santiago Pericas-Geertsen
 * @author Morten Jorgensen
 */
final class UnparsedEntityUriCall extends FunctionCall {
    private Expression _entity;

    public UnparsedEntityUriCall(QName fname, Vector arguments) {
        super(fname, arguments);
        _entity = argument();
    }

    public Type typeCheck(SymbolTable stable) throws TypeCheckError {
        final Type entity = _entity.typeCheck(stable);
        if (entity instanceof StringType == false) {
            _entity = new CastExpr(_entity, Type.String);
        }
        return _type = Type.String;
    }

    public void translate(ClassGenerator classGen, MethodGenerator methodGen) {
        final ConstantPoolGen cpg = classGen.getConstantPool();
        final InstructionList il = methodGen.getInstructionList();
        // Feck the this pointer on the stack...
        il.append(methodGen.loadDOM());
        // ...then the entity name...
        _entity.translate(classGen, methodGen);
        // ...to get the URI from the DOM object.
        il.append(new INVOKEINTERFACE(
                cpg.addInterfaceMethodref(DOM_INTF,
                        GET_UNPARSED_ENTITY_URI,
                        GET_UNPARSED_ENTITY_URI_SIG),
                2));
    }
}
