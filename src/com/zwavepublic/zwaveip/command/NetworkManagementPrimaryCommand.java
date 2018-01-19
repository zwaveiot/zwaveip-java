package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* NetworkManagementPrimary commands (version 1) */
public enum NetworkManagementPrimaryCommand implements Command {
    CONTROLLER_CHANGE((byte)0x01),
    CONTROLLER_CHANGE_STATUS((byte)0x02);

    private static final HashMap<Byte, NetworkManagementPrimaryCommand> _map = new HashMap<Byte, NetworkManagementPrimaryCommand>(2);
    static {
        for (NetworkManagementPrimaryCommand value: NetworkManagementPrimaryCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NetworkManagementPrimaryCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NetworkManagementPrimaryCommand valueOf(byte byteValue) {
        NetworkManagementPrimaryCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementPrimaryCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

