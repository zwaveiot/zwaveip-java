package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* RemoteAssociationActivate commands (version 1) */
public enum RemoteAssociationActivateCommand implements com.zwavepublic.zwaveip.commands.Command {
    REMOTE_ASSOCIATION_ACTIVATE(0x01);

    private static final HashMap<Integer, RemoteAssociationActivateCommand> _map = new HashMap<Integer, RemoteAssociationActivateCommand>(1);
    static {
        for (RemoteAssociationActivateCommand value: RemoteAssociationActivateCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private RemoteAssociationActivateCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static RemoteAssociationActivateCommand valueOf(int intValue) {
        RemoteAssociationActivateCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RemoteAssociationActivateCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

