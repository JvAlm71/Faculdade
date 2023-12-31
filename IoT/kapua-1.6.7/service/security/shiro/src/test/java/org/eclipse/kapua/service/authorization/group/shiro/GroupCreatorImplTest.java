/*******************************************************************************
 * Copyright (c) 2021, 2022 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.authorization.group.shiro;

import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;


@Category(JUnitTests.class)
public class GroupCreatorImplTest {

    String[] names;
    KapuaId scopeId;

    @Before
    public void initialize() {
        names = new String[]{"", "  na123)(&*^&NAME  <>", "Na-,,..,,Me name ---", "-&^454536 na___,,12 NAME name    ", "! 2#@ na     meNEMA 2323", "12&^%4   ,,,. '|<>*(", "       ,,123name;;'", "12#name--765   ,.aaa!!#$%^<> "};
        scopeId = KapuaId.ONE;
    }

    @Test
    public void groupCreatorImplScopeIdNameParametersTest() {
        for (String name : names) {
            GroupCreatorImpl groupCreatorImpl = new GroupCreatorImpl(scopeId, name);
            Assert.assertEquals("Expected and actual values should be the same.", scopeId, groupCreatorImpl.getScopeId());
            Assert.assertEquals("Expected and actual values should be the same.", name, groupCreatorImpl.getName());
        }
    }

    @Test
    public void groupCreatorImplNullScopeIdNameParametersTest() {
        for (String name : names) {
            GroupCreatorImpl groupCreatorImpl = new GroupCreatorImpl(null, name);
            Assert.assertNull("Null expected.", groupCreatorImpl.getScopeId());
            Assert.assertEquals("Expected and actual values should be the same.", name, groupCreatorImpl.getName());
        }
    }

    @Test
    public void groupCreatorImplScopeIdNullNameParametersTest() {
        GroupCreatorImpl groupCreatorImpl = new GroupCreatorImpl(scopeId, null);
        Assert.assertEquals("Expected and actual values should be the same.", scopeId, groupCreatorImpl.getScopeId());
        Assert.assertNull("Null expected.", groupCreatorImpl.getName());
    }

    @Test
    public void groupCreatorImplNullScopeIdNullNameParametersTest() {
        GroupCreatorImpl groupCreatorImpl = new GroupCreatorImpl(null, null);
        Assert.assertNull("Null expected.", groupCreatorImpl.getScopeId());
        Assert.assertNull("Null expected.", groupCreatorImpl.getName());
    }

    @Test
    public void groupCreatorImplScopeIdParameterTest() {
        GroupCreatorImpl groupCreatorImpl = new GroupCreatorImpl(scopeId);
        Assert.assertEquals("Expected and actual values should be the same.", scopeId, groupCreatorImpl.getScopeId());
        Assert.assertNull("Null expected.", groupCreatorImpl.getName());
    }

    @Test
    public void groupCreatorImplNullScopeIdParameterTest() {
        GroupCreatorImpl groupCreatorImpl = new GroupCreatorImpl(null);
        Assert.assertNull("Null expected.", groupCreatorImpl.getScopeId());
        Assert.assertNull("Null expected.", groupCreatorImpl.getName());
    }
}