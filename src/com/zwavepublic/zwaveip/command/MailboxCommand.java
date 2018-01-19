package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Mailbox commands (version 1) */
public enum MailboxCommand implements Command {
    CONFIGURATION_GET((byte)0x01),
    CONFIGURATION_SET((byte)0x02),
    CONFIGURATION_REPORT((byte)0x03),
    QUEUE((byte)0x04),
    WAKEUP_NOTIFICATION((byte)0x05),
    NODE_FAILING((byte)0x06);

    private static final HashMap<Byte, MailboxCommand> _map = new HashMap<Byte, MailboxCommand>(6);
    static {
        for (MailboxCommand value: MailboxCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MailboxCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MailboxCommand valueOf(byte byteValue) {
        MailboxCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MailboxCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

