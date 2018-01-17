package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Association commands (version 2) */
public enum AssociationCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    GROUPINGS_GET(0x05),
    GROUPINGS_REPORT(0x06),
    REMOVE(0x04),
    REPORT(0x03),
    SET(0x01),
    SPECIFIC_GROUP_GET(0x0b),
    SPECIFIC_GROUP_REPORT(0x0c);

    private static final HashMap<Integer, AssociationCommand> _map = new HashMap<Integer, AssociationCommand>(8);
    static {
        for (AssociationCommand value: AssociationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private AssociationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static AssociationCommand valueOf(int intValue) {
        AssociationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static AssociationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

