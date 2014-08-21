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
package eu.jsan.duvi.entity.users;

import ch.rasc.extclassgenerator.Model;
import eu.jsan.duvi.entity.AbstractAuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Model(value = "Duvi.model.users.User", identifier = "sequential", rootProperty = "records",
        createMethod = "userService.create", readMethod = "userService.read",
        updateMethod = "userService.update", destroyMethod = "userService.destroy",
        autodetectTypes = false)
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.INTEGER)
public class User extends AbstractAuditableEntity {


    private static final long serialVersionUID = 4715650322352622851L;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;
}
