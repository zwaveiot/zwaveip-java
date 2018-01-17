package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* NetworkManagementInclusion commands (version 2) */
public enum NetworkManagementInclusionCommand implements com.zwavepublic.zwaveip.commands.Command {
    FAILED_NODE_REMOVE(0x07),
    FAILED_NODE_REMOVE_STATUS(0x08),
    NODE_ADD(0x01),
    NODE_ADD_STATUS(0x02),
    NODE_REMOVE(0x03),
    NODE_REMOVE_STATUS(0x04),
    FAILED_NODE_REPLACE(0x09),
    FAILED_NODE_REPLACE_STATUS(0x0a),
    NODE_NEIGHBOR_UPDATE_REQUEST(0x0b),
    NODE_NEIGHBOR_UPDATE_STATUS(0x0c),
    RETURN_ROUTE_ASSIGN(0x0d),
    RETURN_ROUTE_ASSIGN_COMPLETE(0x0e),
    RETURN_ROUTE_DELETE(0x0f),
    RETURN_ROUTE_DELETE_COMPLETE(0x10),
    NODE_ADD_KEYS_REPORT(0x11),
    NODE_ADD_KEYS_SET(0x12),
    NODE_ADD_DSK_REPORT(0x13),
    NODE_ADD_DSK_SET(0x14);

    private static final HashMap<Integer, NetworkManagementInclusionCommand> _map = new HashMap<Integer, NetworkManagementInclusionCommand>(18);
    static {
        for (NetworkManagementInclusionCommand value: NetworkManagementInclusionCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NetworkManagementInclusionCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NetworkManagementInclusionCommand valueOf(int intValue) {
        NetworkManagementInclusionCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementInclusionCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

