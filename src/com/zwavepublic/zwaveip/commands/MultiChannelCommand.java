package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MultiChannel commands (version 4) */
public enum MultiChannelCommand implements com.zwavepublic.zwaveip.commands.Command {
    CAPABILITY_GET(0x09),
    CAPABILITY_REPORT(0x0a),
    CMD_ENCAP(0x0d),
    END_POINT_FIND(0x0b),
    END_POINT_FIND_REPORT(0x0c),
    END_POINT_GET(0x07),
    END_POINT_REPORT(0x08),
    MULTI_INSTANCE_CMD_ENCAP(0x06),
    MULTI_INSTANCE_GET(0x04),
    MULTI_INSTANCE_REPORT(0x05),
    AGGREGATED_MEMBERS_GET(0x0e),
    AGGREGATED_MEMBERS_REPORT(0x0f);

    private static final HashMap<Integer, MultiChannelCommand> _map = new HashMap<Integer, MultiChannelCommand>(12);
    static {
        for (MultiChannelCommand value: MultiChannelCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MultiChannelCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MultiChannelCommand valueOf(int intValue) {
        MultiChannelCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MultiChannelCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

