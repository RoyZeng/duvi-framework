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
package eu.jsan.duvi.commons.conversion.date.joda;

import org.joda.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDate value) {
        if (value != null) {
            return new Timestamp(value.toDateTimeAtStartOfDay().getMillis());
        }
        return null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp value) {
        if (value != null) {
            return new LocalDate(value.getTime());
        }
        return null;
    }
}
