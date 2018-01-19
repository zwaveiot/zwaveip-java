package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* NetworkManagementProxy commands (version 2) */
public enum NetworkManagementProxyCommand implements Command {
    NODE_INFO_CACHED_GET((byte)0x03),
    NODE_INFO_CACHED_REPORT((byte)0x04),
    NODE_LIST_GET((byte)0x01),
    NODE_LIST_REPORT((byte)0x02);

    private static final HashMap<Byte, NetworkManagementProxyCommand> _map = new HashMap<Byte, NetworkManagementProxyCommand>(4);
    static {
        for (NetworkManagementProxyCommand value: NetworkManagementProxyCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NetworkManagementProxyCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NetworkManagementProxyCommand valueOf(byte byteValue) {
        NetworkManagementProxyCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementProxyCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

