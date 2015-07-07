package ivmikhail.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static ivmikhail.models.Core.GSON;

public class Message {
    //message_id	Integer	Unique message identifier
    private long messageId;
    //from	User	Sender
    private User from;
    //date	Integer	Date the message was sent in Unix time
    private long date;
    //chat	User or GroupChat	Conversation the message belongs to � user in case of a private message, GroupChat in case of a group
    private User chat;
    private GroupChat groupChat;
    //forward_from	User	Optional. For forwarded messages, from of the original message
    private User forwardFrom;
    //forward_date	Integer	Optional. For forwarded messages, date the original message was sent in Unix time
    private long forwardDate;
    //reply_to_message	Message	Optional. For replies, the original message. Note that the Message object in this field
    // will not contain further reply_to_message fields even if it itself is a reply.
    private Message replyToMessage;
    //text	String	Optional. For text messages, the actual UTF-8 text of the message
    private String text = "";
    //audio	Audio	Optional. Message is an audio file, information about the file
    private Audio audio;
    //document	Document	Optional. Message is a general file, information about the file
    private Document document;
    //photo	Array of PhotoSize	Optional. Message is a photo, available sizes of the photo
    private PhotoSize[] photos;
    //sticker	Sticker	Optional. Message is a sticker, information about the sticker
    private Sticker sticker;
    //video	Video	Optional. Message is a video, information about the video
    private Video video;
    //contact	Contact	Optional. Message is a shared contact, information about the contact
    private Contact contact;
    //location	Location	Optional. Message is a shared location, information about the location
    private Location location;
    //new_chat_participant	User	Optional. A new member was added to the group, information about them (this member may be bot itself)
    private User newChatParticipant;
    //left_chat_participant	User	Optional. A member was removed from the group, information about them (this member may be bot itself)
    private User leftChatParticipant;
    //new_chat_title	String	Optional. A group title was changed to this value
    private String newChatTitle;
    //new_chat_photo	Array of PhotoSize	Optional. A group photo was change to this value
    private PhotoSize[] newChatPhotos;
    //delete_chat_photo	True	Optional. Informs that the group photo was deleted
    private boolean deleteChatPhoto = false;
    //group_chat_created	True	Optional. Informs that the group has been created
    private boolean groupChatCreated = false;

    public static Update fromJson(JsonArray array, long aboveId) {
        List<Message> list = new ArrayList<>(array.size());
        long max = aboveId;
        for (int i = 0; i < array.size(); i++) {
            JsonObject obj = array.get(0).getAsJsonObject();
            long updateId = obj.get("update_id").getAsLong();
            if (updateId > aboveId && obj.has("message")) {
                Message message = fromJson(obj.get("message").getAsJsonObject());
                list.add(message);
                if (updateId > max) {
                    max = updateId;
                }
            }
        }
        return new Update(max, list);
    }

    private static Message fromJson(JsonObject json) {
        Message message = new Message();
        message.messageId = json.get("message_id").getAsLong();
        message.from = GSON.fromJson(json.get("from").getAsJsonObject(), User.class);
        message.date = json.get("date").getAsLong();
        if (json.has("chat")) {
            JsonObject chat = json.get("chat").getAsJsonObject();
            if (chat.has("username")) {
                message.chat = GSON.fromJson(chat, User.class);
            } else {
                message.groupChat = GSON.fromJson(chat, GroupChat.class);
            }
        }
        if (json.has("forward_from")) {
            message.forwardFrom = GSON.fromJson(json.get("forward_from").getAsJsonObject(), User.class);
            message.forwardDate = json.get("forward_date").getAsLong();
        }
        if (json.has("reply_to_message")) {
            message.replyToMessage = fromJson(json.get("reply_to_message").getAsJsonObject());
        }
        if (json.has("text")) {
            message.text = json.get("text").getAsString();
        }
        if (json.has("audio")) {
            message.audio = GSON.fromJson(json.get("audio").getAsJsonObject(), Audio.class);
        }
        if (json.has("document")) {
            message.document = GSON.fromJson(json.get("document").getAsJsonObject(), Document.class);
        }
        if (json.has("photo")) {
            message.photos = GSON.fromJson(json.get("photo").getAsJsonArray(), PhotoSize[].class);
        }
        if (json.has("sticker")) {
            message.sticker = GSON.fromJson(json.get("sticker").getAsJsonObject(), Sticker.class);
        }
        if (json.has("video")) {
            message.video = GSON.fromJson(json.get("video").getAsJsonObject(), Video.class);
        }
        if (json.has("contact")) {
            message.contact = GSON.fromJson(json.get("contact").getAsJsonObject(), Contact.class);
        }
        if (json.has("location")) {
            message.location = GSON.fromJson(json.get("location").getAsJsonObject(), Location.class);
        }
        if (json.has("new_chat_participant")) {
            message.newChatParticipant = GSON.fromJson(json.get("new_chat_participant").getAsJsonObject(), User.class);
        }
        if (json.has("left_chat_participant")) {
            message.leftChatParticipant = GSON.fromJson(json.get("left_chat_participant").getAsJsonObject(), User.class);
        }
        if (json.has("new_chat_title")) {
            message.newChatTitle = json.get("new_chat_title").getAsString();
        }
        if (json.has("new_chat_photo")) {
            message.newChatPhotos = GSON.fromJson(json.get("new_chat_photo").getAsJsonObject(), PhotoSize[].class);
        }
        if (json.has("delete_chat_photo")) {
            message.deleteChatPhoto = true;
        }
        if (json.has("group_chat_created")) {
            message.groupChatCreated = true;
        }

        return message;
    }

    public long getMessageId() {
        return messageId;
    }

    public User getFrom() {
        return from;
    }

    public long getDate() {
        return date;
    }

    public User getChat() {
        return chat;
    }

    public GroupChat getGroupChat() {
        return groupChat;
    }

    public User getForwardFrom() {
        return forwardFrom;
    }

    public long getForwardDate() {
        return forwardDate;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public String getText() {
        return text;
    }

    public Audio getAudio() {
        return audio;
    }

    public Document getDocument() {
        return document;
    }

    public PhotoSize[] getPhotos() {
        return photos;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public Video getVideo() {
        return video;
    }

    public Contact getContact() {
        return contact;
    }

    public Location getLocation() {
        return location;
    }

    public User getNewChatParticipant() {
        return newChatParticipant;
    }

    public User getLeftChatParticipant() {
        return leftChatParticipant;
    }

    public String getNewChatTitle() {
        return newChatTitle;
    }

    public PhotoSize[] getNewChatPhotos() {
        return newChatPhotos;
    }

    public boolean isDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    public boolean isGroupChatCreated() {
        return groupChatCreated;
    }
}
