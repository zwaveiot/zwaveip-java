package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* NetworkManagementPrimary commands (version 1) */
public enum NetworkManagementPrimaryCommand implements com.zwavepublic.zwaveip.commands.Command {
    CONTROLLER_CHANGE(0x01),
    CONTROLLER_CHANGE_STATUS(0x02);

    private static final HashMap<Integer, NetworkManagementPrimaryCommand> _map = new HashMap<Integer, NetworkManagementPrimaryCommand>(2);
    static {
        for (NetworkManagementPrimaryCommand value: NetworkManagementPrimaryCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NetworkManagementPrimaryCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NetworkManagementPrimaryCommand valueOf(int intValue) {
        NetworkManagementPrimaryCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementPrimaryCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

