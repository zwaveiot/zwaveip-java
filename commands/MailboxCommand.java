package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Mailbox commands (version 1) */
public enum MailboxCommand implements com.zwavepublic.zwaveip.commands.Command {
    CONFIGURATION_GET(0x01),
    CONFIGURATION_SET(0x02),
    CONFIGURATION_REPORT(0x03),
    QUEUE(0x04),
    WAKEUP_NOTIFICATION(0x05),
    NODE_FAILING(0x06);

    private static final HashMap<Integer, MailboxCommand> _map = new HashMap<Integer, MailboxCommand>(6);
    static {
        for (MailboxCommand value: MailboxCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MailboxCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MailboxCommand valueOf(int intValue) {
        MailboxCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MailboxCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

