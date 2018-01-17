package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MultiChannelAssociation commands (version 3) */
public enum MultiChannelAssociationCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    GROUPINGS_GET(0x05),
    GROUPINGS_REPORT(0x06),
    REMOVE(0x04),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, MultiChannelAssociationCommand> _map = new HashMap<Integer, MultiChannelAssociationCommand>(6);
    static {
        for (MultiChannelAssociationCommand value: MultiChannelAssociationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MultiChannelAssociationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MultiChannelAssociationCommand valueOf(int intValue) {
        MultiChannelAssociationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MultiChannelAssociationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

