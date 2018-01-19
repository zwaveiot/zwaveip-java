package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* RemoteAssociationActivate commands (version 1) */
public enum RemoteAssociationActivateCommand implements Command {
    REMOTE_ASSOCIATION_ACTIVATE((byte)0x01);

    private static final HashMap<Byte, RemoteAssociationActivateCommand> _map = new HashMap<Byte, RemoteAssociationActivateCommand>(1);
    static {
        for (RemoteAssociationActivateCommand value: RemoteAssociationActivateCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private RemoteAssociationActivateCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static RemoteAssociationActivateCommand valueOf(byte byteValue) {
        RemoteAssociationActivateCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RemoteAssociationActivateCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

