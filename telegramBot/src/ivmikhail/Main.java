package ivmikhail;

import ivmikhail.models.Core;
import ivmikhail.models.Message;
import ivmikhail.models.Update;
import ivmikhail.util.UrlUtil;
import com.google.common.base.Objects;
import com.google.common.io.Files;
import com.google.common.primitives.Longs;
import com.google.gson.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class Main {

    public static final String API_KEY = "telegram bot key";
    public static final JsonParser parser = new JsonParser();
    public static File file;

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("missing arg: file name");
            System.exit(0);
        }
        file = new File(args[0]);
        System.out.println("start bot");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("shutdown");
            }
        });
        long above = loadUpdateId();
        infiniteCycle(above);
        System.out.println("stop bot");

    }

    private static long loadUpdateId() {
        if (!file.exists()) {
            return 0;
        }
        try {
            String s = Files.readFirstLine(file, Core.UTF8);
            Long id = Longs.tryParse(s);
            return Objects.firstNonNull(id, 0L);
        } catch (IOException e) {
            return 0;
        }
    }

    private static void infiniteCycle(long above) throws InterruptedException {
        long updateId = above;
        while (true) {
            Thread.sleep(1000);
            String s = UrlUtil.sendPostRequest("https://api.telegram.org/bot" + API_KEY + "/getupdates", "offset=" + (updateId + 1));
            if (s.isEmpty()) {
                continue;
            }
            JsonObject element = (JsonObject) parser.parse(s);
            if (element != null && element.get("ok").getAsBoolean()) {
                JsonArray updates = element.getAsJsonArray("result");
                Update update = Message.fromJson(updates, updateId);
                update.getMessages().forEach(Main::processMessage);
                updateId = update.getUpdateId();
                saveUpdateId(updateId);
            }
        }

    }

    private static void saveUpdateId(long updateId) {
        try {
            Files.write("" + updateId, file, Core.UTF8);
        } catch (IOException e) {
            throw new RuntimeException("cannot save updateId to file " + file.getAbsolutePath());
        }
    }

    private static void processMessage(Message message) {
        long chatId;
        if (message.getChat() != null) {
            chatId = message.getChat().getId();
        } else if (message.getGroupChat() != null) {
            chatId = message.getGroupChat().getId();
        } else {
            return;
        }

        switch (message.getText()) {
            case "/help":
                sendHelp(chatId);
                break;
            case "/selfie":
                sendSelfie(chatId);
                break;
            case "/weather":
                sendWeather(chatId);
                break;
            case "/start":
                sendMessage(chatId, "Who are you, and why should I care?");
                break;
        }

        System.out.println(new Date() + " : " + message.getText());
    }

    public static String UTF8Encode(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return "bugagaga";
        }
    }
    public static void sendWeather(long chatId) {
        Arduino.getTemperatureFromSensorAndSend(chatId);
    }

    public static void sendSelfie(long chatId) {
        sendPhoto(chatId, "AgADAgADvKcxG1VX8AAB27cevNZtrfTN51kqAATaTA5yQDUuljstAAIC");
    }


    public static void sendHelp(long chatId) {
        sendMessage(chatId, "Funny bot with Arduino via COM\n" +
                "/help - you know\n" +
                "/weather - weather at office 500\n" +
                "/selfie - my photo");
     }

    public static void sendMessage(long chatId, String message) {
        UrlUtil.sendPostRequest("https://api.telegram.org/bot" + API_KEY + "/sendMessage", "chat_id=" + chatId + "&text=" + message);
    }

    public static void sendPhoto(long chatId, String photo) {
        UrlUtil.sendPostRequest("https://api.telegram.org/bot" + API_KEY + "/sendPhoto", "chat_id=" + chatId + "&photo=" + photo);
    }
}
