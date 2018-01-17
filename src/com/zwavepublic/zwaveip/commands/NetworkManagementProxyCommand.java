package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* NetworkManagementProxy commands (version 2) */
public enum NetworkManagementProxyCommand implements com.zwavepublic.zwaveip.commands.Command {
    NODE_INFO_CACHED_GET(0x03),
    NODE_INFO_CACHED_REPORT(0x04),
    NODE_LIST_GET(0x01),
    NODE_LIST_REPORT(0x02);

    private static final HashMap<Integer, NetworkManagementProxyCommand> _map = new HashMap<Integer, NetworkManagementProxyCommand>(4);
    static {
        for (NetworkManagementProxyCommand value: NetworkManagementProxyCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NetworkManagementProxyCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NetworkManagementProxyCommand valueOf(int intValue) {
        NetworkManagementProxyCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementProxyCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

