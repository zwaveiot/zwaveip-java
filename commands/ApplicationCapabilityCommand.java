package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ApplicationCapability commands (version 1) */
public enum ApplicationCapabilityCommand implements com.zwavepublic.zwaveip.commands.Command {
    COMMAND_COMMAND_CLASS_NOT_SUPPORTED(0x01);

    private static final HashMap<Integer, ApplicationCapabilityCommand> _map = new HashMap<Integer, ApplicationCapabilityCommand>(1);
    static {
        for (ApplicationCapabilityCommand value: ApplicationCapabilityCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ApplicationCapabilityCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ApplicationCapabilityCommand valueOf(int intValue) {
        ApplicationCapabilityCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ApplicationCapabilityCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

