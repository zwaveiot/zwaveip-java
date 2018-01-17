package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* NetworkManagementBasic commands (version 2) */
public enum NetworkManagementBasicCommand implements com.zwavepublic.zwaveip.commands.Command {
    LEARN_MODE_SET(0x01),
    LEARN_MODE_SET_STATUS(0x02),
    NODE_INFORMATION_SEND(0x05),
    NETWORK_UPDATE_REQUEST(0x03),
    NETWORK_UPDATE_REQUEST_STATUS(0x04),
    DEFAULT_SET(0x06),
    DEFAULT_SET_COMPLETE(0x07),
    DSK_GET(0x08),
    DSK_REPORT(0x09);

    private static final HashMap<Integer, NetworkManagementBasicCommand> _map = new HashMap<Integer, NetworkManagementBasicCommand>(9);
    static {
        for (NetworkManagementBasicCommand value: NetworkManagementBasicCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NetworkManagementBasicCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NetworkManagementBasicCommand valueOf(int intValue) {
        NetworkManagementBasicCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementBasicCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

