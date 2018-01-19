package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ApplicationCapability commands (version 1) */
public enum ApplicationCapabilityCommand implements Command {
    COMMAND_COMMAND_CLASS_NOT_SUPPORTED((byte)0x01);

    private static final HashMap<Byte, ApplicationCapabilityCommand> _map = new HashMap<Byte, ApplicationCapabilityCommand>(1);
    static {
        for (ApplicationCapabilityCommand value: ApplicationCapabilityCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ApplicationCapabilityCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ApplicationCapabilityCommand valueOf(byte byteValue) {
        ApplicationCapabilityCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ApplicationCapabilityCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

