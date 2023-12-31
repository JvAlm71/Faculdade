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
package org.eclipse.kapua.app.api.core.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.eclipse.kapua.KapuaEntityNotFoundException;
import org.eclipse.kapua.app.api.core.exception.model.EntityNotFoundExceptionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class KapuaEntityNotFoundExceptionMapper implements ExceptionMapper<KapuaEntityNotFoundException> {

    private static final Logger LOG = LoggerFactory.getLogger(KapuaEntityNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(KapuaEntityNotFoundException kapuaException) {
        LOG.error("Entity not found exception!", kapuaException);
        return Response//
                .status(Status.NOT_FOUND) //
                .entity(new EntityNotFoundExceptionInfo(Status.NOT_FOUND, kapuaException)) //
                .build();
    }
}
