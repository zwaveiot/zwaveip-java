package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* RemoteAssociation commands (version 1) */
public enum RemoteAssociationCommand implements Command {
    CONFIGURATION_GET((byte)0x02),
    CONFIGURATION_REPORT((byte)0x03),
    CONFIGURATION_SET((byte)0x01);

    private static final HashMap<Byte, RemoteAssociationCommand> _map = new HashMap<Byte, RemoteAssociationCommand>(3);
    static {
        for (RemoteAssociationCommand value: RemoteAssociationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private RemoteAssociationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static RemoteAssociationCommand valueOf(byte byteValue) {
        RemoteAssociationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RemoteAssociationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

