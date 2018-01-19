package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* NodeNaming commands (version 1) */
public enum NodeNamingCommand implements Command {
    NODE_LOCATION_REPORT((byte)0x06),
    NODE_LOCATION_SET((byte)0x04),
    NODE_LOCATION_GET((byte)0x05),
    NODE_NAME_GET((byte)0x02),
    NODE_NAME_REPORT((byte)0x03),
    NODE_NAME_SET((byte)0x01);

    private static final HashMap<Byte, NodeNamingCommand> _map = new HashMap<Byte, NodeNamingCommand>(6);
    static {
        for (NodeNamingCommand value: NodeNamingCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NodeNamingCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NodeNamingCommand valueOf(byte byteValue) {
        NodeNamingCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NodeNamingCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

