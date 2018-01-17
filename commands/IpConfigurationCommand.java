package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* IpConfiguration commands (version 1) */
public enum IpConfigurationCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    RELEASE(0x04),
    RENEW(0x05),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, IpConfigurationCommand> _map = new HashMap<Integer, IpConfigurationCommand>(5);
    static {
        for (IpConfigurationCommand value: IpConfigurationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private IpConfigurationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static IpConfigurationCommand valueOf(int intValue) {
        IpConfigurationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IpConfigurationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

