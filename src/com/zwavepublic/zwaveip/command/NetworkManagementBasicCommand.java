package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* NetworkManagementBasic commands (version 2) */
public enum NetworkManagementBasicCommand implements Command {
    LEARN_MODE_SET((byte)0x01),
    LEARN_MODE_SET_STATUS((byte)0x02),
    NODE_INFORMATION_SEND((byte)0x05),
    NETWORK_UPDATE_REQUEST((byte)0x03),
    NETWORK_UPDATE_REQUEST_STATUS((byte)0x04),
    DEFAULT_SET((byte)0x06),
    DEFAULT_SET_COMPLETE((byte)0x07),
    DSK_GET((byte)0x08),
    DSK_REPORT((byte)0x09);

    private static final HashMap<Byte, NetworkManagementBasicCommand> _map = new HashMap<Byte, NetworkManagementBasicCommand>(9);
    static {
        for (NetworkManagementBasicCommand value: NetworkManagementBasicCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NetworkManagementBasicCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NetworkManagementBasicCommand valueOf(byte byteValue) {
        NetworkManagementBasicCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementBasicCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

