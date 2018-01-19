package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* IpConfiguration commands (version 1) */
public enum IpConfigurationCommand implements Command {
    GET((byte)0x02),
    RELEASE((byte)0x04),
    RENEW((byte)0x05),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, IpConfigurationCommand> _map = new HashMap<Byte, IpConfigurationCommand>(5);
    static {
        for (IpConfigurationCommand value: IpConfigurationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private IpConfigurationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static IpConfigurationCommand valueOf(byte byteValue) {
        IpConfigurationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IpConfigurationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

