import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class myBot extends TelegramLongPollingBot {

    private static int lng = 1;//ru

    public static SendMessage chooseLanguageInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Қазақ тілінде");
        inlineKeyboardButton1.setCallbackData("lng_kz");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("На русском языке");
        inlineKeyboardButton2.setCallbackData("lng_ru");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Вас приветствует онлайн консультанта! Просим Вас выбрать язык интерфейса.\n" +
                "Алдыңызда онлайн-консультант! Өтінеміз тілді таңдаңыз.").setReplyMarkup(inlineKeyboardMarkup);

    }

    public static SendMessage mainMenuInlineKeyBoardMessage(long chatId) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setCallbackData("mainMenu_aboutAssociation");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setCallbackData("mainMenu_associationNews");

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setCallbackData("mainMenu_registrationToEvent");

        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setCallbackData("mainMenu_contacts");

        String mainMenu = "Главное меню";
        if (lng == 1) {
            inlineKeyboardButton1.setText("Об Ассоциации");
            inlineKeyboardButton2.setText("Новости Ассоциации");
            inlineKeyboardButton3.setText("Регистрация на ивент");
            inlineKeyboardButton4.setText("Контакты");
        } else if (lng == 2) {
            inlineKeyboardButton1.setText("Ассоциация туралы");
            inlineKeyboardButton2.setText("Ассоциация жаңалықтары");
            inlineKeyboardButton3.setText("Ивентке регистрация");
            inlineKeyboardButton4.setText("Байланыстар");
            mainMenu = "Басты меню";
        }

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        keyboardButtonsRow4.add(inlineKeyboardButton4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText(mainMenu).setReplyMarkup(inlineKeyboardMarkup);

    }

    public static SendMessage aboutAssociationInlineKeyBoardMessage(long chatId) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setCallbackData("aboutAssociation_mission");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setCallbackData("aboutAssociation_aim_of_work");

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setCallbackData("aboutAssociation_projects");

        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setCallbackData("aboutAssociation_join_to_association");

        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        inlineKeyboardButton5.setCallbackData("aboutAssociation_pay_income");

        String aboutAssociation = "Об Ассоциации";
        if (lng == 1) {
            inlineKeyboardButton1.setText("Миссия");
            inlineKeyboardButton2.setText("Направления работы");
            inlineKeyboardButton3.setText("Проекты");
            inlineKeyboardButton4.setText("Вступить в Ассоциацию");
            inlineKeyboardButton5.setText("Внести взнос");
        } else if (lng == 2) {
            inlineKeyboardButton1.setText("Миссия");
            inlineKeyboardButton2.setText("Жұмыс бағыты");
            inlineKeyboardButton3.setText("Проекттер");
            inlineKeyboardButton4.setText("Ассоциацияға қосылу");
            inlineKeyboardButton5.setText("Үлес қосу");
            aboutAssociation = "Ассоциация туралы";
        }

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow5 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        keyboardButtonsRow4.add(inlineKeyboardButton4);
        keyboardButtonsRow5.add(inlineKeyboardButton5);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        rowList.add(keyboardButtonsRow5);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText(aboutAssociation).setReplyMarkup(inlineKeyboardMarkup);

    }

    public static SendMessage registrationToEventInlineKeyBoardMessage(long chatId) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Семинар ХХХ");
        inlineKeyboardButton1.setCallbackData("registrationToEvent_seminar");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Ивент 2");
        inlineKeyboardButton2.setCallbackData("registrationToEvent_event2");

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Ивент 3");
        inlineKeyboardButton3.setCallbackData("registrationToEvent_event3");

        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setCallbackData("registrationToEvent_call_back");

        String registerToEvent = "Регистрация на ивент";
        if (lng == 1) {
            inlineKeyboardButton4.setText("Заказать обратный звонок");
        }
        else if (lng == 2){
            registerToEvent = "Ивентке регистрация";
            inlineKeyboardButton4.setText("Кері қоңырау жалдау");
        }

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        keyboardButtonsRow4.add(inlineKeyboardButton4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText(registerToEvent).setReplyMarkup(inlineKeyboardMarkup);

    }

    public static SendMessage contactsInlineKeyBoardMessage(long chatId) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Астана");
        inlineKeyboardButton1.setCallbackData("contacts_astana");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Алматы");
        inlineKeyboardButton2.setCallbackData("contacts_almaty");

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setCallbackData("contacts_call_back");

        String contacts = "Контакты";
        if (lng == 1) {
            inlineKeyboardButton3.setText("Заказать обратный звонок");
        }
        else if (lng == 2){
            contacts = "Байланыстар";
            inlineKeyboardButton3.setText("Кері қоңырау жалдау");
        }

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText(contacts).setReplyMarkup(inlineKeyboardMarkup);

    }

    public static SendMessage JoinToAssociationInlineKeyBoardMessage(long chatId) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Продолжая работу по отправке заявки на вступление в Ассоциацию  вы подтверждаете свое ознакомление и согласие с Уставом, а также даете согласие на прием и обработку предоставленных персональных данных. Для продолжения нажмите «Подать заявку.");
        inlineKeyboardButton1.setCallbackData("aboutAssociation_mission");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);


        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Вступить в ассоциацию").setReplyMarkup(inlineKeyboardMarkup);

    }

    public static SendMessage projectsInlineKeyBoardMessage(long chatId) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Наука и Бизнес");
        inlineKeyboardButton1.setCallbackData("projects_science_education");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Энциклопедия «Новый мир»");
        inlineKeyboardButton2.setCallbackData("projects_new_world");

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Сборник стихов А. Ахматовой");
        inlineKeyboardButton3.setCallbackData("projects_Akhmetova");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Проекты").setReplyMarkup(inlineKeyboardMarkup);

    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            //проверяем есть ли сообщение и текстовое ли оно
            if (update.hasMessage() && update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("/start")) {
                    execute(chooseLanguageInlineKeyBoardMessage(update.getMessage().getChatId()));
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
                if (update.getCallbackQuery().getData().startsWith("lng")) {
                    if (update.getCallbackQuery().getData().endsWith("kz")) {
                        lng = 2;//kz
                    }
                    execute(mainMenuInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
                } else if (update.getCallbackQuery().getData().startsWith("mainMenu")) {
                    if (update.getCallbackQuery().getData().endsWith("aboutAssociation")) {
                        execute(aboutAssociationInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("registrationToEvent")) {
                        execute(registrationToEventInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("contacts")) {
                        execute(contactsInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
                    }
                } else if (update.getCallbackQuery().getData().startsWith("aboutAssociation")) {
                    if (update.getCallbackQuery().getData().endsWith("projects")) {
                        execute(projectsInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
                    } else if (update.getCallbackQuery().getData().endsWith("join_to_association")) {
                        execute(JoinToAssociationInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
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
