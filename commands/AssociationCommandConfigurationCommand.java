package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* AssociationCommandConfiguration commands (version 1) */
public enum AssociationCommandConfigurationCommand implements com.zwavepublic.zwaveip.commands.Command {
    COMMAND_CONFIGURATION_GET(0x04),
    COMMAND_CONFIGURATION_REPORT(0x05),
    COMMAND_CONFIGURATION_SET(0x03),
    COMMAND_RECORDS_SUPPORTED_GET(0x01),
    COMMAND_RECORDS_SUPPORTED_REPORT(0x02);

    private static final HashMap<Integer, AssociationCommandConfigurationCommand> _map = new HashMap<Integer, AssociationCommandConfigurationCommand>(5);
    static {
        for (AssociationCommandConfigurationCommand value: AssociationCommandConfigurationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AssociationCommandConfigurationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AssociationCommandConfigurationCommand valueOf(int intValue) {
        AssociationCommandConfigurationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AssociationCommandConfigurationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

