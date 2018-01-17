package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* RemoteAssociation commands (version 1) */
public enum RemoteAssociationCommand implements com.zwavepublic.zwaveip.commands.Command {
    CONFIGURATION_GET(0x02),
    CONFIGURATION_REPORT(0x03),
    CONFIGURATION_SET(0x01);

    private static final HashMap<Integer, RemoteAssociationCommand> _map = new HashMap<Integer, RemoteAssociationCommand>(3);
    static {
        for (RemoteAssociationCommand value: RemoteAssociationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private RemoteAssociationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static RemoteAssociationCommand valueOf(int intValue) {
        RemoteAssociationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RemoteAssociationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

