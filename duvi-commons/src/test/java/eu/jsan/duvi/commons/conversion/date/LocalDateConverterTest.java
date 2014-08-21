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
package eu.jsan.duvi.commons.conversion.date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.LocalDate;

public class LocalDateConverterTest {

    LocalDateConverter localDateConverter;

    LocalDate localDate;

    Timestamp timestamp;

    @BeforeMethod
    public void setUp() throws Exception {
        localDateConverter = new LocalDateConverter();
        localDate = LocalDate.now();
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Test
    public void testConvertToDatabaseColumn() throws Exception {
        timestamp = localDateConverter.convertToDatabaseColumn(localDate);
        Assert.assertEquals(timestamp.toLocalDateTime().toLocalDate(), localDate);
    }

    @Test
    public void testConvertToEntityAttribute() throws Exception {
        localDate = localDateConverter.convertToEntityAttribute(timestamp);
        Assert.assertEquals(timestamp.toLocalDateTime().toLocalDate(), localDate);
    }
}