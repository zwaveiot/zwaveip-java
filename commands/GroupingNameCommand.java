package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* GroupingName commands (version 1) */
public enum GroupingNameCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01);

    private static final HashMap<Integer, GroupingNameCommand> _map = new HashMap<Integer, GroupingNameCommand>(3);
    static {
        for (GroupingNameCommand value: GroupingNameCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private GroupingNameCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static GroupingNameCommand valueOf(int intValue) {
        GroupingNameCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static GroupingNameCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

