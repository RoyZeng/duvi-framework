/**
 * Copyright (C) 2014-2014 Jorge Sánchez (duvi-framework@jsan.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.jsan.duvi.commons.conversion.bool;

import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToLongConverter implements AttributeConverter<Boolean, Long> {

    @Override
    public Long convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? NumberUtils.LONG_ONE : NumberUtils.LONG_ZERO;
    }

    @Override
    public Boolean convertToEntityAttribute(Long dbData) {
        return NumberUtils.LONG_ONE.equals(dbData);
    }

}

