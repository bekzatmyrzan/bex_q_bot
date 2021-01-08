import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class myBot extends TelegramLongPollingBot {

    private static int lng = 1;//ru

    public static SendMessage chooseLanguageMenu(long chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("Қазақ тілінде " + EmojiParser.parseToUnicode(":kz:"));
        row.add(button);
        keyboard.add(row);
        row = new KeyboardRow();
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("На русском языке " + EmojiParser.parseToUnicode(":ru:"));
        row.add(button2);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText("Вас приветствует онлайн консультанта! Просим Вас выбрать язык интерфейса.\n" +
                "Алдыңызда онлайн-консультант! Өтінеміз тілді таңдаңыз.").setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage mainMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        KeyboardButton keyboardButton4 = new KeyboardButton();

        String mainMenu = "Главное меню";
        if (lng == 1) {
            keyboardButton1.setText("Об Ассоциации " + EmojiParser.parseToUnicode(":page_with_curl:"));
            keyboardButton2.setText("Новости Ассоциации " + EmojiParser.parseToUnicode(":newspaper:"));
            keyboardButton3.setText("Регистрация на ивент " + EmojiParser.parseToUnicode(":writing_hand:"));
            keyboardButton4.setText("Контакты " + EmojiParser.parseToUnicode(":blue_book:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Ассоциация туралы " + EmojiParser.parseToUnicode(":page_with_curl:"));
            keyboardButton2.setText("Ассоциация жаңалықтары " + EmojiParser.parseToUnicode(":newspaper:"));
            keyboardButton3.setText("Ивентке регистрация " + EmojiParser.parseToUnicode(":writing_hand:"));
            keyboardButton4.setText("Байланыстар " + EmojiParser.parseToUnicode(":blue_book:"));
            mainMenu = "Басты меню";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row1.add(keyboardButton1);
        row1.add(keyboardButton2);
        row2.add(keyboardButton3);
        row2.add(keyboardButton4);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(mainMenu).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage aboutAssociationMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        KeyboardButton keyboardButton4 = new KeyboardButton();
        KeyboardButton keyboardButton5 = new KeyboardButton();

        String aboutAssociation = "Об Ассоциации";
        if (lng == 1) {
            keyboardButton1.setText("Миссия " + EmojiParser.parseToUnicode(":trophy:"));
            keyboardButton2.setText("Направления работы " + EmojiParser.parseToUnicode(":telescope:"));
            keyboardButton3.setText("Проекты " + EmojiParser.parseToUnicode(":card_index_dividers:"));
            keyboardButton4.setText("Вступить в Ассоциацию " + EmojiParser.parseToUnicode(":gem:"));
            keyboardButton5.setText("Внести взнос " + EmojiParser.parseToUnicode(":credit_card:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Миссия " + EmojiParser.parseToUnicode(":trophy:"));
            keyboardButton2.setText("Жұмыс бағыты " + EmojiParser.parseToUnicode(":telescope:"));
            keyboardButton3.setText("Проекттер " + EmojiParser.parseToUnicode(":card_index_dividers:"));
            keyboardButton4.setText("Ассоциацияға қосылу " + EmojiParser.parseToUnicode(":gem:"));
            keyboardButton5.setText("Үлес қосу " + EmojiParser.parseToUnicode(":credit_card:"));
            aboutAssociation = "Ассоциация туралы";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(keyboardButton1);
        row1.add(keyboardButton2);
        row2.add(keyboardButton3);
        row2.add(keyboardButton4);
        row3.add(keyboardButton5);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(aboutAssociation).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage registrationToEventMenu(long chatId) {


        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        KeyboardButton keyboardButton4 = new KeyboardButton();

        String registerToEvent = "Регистрация на ивент";
        if (lng == 1) {
            keyboardButton1.setText("Семинар ХХХ " + EmojiParser.parseToUnicode(":speaking_head_in_silhouette:"));
            keyboardButton2.setText("Ивент 2 " + EmojiParser.parseToUnicode(":label:"));
            keyboardButton3.setText("Ивент 3 " + EmojiParser.parseToUnicode(":label:"));
            keyboardButton4.setText("Заказать обратный звонок " + EmojiParser.parseToUnicode(":calling:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Семинар ХХХ " + EmojiParser.parseToUnicode(":speaking_head_in_silhouette:"));
            keyboardButton2.setText("Ивент 2 " + EmojiParser.parseToUnicode(":label:"));
            keyboardButton3.setText("Ивент 3 " + EmojiParser.parseToUnicode(":label:"));
            keyboardButton4.setText("Кері қоңырау жалдау " + EmojiParser.parseToUnicode(":calling:"));
            registerToEvent = "Ивентке регистрация";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row1.add(keyboardButton1);
        row1.add(keyboardButton2);
        row2.add(keyboardButton3);
        row2.add(keyboardButton4);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(registerToEvent).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage contactsMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();

        String contacts = "Контакты";
        if (lng == 1) {
            keyboardButton1.setText("Астана " + EmojiParser.parseToUnicode(":star:"));
            keyboardButton2.setText("Алматы " + EmojiParser.parseToUnicode(":snow_capped_mountain:"));
            keyboardButton3.setText("Заказать обратный звонок " + EmojiParser.parseToUnicode(":calling:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Астана " + EmojiParser.parseToUnicode(":star:"));
            keyboardButton2.setText("Алматы " + EmojiParser.parseToUnicode(":snow_capped_mountain:"));
            keyboardButton3.setText("Кері қоңырау жалдау " + EmojiParser.parseToUnicode(":calling:"));
            contacts = "Байланыстар";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row1.add(keyboardButton1);
        row1.add(keyboardButton2);
        row2.add(keyboardButton3);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(contacts).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage JoinToAssociationMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();

        String contacts = "Продолжая работу по отправке заявки на вступление в Ассоциацию  вы подтверждаете свое ознакомление и согласие с Уставом, а также даете согласие на прием и обработку предоставленных персональных данных. Для продолжения нажмите «Подать заявку.";

        keyboardButton1.setText("Подать заявку " + EmojiParser.parseToUnicode(":envelope_with_arrow:"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(keyboardButton1);
        keyboard.add(row1);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(contacts).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage PayIncomeMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();

        String pay_income = "Внести взнос";
        if (lng == 1) {
            keyboardButton1.setText("Благотворительный взнос " + EmojiParser.parseToUnicode(":innocent:"));
            keyboardButton2.setText("Взнос на научные цели " + EmojiParser.parseToUnicode(":man_student:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Қайырымдылық көмек " + EmojiParser.parseToUnicode(":innocent:"));
            keyboardButton2.setText("Ғылыми үлес " + EmojiParser.parseToUnicode(":man_student:"));
            pay_income = "Төлем жасау";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row1.add(keyboardButton1);
        row2.add(keyboardButton2);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(pay_income).setReplyMarkup(keyboardMarkup);
    }

    public static SendMessage charityMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();

        String charity = "Благотворительный взнос – это добровольный взнос физлица (или юрлица), предоставленный бюджетному учреждению, которое относится к перечисленным выше сферам благотворительной деятельности. Поэтому сосредоточим внимание на получении благотворительных взносов в денежной форме именно от физлиц.";
        if (lng == 1) {
            keyboardButton1.setText("Осуществить взнос " + EmojiParser.parseToUnicode(":thumbsup:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Төлем жасау " + EmojiParser.parseToUnicode(":thumbsup:"));
            charity = "Қайырымдылық жарна - бұл жеке тұлғаның (немесе заңды тұлғаның) жоғарыда аталған қайырымдылық қызмет бағыттарына жататын бюджеттік мекемеге берілген ерікті жарнасы. Сондықтан біз қайырымдылық жарналарды жеке тұлғалардан қолма-қол алуға бағытталған боламыз.";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(keyboardButton1);
        keyboard.add(row1);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(charity).setReplyMarkup(keyboardMarkup);
    }

    public static SendMessage scienceMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();

        String science = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat";
        if (lng == 1) {
            keyboardButton1.setText("Осуществить взнос " + EmojiParser.parseToUnicode(":thumbsup:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Төлем жасау " + EmojiParser.parseToUnicode(":thumbsup:"));
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(keyboardButton1);
        keyboard.add(row1);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(science).setReplyMarkup(keyboardMarkup);
    }

    public static SendMessage projectsMenu(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();

        String projects = "Проекты";
        if (lng == 1) {
            keyboardButton1.setText("Наука и Бизнес " + EmojiParser.parseToUnicode(":trophy:"));
            keyboardButton2.setText("Энциклопедия «Новый мир» " + EmojiParser.parseToUnicode(":telescope:"));
            keyboardButton3.setText("Сборник стихов А. Ахматовой " + EmojiParser.parseToUnicode(":card_index_dividers:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Ғылым және Бизнес " + EmojiParser.parseToUnicode(":trophy:"));
            keyboardButton2.setText("«Жаңа әлем» энциклопедиясы " + EmojiParser.parseToUnicode(":telescope:"));
            keyboardButton3.setText("А.Ахматованың өлеңдер жинағы " + EmojiParser.parseToUnicode(":card_index_dividers:"));
            projects = "Проекттер";
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(keyboardButton1);
        row2.add(keyboardButton2);
        row3.add(keyboardButton3);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(projects).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage AstanaContactsMessage(long chatId) {

        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("г. Астана, ул. Черных, 5, офис 212\n" +
                "Тел./факс: +7 (71-72) 453 980\n" +
                "Пресс-служба: press@tema.kz\n");
        return outMessage;

    }

    public static SendLocation AstanaLocationMessage(long chatId) {

        SendLocation location = new SendLocation();
        location.setChatId(chatId);
        location.setLatitude((float) 51.1283);
        location.setLongitude((float) 71.4305);
        return location;

    }

    public static SendLocation AlmatyLocationMessage(long chatId) {

        SendLocation location = new SendLocation();
        location.setChatId(chatId);
        location.setLatitude((float) 43.235225);
        location.setLongitude((float) 76.909691);
        return location;

    }

    public static SendMessage AlmatyContactsMessage(long chatId) {

        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("г. Алматы, ул. Абая, 5, офис 212\n" +
                "Тел./факс: +7 (71-72) 453 980\n" +
                "Пресс-служба: press@tema.kz\n");
        return outMessage;

    }

    public static SendMessage seminarXXXMessage(long chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        KeyboardButton keyboardButton1 = new KeyboardButton();

        String seminarXXX = "21 июля т.г. в Астане, в Конгресс холе,  состоится 8-ми часовой семинар по эффективному управлению временем. Спикер – Михаил Сергеев, автор бестселлера «Омут перемен». На семинаре вы научитесь правильно и эффективно планировать свое рабочее время. Количество мест ограничено. Начало в 10.00ч. После предварительной регистрации, вход свободный";
        if (lng == 1) {
            keyboardButton1.setText("Начать регистрацию " + EmojiParser.parseToUnicode(":trophy:"));
        } else if (lng == 2) {
            keyboardButton1.setText("Тіркеуді бастау " + EmojiParser.parseToUnicode(":trophy:"));
        }

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(keyboardButton1);
        keyboard.add(row1);
        keyboardMarkup.setKeyboard(keyboard);

        return new SendMessage().setChatId(chatId).setText(seminarXXX).setReplyMarkup(keyboardMarkup);

    }

    public static SendMessage associationNewsMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("https://t.me/Akorda_Press");
        return outMessage;

    }

    public static SendMessage showFIOMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("Напишите своё  ФИО.");
        return outMessage;

    }

    public static SendMessage showCallBackMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("Если Вы хотите заказать «Обратный звонок» просим написать Ваше имя и номер контактного телефона.\n" +
                "Пример: Adam, 8XXXXXXXXXX");
        return outMessage;

    }

    public static SendMessage showThanksMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("Благодарим за проявленный интерес. В рабочее время сотрудник Ассоциации перезвонит на указанный Вами номер.");
        return outMessage;
    }

    public static SendMessage showWorkPlaceMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("Напишите, место работы или учебы, с указанием должности и специальности обучения.\nПример – ТОО «АВС», менеджер или КазГЮУ, магистратура, юриспруденция.");
        return outMessage;
    }

    public static SendMessage showLocationContactsMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("Напишите, пожалуйста, населённый пункт, где Вы находитесь, e-mail и номер мобильного телефона.\n" +
                "Пример – Казахстан, Актобе, aigtra1984@gmail.com, 8 797 777 111 77.\n");
        return outMessage;
    }

    public static SendMessage showAcceptedMessage(long chatId) {
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText("Ваша заявка принята. В ближайшее время сотрудники Ассоциации позвонят на указанный вами номер.");
        return outMessage;
    }

    public static boolean isContainNumber(String sample) {
        char[] chars = sample.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContainComma(String sample) {
        char[] chars = sample.toCharArray();
        for (char c : chars) {
            if (c == ',') {
                return true;
            }
        }
        return false;
    }

    public static boolean isContainEmail(String sample) {
        char[] chars = sample.toCharArray();
        for (char c : chars) {
            if (c == '@') {
                return true;
            }
        }
        return false;
    }

    public static DeleteMessage deleteMessage(Update update) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(update.getMessage().getChatId());
        deleteMessage.setMessageId(update.getMessage().getMessageId());
        return deleteMessage;
    }


    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("/start")) {
                    execute(deleteMessage(update));
                    execute(chooseLanguageMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Қазақ тілінде ")) {
                    lng = 2;
                    execute(deleteMessage(update));
                    execute(mainMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("На русском языке ")) {
                    lng = 1;
                    execute(deleteMessage(update));
                    execute(mainMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Об Ассоциации") || update.getMessage().getText().startsWith("Ассоциация туралы")) {
                    execute(deleteMessage(update));
                    execute(aboutAssociationMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Новости Ассоциации") || update.getMessage().getText().startsWith("Ассоциация жаңалықтары")) {
                    execute(deleteMessage(update));
                    execute(associationNewsMessage(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Регистрация на ивент") || update.getMessage().getText().startsWith("Ивентке регистрация")) {
                    execute(deleteMessage(update));
                    execute(registrationToEventMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Контакты") || update.getMessage().getText().startsWith("Байланыстар")) {
                    execute(deleteMessage(update));
                    execute(contactsMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Вступить в Ассоциацию") || update.getMessage().getText().startsWith("Ассоциацияға қосылу")) {
                    execute(deleteMessage(update));
                    execute(JoinToAssociationMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Подать заявку") || update.getMessage().getText().startsWith("Подать заявку")) {
                    execute(deleteMessage(update));
                    execute(showFIOMessage(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Внести взнос") || update.getMessage().getText().startsWith("Үлес қосу")) {
                    execute(deleteMessage(update));
                    execute(PayIncomeMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Благотворительный взнос") || update.getMessage().getText().startsWith("Қайырымдылық көмек")) {
                    execute(deleteMessage(update));
                    execute(charityMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Взнос на научные цели") || update.getMessage().getText().startsWith("Ғылыми үлес")) {
                    execute(deleteMessage(update));
                    execute(scienceMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Проекты") || update.getMessage().getText().startsWith("Проекттер")) {
                    execute(deleteMessage(update));
                    execute(projectsMenu(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Семинар ХХХ") || update.getMessage().getText().startsWith("Семинар ХХХ")) {
                    execute(deleteMessage(update));
                    execute(seminarXXXMessage(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Начать регистрацию") || update.getMessage().getText().startsWith("Тіркеуді бастау")) {
                    execute(deleteMessage(update));
                    execute(showFIOMessage(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Заказать обратный звонок") || update.getMessage().getText().startsWith("Кері қоңырау жалдау")) {
                    execute(deleteMessage(update));
                    execute(showCallBackMessage(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Астана") || update.getMessage().getText().startsWith("Астана")) {
                    execute(deleteMessage(update));
                    execute(AstanaContactsMessage(update.getMessage().getChatId()));
                    execute(AstanaLocationMessage(update.getMessage().getChatId()));
                } else if (update.getMessage().getText().startsWith("Алматы") || update.getMessage().getText().startsWith("Алматы")) {
                    execute(deleteMessage(update));
                    execute(AlmatyContactsMessage(update.getMessage().getChatId()));
                    execute(AlmatyLocationMessage(update.getMessage().getChatId()));
                } else if (isContainNumber(update.getMessage().getText())) {
                    if (isContainEmail(update.getMessage().getText())) {
                        execute(showAcceptedMessage(update.getMessage().getChatId()));
                    } else if (isContainComma(update.getMessage().getText())) {
                        execute(showThanksMessage(update.getMessage().getChatId()));
                    }

                } else {
                    if (!isContainComma(update.getMessage().getText())) {
                        execute(showWorkPlaceMessage(update.getMessage().getChatId()));
                    } else {
                        execute(showLocationContactsMessage(update.getMessage().getChatId()));
                    }
                }
//                //Извлекаем объект входящего сообщения
//                Message inMessage = update.getMessage();
//                //Создаем исходящее сообщение
//                SendMessage outMessage = new SendMessage();
//                //Указываем в какой чат будем отправлять сообщение
//                //(в тот же чат, откуда пришло входящее сообщение)
//                outMessage.setChatId(inMessage.getChatId());
//                //Указываем текст сообщения
//                outMessage.setText(inMessage.getText());
//                //Отправляем сообщение
//                execute(outMessage);
            } else if (update.hasCallbackQuery()) {
                if (update.getCallbackQuery().getData().startsWith("mainMenu")) {
                    if (update.getCallbackQuery().getData().endsWith("aboutAssociation")) {
                        execute(aboutAssociationMenu(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("registrationToEvent")) {
                        execute(registrationToEventMenu(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("contacts")) {
                        execute(contactsMenu(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("associationNews")) {
                        execute(associationNewsMessage(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("aboutAssociation")) {
                    if (update.getCallbackQuery().getData().endsWith("projects")) {
                        execute(projectsMenu(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("join_to_association")) {
                        execute(JoinToAssociationMenu(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("pay_income")) {
                        execute(PayIncomeMenu(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("join_to_association")) {
                    if (update.getCallbackQuery().getData().endsWith("apply")) {
                        execute(showFIOMessage(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("pay_income")) {
                    if (update.getCallbackQuery().getData().endsWith("charity")) {
                        execute(charityMenu(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("science")) {
                        execute(scienceMenu(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("registrationToEvent")) {
                    if (update.getCallbackQuery().getData().endsWith("seminarXXX")) {
                        execute(seminarXXXMessage(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("call_back")) {
                        execute(showCallBackMessage(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("seminarXXX")) {
                    if (update.getCallbackQuery().getData().endsWith("start_registration")) {
                        execute(showFIOMessage(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("contacts")) {
                    if (update.getCallbackQuery().getData().endsWith("astana")) {
                        execute(AstanaContactsMessage(update.getCallbackQuery().getMessage().getChatId()));
                        execute(AstanaLocationMessage(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("almaty")) {
                        execute(AlmatyContactsMessage(update.getCallbackQuery().getMessage().getChatId()));
                        execute(AlmatyLocationMessage(update.getCallbackQuery().getMessage().getChatId()));
                    }
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//    public void setButtons(SendMessage sendMessage){
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//
//        KeyboardRow keyboardRowFirst = new KeyboardRow();
//
//        keyboardRowFirst.add(new KeyboardButton("/help"));
//        keyboardRowFirst.add(new KeyboardButton("/settings"));
//
//        keyboardRowList.add(keyboardRowFirst);
//        replyKeyboardMarkup.setKeyboard(keyboardRowList);
//    }

    @Override
    public String getBotUsername() {
        return "bex_q_bot";
    }

    @Override
    public String getBotToken() {
        return "1590405780:AAEDj3OlcNq0wDh-9MGsQsTdMBlFi0bh-P4";
    }
}
