package ivmikhail.models;

import java.util.List;

public class Update {
    private final long updateId;
    private final List<Message> messages;

    public long getUpdateId() {
        return updateId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Update(long updateId, List<Message> messages) {

        this.updateId = updateId;
        this.messages = messages;
    }
}
