package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MultiChannelAssociation commands (version 3) */
public enum MultiChannelAssociationCommand implements Command {
    GET((byte)0x02),
    GROUPINGS_GET((byte)0x05),
    GROUPINGS_REPORT((byte)0x06),
    REMOVE((byte)0x04),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, MultiChannelAssociationCommand> _map = new HashMap<Byte, MultiChannelAssociationCommand>(6);
    static {
        for (MultiChannelAssociationCommand value: MultiChannelAssociationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MultiChannelAssociationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MultiChannelAssociationCommand valueOf(byte byteValue) {
        MultiChannelAssociationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MultiChannelAssociationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

