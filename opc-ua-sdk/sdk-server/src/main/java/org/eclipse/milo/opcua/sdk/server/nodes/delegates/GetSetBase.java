/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.nodes.delegates;

import org.eclipse.milo.opcua.sdk.server.nodes.AttributeContext;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNode;
import org.eclipse.milo.opcua.sdk.server.util.AttributeUtil;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.StatusCodes;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;

import static org.eclipse.milo.opcua.sdk.server.util.AttributeUtil.dv;

public interface GetSetBase {

    default DataValue getBaseAttribute(
        AttributeContext context,
        UaNode node,
        AttributeId attributeId
    ) throws UaException {

        switch (attributeId) {
            case NodeId:
                return dv(getNodeId(context, node));

            case NodeClass:
                return dv(getNodeClass(context, node));

            case BrowseName:
                return dv(getBrowseName(context, node));

            case DisplayName:
                return dv(getDisplayName(context, node));

            case Description:
                return dv(getDescription(context, node));

            case WriteMask:
                return dv(getWriteMask(context, node));

            case UserWriteMask:
                return dv(getUserWriteMask(context, node));

            default:
                throw new UaException(StatusCodes.Bad_AttributeIdInvalid);
        }
    }

    default void setBaseAttribute(
        AttributeContext context,
        UaNode node,
        AttributeId attributeId,
        DataValue value
    ) throws UaException {

        switch (attributeId) {
            case NodeId:
                setNodeId(context, node, AttributeUtil.extract(value));
                break;
            case NodeClass:
                setNodeClass(context, node, AttributeUtil.extract(value));
                break;
            case BrowseName:
                setBrowseName(context, node, AttributeUtil.extract(value));
                break;
            case DisplayName:
                setDisplayName(context, node, AttributeUtil.extract(value));
                break;
            case Description:
                setDescription(context, node, AttributeUtil.extract(value));
                break;
            case WriteMask:
                setWriteMask(context, node, AttributeUtil.extract(value));
                break;
            case UserWriteMask:
                setUserWriteMask(context, node, AttributeUtil.extract(value));
                break;

            default:
                throw new UaException(StatusCodes.Bad_AttributeIdInvalid);
        }
    }

    default NodeId getNodeId(AttributeContext context, UaNode node) throws UaException {
        return (NodeId) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.NodeId
        );
    }

    default NodeClass getNodeClass(AttributeContext context, UaNode node) throws UaException {
        return (NodeClass) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.NodeClass
        );
    }

    default QualifiedName getBrowseName(AttributeContext context, UaNode node) throws UaException {
        return (QualifiedName) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.BrowseName
        );
    }

    default LocalizedText getDisplayName(AttributeContext context, UaNode node) throws UaException {
        return (LocalizedText) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.DisplayName
        );
    }

    default LocalizedText getDescription(AttributeContext context, UaNode node) throws UaException {
        return (LocalizedText) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.Description
        );
    }

    default UInteger getWriteMask(AttributeContext context, UaNode node) throws UaException {
        return (UInteger) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.WriteMask
        );
    }

    default UInteger getUserWriteMask(AttributeContext context, UaNode node) throws UaException {
        return (UInteger) node.getFilterChain().getAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.UserWriteMask
        );
    }

    default void setNodeId(AttributeContext context, UaNode node, NodeId nodeId) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.NodeId,
            nodeId
        );
    }

    default void setNodeClass(AttributeContext context, UaNode node, NodeClass nodeClass) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.NodeClass,
            nodeClass
        );
    }

    default void setBrowseName(AttributeContext context, UaNode node, QualifiedName browseName) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.BrowseName,
            browseName
        );
    }

    default void setDisplayName(AttributeContext context, UaNode node, LocalizedText displayName) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.DisplayName,
            displayName
        );
    }

    default void setDescription(AttributeContext context, UaNode node, LocalizedText description) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.Description,
            description
        );
    }

    default void setWriteMask(AttributeContext context, UaNode node, UInteger writeMask) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.WriteMask,
            writeMask
        );
    }

    default void setUserWriteMask(AttributeContext context, UaNode node, UInteger userWriteMask) throws UaException {
        node.getFilterChain().setAttribute(
            context.getSession().orElse(null),
            node,
            AttributeId.UserWriteMask,
            userWriteMask
        );
    }

}
