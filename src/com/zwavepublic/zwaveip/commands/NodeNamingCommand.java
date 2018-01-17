package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* NodeNaming commands (version 1) */
public enum NodeNamingCommand implements com.zwavepublic.zwaveip.commands.Command {
    NODE_LOCATION_REPORT(0x06),
    NODE_LOCATION_SET(0x04),
    NODE_LOCATION_GET(0x05),
    NODE_NAME_GET(0x02),
    NODE_NAME_REPORT(0x03),
    NODE_NAME_SET(0x01);

    private static final HashMap<Integer, NodeNamingCommand> _map = new HashMap<Integer, NodeNamingCommand>(6);
    static {
        for (NodeNamingCommand value: NodeNamingCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NodeNamingCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NodeNamingCommand valueOf(int intValue) {
        NodeNamingCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NodeNamingCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

