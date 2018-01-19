package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* NetworkManagementInclusion commands (version 2) */
public enum NetworkManagementInclusionCommand implements Command {
    FAILED_NODE_REMOVE((byte)0x07),
    FAILED_NODE_REMOVE_STATUS((byte)0x08),
    NODE_ADD((byte)0x01),
    NODE_ADD_STATUS((byte)0x02),
    NODE_REMOVE((byte)0x03),
    NODE_REMOVE_STATUS((byte)0x04),
    FAILED_NODE_REPLACE((byte)0x09),
    FAILED_NODE_REPLACE_STATUS((byte)0x0a),
    NODE_NEIGHBOR_UPDATE_REQUEST((byte)0x0b),
    NODE_NEIGHBOR_UPDATE_STATUS((byte)0x0c),
    RETURN_ROUTE_ASSIGN((byte)0x0d),
    RETURN_ROUTE_ASSIGN_COMPLETE((byte)0x0e),
    RETURN_ROUTE_DELETE((byte)0x0f),
    RETURN_ROUTE_DELETE_COMPLETE((byte)0x10),
    NODE_ADD_KEYS_REPORT((byte)0x11),
    NODE_ADD_KEYS_SET((byte)0x12),
    NODE_ADD_DSK_REPORT((byte)0x13),
    NODE_ADD_DSK_SET((byte)0x14);

    private static final HashMap<Byte, NetworkManagementInclusionCommand> _map = new HashMap<Byte, NetworkManagementInclusionCommand>(18);
    static {
        for (NetworkManagementInclusionCommand value: NetworkManagementInclusionCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NetworkManagementInclusionCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NetworkManagementInclusionCommand valueOf(byte byteValue) {
        NetworkManagementInclusionCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementInclusionCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

