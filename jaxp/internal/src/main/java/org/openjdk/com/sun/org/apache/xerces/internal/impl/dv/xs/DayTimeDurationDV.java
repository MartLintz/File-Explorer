/*
 * reserved comment block
 * DO NOT REMOVE OR ALTER!
 */
/*
 * Copyright 2004,2005 The Apache Software Foundation.
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
package org.openjdk.com.sun.org.apache.xerces.internal.impl.dv.xs;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.openjdk.javax.xml.datatype.DatatypeConstants;
import org.openjdk.javax.xml.datatype.Duration;

import org.openjdk.com.sun.org.apache.xerces.internal.impl.dv.InvalidDatatypeValueException;
import org.openjdk.com.sun.org.apache.xerces.internal.impl.dv.ValidationContext;

/**
 * Used to validate the <dayTimeDuration> type
 *
 * @author Ankit Pasricha, IBM
 * @version $Id: DayTimeDurationDV.java,v 1.6 2010-11-01 04:39:46 joehw Exp $
 * @xerces.internal
 */
class DayTimeDurationDV extends DurationDV {

    public Object getActualValue(String content, ValidationContext context)
            throws InvalidDatatypeValueException {
        try {
            return parse(content, DAYTIMEDURATION_TYPE);
        } catch (Exception ex) {
            throw new InvalidDatatypeValueException("cvc-datatype-valid.1.2.1", new Object[]{content, "dayTimeDuration"});
        }
    }

    protected Duration getDuration(DateTimeData date) {
        int sign = 1;
        if (date.day < 0 || date.hour < 0 || date.minute < 0 || date.second < 0) {
            sign = -1;
        }
        return datatypeFactory.newDuration(sign == 1, null, null,
                date.day != DatatypeConstants.FIELD_UNDEFINED ? BigInteger.valueOf(sign * date.day) : null,
                date.hour != DatatypeConstants.FIELD_UNDEFINED ? BigInteger.valueOf(sign * date.hour) : null,
                date.minute != DatatypeConstants.FIELD_UNDEFINED ? BigInteger.valueOf(sign * date.minute) : null,
                date.second != DatatypeConstants.FIELD_UNDEFINED ? new BigDecimal(String.valueOf(sign * date.second)) : null);
    }
}
