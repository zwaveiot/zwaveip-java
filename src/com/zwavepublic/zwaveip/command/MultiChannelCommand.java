package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MultiChannel commands (version 4) */
public enum MultiChannelCommand implements Command {
    CAPABILITY_GET((byte)0x09),
    CAPABILITY_REPORT((byte)0x0a),
    CMD_ENCAP((byte)0x0d),
    END_POINT_FIND((byte)0x0b),
    END_POINT_FIND_REPORT((byte)0x0c),
    END_POINT_GET((byte)0x07),
    END_POINT_REPORT((byte)0x08),
    MULTI_INSTANCE_CMD_ENCAP((byte)0x06),
    MULTI_INSTANCE_GET((byte)0x04),
    MULTI_INSTANCE_REPORT((byte)0x05),
    AGGREGATED_MEMBERS_GET((byte)0x0e),
    AGGREGATED_MEMBERS_REPORT((byte)0x0f);

    private static final HashMap<Byte, MultiChannelCommand> _map = new HashMap<Byte, MultiChannelCommand>(12);
    static {
        for (MultiChannelCommand value: MultiChannelCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MultiChannelCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MultiChannelCommand valueOf(byte byteValue) {
        MultiChannelCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MultiChannelCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

