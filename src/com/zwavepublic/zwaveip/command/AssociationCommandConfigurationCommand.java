package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* AssociationCommandConfiguration commands (version 1) */
public enum AssociationCommandConfigurationCommand implements Command {
    COMMAND_CONFIGURATION_GET((byte)0x04),
    COMMAND_CONFIGURATION_REPORT((byte)0x05),
    COMMAND_CONFIGURATION_SET((byte)0x03),
    COMMAND_RECORDS_SUPPORTED_GET((byte)0x01),
    COMMAND_RECORDS_SUPPORTED_REPORT((byte)0x02);

    private static final HashMap<Byte, AssociationCommandConfigurationCommand> _map = new HashMap<Byte, AssociationCommandConfigurationCommand>(5);
    static {
        for (AssociationCommandConfigurationCommand value: AssociationCommandConfigurationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private AssociationCommandConfigurationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static AssociationCommandConfigurationCommand valueOf(byte byteValue) {
        AssociationCommandConfigurationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AssociationCommandConfigurationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

