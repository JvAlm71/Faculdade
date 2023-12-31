/*******************************************************************************
 * Copyright (c) 2017, 2022 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.app.api.core.exception.model;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.kapua.KapuaEntityNotFoundException;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.model.id.KapuaIdAdapter;

@XmlRootElement(name = "entityNotFoundExceptionInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntityNotFoundExceptionInfo extends ExceptionInfo {

    @XmlElement(name = "entityType")
    private String entityType;

    @XmlElement(name = "entityId")
    @XmlJavaTypeAdapter(KapuaIdAdapter.class)
    private KapuaId entityId;

    protected EntityNotFoundExceptionInfo() {
        super();
    }

    public EntityNotFoundExceptionInfo(Status httpStatus, KapuaEntityNotFoundException kapuaException) {
        super(httpStatus, kapuaException.getCode(), kapuaException);

        setEntityType(kapuaException.getEntityType());
        setEntityId(kapuaException.getEntityId());
    }

    public String getEntityType() {
        return entityType;
    }

    private void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public KapuaId getEntityId() {
        return entityId;
    }

    private void setEntityId(KapuaId entityId) {
        this.entityId = entityId;
    }

}
